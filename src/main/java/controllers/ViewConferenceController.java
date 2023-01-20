package controllers;

import constants.Constants;
import model.beans.Conference;
import model.impl.ConferenceImpl;
import model.interfaces.IConferenceDAO;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/viewConf")
public class ViewConferenceController extends AbstractController{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idConf = request.getParameter(Constants.ID_CONF);

        if(idConf == null) {
            jump(request, response, Constants.CONF_CONTR);
        }

        IConferenceDAO confDAO = new ConferenceImpl();
        HttpSession session = request.getSession();
        List<Conference> conferences = (List<Conference>) session.getAttribute(Constants.CONF_LIST);

        try {
            int indexConf = confDAO.fillConferenceEvents(conferences, idConf);
            if (indexConf != -1) {
                session.setAttribute(Constants.INDEX_CONF, indexConf);
                jump(request, response, Constants.CONF_JSP);
            }else {
                jumpError(request, response, Constants.INDEX_JSP, Constants.ERROR_MESS);
            }


        } catch (SQLException e) {
            jumpError(request, response, Constants.INDEX_JSP, e.getMessage());
        }
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
