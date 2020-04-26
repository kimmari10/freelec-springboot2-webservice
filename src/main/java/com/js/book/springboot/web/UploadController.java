package com.js.book.springboot.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {

    @PostMapping(value = "/upload/uploadAjax")
    public void uploadAjax(String title, String author, String content, MultipartFile file) throws Exception {
        System.out.println(title);
        System.out.println(author);
        System.out.println(content);
        System.out.println(file.getOriginalFilename());
    }
}
