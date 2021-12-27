package com.example.event.domain.dto;

import lombok.Getter;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ModifyReviewParam {

    private String content;

    private List<String> attachedPhotoIds = new ArrayList<>();

    public static ModifyReviewParam createReviewParam(String content, List<String> attachedPhotoIds) {
        ModifyReviewParam newAddReviewParam = new ModifyReviewParam();
        newAddReviewParam.content = content;
        newAddReviewParam.attachedPhotoIds = attachedPhotoIds;
        return newAddReviewParam;
    }
}
