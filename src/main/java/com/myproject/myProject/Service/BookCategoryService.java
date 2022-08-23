package com.myproject.myProject.Service;


import com.myproject.myProject.Model.BookCategory;
import com.myproject.myProject.Repo.BookCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookCategoryService {
    private final BookCategoryRepo bookCategoryRepo;

    @Autowired
    public BookCategoryService(BookCategoryRepo bookCategoryRepo) {
        this.bookCategoryRepo = bookCategoryRepo;
    }

    public BookCategory addBookCategory(BookCategory bookCategory) {
        return bookCategoryRepo.save(bookCategory);
    }

    public void deleteBookCategory(Long id) {
        bookCategoryRepo.deleteBookCategoryById(id);
    }

    public BookCategory updateBookCategory(Long id, BookCategory bookCategory) {
        BookCategory bookCategory1 = bookCategoryRepo.findById(id).get();
        bookCategory1.setName(bookCategory.getName());
        return bookCategory1;
    }

    public List<BookCategory> findAllBookCategory() {
        return bookCategoryRepo.findAll();
    }

    public BookCategory findBookCategoryById(Long id) {
        return bookCategoryRepo.findById(id).get();
    }

    public void deleteBookCategoryById(Long id) {
        bookCategoryRepo.deleteBookCategoryById(id);
    }
}
