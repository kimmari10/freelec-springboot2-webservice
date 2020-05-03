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
public class UploadFile extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String fileName;


    @ManyToOne(cascade = CascadeType.ALL)
    private Posts posts;

    @Builder
    public UploadFile(String fileName, Posts posts) {
        this.fileName = fileName;
        this.posts = posts;
    }

}
