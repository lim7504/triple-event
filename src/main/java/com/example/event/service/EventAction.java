package com.example.event.service;

import com.example.event.domain.dto.EventParam;

public interface EventAction {

    Object action(EventParam eventParam);

}
