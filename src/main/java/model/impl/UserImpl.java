package model.impl;

import constants.SQLConstants;
import model.beans.User;
import model.db.ConnectionManager;
import model.interfaces.IUserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserImpl implements IUserDAO {
    public User getUser(String login, String password) throws SQLException {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        User user = null;

        conn = ConnectionManager.createConnection();
        pst = conn.prepareStatement(SQLConstants.SELECT_USER);
        pst.setString(1, login);
        pst.setString(2, password);
        rs = pst.executeQuery();

        while (rs.next()){
            int id_from_db = rs.getInt(SQLConstants.ID_LABEL);
            String login_from_db = rs.getString(SQLConstants.LOGIN_LABEL);
            user = new User(id_from_db, login_from_db);
        }

        return user;
    }

    public boolean addUser(User user, String password) throws SQLException {
        Connection conn = null;
        PreparedStatement pst = null;
        boolean result = false;

        conn = ConnectionManager.createConnection();
        pst = conn.prepareStatement(SQLConstants.INSERT_USER);
        pst.setString(1, user.getLogin());
        pst.setString(2, user.getMail());
        pst.setString(3, password);
        pst.setString(4, user.getFirstName());
        pst.setString(5, user.getLastName());

        synchronized (UserImpl.class){
            if(!isFoundLogin(user.getLogin())){
                pst.executeUpdate();
                result = true;
            }
        }

        return result;
    }

    private boolean isFoundLogin(String login) throws SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean result = false;

        try {
            cn = ConnectionManager.createConnection();
            pst = cn.prepareStatement(SQLConstants.FOUND_USER);
            pst.setString(1, login);
            rs = pst.executeQuery();
            result = rs.next();
        } finally {
            ConnectionManager.closeResultSet(rs);
            ConnectionManager.closeStatement(pst);
        }
        return result;
    }
}
