package command;

import service.*;

import java.util.ArrayList;
import java.util.List;

public class Delete implements Command{
    private static final GroupService GROUP_SERVICE = new GroupService();
    private static final StudentService STUDENT_SERVICE = new StudentService();
    private static final SubjectService SUBJECT_SERVICE = new SubjectService();
    private static final TeacherService TEACHER_SERVICE = new TeacherService();
    private static final GradeService GRADE_SERVICE = new GradeService();
    @Override
    public void execute() {
        System.out.println("What do you want to delete:");
        final Type[] values = Type.values();
        final List<String> names = getNamesOfType(values);
        final int userInput = UserInputUtil.getUserInput(values.length, names);
        String id = UserInputUtil.inputDelete();
        Delete.delete(values[userInput],id);
    }
    private List<String> getNamesOfType(final Type[] values) {
        final List<String> names = new ArrayList<>(values.length);
        for (Type type : values) {
            names.add(type.name());
        }
        return names;
    }

    private static void delete(Type type, String id) {
        switch (type) {
            case STUDENT -> STUDENT_SERVICE.delete(id);
            case TEACHER -> TEACHER_SERVICE.delete(id);
            case GRADE -> GRADE_SERVICE.delete(id);
            case GROUP -> GROUP_SERVICE.delete(id);
            case SUBJECT -> SUBJECT_SERVICE.delete(id);
            default -> {
                throw new IllegalArgumentException("Unknown ProductType " + type);
            }
        };
    }

}
