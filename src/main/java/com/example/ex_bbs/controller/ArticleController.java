package com.example.ex_bbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ex_bbs.domain.Article;
import com.example.ex_bbs.form.ArticleForm;
import com.example.ex_bbs.service.ArticleService;

/**
 * 記事一覧画面を表示するクラスです.
 * 
 * @author suzukiayumu
 */

@Controller
@RequestMapping("/board")
public class ArticleController {

  @Autowired
  private ArticleService articleService;

  /**
   * 記事一覧画面を表示します.
   * 全ての記事を新しい順で取得し、画面に表示します。
   * 
   * @param modelに渡すデータを格納するModelオブジェクト
   * @return 記事一覧画面("index")
   */

  @RequestMapping("/index")
  public String index(Model model) {
    List<Article> articles = articleService.findAllWithComment();
    model.addAttribute("articles", articles);
    return "index";
  }

  /**
   * 記事を投稿します.
   * フォームから送信された記事情報をデータベースに保存します。
   * 
   * @param form 投稿フォームデータ
   * @return 記事一覧画面へのリダイレクト
   */

   @RequestMapping("/insertArticle")
   public String insertArticle(ArticleForm form) {
    Article article = new Article();
    article.setName(form.getName());
    article.setContent(form.getContent());
    articleService.insert(article);
    return "redirect:/index";
   }
}