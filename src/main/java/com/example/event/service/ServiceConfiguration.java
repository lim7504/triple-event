package com.example.event.service;

import com.example.event.domain.EventType;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ServiceConfiguration {

    @Bean
    public Map<EventType, EventAction> getEventAction(ReviewService reviewService, PostService postService) {
        Map<EventType, EventAction> map = new HashMap<>();
        map.put(EventType.REVIEW, reviewService);
        map.put(EventType.POST, postService);
        return map;
    }

}
