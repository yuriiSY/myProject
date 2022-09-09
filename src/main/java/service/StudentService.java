package service;

import model.Student;
import repository.StudentRepository;

import java.util.List;

public class StudentService implements CrudService<Student>{
    private final StudentRepository studentRepository;
    public StudentService() {
        this.studentRepository = new StudentRepository();
    }
    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }
    @Override
    public void delete(String id) {
        studentRepository.delete(id);
    }
    @Override
    public void update(Student student) {
        studentRepository.update(student);
    }
    @Override
    public void printAll() {
        for (Student student : studentRepository.getAll()) {
            System.out.println(student);
        }
    }
    @Override
    public List<Student> getAll() {
       return studentRepository.getAll();
    }

    public Student findById(String id) {
        Student student = studentRepository.findById(id).orElse(null);
        return student;
    }


}
