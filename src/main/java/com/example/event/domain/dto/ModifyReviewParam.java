package com.example.event.domain.dto;

import lombok.Getter;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ModifyReviewParam {

    @Size(min = 36, max = 36)
    private String userId;

    @Size(min = 1)
    private String content;

    private List<@Size(min = 36, max = 36) String> attachedPhotoIds = new ArrayList<>();

    public static ModifyReviewParam createReviewParam(String userId, String content, List<String> attachedPhotoIds) {
        ModifyReviewParam newAddReviewParam = new ModifyReviewParam();
        newAddReviewParam.userId = userId;
        newAddReviewParam.content = content;
        newAddReviewParam.attachedPhotoIds = attachedPhotoIds;
        return newAddReviewParam;
    }
}
