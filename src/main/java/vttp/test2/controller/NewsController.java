package vttp.test2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vttp.test2.model.NewsArticle;
import vttp.test2.service.NewsService;

@Controller
@RequestMapping(path = "/")

public class NewsController {

    private static final Logger logger = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    NewsService NewsService;

    @GetMapping ("/text")
    public String showIndexPage(Model model) {
        NewsArticle n = new NewsArticle();
        model.addAttribute("NewsArticle", n);
        return "text";
    }

    @PostMapping ("/articles")
    public String saveArticles(Model model) {
        logger.info("post works>>>");
        NewsArticle n = new NewsArticle();
        model.addAttribute("NewsArticle", n);
        return "articles";
    }
    
}
