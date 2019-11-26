package com.naughtyzombie.boilerplate.springreactboilerplate.repository;

import com.naughtyzombie.boilerplate.springreactboilerplate.model.News;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
	
}
