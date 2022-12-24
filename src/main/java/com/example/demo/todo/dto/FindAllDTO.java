package com.example.demo.todo.dto;

import com.example.demo.todo.entity.ToDo;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor

// 전체 목록 보여줄 때 필요한 객체
public class FindAllDTO {

    private int count; // 할 일 목록의 갯수
    private List<TodoDto> todos; // userId가 빠진 할 일 목록

    public FindAllDTO(List<ToDo> toDoList) {
        this.count = toDoList.size();
        this.convertDtoList(toDoList);
    }

    // List<ToDo>를 받으면 List<TodoDto>로 변환하는 메서드
    public void convertDtoList(List<ToDo> toDoList) {
        List<TodoDto> dtos = new ArrayList<>();

        for (ToDo toDo : toDoList) {
            dtos.add(new TodoDto(toDo)); // ctrl + alt + n, ctrl + alt + v
        }
        this.todos = dtos;
    }
}
