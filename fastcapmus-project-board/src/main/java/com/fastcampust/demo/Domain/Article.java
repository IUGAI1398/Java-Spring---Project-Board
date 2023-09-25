package com.fastcampust.demo.Domain;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Table;
import java.time.LocalDateTime;


@Getter
@ToString
@Table
public class Article {
    private  Long id;
    private  String title;
    private  String hashtag;
    private LocalDateTime createdAt;
    private  String createdby;
    private  LocalDateTime CreatedAt;
    private  String createdBy;


}
