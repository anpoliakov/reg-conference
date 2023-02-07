package controllers;

import constants.Constants;
import model.beans.User;
import model.impl.UserImpl;
import model.interfaces.IUserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginController extends AbstractController{
    public LoginController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter(Constants.LOGIN);
        String password = request.getParameter(Constants.PASSWORD);

        if(login == null || password == null){
            jumpError(request,response,Constants.LOGIN_JSP, Constants.NULL_MESS);
            return;
        }

        login = login.trim();
        password = password.trim();

        if(login.equals(Constants.EMPTY) || password.equals(Constants.EMPTY)){
            jumpError(request,response,Constants.LOGIN_JSP,Constants.EMPTY_MESS);
            return;
        }

        IUserDAO userDAO = new UserImpl();
        try {
            User user = userDAO.getUser(login,password);
            if(user != null){
                HttpSession session = request.getSession();
                session.setAttribute(Constants.USER, user);
                jump(request,response,Constants.CONF_CONTR);
            }else{
                jumpError(request,response,Constants.LOGIN_JSP,Constants.USER_NOT_FOUND);
            }
        } catch (SQLException e) {
            //что бы в любом случае перепрыгнули и вывели какое-либо сообщение
            jumpError(request, response, Constants.LOGIN_JSP, e.getMessage());
            e.printStackTrace();
        }

        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
