package services;

import config.Credential;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<Credential> userList = new ArrayList<>();

    public UserService() {
        // Usuario por defecto para login de prueba
        userList.add(new Credential("admin", "1234"));
    }

    public void addUser(Credential cred) {
        userList.add(cred);
    }

    public List<Credential> getAllUsers() {
        return new ArrayList<>(userList);
    }

    public boolean authenticate(String username, String password) {
        return userList.stream().anyMatch(c -> c.getUsername().equals(username) && c.getPassword().equals(password));
    }
}