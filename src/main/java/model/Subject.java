package model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Setter
@Getter
@Entity
public class Subject {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String code;
    private String subjectName;

    @ManyToMany(mappedBy = "subjects")
    private List<Teacher> teacher;

    public Subject(String code, String subjectName) {
        this.code = code;
        this.subjectName = subjectName;
    }

    public Subject() {

    }
}
