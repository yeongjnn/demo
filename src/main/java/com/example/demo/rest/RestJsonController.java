package com.example.demo.rest;


import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/json")
@Slf4j // 로깅 라이브러리
public class RestJsonController {

    /**
     * 로그 레벨
     *
     * TRACE - 잡다한 내용을 로깅 (1초마다 서버가 돌아가는 기록)
     * DEBUG - 개발 시 확인할 내용들 로깅
     * INFO - 운영 시 필요한 정보들을 로깅
     * WARN - 에러까지는 아닌데 좀 경고상황 로깅
     * ERROR - (서버에 위협을 주는) 심각한 에러 로깅
     * 개념 정도는 알고 있어라.
     */

    @PostMapping("/major")
    public List<String> major(@RequestBody List<String> majorList) {
        // 소괄호 안에 아무것도 안 쓰였다면 @RequestParam 이 숨어있는것.
        // 데이터가 json 으로 날라올 때 @RequestBody 를 써줘야.

        log.info("/json/major POST request! - {}", majorList); // System.out.println 은 메모리를 많이 잡아먹음
        return null;
    }

    /**
     * json
     * 리스트와 배열만 대괄호로 보냄. 나머지는 중괄호로 보내야.
     * 서버 실행한 상태에서 SEND 눌러야 콘솔창에 뜸.
     */

    @PutMapping("/bbs")
    public void bbs(@RequestBody Article article) {
        log.info("/json/bbs PUT request! - {}", article);
    }

    @DeleteMapping("/bbs-list")
    public void bbsList(@RequestBody List<Article> list) {
        log.info("/json/bbs-list DELETE request! - {}", list);
    }

    @Setter @Getter @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Article {

        private long id;
        private String title;
        private String content;
        private String writer;
    }

}
