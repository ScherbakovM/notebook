package notebook.view;

import notebook.controller.UserController;
import notebook.log.Logger;
import notebook.model.User;
import notebook.util.Commands;

import java.util.Scanner;

public class UserView {
    private final UserController userController;

    public UserView(UserController userController) {
        this.userController = userController;
    }

    public void run( ) {
        Commands com;

        while (true) {
            String command = prompt("������� �������: ");
            com = Commands.valueOf(command);
            if (com == Commands.EXIT) return;
            switch (com) {
                case CREATE:
                    String firstName = prompt("���: ");
                    String lastName = prompt("�������: ");
                    String phone = prompt("����� ��������: ");
                    userController.saveUser(new User(firstName, lastName, phone));
                    break;
                case READ:
                    String id = prompt("������������� ������������: ");
                    try {
                        User user = userController.readUser(Long.parseLong(id));
                        System.out.println(user);
                        System.out.println();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case LIST:
                    userController.printList();
                    break;
                case UPDATE:
                    String userId = prompt("Enter user id: ");
                    String updateName = prompt("���: ");
                    String updateLastName = prompt("�������: ");
                    String updatePhone = prompt("����� ��������: ");
                    User updatedUser = new User(updateName, updateLastName, updatePhone);
                    userController.updateUser(userId, updatedUser);
                    break;
                case DELETE:
                    String delId = prompt("Enter user id: ");
                    userController.deleteUser(delId);
                    break;
            }
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

}
