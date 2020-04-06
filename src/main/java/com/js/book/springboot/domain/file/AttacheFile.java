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

    private String originName;

    private String storedName;

    private String path;

    private int size;

    @ManyToOne
    private Posts posts;

    @Builder
    public AttacheFile(String originName, String storedName, String path, int size) {
        this.originName = originName;
        this.storedName = storedName;
        this.path = path;
        this.size = size;
    }

}
