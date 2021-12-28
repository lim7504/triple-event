package com.example.event.service;

import com.example.event.client.ReviewServiceClient;
import com.example.event.config.ResponseResult;
import com.example.event.config.TripleException;
import com.example.event.domain.Action;
import com.example.event.domain.dto.EventParam;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewService implements EventAction {

    private final ReviewServiceClient reviewServiceClient;
    private final ObjectMapper om;

    @Override
    @Transactional
    public Object action(EventParam eventParam) {
        ResponseResult<Object> result = null;
        try {
            if (Action.ADD.equals(eventParam.getAction())) {
                result = this.reviewServiceClient.addReview(eventParam.getAddReviewParam());
            } else if (Action.MOD.equals(eventParam.getAction())) {
                result = this.reviewServiceClient.modifyReview(eventParam.getReviewId(), eventParam.getModifyReviewParam());
            } else if (Action.DELETE.equals(eventParam.getAction())) {
                result = this.reviewServiceClient.deleteReview(eventParam.getReviewId(), eventParam.getDeleteReviewParam());
            }
        } catch (FeignException.FeignClientException e) {
            e.responseBody().ifPresent(byteBuffer -> {
                String jsonBody = new String(byteBuffer.array());
                ResponseResult responseResult = null;
                try {
                    responseResult = om.readValue(jsonBody, ResponseResult.class);
                } catch (JsonProcessingException jsonProcessingException) {
                    jsonProcessingException.printStackTrace();
                }
                throw new TripleException(responseResult.getCode());
            });
        }
        return result.getData();
    }
}
