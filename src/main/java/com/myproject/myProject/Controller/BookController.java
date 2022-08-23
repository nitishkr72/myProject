package com.myproject.myProject.Controller;

import com.myproject.myProject.Model.Book;
import com.myproject.myProject.Model.BookCategory;
import com.myproject.myProject.Service.BookCategoryService;
import com.myproject.myProject.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;


    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book book1 = bookService.addBook(book);
        return new ResponseEntity<>(book1, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteBook(@RequestParam Long id) {
        bookService.deleteBookById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<Book>> getAllBook() {
        List<Book> books = bookService.getAllBook();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/find/id")
    public ResponseEntity<Book> getBookById(@RequestParam Long id) {
        Book book = bookService.findBookById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PutMapping("/update/category")
    public ResponseEntity<Book> updateBookCategory(@RequestParam Long b_id, @RequestParam Long c_id) {
        Book book = bookService.updateBookCategory(b_id, c_id);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }
}
