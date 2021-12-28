package com.example.event.controller;

import com.example.event.domain.Action;
import com.example.event.domain.EventType;
import com.example.event.domain.dto.EventParam;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.net.MediaType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class EventControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

//    @Test
//    @DisplayName("리뷰 추가")
//    void testAddEvent() throws Exception {
//
//        EventParam eventParam = EventParam.builder()
//                .type(EventType.REVIEW)
//                .action(Action.ADD)
//                .userId("04ea2107-7b9e-4360-8099-6f10ce2276ac")
//                .placeId("603178bc-214a-49f0-85ea-f1cacbeeaa41")
//                .content("콘텐츠")
//                .attachedPhotoIds(List.of("qb5f4de6-1714-4973-8d4f-c9a68e1a1a6e", "qeafa503-7d28-4cdd-bfe5-d8aba810f9f6"))
//                .build();
//
//        mockMvc.perform(post("/events")
//                .contentType(String.valueOf(MediaType.JSON_UTF_8))
//                .accept(String.valueOf(MediaType.JSON_UTF_8))
//                .content(objectMapper.writeValueAsString(eventParam)))
//                .andExpect(status().isOk())
//                .andDo(print());
//    }
}