package vttp.test2.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import vttp.test2.model.NewsArticle;

@Service
public class NewsService {
    private static final Logger logger = LoggerFactory.getLogger(NewsService.class);

    private static String cryptoNewsURL = "https://min-api.cryptocompare.com/data/v2/news/?lang=EN";

    public Optional<NewsArticle> getArticles(NewsArticle c) {
        // String apiKey = System.getenv("API_KEY");
        String apiKey = "18275781e9a5f2e934f76002ae4b4150f0c76fff27568c9b93d7ee5e40cb126f";
        
        String newsUrl = UriComponentsBuilder.fromUriString(cryptoNewsURL)
                            .queryParam("Apikey", apiKey)
                            .toUriString();
        logger.info("newsUrl >>>>> " + newsUrl);

        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp = null;
        
        try{
            resp = template.getForEntity(newsUrl, String.class);
           
            NewsArticle n = NewsArticle.createJson(resp.getBody());
            logger.info(resp.getBody());
            return Optional.of(n);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }

        return Optional.empty();
    }

}
