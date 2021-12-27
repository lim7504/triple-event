package com.example.event.client;

import com.example.event.config.ResponseResult;
import com.example.event.domain.dto.AddReviewParam;
import com.example.event.domain.dto.ModifyReviewParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "review-service")
public interface ReviewServiceClient {

    @GetMapping("/hello")
    String hello();

    @PostMapping("reviews")
    ResponseResult<Object> addReview(@RequestBody AddReviewParam addReviewParam);

    @PutMapping("reviews/{review-id}")
    ResponseResult<Object> modifyReview(@PathVariable("review-id") String reviewId,
                                        @RequestBody ModifyReviewParam modifyReviewParam);

    @DeleteMapping("reviews/{review-id}")
    ResponseResult<Object> deleteReview(@PathVariable("review-id") String reviewId);

}
