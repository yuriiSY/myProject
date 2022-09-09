package service;

import model.Grade;
import repository.GradeRepository;

import java.util.List;
import java.util.Map;

public class GradeService implements CrudService<Grade>{

private final GradeRepository gradeRepository;

    public GradeService() {
        this.gradeRepository = new GradeRepository();
    }

    @Override
    public void save(Grade entity) {
        gradeRepository.save(entity);
    }

    @Override
    public void delete(String id) {
        gradeRepository.delete(id);
    }

    @Override
    public void update(Grade entity) {
        gradeRepository.update(entity);
    }

    @Override
    public void printAll() {
        for (Grade grade : gradeRepository.getAll()) {
            System.out.println(grade);
        }
    }

    @Override
    public List<Grade> getAll() {
        return gradeRepository.getAll();
    }

    public void studentMarks(int mark) {
        for (Map.Entry<String,Double> entry : gradeRepository.findMoreThan(mark).entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
