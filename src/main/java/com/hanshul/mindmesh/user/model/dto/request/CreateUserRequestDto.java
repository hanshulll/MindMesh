package com.hanshul.mindmesh.user.model.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequestDto {
    private String firstName;
    private String secondName;
    private String email;
    private String password;
}
