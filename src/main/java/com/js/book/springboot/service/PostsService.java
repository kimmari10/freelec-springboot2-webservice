package com.js.book.springboot.service;

import com.js.book.springboot.domain.file.UploadFile;
import com.js.book.springboot.domain.file.UploadFileRepository;
import com.js.book.springboot.domain.posts.Posts;
import com.js.book.springboot.domain.posts.PostsRepository;
import com.js.book.springboot.web.dto.PostsListResponseDto;
import com.js.book.springboot.web.dto.PostsResponseDto;
import com.js.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;
    private final UploadFileRepository fileRepository;
    private final FileService fileService;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) throws IOException {

        Posts posts = requestDto.toEntity();
        UploadFile file = UploadFile.builder()
                .file(requestDto.getFile())
                .posts(posts)
                .build();

        fileService.fileUplaod(requestDto.getFile());

        fileRepository.save(file);
        return postsRepository.save(posts).getId();
    }

    @Transactional
    public Long update(Long id, PostsSaveRequestDto requestDto) {
        Posts entity = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 없습니다. id = "+ id));

        entity.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional
    public Long delete(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 없습니다. id = "+ id));

        postsRepository.delete(entity);

        return id;
    }

    @Transactional
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 없습니다. id = "+ id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAll() {
        return postsRepository.findAll()
                .stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }
}
