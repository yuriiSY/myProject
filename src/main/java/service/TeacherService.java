package service;

import model.Teacher;
import repository.TeacherRepository;

import java.util.List;

public class TeacherService implements CrudService<Teacher>{

    private final TeacherRepository teacherRepository;

    public TeacherService() {
        this.teacherRepository = new TeacherRepository();
    }


    @Override
    public void save(Teacher entity) {
        teacherRepository.save(entity);
    }

    @Override
    public void delete(String id) {
        teacherRepository.delete(id);
    }

    @Override
    public void update(Teacher entity) {
        teacherRepository.update(entity);
    }

    @Override
    public void printAll() {
        for (Teacher student : teacherRepository.getAll()) {
            System.out.println(student);
        }
    }

    @Override
    public List<Teacher> getAll() {
        return teacherRepository.getAll();
    }

    public void findTeacher(String name,String surname) {
        for (Teacher teacher : teacherRepository.findTeacher(name,surname)) {
            System.out.println(teacher);
        }
    }
}
