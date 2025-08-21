package com.example.ex_bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ex_bbs.domain.Article;
import com.example.ex_bbs.repository.ArticleRepository;

/**
 * 記事に関するビジネスロジックを提供するサービスクラスです.
 * 
 * @author suzukiayumu
 */
@Service
public class ArticleService {
    
    @Autowired
    private ArticleRepository articleRepository;
    
    /**
     * 全ての記事を取得します.
     * 
     * @return 記事リスト
     */
    public List<Article> findAll() {
        return articleRepository.findAll();
    }
}