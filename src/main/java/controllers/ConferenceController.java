package controllers;

import constants.Constants;
import model.beans.Conference;
import model.beans.User;
import model.enums.SectionManager;
import model.enums.SectionKind;
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
        String paramChoice = request.getParameter(Constants.SECTION);

        if (paramChoice == null) {
            paramChoice = Constants.TODAY;
        }

        try {
            IConferenceDAO confDAO = new ConferenceImpl();
            Enum <?> section = SectionManager.getSectionKind(paramChoice);

            HttpSession session = request.getSession();
            User user = (User) session.getAttribute(Constants.USER);

            List<Conference> conferences = confDAO.getConferences(section, user);
            session.setAttribute(Constants.CONF_LIST, conferences);

            if (section == SectionKind.CONF_BY_USER) {
                response.sendRedirect("/reg-conferences" + Constants.HOME_JSP);
            }else {
                jump(request, response, Constants.INDEX_JSP);
            }
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
