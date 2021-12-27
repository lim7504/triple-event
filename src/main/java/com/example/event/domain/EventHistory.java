package com.example.event.domain;

import com.example.event.domain.dto.EventParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
public class EventHistory extends CreatedModifiedAuditing {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Enumerated(EnumType.STRING)
    private EventType type;

    @Enumerated(EnumType.STRING)
    private Action action;

    private String userId;

    private String json;

    public static EventHistory createEventHistory(EventParam param) {
        EventHistory newEventHistory = new EventHistory();
        newEventHistory.action = param.getAction();
        newEventHistory.type = param.getType();
        newEventHistory.userId = param.getUserId();
        newEventHistory.json = param.toStringForEventHistory();
        return newEventHistory;
    }

}
