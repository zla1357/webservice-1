package com.webservice.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity // 테이블을 뜻하는 어노테이션
public class Posts {

    @Id // pk를 뜻하는 어노테이션
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk의 생성 규칙, GenerationType.IDENTITY가 있어야 자동증가가 됨
    private Long id;

    @Column(length = 500, nullable = false) // 컬럼을 뜻하는 어노테이션 굳이 선언하지 않아도 컬럼이 되지만 옵션지정을 위해
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
