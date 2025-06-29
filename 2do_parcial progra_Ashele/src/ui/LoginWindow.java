package ui;

import services.UserService;

import javax.swing.*;
import java.awt.*;

public class LoginWindow extends JFrame {
    private JTextField txtUser;
    private JPasswordField txtPass;
    private JButton btnLogin;

    private UserService userService;

    public LoginWindow() {
        userService = new UserService();
        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        txtUser = new JTextField();
        txtPass = new JPasswordField();
        btnLogin = new JButton("Iniciar sesión");

        add(new JLabel("Usuario:"));
        add(txtUser);
        add(new JLabel("Contraseña:"));
        add(txtPass);
        add(new JLabel(""));
        add(btnLogin);

        btnLogin.addActionListener(e -> login());

        setVisible(true);
    }

    private void login() {
        String user = txtUser.getText().trim();
        String pass = new String(txtPass.getPassword()).trim();

        if (userService.authenticate(user, pass)) {
            JOptionPane.showMessageDialog(this, "Bienvenido, " + user);
            dispose();
            new DashBoard(userService);
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.");
        }
    }
}