package com.js.book.springboot.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {
    @PostMapping(value = "/upload/uploadAjax")
    public void uploadAjax(MultipartFile file) throws Exception {
        System.out.println(file.getOriginalFilename());

    }
}
