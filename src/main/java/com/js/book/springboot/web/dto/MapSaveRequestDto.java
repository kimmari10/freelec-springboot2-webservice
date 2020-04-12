package com.js.book.springboot.web.dto;


import com.js.book.springboot.domain.map.posts.Map;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MapSaveRequestDto {

    private String title;
    private String lat;
    private String lng;

    @Builder
    public MapSaveRequestDto(String title, String lat, String lng) {
        this.title = title;
        this.lat = lat;
        this.lng = lng;
    }

    public Map toEntity() {
        return Map.builder()
                .title(title)
                .lat(lat)
                .lng(lng)
                .build();
    }
}
