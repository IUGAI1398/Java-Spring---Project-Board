package com.fastcampust.demo.repository;

import com.fastcampust.demo.Domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
