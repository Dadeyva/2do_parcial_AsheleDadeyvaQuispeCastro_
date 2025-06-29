package ui;

import config.Credential;
import services.UserService;

import javax.swing.*;
import java.awt.*;

public class UserManagementWindow extends JFrame {
    private JTextField txtUser;
    private JPasswordField txtPass;
    private JButton btnSave, btnClear;
    private DefaultListModel<String> userModel;
    private JList<String> userList;

    private UserService userService;

    public UserManagementWindow(UserService userService) {
        super("Gestión de Usuarios");
        this.userService = userService;

        setSize(400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(3, 2));
        txtUser = new JTextField();
        txtPass = new JPasswordField();
        btnSave = new JButton("Guardar usuario");
        btnClear = new JButton("Limpiar formulario");

        form.add(new JLabel("Usuario:"));
        form.add(txtUser);
        form.add(new JLabel("Contraseña:"));
        form.add(txtPass);
        form.add(btnSave);
        form.add(btnClear);
        add(form, BorderLayout.NORTH);

        userModel = new DefaultListModel<>();
        userList = new JList<>(userModel);
        add(new JScrollPane(userList), BorderLayout.CENTER);

        btnSave.addActionListener(e -> guardar());
        btnClear.addActionListener(e -> limpiar());
    }

    private void guardar() {
        String user = txtUser.getText().trim();
        String pass = new String(txtPass.getPassword()).trim();

        if (user.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Campos vacíos no permitidos.");
            return;
        }

        userService.addUser(new Credential(user, pass));
        userModel.addElement(user);
        JOptionPane.showMessageDialog(this, "Usuario agregado.");
        limpiar();
    }

    private void limpiar() {
        txtUser.setText("");
        txtPass.setText("");
    }
}