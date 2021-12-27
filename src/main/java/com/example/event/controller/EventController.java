package com.example.event.controller;

import com.example.event.config.ResponseResult;
import com.example.event.domain.dto.EventParam;
import com.example.event.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @PostMapping
    public ResponseEntity<Object> addEvent(@Validated @RequestBody EventParam eventParam) {
        return this.eventService.addEvent(eventParam).createResponseEntity();
    }

    @GetMapping
    public ResponseEntity get() {
        return ResponseEntity.ok(UUID.randomUUID().toString());
    }
}
