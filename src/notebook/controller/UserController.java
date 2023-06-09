package notebook.controller;

import notebook.log.Logger;
import notebook.model.User;
import notebook.repository.GBRepository;

import java.util.List;
import java.util.Objects;

public class UserController {
    private final GBRepository<User, Long> repository;
    private Logger logger;

    public UserController(GBRepository<User, Long> repository, Logger logger) {
        this.logger = logger;
        this.repository = repository;
    }

    public void saveUser(User user) {
        logger.log("������� �������� ������������: " + user.getFirstName());
        repository.create(user);
        logger.log("�������� ����� ������������: " + user.getFirstName());
    }

    public User readUser(Long userId) {
        List<User> users = repository.findAll();
        for (User user : users) {
            if (Objects.equals(user.getId(), userId)) {
                return user;
            }
        }

        throw new RuntimeException("User not found");
    }

    public void updateUser(String userId, User update) {
        logger.log("������� ��������� ������������ c id: " + userId);
        update.setId(Long.parseLong(userId));
        repository.update(Long.parseLong(userId), update);
        logger.log("������������ c id: " + userId + " �������");
    }

    public void deleteUser(String userId) {
        logger.log("������� �������� ������������ c id: " + userId);
        repository.delete(Long.parseLong(userId));
        logger.log("������������ c id: " + userId + " �����");
    }

    public void printList( ) {
        logger.log("������� ������� ������ �������������");
        repository.printList();
        logger.log("������ �������");
    }

}
