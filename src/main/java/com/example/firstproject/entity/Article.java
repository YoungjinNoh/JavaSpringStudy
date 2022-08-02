package com.example.firstproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity//해당 클래스 형식에 맞게 DB에 테이블이 만들어지게 만듬
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//DB가 id를 자동 생성 어노테이션
    private Long id;
    @Column
    private String title;
    @Column
    private String content;

    public void patch(Article article){
        if(article.title!=null)
            this.title=article.title;
        if(article.content!=null)
            this.content=article.content;
    }
}
