package com.example.ex_bbs.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.ex_bbs.domain.Article;

/**
 * 記事テーブルの操作を行うリポジトリクラス.
 * 
 * @author suzukiayumu
 */

@Repository
public class ArticleRepository {

  @Autowired
  private NamedParameterJdbcTemplate template;

/**
 * ArticleのRowMapperです.
 * ResultSetから取得したデータをArticleオブジェクトに変換します。
 * データベースの各行をJavaオブジェクトに変換します。
 */

  private static final RowMapper<Article> ARTICLE_ROW_MAPPER =(rs,i) -> {
    Article article = new Article();
    article.setId(rs.getInt("id"));
    article.setName(rs.getString("name"));
    article.setContent(rs.getString("content"));
    return article;
  };

/**
 * 全ての記事を取得します.
 * 新しい投稿が上に来るように降順で取得します。
 * 
 * @return 記事一覧（新しい投稿順）
 */

   public List<Article> findAll() {
    String sql = "SELECT id, name, content FROM articles ORDER BY id DESC";
    return template.query(sql, ARTICLE_ROW_MAPPER);
   }
}
