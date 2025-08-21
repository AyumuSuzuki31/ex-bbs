package com.example.ex_bbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ex_bbs.domain.Article;
import com.example.ex_bbs.form.ArticleForm;
import com.example.ex_bbs.repository.ArticleRepository;

/**
 * 記事一覧画面を表示するクラスです.
 * 
 * @author suzukiayumu
 */

@Controller
@RequestMapping()
public class ArticleController {

  @Autowired
  private ArticleRepository articleRepository;

  /**
   * 記事一覧画面を表示します.
   * 全ての記事を新しい順で取得し、画面に表示します.
   * 
   * @param model ビューに渡すデータを格納するModelオブジェクト
   * @return 記事一覧画面("index")
   */

  @GetMapping("/")
  public String index(Model model) {
    List<Article> articles = articleRepository.findAll();
    
    model.addAttribute("articles", articles);
    model.addAttribute("articleForm", new ArticleForm());
    
    return "index";
  }
}