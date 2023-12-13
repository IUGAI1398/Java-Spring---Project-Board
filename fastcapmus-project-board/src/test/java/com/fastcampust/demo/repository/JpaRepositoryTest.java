package com.fastcampust.demo.repository;

import com.fastcampust.demo.Domain.Article;
import com.fastcampust.demo.config.JpaConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("JPA 연결 데스트")
@Import(JpaConfig.class)
@DataJpaTest
class JpaRepositoryTest {
  private final ArticleRepository articleRepository;
  private final ArticleCommentRepository articleCommentRepository;

    public JpaRepositoryTest(
            @Autowired ArticleRepository articleRepository,
            @Autowired ArticleCommentRepository articleCommentRepository) {
        this.articleRepository = articleRepository;
        this.articleCommentRepository = articleCommentRepository;
    }

    @DisplayName("select 테스트")
    @Test
    void givenTestData_WhenSelectinhthenWho(){
        List<Article> articles = articleRepository.findAll();

        assertThat(articles)
                .isNotNull()
                .hasSize(1); // classpath:resources/data.sql 참조
    }

    @DisplayName("insert 테스트")
    @Test
    void  givenTestData_WheninsertinhthenWho(){
        long previusCount = articleRepository.count();
        System.out.println(previusCount);
        Article article = Article.of("new article", "new content", "spring");

        articleRepository.save(article);

        assertThat(articleRepository.count()).isEqualTo(previusCount + 1);
    }

    @DisplayName("update 테스트")
    @Test
    void  givenTestData_WhenUpdatenhthenWho(){
          Article article = articleRepository.findById(1000001L).orElseThrow();
          String updateHashtag = "springboot";
          article.setHashtag(updateHashtag);
          Article savedarticle = articleRepository.saveAndFlush(article);

          assertThat(savedarticle).hasFieldOrPropertyWithValue("hashtag", updateHashtag);
    }

    @DisplayName("delete 테스트")
    @Test
    void  givenTestData_WhenDeletehthenWho(){
        Article article = articleRepository.findById(1000001L).orElseThrow();
      long  previusArticle = articleRepository.count();
      long priveiusArticlecomment = articleCommentRepository.count();
      int deltegommentsize = article.getArticleCommentSet().size();

      articleRepository.delete(article);

      assertThat(articleRepository.count()).isEqualTo(previusArticle - 1);
      assertThat(articleCommentRepository.count()).isEqualTo(priveiusArticlecomment - deltegommentsize);


    }
}