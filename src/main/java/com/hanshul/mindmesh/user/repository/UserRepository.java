package com.hanshul.mindmesh.user.repository;

import com.hanshul.mindmesh.user.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
