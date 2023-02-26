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

@WebServlet("/editConf")
public class EditConferenceController extends AbstractController {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter(Constants.ID_CONF);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(Constants.USER);

        if (user != null) {
            System.out.println("Редактируем конференцию №" + id);
        } else {
            jump(request, response, Constants.LOGIN_JSP);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
