package Services;

import DAO.RoleDAO;
import Entity.Role;
import Entity.User;
import Utilities.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleService implements RoleDAO {

    public void add(Role role) {
        Util.connectToDB();
        String insertData = "INSERT INTO role VALUES (?,?)";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = Util.connection.prepareStatement(insertData);
            preparedStatement.setInt(1, role.getId());
            preparedStatement.setString(2, role.getName());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        Util.disconnectFromDB();

    }

    public List<Role> getAll() throws SQLException {
        String query = "select * from role";

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

        List<Role> roleList = new ArrayList<Role>();

        while (resultSet.next()) {

            Role role = new Role(
                    resultSet.getInt(1),
                    resultSet.getString(2)
                    );

            roleList.add(role);
        }
        return roleList;
    }

    public Role getByID(int id) {
        String query = "SELECT * FROM role WHERE id=" + id;

        Util.connectToDB();

        Connection connection = Util.connection;
        Statement statement = null;
        ResultSet resultSet = null;
        Role role = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            role = new Role(
                    resultSet.getInt(1),
                    resultSet.getString(2)

            );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return role;
    }

    public void update(Role role) {

        Util.connectToDB();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE role SET id=\'");
        stringBuilder.append(role.getId());
        stringBuilder.append("\',name=\'");
        stringBuilder.append(role.getName());
        stringBuilder.append("\'WHERE id=");
        stringBuilder.append(role.getId());
        System.out.println(stringBuilder.toString());
        try {
            Statement statement = Util.connection.createStatement();
            statement.executeUpdate(stringBuilder.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Util.disconnectFromDB();
    }

    public void remove(Role role) {

        Util.connectToDB();
        PreparedStatement preparedStatement = null;
        String deleteData = "DELETE FROM role WHERE id=" + role.getId();

        try {
            preparedStatement = Util.connection.prepareStatement(deleteData);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Util.disconnectFromDB();
    }
}
