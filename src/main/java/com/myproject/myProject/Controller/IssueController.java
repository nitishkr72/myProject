package com.myproject.myProject.Controller;

import com.myproject.myProject.Model.Issue;
import com.myproject.myProject.Service.BookService;
import com.myproject.myProject.Service.IssueService;
import com.myproject.myProject.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/issue")
public class IssueController {

    private final IssueService issueService;

    @Autowired
    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @PostMapping("/issue")
    public ResponseEntity<Issue> issueBook(@RequestParam Long s_id, @RequestParam Long b_id) {
        Issue issue = issueService.issueBookToStudent(s_id, b_id);
        return new ResponseEntity<>(issue, HttpStatus.CREATED);
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<Issue>> getAllIssued() {
        List<Issue> issues = issueService.findAllIssued();
        return new ResponseEntity<>(issues, HttpStatus.OK);
    }

}
