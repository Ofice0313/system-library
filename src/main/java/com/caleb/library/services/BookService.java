package com.caleb.library.services;

import com.caleb.library.dto.BookDTO;
import com.caleb.library.entities.Book;
import com.caleb.library.repositories.BookRepository;
import com.caleb.library.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Transactional(readOnly = true)
    public BookDTO findById(Integer id){
        Book book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));
        return new BookDTO(book);
    }
}
