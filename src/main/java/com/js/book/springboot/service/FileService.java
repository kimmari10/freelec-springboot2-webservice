package com.js.book.springboot.service;

import com.js.book.springboot.domain.file.UploadFile;
import com.js.book.springboot.domain.file.UploadFileRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FileService {

    private final UploadFileRepository fileRepository;

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
    
    public UploadFile getFile(long fileId) {
        return fileRepository.getOne(fileId);
    }
}
