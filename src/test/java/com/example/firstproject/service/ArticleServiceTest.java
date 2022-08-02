package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest// this class is associate with springboot
class ArticleServiceTest {
    @Autowired
    ArticleService articleService;


    @Test
//this method is ot test
    void index() {
        //expect
        Article a = new Article(1L, "aaa", "111");
        Article b = new Article(2L, "bbb", "222");
        Article c = new Article(3L, "ccc", "333");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a, b, c));

        //real
        List<Article> articles = articleService.index();

        //compare
        assertEquals(expected.toString(),articles.toString());
    }

    @Test
    void show_success() {

        Long id=1L;
        Article expected=new Article(id,"aaa","111");

        Article article=articleService.show(id);

        assertEquals(expected.toString(),article.toString());

    }

    @Test
    void show_fail(){
        Long id=-1L;
        Article expected=null;

        Article article=articleService.show(id);

        assertEquals(expected,article);
    }

    @Test
    @Transactional//i don't know if it's required.
    void create_success() {
        String title="adsf";
        String content="12323";
        ArticleForm dto=new ArticleForm(null,title,content);

        Article expected=new Article(4L,title,content);

        Article article=articleService.create(dto);

        assertEquals(expected.toString(),article.toString());
    }

    @Test
    void create_fail(){
        String title="adsf";
        String content="12323";
        ArticleForm dto=new ArticleForm(4L,title,content);

        Article expected=null;

        Article article=articleService.create(dto);

        assertEquals(expected,article);
    }


    //the rest of test function are homework....
}