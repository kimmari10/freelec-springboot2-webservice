package com.js.book.springboot.web;

import com.js.book.springboot.domain.file.UploadFile;
import com.js.book.springboot.service.FileService;
import com.js.book.springboot.service.PostsService;
import com.js.book.springboot.web.dto.PostsResponseDto;
import com.js.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;
    private final FileService fileService;

    @PostMapping("/api/v1/posts")
    public Long save(String title, String author, String content, MultipartFile[] file) throws Exception {
        return postsService.save(PostsSaveRequestDto.builder()
                .title(title)
                .author(author)
                .content(content)
                .file(file)
                .build());
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsSaveRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        return postsService.delete(id);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @GetMapping("/fileDown/{id}")
    public void fileDown(@PathVariable long id, HttpServletRequest request,
                         HttpServletResponse response)throws Exception {
        request.setCharacterEncoding("UTF-8");
        UploadFile uploadFile = fileService.getFile(id);

        //파일 업로드된 경로
        String fileUrl = "C:\\attachments\\";
//        String fileUrl = uploadFile.getFileUrl();
//        fileUrl += "/";
        String savePath = fileUrl;
        String fileName = uploadFile.getFileName();

        //실제 내보낼 파일명
        String oriFileName = uploadFile.getFileName();
        InputStream in = null;
        OutputStream os = null;
        File file = null;
        boolean skip = false;
        String client = "";

        //파일을 읽어 스트림에 담기
        try{
            file = new File(savePath, fileName);
            in = new FileInputStream(file);


            client = request.getHeader("User-Agent");

            //파일 다운로드 헤더 지정
            response.reset();
            response.setContentType("application/octet-stream");
            //response.setHeader("Content-Description", "JSP Generated Data");

            // IE
            if (client.indexOf("MSIE") != -1) {
                response.setHeader("Content-Disposition", "attachment; filename=\""
                        + java.net.URLEncoder.encode(oriFileName, "UTF-8").replaceAll("\\+", "\\ ") + "\"");
                // IE 11 이상.
            } else if (client.indexOf("Trident") != -1) {
                response.setHeader("Content-Disposition", "attachment; filename=\""
                        + java.net.URLEncoder.encode(oriFileName, "UTF-8").replaceAll("\\+", "\\ ") + "\"");
            } else {
                // 한글 파일명 처리
                response.setHeader("Content-Disposition",
                        "attachment; filename=\"" + new String(oriFileName.getBytes("UTF-8"), "ISO8859_1") + "\"");
                response.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
            }
            response.setHeader("Content-Length", "" + file.length());
            os = response.getOutputStream();
            byte b[] = new byte[(int) file.length()];
            int leng = 0;
            while ((leng = in.read(b)) > 0) {
                os.write(b, 0, leng);
            }
        } catch (FileNotFoundException fe) {
            System.out.println(fe.toString());
        } finally {
            in.close();
            os.close();
        }
    }

}
