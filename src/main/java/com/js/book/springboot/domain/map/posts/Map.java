package com.js.book.springboot.domain.map.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Map{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String lat;
    private String lng;

    @Builder
    public Map(String title, String lat, String lng) {
        this.title = title;
        this.lat = lat;
        this.lng = lng;
    }

}
