package com.js.book.springboot.domain.posts;

import com.js.book.springboot.domain.BaseTimeEntity;
import com.js.book.springboot.domain.file.UploadFile;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @OneToMany(mappedBy = "posts", cascade = CascadeType.REMOVE)
    List<UploadFile> uploadFiles = new ArrayList<>();

    @Builder
    public Posts(String title, String content, String author, UploadFile file) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.uploadFiles.add(file);
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
