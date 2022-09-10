package com.command;

import com.model.Teacher;
import com.service.TeacherService;

public class CreateTeacher implements Command{
    private static final TeacherService TEACHER_SERVICE = new TeacherService();

    @Override
    public void execute() {
        Teacher teacher = UserInputUtil.inputDataTeacher();
        CreateTeacher.saveTeacher(teacher);
    }
    private static void saveTeacher(Teacher teacher) {TEACHER_SERVICE.save(teacher);}

}
