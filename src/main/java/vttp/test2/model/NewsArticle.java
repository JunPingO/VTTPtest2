package vttp.test2.model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class NewsArticle {
    private static final Logger logger = LoggerFactory.getLogger(NewsArticle.class);

    private String id;
    private String published_on;
    private String title;
    private String url;
    private String imageurl;
    private String body;
    private String tags;
    private String categories;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPublished_on() {
        return published_on;
    }
    public void setPublished_on(String published_on) {
        this.published_on = published_on;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getImageurl() {
        return imageurl;
    }
    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public String getTags() {
        return tags;
    }
    public void setTags(String tags) {
        this.tags = tags;
    }
    public String getCategories() {
        return categories;
    }
    public void setCategories(String categories) {
        this.categories = categories;
    }

    public static NewsArticle createJson(String json) throws IOException {
        logger.info("NewsArticle createJson method");
        NewsArticle n = new NewsArticle();

        try (InputStream is = new ByteArrayInputStream(json.getBytes())) {
            JsonReader reader = Json.createReader(is);
            JsonObject object = reader.readObject();
            logger.info(object.toString());
            JsonObject mainObj = object.getJsonObject("Data");
            n.id = mainObj.getJsonNumber("id").toString();
            n.published_on = mainObj.getJsonNumber("published_on").toString();
            n.imageurl = mainObj.getJsonString("imageurl").toString();
            n.title = mainObj.getJsonString("title").toString();
            n.url = mainObj.getJsonString("url").toString();
            n.body = mainObj.getJsonString("body").toString();
            n.categories = mainObj.getJsonString("categories").toString();
            logger.info(">>>>>> " + n.toString());
        }
        return n;
    }
    
}
