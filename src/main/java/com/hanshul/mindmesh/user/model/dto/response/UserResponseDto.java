package com.hanshul.mindmesh.user.model.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserResponseDto {
    private String firstName;
    private String secondName;
    private String email;
}
