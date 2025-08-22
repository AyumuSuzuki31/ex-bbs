package com.example.ex_bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ex_bbs.domain.Article;
import com.example.ex_bbs.domain.Comment;
import com.example.ex_bbs.repository.ArticleRepository;
import com.example.ex_bbs.repository.CommentRepository;

/**
 * 記事に関するビジネスロジックを提供するサービスクラスです.
 * 
 * @author suzukiayumu
 */
@Service
public class ArticleService {
    
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CommentRepository commentRepository;
    
    /**
     * 全ての記事を取得します.
     * 
     * @return 記事リスト
     */
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    /**
     * 記事を新規登録します.
     * 
     * @param article 登録する記事情報
     */
    public void insert(Article article) {
      articleRepository.insert(article);
    }

    /**
     * 全ての記事とそれに関するコメントを取得します.
     * 
     * @return コメント付き記事一覧
     */

     public List<Article> findAllWithComment() {
      List<Article> articles = articleRepository.findAll();

      for (Article article : articles) {
        List<Comment> comments = commentRepository.findByArticleId(article.getId());
        article.setCommentList(comments);
      }

      return articles;
     }


}