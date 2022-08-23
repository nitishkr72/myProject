package com.myproject.myProject.Repo;

import com.myproject.myProject.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Long> {
}
