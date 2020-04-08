package com.js.book.springboot.domain.file;

import com.js.book.springboot.domain.BaseTimeEntity;
import com.js.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class AttacheFile extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String fileName;

    private long size;

    private String mimeType;

    @ManyToOne
    private Posts posts;

    @Builder
    public AttacheFile(String fileName, long size, String mimeType, Posts posts) {
        this.fileName = fileName;
        this.size = size;
        this.mimeType = mimeType;
        this.posts = posts;
    }

}
