package com.command;

import com.service.*;

import java.util.ArrayList;
import java.util.List;

public class Print implements Command{

    private static final GroupService GROUP_SERVICE = new GroupService();
    private static final StudentService STUDENT_SERVICE = new StudentService();
    private static final SubjectService SUBJECT_SERVICE = new SubjectService();
    private static final TeacherService TEACHER_SERVICE = new TeacherService();
    private static final GradeService GRADE_SERVICE = new GradeService();
    @Override
    public void execute() {
        System.out.println("What do you want to print:");
        final Type[] values = Type.values();
        final List<String> names = getNamesOfType(values);
        final int userInput = UserInputUtil.getUserInput(values.length, names);
        Print.print(values[userInput]);
    }
    private List<String> getNamesOfType(final Type[] values) {
        final List<String> names = new ArrayList<>(values.length);
        for (Type type : values) {
            names.add(type.name());
        }
        return names;
    }

    public static void print(Type type) {
        switch (type) {
            case STUDENT -> STUDENT_SERVICE.printAll();
            case TEACHER -> TEACHER_SERVICE.printAll();
            case GRADE -> GRADE_SERVICE.printAll();
            case GROUP -> GROUP_SERVICE.printAll();
            case SUBJECT -> SUBJECT_SERVICE.printAll();
            default -> {
                throw new IllegalArgumentException("Unknown ProductType " + type);
            }
        };
    }
}
