package com.naughtyzombie.boilerplate.springreactboilerplate.resource;

import com.naughtyzombie.boilerplate.springreactboilerplate.model.News;
import com.naughtyzombie.boilerplate.springreactboilerplate.service.NewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
@Slf4j
public class NewsResource {

    @Autowired
    NewsService newsService;

    @RequestMapping(path = "/allNews", method = GET)
    public List<News> getAllNews() {
        return newsService.getAllNews();
    }

    @RequestMapping(path = "/addNews", method = POST)
    public List<News> addNews(News news) {
        newsService.addNews(news);

        return newsService.getAllNews();
    }

}
