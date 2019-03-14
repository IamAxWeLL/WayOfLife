package Services;

import DAO.UserDAO;
import Entity.Aim;
import Entity.User;
import Utilities.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService implements UserDAO {
    public void add(User user) {

        Util.connectToDB();
        String insertData = "INSERT INTO users VALUES (?,?,?,?)";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = Util.connection.prepareStatement(insertData);
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setInt(3, user.getPassword());
            preparedStatement.setInt(4, user.getRole());


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        Util.disconnectFromDB();

    }

    public List<User> getAll() throws SQLException {
        String query = "select * from users";

        Util.connectToDB();

        Connection connection = Util.connection;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<User> userList = new ArrayList<User>();

        while (resultSet.next()) {

            User user = new User(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getInt(4));

            userList.add(user);
        }
        return userList;
    }

    public List<Aim> getAllAims(User user) throws SQLException {
        String query = "select * from aims where usedID=" + user.getId();

        Util.connectToDB();

        Connection connection = Util.connection;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Aim> aimsList = new ArrayList<Aim>();

        while (resultSet.next()) {

            Aim aim = new Aim(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getDate(3),
                    resultSet.getBoolean(4),
                    resultSet.getInt(5)
                    );

            aimsList.add(aim);
        }
        return aimsList;
    }

    public User getByID(int id) {
        String query = "SELECT * FROM users WHERE id=" + id;

        Util.connectToDB();

        Connection connection = Util.connection;
        Statement statement = null;
        ResultSet resultSet = null;
        User user = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            user = new User(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getInt(4)
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public void update(User user) {

        Util.connectToDB();

        System.out.println("new changes");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE users SET id=\'");
        stringBuilder.append(user.getId());
        stringBuilder.append("\',login=\'");
        stringBuilder.append(user.getLogin());
        stringBuilder.append("\',password=\'");
        stringBuilder.append(user.getPassword());
        stringBuilder.append("\',role=\'");
        stringBuilder.append(user.getRole());
        stringBuilder.append("\'WHERE id=");
        stringBuilder.append(user.getId());
        System.out.println(stringBuilder.toString());
        try {
            Statement statement = Util.connection.createStatement();
            statement.executeUpdate(stringBuilder.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Util.disconnectFromDB();
    }

    public void remove(User user) {

        Util.connectToDB();
        PreparedStatement preparedStatement = null;
        String deleteData = "DELETE FROM users WHERE id=" + user.getId();

        try {
            preparedStatement = Util.connection.prepareStatement(deleteData);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Util.disconnectFromDB();
    }

    public boolean containsUser(User user) throws SQLException {

        String query = "select * from users where login=" + user.getLogin() + ",password=" + user.getPassword();

        Util.connectToDB();

        Connection connection = Util.connection;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

          Util.disconnectFromDB();

        return resultSet.next();
    }
}
