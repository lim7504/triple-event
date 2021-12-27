package com.example.event.domain.dto;

import com.example.event.domain.Action;
import com.example.event.domain.EventType;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
public class EventParam {

    @NotNull
    private EventType type;

    @NotNull
    private Action action;

    @Size(min = 36, max = 36)
    private String reviewId;

    @NotNull
    @Size(min = 36, max = 36)
    private String userId;

    @Size(min = 36, max = 36)
    private String placeId;

    @Size(min = 1)
    private String content;

    private List<@Size(min = 36, max = 36) String> attachedPhotoIds = new ArrayList<>();

    public String toStringForEventHistory() {
        return "{" +
                "reviewId='" + reviewId + '\'' +
                ", content='" + content + '\'' +
                ", attachedPhotoIds=" + attachedPhotoIds +
                ", userId='" + userId + '\'' +
                ", placeId='" + placeId + '\'' +
                '}';
    }

    public AddReviewParam getAddReviewParam() {
        return AddReviewParam.createReviewParam(this.userId, this.placeId, this.content, this.attachedPhotoIds);
    }

    public ModifyReviewParam getModifyReviewParam() {
        return ModifyReviewParam.createReviewParam(this.content, this.attachedPhotoIds);
    }
}
