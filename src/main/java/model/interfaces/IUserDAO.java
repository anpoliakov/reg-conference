package model.interfaces;

import model.beans.User;

public interface IUserDAO {
    User getUser(String login, String password);
}
