package com.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
public class Group {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @Column
    private String nameOfGroup;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "group", fetch = FetchType.LAZY)
    private List<Student> students;

    public Group(String nameOfGroup, List<Student> students) {
        this.nameOfGroup = nameOfGroup;
        if (students != null) {
            students.forEach(a -> a.setGroup(this));
        }
        this.students = students;
    }

    public Group(String nameOfGroup) {
        this.nameOfGroup = nameOfGroup;
    }

    public Group() {

    }

    public void setStudents(List<Student> students) {
        if (students != null) {
            students.forEach(a -> a.setGroup(this));
        }
        this.students = students;
    }

    @Override
    public String toString() {
        return "\nGroup{" +
                "id='" + id + '\'' +
                ", nameOfGroup='" + nameOfGroup + '\'' +
                ", students=" + students +
                '}';
    }
}
