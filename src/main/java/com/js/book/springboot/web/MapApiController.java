package com.js.book.springboot.web;

import com.js.book.springboot.service.MapService;
import com.js.book.springboot.service.PostsService;
import com.js.book.springboot.web.dto.MapSaveRequestDto;
import com.js.book.springboot.web.dto.PostsResponseDto;
import com.js.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MapApiController {

    private final MapService mapService;

    @PostMapping("/api/v1/map")
    public Long save(@RequestBody MapSaveRequestDto requestDto) {
        return mapService.save(requestDto);
    }

    @DeleteMapping("/api/v1/map/{id}")
    public Long delete(@PathVariable Long id) {
        return mapService.delete(id);
    }

}
