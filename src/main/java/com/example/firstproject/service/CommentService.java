package com.example.firstproject.service;

import com.example.firstproject.dto.CommentDto;
import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ArticleRepository articleRepository;

    public List<CommentDto> comments(Long articleId) {
//        List<Comment> comments = commentRepository.findByArticleId(articleId);
//        List<CommentDto> dtos = new ArrayList<CommentDto>();
//        for(int i=0;i<comments.size();i++){
//            Comment c=comments.get(i);
//            CommentDto dto=CommentDto.createCommentDto(c);
//            dtos.add(dto);
//        }
        return commentRepository.findByArticleId(articleId)
                .stream()
                .map(comment -> CommentDto.createCommentDto(comment))
                .collect(Collectors.toList());
    }

    @Transactional
    public CommentDto create(Long articleId, CommentDto dto) {
        Article article=articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("create comment fail"));
        Comment comment=Comment.createComment(dto,article);

        Comment created=commentRepository.save(comment);

        return CommentDto.createCommentDto(created);
    }

    @Transactional//require transactional because this method deal with data
    public CommentDto update(Long id, CommentDto dto) {
        Comment target=commentRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("target comment missing"));
        target.patch(dto);
        Comment updated=commentRepository.save(target);
        return CommentDto.createCommentDto(updated);
    }

    @Transactional
    public CommentDto delete(Long id) {
        Comment target=commentRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("target comment missing"));

        commentRepository.delete(target);

        return CommentDto.createCommentDto(target);
    }
}
