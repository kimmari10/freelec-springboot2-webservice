package com.js.book.springboot.service;

import com.js.book.springboot.domain.map.posts.Map;
import com.js.book.springboot.domain.map.posts.MapRepository;
import com.js.book.springboot.web.dto.MapListResponseDto;
import com.js.book.springboot.web.dto.MapSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class MapService {

    private final MapRepository mapRepository;

    @Transactional
    public Long save(MapSaveRequestDto requestDto) {
        return mapRepository.save(requestDto.toEntity()).getId();
    }


    @Transactional
    public Long delete(Long id) {
        Map entity = mapRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 없습니다. id = "+ id));

        mapRepository.delete(entity);

        return id;
    }


    @Transactional(readOnly = true)
    public List<MapListResponseDto> findAll() {
        return mapRepository.findAll()
                .stream()
                .map(MapListResponseDto::new)
                .collect(Collectors.toList());
    }
}
