package command;

import model.Grade;
import service.GradeService;

public class CreateGrade implements Command{

    private static final GradeService GRADE_SERVICE = new GradeService();
    @Override
    public void execute() {

        Grade grade = UserInputUtil.inputGradeData();
        CreateGrade.saveGrade(grade);
    }
    private static void saveGrade(Grade grade) {GRADE_SERVICE.save(grade);}
}
