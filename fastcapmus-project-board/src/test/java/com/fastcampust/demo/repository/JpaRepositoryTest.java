package com.fastcampust.demo.repository;

import com.fastcampust.demo.config.JpaConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.*;

@DisplayName("JPA 연결 데스트")
@Import(JpaConfig.class)
@DataJpaTest
class JpaRepositoryTes  {
  private final ArticleRepository articleRepository;
  private final ArticleCommentRepository articleCommentRepository;

    public JpaRepositoryTes(
            @Autowired ArticleRepository articleRepository,
            @Autowired ArticleCommentRepository articleCommentRepository) {
        this.articleRepository = articleRepository;
        this.articleCommentRepository = articleCommentRepository;
    }

    @DisplayName("select 테스트")
    @Test
    void givenTestData_WhenSelectinhthenWho(){

    }
}