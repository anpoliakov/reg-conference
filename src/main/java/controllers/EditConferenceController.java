package controllers;

import constants.Constants;
import model.beans.User;
import model.impl.ConferenceImpl;
import model.impl.UserImpl;
import model.interfaces.IConferenceDAO;
import model.interfaces.IUserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/editConf")
public class EditConferenceController extends AbstractController {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idConf = null;
        boolean existUser = false;
        try{
            idConf = Integer.valueOf(request.getParameter(Constants.ID_CONF).trim());
        }catch (NumberFormatException e){
            System.err.println("Ошибка формата данных! Получен не верный номер конференции!");
            jump(request,response, Constants.HOME_JSP);
        }

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(Constants.USER);

        IUserDAO userDAO = new UserImpl();
        IConferenceDAO confDAO = new ConferenceImpl();

        //Сейчас может придти idConf и мнимый user - нужно сделать проверку этого user в дб
        try {
            existUser = userDAO.isFoundLogin(user.getLogin());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        if (existUser == true && idConf != null) {
            System.out.println("Редактируем конференцию №" + idConf);
            try {
                confDAO.getConference(idConf);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else {
            jump(request, response, Constants.LOGIN_JSP);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
