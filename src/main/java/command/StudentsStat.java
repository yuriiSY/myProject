package command;

import service.GradeService;

public class StudentsStat implements Command{
    private static final GradeService GRADE_SERVICE = new GradeService();
    @Override
    public void execute() {
        int mark = UserInputUtil.inputMark();
        StudentsStat.findMarksMoreThanX(mark);
    }

    private static void findMarksMoreThanX(int mark) {
        GRADE_SERVICE.studentMarks(mark);
    }
}
