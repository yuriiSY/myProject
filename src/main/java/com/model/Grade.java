package com.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Grade {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "subject_id")
    private Subject subject;
    @Column
    private int signification;

    public Grade(Student student, Subject subject, int signification) {
        this.student = student;
        this.subject = subject;
        this.signification = signification;
    }

    public Grade() {

    }

    @Override
    public String toString() {
        return "Grade{" +
                "id='" + id + '\'' +
                ", student=" + student +
                ", subject=" + subject +
                ", signification=" + signification +
                '}';
    }
}
