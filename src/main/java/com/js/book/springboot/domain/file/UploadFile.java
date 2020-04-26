package com.js.book.springboot.domain.file;

import com.js.book.springboot.domain.BaseTimeEntity;
import com.js.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class UploadFile extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String fileName;


    @ManyToOne
    private Posts posts;

    @Builder
    public UploadFile(MultipartFile file, Posts posts) {
        this.fileName = file.getOriginalFilename();
        this.posts = posts;
    }

}
