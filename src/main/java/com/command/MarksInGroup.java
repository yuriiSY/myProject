package com.command;

import com.service.GroupService;

public class MarksInGroup implements Command{
    private static final GroupService GROUP_SERVICE = new GroupService();
    @Override
    public void execute() {
        MarksInGroup.groupByMarks();
    }
    private static void groupByMarks() {
        GROUP_SERVICE.groupByMarks();
    }
}
