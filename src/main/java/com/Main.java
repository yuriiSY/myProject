package com;

import com.command.Commands;
import com.command.UserInputUtil;
import com.config.FlyWayConfig;
import com.config.HibernateFactoryUtil;

import javax.persistence.EntityManager;

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
