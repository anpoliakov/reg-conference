package controllers;

import constants.Constants;
import model.beans.Conference;
import model.enums.EnumManager;
import model.impl.ConferenceImpl;
import model.interfaces.IConferenceDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet ("/conf")
public class ConferenceController extends AbstractController{
    public ConferenceController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param = request.getParameter(Constants.SECTION);

        if (param == null) {
            param = Constants.TODAY_SECT;
        }

        try {
            Enum <?> section = EnumManager.getKindConf(param);
            IConferenceDAO confDAO = new ConferenceImpl();
            List<Conference> conferences = confDAO.getConferences(section);
            HttpSession session = request.getSession();
            session.setAttribute(Constants.CONF_LIST, conferences);
            jump(request, response, Constants.INDEX_JSP);
        } catch (SQLException e) {
            e.printStackTrace();
            jumpError(request, response, Constants.INDEX_JSP, e.getMessage());
        }
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
