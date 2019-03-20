package DAO;

import Entity.Aim;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface AimDAO {

    void add(Aim aim);
    ArrayList<Aim> getAll() throws SQLException;
    Aim getByID(int id);
    //Aim getByUser(User user);
    void update(Aim aim);
    void remove(Aim aim);

}
