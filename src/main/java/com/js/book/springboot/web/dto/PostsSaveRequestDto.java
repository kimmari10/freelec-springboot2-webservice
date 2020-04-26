package com.js.book.springboot.web.dto;


import com.js.book.springboot.domain.file.UploadFile;
import com.js.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    private MultipartFile file;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author, MultipartFile file) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.file = file;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .file(UploadFile.builder().file(file).build())
                .build();
    }
}
