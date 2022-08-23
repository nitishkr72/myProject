package com.myproject.myProject.Service;


import com.myproject.myProject.Model.Book;
import com.myproject.myProject.Model.BookCategory;
import com.myproject.myProject.Repo.BookCategoryRepo;
import com.myproject.myProject.Repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {
    public final BookRepo bookRepo;

    public final BookCategoryRepo bookCategoryRepo;

    @Autowired
    public BookService(BookRepo bookRepo, BookCategoryRepo bookCategoryRepo) {
        this.bookRepo = bookRepo;
        this.bookCategoryRepo = bookCategoryRepo;
    }


    public Book addBook(Book book) {
        return bookRepo.save(book);
    }

    public void deleteBookById(Long id) {
        bookRepo.deleteBookById(id);
    }

    public List<Book> getAllBook() {
        return bookRepo.findAll();
    }

    public Book findBookById(Long id) {
        return bookRepo.findById(id).get();
    }

    public Book updateBookCategory(Long b_id, Long c_id) {
        Book book = bookRepo.findById(b_id).get();
        BookCategory bookCategory = bookCategoryRepo.findById(c_id).get();
        book.setBookCategory(bookCategory);
        return book;
    }
}
