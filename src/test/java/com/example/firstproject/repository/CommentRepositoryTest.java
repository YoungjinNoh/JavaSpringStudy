package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest //test that associate with jpa
class CommentRepositoryTest {
    @Autowired CommentRepository commentRepository;

    @Test
    @DisplayName("show all comment in the article")
    void findByArticleId() {
        //case 1
        {
            Long articleId=4L;
            List<Comment> comments=commentRepository.findByArticleId(articleId);

            Article article=new Article(4L,"what","111gg");
            Comment a=new Comment(1L,article,"park","fuck");
            Comment b=new Comment(2L,article,"kim","good");
            Comment c=new Comment(3L,article,"noh","sad");
            List<Comment> expected= Arrays.asList(a,b,c);

            assertEquals(expected.toString(), comments.toString(),"show 4 article comment");
        }

        //case2
        {

            Long articleId=1L;
            List<Comment> comments=commentRepository.findByArticleId(articleId);

            Article article=new Article(1L,"aaa","111");
            List<Comment> expected= Arrays.asList();


            assertEquals(expected.toString(), comments.toString(),"show no comment on 1 article");
        }
    }

    @Test
    @DisplayName("show all comment associate with the nickname")
    void findByNickname() {
        //case1
        {
            String nickname="park";
            List<Comment> comments=commentRepository.findByNickname(nickname);

            Comment a=new Comment(1L,new Article(4L,"what","111gg"),nickname,"fuck");
            Comment b=new Comment(4L,new Article(5L,"how","222gg"),nickname,"fudsfck");
            Comment c=new Comment(7L,new Article(6L,"when","333gg"),nickname,"yo");
            List<Comment> expected= Arrays.asList(a,b,c);

            assertEquals(expected.toString(), comments.toString(),"show all park's comment");
        }
    }
}