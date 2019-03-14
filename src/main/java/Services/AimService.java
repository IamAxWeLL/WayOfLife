package Services;

import DAO.AimDAO;
import Utilities.Util;
import Entity.Aim;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AimService implements AimDAO {
    public void add(Aim aim) {

        Util.connectToDB();
        String insertData = "INSERT INTO aims VALUES (?,?,?,?,?)";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = Util.connection.prepareStatement(insertData);
            preparedStatement.setInt(1, aim.getId());
            preparedStatement.setString(2, aim.getAim());
            preparedStatement.setDate(3, aim.getDate());
            preparedStatement.setBoolean(4, aim.isDone());
            preparedStatement.setInt(5, aim.getUserID());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        Util.disconnectFromDB();

    }

    public List<Aim> getAll() throws SQLException {

        String query = "select * from aims";

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
                    resultSet.getInt(5));

            aimsList.add(aim);
        }
        return aimsList;
    }

    public Aim getByID(int id) {
        String query = "SELECT * FROM aims WHERE id=" + id;

        Util.connectToDB();

        Connection connection = Util.connection;
        Statement statement = null;
        ResultSet resultSet = null;
        Aim aim = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            aim = new Aim(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getDate(3),
                    resultSet.getBoolean(4),
                    resultSet.getInt(5)
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aim;
    }

    public void update(Aim aim) {

        Util.connectToDB();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE aims SET id=\'");
        stringBuilder.append(aim.getId());
        stringBuilder.append("\',aim=\'");
        stringBuilder.append(aim.getAim());
        stringBuilder.append("\',Date=\'");
        stringBuilder.append(aim.getDate());
        stringBuilder.append("\',isDone=\'");
        stringBuilder.append(aim.isDone());
        stringBuilder.append("\'WHERE id=");
        stringBuilder.append(aim.getId());
        System.out.println(stringBuilder.toString());
        try {
            Statement statement = Util.connection.createStatement();
            statement.executeUpdate(stringBuilder.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Util.disconnectFromDB();

    }

    public void remove(Aim aim) {


        Util.connectToDB();
        PreparedStatement preparedStatement = null;
        String deleteData = "DELETE FROM aims WHERE id=" + aim.getId();

        try {
            preparedStatement = Util.connection.prepareStatement(deleteData);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Util.disconnectFromDB();


    }
    }

