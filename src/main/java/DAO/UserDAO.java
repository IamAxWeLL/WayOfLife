package DAO;



import Entity.Aim;
import Entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    void add(User user);
    List<User> getAll() throws SQLException;
    List<Aim> getAllAims(User user) throws SQLException;
    User getByID(int id);
    void update(User user);
    void remove(User user);

    //Aim getByUser(User user);
}
