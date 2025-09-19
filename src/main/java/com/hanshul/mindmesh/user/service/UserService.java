package com.hanshul.mindmesh.user.service;

import com.hanshul.mindmesh.common.dto.response.Meta;
import com.hanshul.mindmesh.common.dto.response.MindMeshResponse;

import com.hanshul.mindmesh.user.model.dto.request.CreateUserRequestDto;
import com.hanshul.mindmesh.user.model.dto.response.UserResponseDto;
import com.hanshul.mindmesh.user.model.entity.UserEntity;
import com.hanshul.mindmesh.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.time.Instant;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    public ResponseEntity<MindMeshResponse> createUser(CreateUserRequestDto createUserRequestDto) {
        log.info("Inside UserService, createUser : {}", createUserRequestDto.getEmail());
        Instant startTime = Instant.now();
        createUserRequestDto.setPassword(bCryptPasswordEncoder.encode(createUserRequestDto.getPassword()));
        UserEntity userEntity = modelMapper.map(createUserRequestDto, UserEntity.class);
        UserResponseDto responseDto = this.userEntityToResponse(this.userRepository.save(userEntity));
        return new ResponseEntity<>(MindMeshResponse.builder()
                .isSuccess(true)
                .data(responseDto)
                .meta(Meta.builder().timeTaken(startTime)
                        .status(HttpStatus.CREATED.value())
                        .build())
                .build(), HttpStatus.CREATED);
    }

    private UserResponseDto userEntityToResponse(UserEntity userEntity) {
        return UserResponseDto.builder()
                .email(userEntity.getEmail())
                .firstName(userEntity.getFirstName())
                .secondName(userEntity.getSecondName())
                .build();
    }
}
