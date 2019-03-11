package Entity;

import DAO.RoleDAO;
import Utilities.Util;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Role {

    private int id;
    private String name;

    public Role(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
