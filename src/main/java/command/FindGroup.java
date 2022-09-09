package command;

import model.Group;
import service.GroupService;

public class FindGroup implements Command{
    private static final GroupService GROUP_SERVICE = new GroupService();
    @Override
    public void execute() {
        String name = UserInputUtil.inputName();
        FindGroup.findGroup(name);
    }
    private static void findGroup(String name) {
        for (Group group : GROUP_SERVICE.getByName(name)) {
            System.out.println(group);
        }
    }

}
