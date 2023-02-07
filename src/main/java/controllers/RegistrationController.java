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

@WebServlet("/registration")
public class RegistrationController extends AbstractController {
    //TODO: РАЗОБРАТЬСЯ С Parameter и Attribute
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter(Constants.LOGIN);
        String password = request.getParameter(Constants.PASSWORD);
        String firstname = request.getParameter(Constants.FIRST_NAME);
        String lastname = request.getParameter(Constants.SECOND_NAME);
        String mail = request.getParameter(Constants.EMAIL);

        if(login == null || password == null || firstname == null || lastname == null || mail == null) {
            jumpError(request, response, Constants.REGIST_JSP, Constants.NULL_MESS);
            return;
        }

        login = login.trim();
        password = password.trim();
        firstname = firstname.trim();
        lastname = lastname.trim();
        mail = mail.trim();

        if(login.equals(Constants.EMPTY) || password.equals(Constants.EMPTY) || mail.equals(Constants.EMPTY) ||
                firstname.equals(Constants.EMPTY) || lastname.equals(Constants.EMPTY)) {
            jumpError(request, response, Constants.REGIST_JSP, Constants.EMPTY_MESS);
            return;
        }

        IUserDAO userDAO = new UserImpl();
        User user = new User(login,mail,firstname,lastname);

        try{
            if(userDAO.isAddUser(user,password)){
                HttpSession session = request.getSession();
                session.setAttribute(Constants.USER, user);
                jump(request,response,Constants.CONF_CONTR);
            }else {
                jumpError(request, response, Constants.REGIST_JSP, Constants.USER_FOUND_MESS);
            }
        }catch (SQLException e){
            jumpError(request, response, Constants.REGIST_JSP, e.getMessage());
            e.printStackTrace();
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
