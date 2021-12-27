package com.example.event.service;

import com.example.event.config.ResponseResult;
import com.example.event.domain.EventHistory;
import com.example.event.domain.EventType;
import com.example.event.domain.dto.EventParam;
import com.example.event.repository.EventHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventService {

    private final EventHistoryRepository eventHistoryRepository;
    private final Map<EventType, EventAction> eventActionMap;

    @Transactional
    public ResponseResult<Object> addEvent(EventParam eventParam) {
        EventHistory eventHistory = EventHistory.createEventHistory(eventParam);
        this.eventHistoryRepository.save(eventHistory);
        EventAction eventAction = this.eventActionMap.get(eventParam.getType());
        return eventAction.action(eventParam);
    }
}
