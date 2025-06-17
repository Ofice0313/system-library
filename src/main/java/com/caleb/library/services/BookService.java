package com.caleb.library.services;

import com.caleb.library.dto.*;
import com.caleb.library.entities.Author;
import com.caleb.library.entities.Book;
import com.caleb.library.entities.Category;
import com.caleb.library.entities.Publisher;
import com.caleb.library.repositories.AuthorRepository;
import com.caleb.library.repositories.BookRepository;
import com.caleb.library.repositories.CategoryRepository;
import com.caleb.library.repositories.PublisherRepository;
import com.caleb.library.services.exceptions.DatabaseException;
import com.caleb.library.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public BookDTO findById(Integer id){
        Book book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));
        return new BookDTO(book);
    }

    @Transactional(readOnly = true)
    public Page<BookDTO> findAll(Pageable pageable){
        Page<Book> result = bookRepository.findAll(pageable);
        return result.map(x -> new BookDTO(x));
    }

    @Transactional
    public BookDTO insert(BookDTO dto){
        Book entity = new Book();
        copyDtoToEntity(dto, entity);
        entity = bookRepository.save(entity);
        return new BookDTO(entity);
    }

    @Transactional
    public BookPublisherDTO insert(BookPublisherDTO dto){

        Book entity = new Book();
        entity.setTitle(dto.getTitle());
        entity.setCountryPublished(dto.getCountryPublished());
        entity.setLanguage(dto.getLanguage());
        entity.setYearOfEdition(dto.getYearOfEdition());
        entity.setCdu(dto.getCdu());
        entity.setMatter(dto.getMatter());
        entity.setIsbn(dto.getIsbn());
        entity.setCaption(dto.getCaption());

        Publisher publisher = publisherRepository.getReferenceById(dto.getPublisher().getId());

        entity.setPublisher(publisher);

        entity = bookRepository.save(entity);
        return new BookPublisherDTO(entity);
    }

    @Transactional
    public BookPublisherAuthorDTO insert(BookPublisherAuthorDTO dto){

        Book entity = new Book();
        entity.setTitle(dto.getTitle());
        entity.setCountryPublished(dto.getCountryPublished());
        entity.setLanguage(dto.getLanguage());
        entity.setYearOfEdition(dto.getYearOfEdition());
        entity.setCdu(dto.getCdu());
        entity.setMatter(dto.getMatter());
        entity.setIsbn(dto.getIsbn());
        entity.setCaption(dto.getCaption());

        Publisher publisher = publisherRepository.getReferenceById(dto.getPublisher().getId());
        entity.setPublisher(publisher);

        for(AuthorDTO authorDTO: dto.getAuthors()){
            Author author = authorRepository.getReferenceById(authorDTO.getId());
            entity.getAuthors().add(author);
        }

        entity = bookRepository.save(entity);
        return new BookPublisherAuthorDTO(entity);
    }

    @Transactional
    public BookPublisherAuthorCategoryDTO insert(BookPublisherAuthorCategoryDTO dto){

        Book entity = new Book();
        entity.setTitle(dto.getTitle());
        entity.setCountryPublished(dto.getCountryPublished());
        entity.setLanguage(dto.getLanguage());
        entity.setYearOfEdition(dto.getYearOfEdition());
        entity.setCdu(dto.getCdu());
        entity.setMatter(dto.getMatter());
        entity.setIsbn(dto.getIsbn());
        entity.setCaption(dto.getCaption());

        Publisher publisher = publisherRepository.getReferenceById(dto.getPublisher().getId());
        entity.setPublisher(publisher);

        for(AuthorDTO authorDTO: dto.getAuthors()){
            Author author = authorRepository.getReferenceById(authorDTO.getId());
            entity.getAuthors().add(author);
        }

        for (CategoryDTO categoryDTO: dto.getCategories()){
            Category category = categoryRepository.getReferenceById(categoryDTO.getId());
            entity.getCategories().add(category);
        }

        entity = bookRepository.save(entity);
        return new BookPublisherAuthorCategoryDTO(entity);
    }

    @Transactional
    public BookDTO update(Integer id, BookDTO dto){
        try {
            Book entity = bookRepository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            return new BookDTO(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Resource not found!");
        }
    }

    @Transactional
    public BookPublisherDTO update(Integer id, BookPublisherDTO dto){
        try {
            Book entity = bookRepository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            return new BookPublisherDTO(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Resource not found!");
        }
    }

    @Transactional
    public BookPublisherAuthorDTO update(Integer id, BookPublisherAuthorDTO dto){
        try {
            Book entity = bookRepository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            return new BookPublisherAuthorDTO(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Resource not found!");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Integer id){
        if(!bookRepository.existsById(id)){
            throw new ResourceNotFoundException("Resource not found!");
        }
        try {
            bookRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Referential Integrity Failure!");
        }
    }

    private void copyDtoToEntity(BookDTO dto, Book entity) {
        entity.setTitle(dto.getTitle());
        entity.setCaption(dto.getCaption());
        entity.setCdu(dto.getCdu());
        entity.setIsbn(dto.getIsbn());
        entity.setCountryPublished(dto.getCountryPublished());
        entity.setLanguage(dto.getLanguage());
        entity.setMatter(dto.getMatter());
        entity.setYearOfEdition(dto.getYearOfEdition());
    }

    private void copyDtoToEntity(BookPublisherDTO dto, Book entity) {
        entity.setTitle(dto.getTitle());
        entity.setCaption(dto.getCaption());
        entity.setCdu(dto.getCdu());
        entity.setIsbn(dto.getIsbn());
        entity.setCountryPublished(dto.getCountryPublished());
        entity.setLanguage(dto.getLanguage());
        entity.setMatter(dto.getMatter());
        entity.setYearOfEdition(dto.getYearOfEdition());

        if(dto.getPublisher() != null && dto.getPublisher().getId() != null){
            try {
                Publisher publisher = publisherRepository.getReferenceById(dto.getPublisher().getId());

                publisher.setName(dto.getPublisher().getName());
                publisher.setContact(dto.getPublisher().getContact());
                publisher.setSite(dto.getPublisher().getSite());

                entity.setPublisher(publisher);
            }catch (EntityNotFoundException e){
                throw new ResourceNotFoundException("Resource not found with ID: " + dto.getPublisher().getId());
            }
        }else {
            entity.setPublisher(null);
        }
    }

    private void copyDtoToEntity(BookPublisherAuthorDTO dto, Book entity) {
        entity.setTitle(dto.getTitle());
        entity.setCaption(dto.getCaption());
        entity.setCdu(dto.getCdu());
        entity.setIsbn(dto.getIsbn());
        entity.setCountryPublished(dto.getCountryPublished());
        entity.setLanguage(dto.getLanguage());
        entity.setMatter(dto.getMatter());
        entity.setYearOfEdition(dto.getYearOfEdition());

        if(dto.getPublisher() != null && dto.getPublisher().getId() != null){
            try {
                Publisher publisher = publisherRepository.getReferenceById(dto.getPublisher().getId());

                publisher.setName(dto.getPublisher().getName());
                publisher.setContact(dto.getPublisher().getContact());
                publisher.setSite(dto.getPublisher().getSite());

                entity.setPublisher(publisher);
            }catch (EntityNotFoundException e){
                throw new ResourceNotFoundException("Resource not found with ID: " + dto.getPublisher().getId());
            }
        }else {
            entity.setPublisher(null);
        }

        for(AuthorDTO authorDTO: dto.getAuthors()){
            try {
                Author author = authorRepository.getReferenceById(authorDTO.getId());
                entity.getAuthors().add(author);
            }catch (EntityNotFoundException e){
                throw new ResourceNotFoundException("Entity not found with ID: " + authorDTO.getId());
            }
        }
    }
}
