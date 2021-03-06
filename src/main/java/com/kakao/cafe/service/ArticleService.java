package com.kakao.cafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kakao.cafe.domain.Article;
import com.kakao.cafe.exception.ArticleException;
import com.kakao.cafe.exception.ErrorCode;
import com.kakao.cafe.repository.ArticleRepository;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public int add(Article article) {
        article.checkBlankInput();
        return articleRepository.save(article);
    }

    public List<Article> findArticles() {
        return articleRepository.findAll();
    }

    public Article findById(int index) {
        return articleRepository.findById(index).orElseThrow(() ->
            new ArticleException(ErrorCode.NO_MATCH_ARTICLE));
    }
}
