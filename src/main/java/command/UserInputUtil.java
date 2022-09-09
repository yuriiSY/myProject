package command;

import model.*;
import service.GroupService;
import service.StudentService;
import service.SubjectService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class UserInputUtil {

    private static final GroupService GROUP_SERVICE = new GroupService();
    private static final StudentService STUDENT_SERVICE = new StudentService();
    private static final SubjectService SUBJECT_SERVICE = new SubjectService();


    private UserInputUtil() {
    }

    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static int getUserInput(int length, List<String> names) {
        int userType = -1;
        do {
            userType = getUserInput(names, length);
        } while (userType == -1);
        return userType;
    }

    public static boolean userAction(final Commands[] values) {
        try {
            int userCommand = -1;
            do {
                for (int i = 0; i < values.length; i++) {
                    System.out.printf("%d) %s%n", i, values[i].getName());
                }
                int input = Integer.parseInt(READER.readLine());
                if (input >= 0 && input < values.length) {
                    userCommand = input;
                }
            } while (userCommand == -1);
            final Command command = values[userCommand].getCommand();
            if (command == null) {
                return true;
            } else {
                command.execute();
                return false;
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Input is not valid");
        }
        return false;
    }

    private static int getUserInput(List<String> names, int length) {
        try {
            if (length > 0) {
                System.out.println("Please enter number between 0 and " + length);
            } else {
                System.out.println("Which one");
            }
            for (int i = 0; i < length; i++) {
                System.out.printf("%d) %s%n", i, names.get(i));
            }
            int input = Integer.parseInt(READER.readLine());
            if (input >= 0 && input <= length) {
                return input;
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Input is not valid");
        }
        return -1;
    }

    public static Student inputDataStudent() {
        String name, surname;
        int age;
        try {
            System.out.println("Input name: ");
            name = READER.readLine();
            System.out.println("Input surname: ");
            surname = READER.readLine();
            System.out.println("Input age: ");
            age = Integer.parseInt(READER.readLine());
            return new Student(name, surname, age, LocalDateTime.now());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Group inputDataGroup(List<Student> students) {
        String nameOfGroup;
        Group result = null;

        try {
            System.out.println("Input name: ");
            nameOfGroup = READER.readLine();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (GROUP_SERVICE.getAll().size() > 0) {
            for (Group group : GROUP_SERVICE.getAll()) {
                if(group.getNameOfGroup().equals(nameOfGroup)){
                    group.setStudents(students);
                    result = group;
                }else {
                    result = new Group(nameOfGroup,students);
                }
            }
            return result;
        }else {
            return new Group(nameOfGroup,students);
        }
    }

    public static Teacher inputDataTeacher() {
        String name, surname,code,subjectName;
        int age;
        try {
            System.out.println("Input name: ");
            name = READER.readLine();
            System.out.println("Input surname: ");
            surname = READER.readLine();
            System.out.println("Input age: ");
            age = Integer.parseInt(READER.readLine());
            System.out.println("Subject: ");
            System.out.println("Code: ");
            code = READER.readLine();
            System.out.println("Subject name: ");
            subjectName = READER.readLine();

            return new Teacher(name, surname, age, Arrays.asList(new Subject(code,subjectName)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Grade inputGradeData() {
        String idStudent,idSubject;
        int mark;
        Student student = null;
        Subject subject = null;
        try {
            do {
                System.out.println("Input id of Student: ");
                idStudent = READER.readLine();
                student = STUDENT_SERVICE.findById(idStudent);
            }while (student == null);
            do {
                System.out.println("Input id of Subject: ");
                idSubject = READER.readLine();
                subject = SUBJECT_SERVICE.findById(idSubject);
            }while (subject == null);
            System.out.println("Mark: ");
            mark = Integer.parseInt(READER.readLine());
            return new Grade(student,subject,mark);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String inputDelete() {
        String id;
        try {
            System.out.println("Input id for delete: ");
            id = READER.readLine();
            return id;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String inputName() {
        String name;
        try {
            System.out.println("Input data: ");
            name = READER.readLine();
            return name;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int inputMark() {
        int mark;
        try {
            System.out.println("Input data: ");
            mark = Integer.parseInt(READER.readLine());
            return mark;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
