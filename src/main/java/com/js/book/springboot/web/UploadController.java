package com.js.book.springboot.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

public class UploadController {
//    @ResponseBody // json 형식으로 리턴
//    @PostMapping(value = "/upload/uploadAjax", produces = "text/plain;charset=utf-8")
//    public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception {
//
//        //new ResponseEntity (데이터, 상태코드)
//        //new ResponseEntity (업로드된 파일이름, 상태코드)
//
//        return new ResponseEntity<String>(
//                UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes()), HttpStatus.OK);
//    }
}
