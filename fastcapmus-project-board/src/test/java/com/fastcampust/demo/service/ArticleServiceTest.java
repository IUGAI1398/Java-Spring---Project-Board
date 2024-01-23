package com.fastcampust.demo.service;


import com.fastcampust.demo.Domain.Article;
import com.fastcampust.demo.Domain.type.SearchType;
import com.fastcampust.demo.dto.ArticleDto;
import com.fastcampust.demo.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
public class ArticleServiceTest {


    @InjectMocks private ArticleService sut;
    @Mock private ArticleRepository articleRepository;

    @DisplayName("개시글 검색하면 , 게시글 리스트 반환한다.")
    @Test
    void givenSearchParameters_whenSearchingArticles_thenReturnsArticlePage() {
        Page<ArticleDto> articles = sut.searchArticles(SearchType.TITLE, "search keyword");

        assertThat(articles).isEmpty();
    }

    @DisplayName("게시글을 조회하면, 게시글을 반환한다.")
    @Test
    void givenArticleId_whenSearchingArticle_thenReturnsArticle() {
        // Given

        ArticleDto articles = sut.searchArticle(1L);
        assertThat(articles).isNotNull();

    }

    @DisplayName("게시글 입력하면 정보를 생선한다")
    @Test
    void givenArticleId_whenSaveArticle_thenSAveArticle() {
        // Given

       given(articleRepository.save(any(Article.class))).willReturn(null);

        sut.saveArticle(ArticleDto.of(LocalDateTime.now(), "title", "content", "aleks","asss"));

        then(articleRepository).should().save(any(Article.class));
    }

}
