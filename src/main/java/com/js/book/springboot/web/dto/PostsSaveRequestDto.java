package com.js.book.springboot.web.dto;


import com.js.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    private List<MultipartFile> uploadFiles;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author, MultipartFile[] file) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.uploadFiles = Arrays.asList(file);
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}
