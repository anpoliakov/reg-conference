package model.db;

import constants.Constants;

import java.sql.*;

public class ConnectionManager {
    //загрузит драйвер postgreSQL при старте приложения
    static {
        try {
            Class.forName(Constants.DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Connection conn = null;

    public static Connection createConnection (){
        try {
            if(conn == null || conn.isClosed()){
                conn = DriverManager.getConnection(Constants.URL_DB,Constants.USER_DB, Constants.PASS_DB);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return conn;
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
