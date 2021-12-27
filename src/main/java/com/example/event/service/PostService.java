package com.example.event.service;

import com.example.event.config.ResponseResult;
import com.example.event.domain.dto.EventParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService implements EventAction {

    @Override
    @Transactional
    public ResponseResult<Object> action(EventParam eventParam) {
        ResponseResult<Object> result = null;
        return result;
    }
}
