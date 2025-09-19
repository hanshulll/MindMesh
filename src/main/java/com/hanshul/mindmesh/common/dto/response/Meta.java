package com.hanshul.mindmesh.common.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Builder
public class Meta<J> {
    private Instant timeTaken;
    private J request;
    private int status;
}