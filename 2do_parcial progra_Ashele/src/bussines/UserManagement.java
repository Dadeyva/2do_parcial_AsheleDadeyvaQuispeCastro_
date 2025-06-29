package bussines;

import ui.UserManagementWindow;
import services.UserService;

public class UserManagement {
    private UserService userService;
    private UserManagementWindow window;

    public UserManagement() {
        userService = new UserService();
        window = new UserManagementWindow(userService);
        window.setVisible(true);
    }

    public UserManagement(UserService service) {
        this.userService = service;
        window = new UserManagementWindow(service);
        window.setVisible(true);
    }
}