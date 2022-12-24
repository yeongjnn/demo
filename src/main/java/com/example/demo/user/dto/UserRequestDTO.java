package com.example.demo.user.dto;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
// 사용자가 직접 입력하는 정보
public class UserRequestDTO {

    private String email;
    private String password;
    private String username;
}
