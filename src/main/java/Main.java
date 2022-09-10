import command.Commands;
import command.UserInputUtil;
import config.FlyWayConfig;
import config.HibernateFactoryUtil;
import model.Student;
import repository.StudentRepository;
import service.StudentService;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;


public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        entityManager.isOpen();
        FlyWayConfig.getInstance().migrate();
        final Commands[] values = Commands.values();
        boolean exit;

        do {
            exit = UserInputUtil.userAction(values);
        } while (!exit);
    }
}
