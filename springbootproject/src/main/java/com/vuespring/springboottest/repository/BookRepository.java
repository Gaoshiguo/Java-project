package com.vuespring.springboottest.repository;

import com.vuespring.springboottest.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {



}
