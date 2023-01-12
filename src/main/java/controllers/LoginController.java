package controllers;

import constants.Constants;
import model.impl.UserImpl;
import model.interfaces.IUserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
            jumpError(request,response,Constants.LOGIN_JSP, Constants.MESS_NULL);
            return;
        }

        login = login.trim();
        password = password.trim();

        if(login.equals(Constants.EMPTY) || password.equals(Constants.EMPTY)){
            jumpError(request,response,Constants.LOGIN_JSP,Constants.MESS_EMPTY);
            return;
        }

        IUserDAO userDAO = new UserImpl();
        //TODO: запрос к бд на поиск пользователя (пока вносим ручками)
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
