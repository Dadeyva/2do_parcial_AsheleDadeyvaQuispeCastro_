package ui;

import javax.swing.*;
import java.awt.*;
import bussines.UserManagement;
import services.UserService;

public class DashBoard extends JFrame {
    public DashBoard(UserService userService) {
        setTitle("Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        JButton btnUsuarios = new JButton("Gestión de usuarios");
        btnUsuarios.addActionListener(e -> new UserManagement(userService));
        leftPanel.add(btnUsuarios);

        add(leftPanel, BorderLayout.WEST);
        setVisible(true);
    }
}