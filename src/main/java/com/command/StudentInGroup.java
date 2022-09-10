package com.command;

import com.service.GroupService;

public class StudentInGroup implements Command{
    private static final GroupService GROUP_SERVICE = new GroupService();
    @Override
    public void execute() {
        StudentInGroup.studentsInGroup();
    }
    private static void studentsInGroup() {
        GROUP_SERVICE.groupBySum();
    }
}
