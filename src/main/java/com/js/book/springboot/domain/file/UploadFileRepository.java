package com.js.book.springboot.domain.file;

import com.js.book.springboot.domain.map.posts.Map;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadFileRepository extends JpaRepository<UploadFile, Long> {

}
