package com.example.demo.todo.entity;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter @ToString
//@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 전체 필드 초기화 생성자
// 역할 : 하나의 할 일 데이터의 집합 객체
// DB에 그대로 들어갈 객체
public class ToDo {
    
    private String id; // 할 일들을 식별하는 번호
    private String userId; // 할 일을 등록한 회원의 식별자
    private String title; // 할 일의 내용
    private boolean done; // 할 일 완료 여부
    private Date regDate; // 할 일 등록 시간

    // 일련번호
    private static long seq; // static 을 쓰지 않으면 seq 가 '1'로만 나타남(long 타입의 기본값은 0).

    public ToDo() {
        this.id = UUID.randomUUID().toString();
    }

    public ToDo(String title) {
        this(); // 자신의 기본 생성자 호출. 무조건 첫줄에 써야.
        this.title = title;
        this.userId = "noname";
//        this.done = false; // boolean 의 기본값은 false 이기 때문에 안 써도 됨.
    }
}
