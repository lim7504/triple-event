package com.example.event.service;

import com.example.event.config.ResponseResult;
import com.example.event.domain.dto.EventParam;

public interface EventAction {

    ResponseResult<Object> action(EventParam eventParam);

}
