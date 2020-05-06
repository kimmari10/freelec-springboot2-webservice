package com.js.book.springboot.web.dto;

import com.js.book.springboot.domain.posts.Posts;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor
public class PostsListResponseDto {
    private Long id;
    private String title;
    private String author;
    private String modifiedDate;
    private String existFileYn;

    public PostsListResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.existFileYn = entity.getUploadFiles().size() > 0 ? "Y" : "N";
    }
}
