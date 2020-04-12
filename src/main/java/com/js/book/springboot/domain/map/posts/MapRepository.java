package com.js.book.springboot.domain.map.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MapRepository extends JpaRepository<Map, Long> {

//    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
//    List<Posts> findAllDesc();
}
