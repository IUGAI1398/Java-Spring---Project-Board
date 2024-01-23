package com.fastcampust.demo.service;


import com.fastcampust.demo.Domain.Article;
import com.fastcampust.demo.Domain.type.SearchType;
import com.fastcampust.demo.dto.ArticleCommentDto;
import com.fastcampust.demo.dto.ArticleDto;
import com.fastcampust.demo.repository.ArticleCommentRepository;
import com.fastcampust.demo.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@DisplayName("비지니스 로직")
@ExtendWith(MockitoExtension.class)
public class ArticleCommentServiceTest {


    @InjectMocks
    private ArticleCommentService sut;

    @Mock private  ArticleRepository articleRepository;
    @Mock
    private ArticleCommentRepository articleCommentRepository;

    @DisplayName("게시글 ID로 조회하면, 해당하는 댓글 리스트를 반환한다.")
    @Test
    void givenArticleId_whenSearchingArticleComments_thenReturnsArticleComments() {
        // Given
        Long articleid = 1L;
        given(articleRepository.findById(articleid)).willReturn(Optional.of(Article.of("title","content","java")));

         List<ArticleCommentDto> articleCommentDtos = sut.searchArtcileComments();
         assertThat(articleCommentDtos).isNotNull();
         then(articleRepository).should().findById(articleid);
    }

}
