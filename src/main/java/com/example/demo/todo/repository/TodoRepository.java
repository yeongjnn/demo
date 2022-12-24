package com.example.demo.todo.repository;

import com.example.demo.todo.entity.ToDo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
// 역할 : 할 일 데이터를 CRUD 한다(생성, 조회, 수정, 삭제).
public interface TodoRepository {

    // 할 일 생성 기능

    /**
     * 할 일 데이터를 저장소에 저장하는 기능
     * @param todo - 할 일 데이터의 집합
     * @return - 저장 성공 시 true, 실패 시 false
     */
    boolean save(ToDo todo);

    // 할 일 목록 조회 기능
    List<ToDo> findAll(String userId);

    // 할 일 개별 조회 기능
    ToDo findOne(String id);

    // 할 일 삭제 기능
    boolean remove(String id);

    // 할 일 수정 기능 (체크 기능, 제목수정 기능)
    boolean modify(ToDo todo);
}
