package com.vuespring.springboottest;

import com.vuespring.springboottest.entity.Book;
import com.vuespring.springboottest.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import java.util.Date;
@SpringBootTest
@EnableJpaAuditing
class SpringboottestApplicationTests {
    @Autowired
    private BookRepository repository;
    @Test
    void contextLoads() {
        PageRequest pagerequest = PageRequest.of(0,3);
        Page<Book> page = repository.findAll(pagerequest);
        int i=0;
    }
    @Test
    void save(){
        Book book = new Book();
        book.setTitle("java");
        book.setAuthor("hello");
        book.setPrice(12);
        Date date = new Date();
        book.setCreate_time(date);
        Book book1 = repository.save(book);
        System.out.println(book1);
    }

}
