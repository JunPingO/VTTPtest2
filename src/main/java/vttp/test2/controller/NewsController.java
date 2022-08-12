package vttp.test2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import vttp.test2.model.NewsArticle;
import vttp.test2.service.NewsService;

public class NewsController {

    private static final Logger logger = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    NewsService NewsService;

    @GetMapping ("/")
    public String showIndexPage(Model model) {
        logger.info("GETMAPPING works>>>");
        NewsArticle n = new NewsArticle();
        model.addAttribute("showArticles", n);
        return "text";
    }

    @PostMapping ("/articles")
    public String saveArticles(Model model) {
        logger.info("post works>>>");
        NewsArticle n = new NewsArticle();
        model.addAttribute("showArticles", n);
        return "articles";
    }
    
}
