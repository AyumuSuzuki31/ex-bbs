package com.example.ex_bbs.form;

/**
 * 記事投稿用のフォームクラスです.
 * 画面からの入力値を受け取ります。
 * 
 * @author suzukiayumu
 */

public class ArticleForm {

  private String name;

  private String content;

  public ArticleForm() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
