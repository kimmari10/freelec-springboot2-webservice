package com.js.book.springboot.service;

import com.js.book.springboot.domain.file.UploadFile;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileService {
    public UploadFile fileUplaod(MultipartFile file) throws Exception{

        String originalFilename = file.getOriginalFilename();
        String sourceFileNameExtension = FilenameUtils.getExtension(originalFilename);
        File storedFile;

        String storedFileName = RandomStringUtils.randomAlphanumeric(10) + "." + originalFilename;
        do {
            storedFile = new File("C:\\attachments\\" + storedFileName);
        } while (storedFile.exists());

        storedFile.getParentFile().mkdirs();
        file.transferTo(storedFile);

        return null;
    }
}
