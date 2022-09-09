package service;

import model.Group;
import repository.GroupRepository;

import java.util.List;
import java.util.Map;

public class GroupService implements CrudService<Group> {

    private final GroupRepository groupRepository;

    public GroupService() {
        this.groupRepository = new GroupRepository();
    }

    @Override
    public void save(Group entity) {
        groupRepository.save(entity);
    }

    @Override
    public void delete(String id) {
        groupRepository.delete(id);
    }

    @Override
    public void update(Group entity) {
        groupRepository.update(entity);
    }

    @Override
    public void printAll() {
        for (Group student : groupRepository.getAll()) {
            System.out.println(student);
        }
    }

    @Override
    public List<Group> getAll() {
        return groupRepository.getAll();
    }


    public List<Group> getByName(String name) {
        return groupRepository.getByName(name);
    }

    public void groupBySum() {
        for (Map.Entry<String,Long> entry :groupRepository.groupBySum().entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }

    public void groupByMarks() {
        for (Map.Entry<String,Double> entry :groupRepository.groupByAvgMarks().entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
