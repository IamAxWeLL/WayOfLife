package DAO;

import Entity.Role;
import Entity.User;

import java.sql.SQLException;
import java.util.List;

public interface RoleDAO {

    void add(Role role);
    List<Role> getAll() throws SQLException;
    Role getByID(int id);
    void update(Role role);
    void remove(Role role);
}
