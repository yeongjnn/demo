package com.example.demo.todo.dto;

import com.example.demo.todo.entity.ToDo;
import lombok.*;

import java.util.Date;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor

// 민감한 정보 빼고 공개가능한 데이터
public class TodoDto {

    private String id;
    private String title;
    private boolean done;
    private Date regDate;

    public String getTitle() {
        return title;
    }

    // ToDo에서 TodoDto가 필요한 필드를 빼오는 생성자
    public TodoDto(ToDo toDo) {
        this.id = toDo.getId();
        this.title = toDo.getTitle();
        this.done = toDo.isDone();
        this.regDate = toDo.getRegDate();
    }
}
