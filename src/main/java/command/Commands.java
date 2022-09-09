package command;

import lombok.Getter;

@Getter
public enum Commands {

    CREATE_STUDENT("Create Student", new CreateStudent()),
    CREATE_TEACHER("Create Teacher", new CreateTeacher()),
    CREATE_GRADE("Create Grade", new CreateGrade()),
    PRINT("Print", new Print()),
    DELETE("Delete", new Delete()),
    GROUP_BY_STUDENTS("Group By Students", new StudentInGroup()),
    GROUP_BY_MARKS("Group By Marks", new MarksInGroup()),
    FIND_TEACHER("Find Teacher",new FindTeacher()),
    FIND("Find Group" , new FindGroup()),
    SUBJECT_STAT("SubjectStat" , new SubjectStat()),
    STUDENT_MARK_MORE_THAN("StudentStat", new StudentsStat()),
    EXIT("Exit", null);
    private final String name;
    private final Command command;
    Commands(String name, Command command) {
        this.name = name;
        this.command = command;
    }
}
