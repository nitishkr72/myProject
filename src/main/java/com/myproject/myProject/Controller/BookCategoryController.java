package com.myproject.myProject.Controller;

import com.myproject.myProject.Model.BookCategory;
import com.myproject.myProject.Service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class BookCategoryController {
    public final BookCategoryService bookCategoryService;

    @Autowired
    public BookCategoryController(BookCategoryService bookCategoryService) {
        this.bookCategoryService = bookCategoryService;
    }

    @PostMapping("/add")
    public ResponseEntity<BookCategory> addBookCategory(@RequestBody BookCategory bookCategory) {
        BookCategory bookCategory1 = bookCategoryService.addBookCategory(bookCategory);
        return new ResponseEntity<>(bookCategory1, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookCategory>> getBookCategory() {
        List<BookCategory> bookCategories = bookCategoryService.findAllBookCategory();
        return new ResponseEntity<>(bookCategories, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteBookCategoryById(@RequestParam Long id) {
        bookCategoryService.deleteBookCategoryById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find/id")
    public ResponseEntity<BookCategory> getBookCategoryById(Long id) {
        BookCategory bookCategory = bookCategoryService.findBookCategoryById(id);
        return new ResponseEntity<>(bookCategory, HttpStatus.OK);
    }
}
