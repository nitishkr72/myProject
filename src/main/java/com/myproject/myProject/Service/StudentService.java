package com.myproject.myProject.Service;

import com.myproject.myProject.Model.Student;
import com.myproject.myProject.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentService {
    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }


    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public void deleteStudentById(Long id) {
        studentRepo.deleteStudentById(id);
    }

    public Student getStudentById(Long id) {
        Student student = studentRepo.findById(id).get();
        return student;
    }
}
