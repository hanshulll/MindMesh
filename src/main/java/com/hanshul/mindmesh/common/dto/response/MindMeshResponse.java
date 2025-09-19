package com.hanshul.mindmesh.common.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Builder
public class MindMeshResponse<T,J> {
    private boolean isSuccess;
    private Meta<J> meta;
    private T data;
}
