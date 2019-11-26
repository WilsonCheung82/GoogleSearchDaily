package com.naughtyzombie.boilerplate.springreactboilerplate;

import com.naughtyzombie.boilerplate.springreactboilerplate.repository.BookmarkRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.naughtyzombie.boilerplate.springreactboilerplate.model.Bookmark;
import com.naughtyzombie.boilerplate.springreactboilerplate.model.News;
import com.naughtyzombie.boilerplate.springreactboilerplate.model.security.User;
import com.naughtyzombie.boilerplate.springreactboilerplate.repository.NewsRepository;
import com.naughtyzombie.boilerplate.springreactboilerplate.resource.BookmarkResource;
import com.naughtyzombie.boilerplate.springreactboilerplate.security.repository.UserRepository;
import com.naughtyzombie.boilerplate.springreactboilerplate.service.BookmarkService;


@Configuration
@ComponentScan(basePackageClasses = {News.class, User.class, Bookmark.class})
@EnableJpaRepositories(basePackageClasses = {BookmarkService.class, BookmarkResource.class, News.class, User.class, Bookmark.class, NewsRepository.class, UserRepository.class, BookmarkRepository.class})
public class MainDataSourceConfig {
}
