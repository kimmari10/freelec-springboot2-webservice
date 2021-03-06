package com.js.book.springboot.web.dto;

import com.js.book.springboot.domain.map.posts.Map;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MapListResponseDto {
    private Long id;
    private String title;
    private String lat;
    private String lng;

    public MapListResponseDto(Map entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.lat = entity.getLat();
        this.lng = entity.getLng();
    }
}
