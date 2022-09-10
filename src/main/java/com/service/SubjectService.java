package com.service;

import com.model.Subject;
import com.repository.SubjectRepository;

import java.util.List;

public class SubjectService implements CrudService<Subject>{

    private final SubjectRepository subjectRepository;

    public SubjectService() {
        this.subjectRepository = new SubjectRepository();
    }

    @Override
    public void save(Subject entity) {
        subjectRepository.save(entity);
    }

    @Override
    public void delete(String id) {
        subjectRepository.delete(id);
    }

    @Override
    public void update(Subject entity) {
        subjectRepository.update(entity);
    }

    @Override
    public void printAll() {
        for (Subject subject : subjectRepository.getAll()) {
            System.out.println(subject);
        }
    }

    @Override
    public List<Subject> getAll() {
        return subjectRepository.getAll();
    }

    public Subject findById(String id) {
        return subjectRepository.findById(id).orElse(null);
    }

    public void findBestSubjectAndWorst() {
        System.out.println("Best subject");
        System.out.println(subjectRepository.bestSubject());
        System.out.println("Worst subject");
        System.out.println(subjectRepository.worstSubject());
    }

}
