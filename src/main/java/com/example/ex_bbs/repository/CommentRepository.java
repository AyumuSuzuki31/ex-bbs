package com.example.ex_bbs.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.ex_bbs.domain.Comment;

/**
 * コメントテーブルの操作を行うクラス.
 * 
 * @author suzukiayumu
 */
@Repository
public class CommentRepository {
  
  @Autowired
  private NamedParameterJdbcTemplate template;

  /**
   * CommentのRowMapperです.
   * ResultSetから取得したデータをCommentオブジェクトに変換します。
   */
  private static final RowMapper<Comment> COMMENT_ROW_MAPPER = (rs, i) -> {
    Comment comment = new Comment();
    comment.setId(rs.getInt("id"));
    comment.setName(rs.getString("name"));
    comment.setContent(rs.getString("content"));
    comment.setArticleId(rs.getInt("article_id"));
    return comment;
  };

  /**
   * 指定された記事IDのコメントを取得します.
   * id降順で並べ替えます。
   * 
   * @param articleId 記事ID
   * @return コメント一覧(id降順)
   */

   public List<Comment> findByArticleId(int articleId) {
    String sql = "SELECT id, name, content, article_id FROM comments WHERE article_id = :articleId ORDER BY id DESC";
    
    SqlParameterSource param = new MapSqlParameterSource().addValue("articleId", articleId);

    return template.query(sql, param, COMMENT_ROW_MAPPER);

   }
}
