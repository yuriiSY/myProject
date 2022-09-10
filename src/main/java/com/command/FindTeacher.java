package com.command;

import com.service.TeacherService;

public class FindTeacher implements Command{
    private static final TeacherService TEACHER_SERVICE = new TeacherService();
    @Override
    public void execute() {
        String nameOrSurname = UserInputUtil.inputName();
        FindTeacher.findTeacher(nameOrSurname, nameOrSurname);
    }
    private static void findTeacher(String name,String surname) {
        TEACHER_SERVICE.findTeacher(name,surname);
    }
}
