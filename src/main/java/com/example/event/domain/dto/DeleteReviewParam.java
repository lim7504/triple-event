package com.example.event.domain.dto;

import lombok.Getter;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
public class DeleteReviewParam {

    @Size(min = 36, max = 36)
    private String userId;

    public static DeleteReviewParam createReviewParam(String userId) {
        DeleteReviewParam newAddReviewParam = new DeleteReviewParam();
        newAddReviewParam.userId = userId;
        return newAddReviewParam;
    }
}
