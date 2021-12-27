package com.example.event.service;

import com.example.event.client.ReviewServiceClient;
import com.example.event.config.ResponseResult;
import com.example.event.domain.Action;
import com.example.event.domain.dto.EventParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewService implements EventAction {

    private final ReviewServiceClient reviewServiceClient;

    @Override
    @Transactional
    public ResponseResult<Object> action(EventParam eventParam) {
        ResponseResult<Object> result = null;
        if(Action.ADD.equals(eventParam.getAction())) {
            result = this.reviewServiceClient.addReview(eventParam.getAddReviewParam());
        } else if(Action.MOD.equals(eventParam.getAction())) {
            result = this.reviewServiceClient.modifyReview(eventParam.getReviewId(), eventParam.getModifyReviewParam());
        } else if(Action.DELETE.equals(eventParam.getAction())) {
            result = this.reviewServiceClient.deleteReview(eventParam.getReviewId());
        }
        return result;
    }
}
