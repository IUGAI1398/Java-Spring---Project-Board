package com.fastcampust.demo.service;

import com.fastcampust.demo.Domain.type.SearchType;
import com.fastcampust.demo.dto.ArticleCommentDto;
import com.fastcampust.demo.dto.ArticleDto;
import com.fastcampust.demo.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional(readOnly  = true)
    public Page<ArticleDto> searchArticles(SearchType searchType, String searchKeyword) {
        return  Page.empty();
     }

    public ArticleDto searchArticle(long l) {
        return  null;
    }

    public void saveArticle(ArticleDto dto) {

    }


}
