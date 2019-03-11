package Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

        private static final String URL = "jdbc:mysql://localhost:3306/my_db?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true" +
                "&useLegacyDatetimeCode=false&serverTimezone=UTC";
        private static final String USER = "root";
        private static final String PASS = "root";

        public static Connection connection;

        public static void connectToDB(){
            try {
                connection = DriverManager.getConnection(URL, USER, PASS);
                if (!connection.isClosed()) {System.out.println("Соединение с БД установлено");}
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public static void disconnectFromDB() {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection.isClosed()) {
                    System.out.println("Соединение с БД прервано");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
}
