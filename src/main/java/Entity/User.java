package Entity;


import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;
    private String login;
    private int password;
    private int role;
    private List<Aim> aims;
    private double efficiency;

    public User(int id, String login, int password, int role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.aims = new ArrayList<Aim>();
        this.efficiency = 0;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public List<Aim> getAims() {
        return aims;
    }
}
