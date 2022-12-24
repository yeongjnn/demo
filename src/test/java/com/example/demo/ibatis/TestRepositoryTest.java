package com.example.demo.ibatis;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//junit5
@SpringBootTest
class TestRepositoryTest {

    @Autowired TestRepository repository;

    @Test
    @DisplayName("유저이름과 나이가 TBL_TEST 테이블에 저장되어야 한다.")
    void saveTest() {
        // given : 테스트 상황에 주어질 데이터
        TestEntity entity = new TestEntity();
        entity.setUsername("심리섭");
        entity.setAge(33);

        // when : 실제 테스트 실행
        boolean flag = repository.save(entity);

        // then : 테스트 결과 단언
        assertTrue(flag);
        assertNotNull(entity.getId());
    }

    @Test
    @DisplayName("유저이름과 나이를 수정해야 한다.")
    void modifyTest() {
        // given
        TestEntity entity = new TestEntity();
        entity.setUsername("이재홍");
        entity.setAge(38);
        entity.setId("5ff94f16-7f7b-4891-bae9-eb259fdb1f4f");

        // when
        boolean flag = repository.modify(entity);

        // then
        assertTrue(flag);
    }

    @Test
    @DisplayName("유저이름과 나이를 수정해야 한다.")
    @Transactional
    @Rollback
    void deleteTest() {
        // given
        String id = "17b1ac78-6679-4502-aeb1-37585da684bd";

        // when
        boolean flag = repository.remove(id);

        // then
        assertTrue(flag);
    }

    @Test
    @DisplayName("테스트 데이터 전체를 조회해야 한다.")
    void findAllTest() {
        // given
        // when
        List<TestEntity> entityList = repository.findAll();

        //then
        System.out.println(entityList);
        assertEquals(2, entityList.size());

    }
}