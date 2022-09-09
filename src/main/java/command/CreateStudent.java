package command;

import model.Group;
import model.Student;
import service.GroupService;
import service.StudentService;

import java.util.Arrays;

public class CreateStudent implements Command{
    private static final StudentService STUDENT_SERVICE = new StudentService();
    private static final GroupService GROUP_SERVICE = new GroupService();
    @Override
    public void execute() {
        Student student = UserInputUtil.inputDataStudent();
        CreateStudent.saveStudent(student);
        Group group = UserInputUtil.inputDataGroup(Arrays.asList(student));
        CreateStudent.saveStudentInGroup(group);
    }
    private static void saveStudent(Student student) {STUDENT_SERVICE.save(student);}
    private static void saveStudentInGroup(Group group) {GROUP_SERVICE.save(group);}
}
