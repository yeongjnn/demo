package com.example.demo.user.entity;

import com.example.demo.user.dto.UserRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

// 엔티티 객체는 해당 DB와 1 대 1 로 대응되게 만들어야.
@Setter @Getter @ToString
@AllArgsConstructor
public class UserEntity {

    private String id;
    private String username;
    private String email;
    private String password;
    private String profileImg;

    public UserEntity() {
        this.id = UUID.randomUUID().toString();
    }

    // dto를 entity로 변환
    public UserEntity(UserRequestDTO dto) {
        this();
        this.email = dto.getEmail();
        this.username = dto.getUsername();
        this.password = dto.getPassword();
    }
}