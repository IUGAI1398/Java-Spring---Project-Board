package com.fastcampust.demo.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

public record ArticleDto(
        LocalDateTime createdAt,
        String title,
        String content,
        String createdBy,
        String hashtag
) implements Serializable {
    public static  ArticleDto of (LocalDateTime createdAt, String title, String content, String createdBy, String hashtag) {
       return  new ArticleDto(createdAt, title, content, createdBy, hashtag);
    }
}
