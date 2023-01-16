package model.interfaces;

import model.beans.User;

import java.sql.SQLException;

public interface IUserDAO {
    User getUser(String login, String password) throws SQLException;
    boolean addUser(User user, String password) throws SQLException;
}
