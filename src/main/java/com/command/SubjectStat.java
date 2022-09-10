package com.command;

import com.service.SubjectService;

public class SubjectStat implements Command{

    private static final SubjectService SUBJECT_SERVICE = new SubjectService();
    @Override
    public void execute() {
        SubjectStat.findBestSubjectAndWorst();
    }
    private static void findBestSubjectAndWorst() {
        SUBJECT_SERVICE.findBestSubjectAndWorst();
    }
}
