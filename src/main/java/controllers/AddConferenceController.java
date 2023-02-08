package controllers;

import constants.Constants;
import model.beans.Conference;
import model.beans.Event;
import model.beans.User;
import model.factories.EventFactory;
import model.impl.ConferenceImpl;
import model.interfaces.IConferenceDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@WebServlet("/addConf")
public class AddConferenceController extends AbstractController {
    public AddConferenceController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        String title = request.getParameter(Constants.TITLE);
        String descr = request.getParameter(Constants.DESCR);
        String place = request.getParameter(Constants.PLACE);
        String date = request.getParameter(Constants.DATE);

        if (title == null || descr == null || place == null || date == null ) {
            jumpError(request, response, Constants.ADD_CONF_JSP, Constants.NULL_MESS);
            return;
        }

        if (title.equals(Constants.EMPTY)) {
            jumpError(request, response, Constants.ADD_CONF_JSP, Constants.EMPTY_MESS);
            return;
        }

        try {
            Conference conference = new Conference(title, descr, place, date);

            HttpSession session = request.getSession();
            User user = (User) session.getAttribute(Constants.USER);
            IConferenceDAO confDAO = new ConferenceImpl();

            int idConf = confDAO.addConference(conference, user);
            if (idConf != -1) { //следовательно концеренция была добавлена и необходимо внести events
                String[] titlesEvents = request.getParameterValues(Constants.TITLE_EV);
                String[] timesEvents = request.getParameterValues(Constants.TIME_EV);

                List<Event> events = EventFactory.getEvents(titlesEvents, timesEvents);
                confDAO.addConferenceEvents(events, idConf);

                jump(request, response, Constants.CONF_CONTR);
            }else {
                jumpError(request, response, Constants.ADD_CONF_JSP, Constants.WRONG_ADD_CONF);
            }


        } catch (ParseException e) {
            e.printStackTrace();
            jumpError(request, response, Constants.ADD_CONF_JSP, Constants.INCORRECT_DATE);
        } catch (SQLException e) {
            e.printStackTrace();
            jumpError(request, response, Constants.ADD_CONF_JSP, e.getMessage());
        }
        return;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
