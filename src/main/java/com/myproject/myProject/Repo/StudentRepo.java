package com.myproject.myProject.Repo;

import com.myproject.myProject.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
