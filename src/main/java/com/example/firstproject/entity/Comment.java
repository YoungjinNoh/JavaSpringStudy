package com.example.firstproject.entity;

import com.example.firstproject.dto.CommentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne //many to one relation between comment and article
    @JoinColumn(name="article_id")
    private Article article;

    @Column
    private String nickname;

    @Column
    private String body;

    public static Comment createComment(CommentDto dto, Article article) {
        if(dto.getId()!=null)
            throw new IllegalArgumentException("create comment fail! require set id null!");
        if(dto.getArticleId()!=article.getId())
            throw new IllegalArgumentException("create comment fail! check id");
        return new Comment(
                dto.getId(),
                article,
                dto.getNickname(),
                dto.getBody()
        );
    }

    public void patch(CommentDto dto) {
        if(this.id!=dto.getId())
            throw new IllegalArgumentException("id value error");

        if(dto.getNickname()!=null)
            this.nickname=dto.getNickname();

        if(dto.getBody()!=null)
            this.body=dto.getBody();
    }
}
