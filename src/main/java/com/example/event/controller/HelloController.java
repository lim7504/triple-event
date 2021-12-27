package com.example.event.controller;

import com.example.event.client.ReviewServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@RequiredArgsConstructor
public class HelloController {

    private final ReviewServiceClient reviewServiceClient;

    @GetMapping
    public ResponseEntity get() {
        return ResponseEntity.ok("event hello~");
    }

    @GetMapping("/2")
    public ResponseEntity getReviewHello() {
        String hello = reviewServiceClient.hello();
        return ResponseEntity.ok(hello);
    }
}
