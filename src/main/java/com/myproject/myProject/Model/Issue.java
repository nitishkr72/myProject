package com.myproject.myProject.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Issue implements Serializable {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "date_issued")
    private LocalDate dateIssued;

    @Column(name = "date_return")
    private LocalDate dateReturn;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Issue() {
    }

    public Issue(Long id, LocalDate dateIssued, LocalDate dateReturn, Book book, Student student) {
        this.id = id;
        this.dateIssued = dateIssued;
        this.dateReturn = dateReturn;
        this.book = book;
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(LocalDate dateIssued) {
        this.dateIssued = dateIssued;
    }

    public LocalDate getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(LocalDate dateReturn) {
        this.dateReturn = dateReturn;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", dateIssued=" + dateIssued +
                ", dateReturn=" + dateReturn +
                ", book=" + book +
                ", student=" + student +
                '}';
    }
}
