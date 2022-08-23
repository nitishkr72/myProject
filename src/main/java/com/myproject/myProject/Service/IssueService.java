package com.myproject.myProject.Service;

import com.myproject.myProject.Model.Book;
import com.myproject.myProject.Model.Issue;
import com.myproject.myProject.Model.Student;
import com.myproject.myProject.Repo.BookRepo;
import com.myproject.myProject.Repo.IssueRepo;
import com.myproject.myProject.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class IssueService {

    private final IssueRepo issueRepo;
    private final BookRepo bookRepo;
    private final StudentRepo studentRepo;

    @Autowired
    public IssueService(IssueRepo issueRepo, BookRepo bookRepo, StudentRepo studentRepo) {
        this.issueRepo = issueRepo;
        this.bookRepo = bookRepo;
        this.studentRepo = studentRepo;
    }

    public Issue issueBookToStudent(Long s_id, Long b_id) {
        Student student = studentRepo.findById(s_id).get();
        Book book = bookRepo.findById(b_id).get();

        LocalDate currentDate = LocalDate.now();
        LocalDate returnDate =  LocalDate.now().plusDays(15);

        Issue issue = new Issue();
        issue.setBook(book);
        issue.setStudent(student);
        issue.setDateIssued(currentDate);
        issue.setDateReturn(returnDate);

        return issueRepo.save(issue);
    }


    public List<Issue> findAllIssued() {
        return issueRepo.findAll();
    }
}
