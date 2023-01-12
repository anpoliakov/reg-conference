package model.impl;

import model.beans.User;
import model.interfaces.IUserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserImpl implements IUserDAO {

    public User getUser(String login, String password) {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        User user = null;

        //TODO: организовать запрос в БД
        return null;
    }
}
