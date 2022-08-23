package com.myproject.myProject.Repo;

import com.myproject.myProject.Model.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryRepo extends JpaRepository<BookCategory, Long> {
}
