package com.myproject.myProject.Repo;

import com.myproject.myProject.Model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepo extends JpaRepository<Issue, Long> {
}
