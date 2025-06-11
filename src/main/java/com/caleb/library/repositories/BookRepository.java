package com.caleb.library.repositories;

import com.caleb.library.dto.BookDTO;
import com.caleb.library.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

//    @Query(nativeQuery = true, value = "SELECT * FROM tb_book INNER JOIN tb_publisher ON tb_book.publisher_id = tb_publisher.id")
//    private List<BookDTO> findByIdWithPublisher(Integer id);
}
