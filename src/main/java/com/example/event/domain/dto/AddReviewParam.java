package com.example.event.domain.dto;

import lombok.Getter;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
public class AddReviewParam {

    @Size(min = 36, max = 36)
    private String userId;

    @Size(min = 36, max = 36)
    private String placeId;

    private String content;

    private List<@Size(min = 36, max = 36) String> attachedPhotoIds = new ArrayList<>();

    public static AddReviewParam createReviewParam(String userId, String placeId, String content, List<String> attachedPhotoIds) {
        AddReviewParam newAddReviewParam = new AddReviewParam();
        newAddReviewParam.userId = userId;
        newAddReviewParam.placeId = placeId;
        newAddReviewParam.content = content;
        newAddReviewParam.attachedPhotoIds = attachedPhotoIds;
        return newAddReviewParam;
    }
}
