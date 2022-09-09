import command.Commands;
import command.UserInputUtil;


public class Main {
    public static void main(String[] args) {
        final Commands[] values = Commands.values();
        boolean exit;

        do {
            exit = UserInputUtil.userAction(values);
        } while (!exit);
    }
}
