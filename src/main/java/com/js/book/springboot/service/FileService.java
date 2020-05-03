package com.js.book.springboot.service;

import com.js.book.springboot.domain.file.UploadFile;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class FileService {
    public UploadFile fileUplaod(List<MultipartFile> file) throws Exception{

        for (MultipartFile mf: file) {
            String originalFilename = mf.getOriginalFilename();
            String sourceFileNameExtension = FilenameUtils.getExtension(originalFilename);
            File storedFile;

            String storedFileName = RandomStringUtils.randomAlphanumeric(10) + "." + originalFilename;
            do {
                storedFile = new File("C:\\attachments\\" + storedFileName);
            } while (storedFile.exists());

            storedFile.getParentFile().mkdirs();
            mf.transferTo(storedFile);
        }

        return null;
    }
}
