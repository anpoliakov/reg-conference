package model.impl;

import constants.SQLConstants;
import model.beans.Conference;
import model.beans.Event;
import model.beans.User;
import model.db.ConnectionManager;
import model.enums.SectionKind;
import model.interfaces.IConferenceDAO;
import model.managers.ConferenceManager;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ConferenceImpl implements IConferenceDAO {
    public ConferenceImpl() {
        super();
    }

    public List<Conference> getConferences(Enum<?> select, User user) throws SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        SectionKind sect = (SectionKind) select;
        String sql = sect.getSql();
        List<Conference> conferences = new ArrayList<Conference>();

        try {
            conn = ConnectionManager.createConnection();
            st = conn.prepareStatement(sql);
            if (sect == SectionKind.CONF_BY_USER) {
                st.setInt(1, user.getId());
            }
            rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(SQLConstants.ID_LABEL);
                String title = rs.getString(SQLConstants.TITLE_LABLE);
                String descr = rs.getString(SQLConstants.DESCR_LABLE);
                String place = rs.getString(SQLConstants.PLACE_LABLE);
                Date date = rs.getDate(SQLConstants.DATE_LABLE);
                conferences.add(new Conference(id, title, descr, place, date));
            }

        } finally {
            ConnectionManager.closeResultSet(rs);
            ConnectionManager.closeStatement(st);
            ConnectionManager.closeConnection();
        }

        return conferences;
    }

    public int fillConferenceEvents(List<Conference> conferences, String idConf) throws SQLException, ParseException {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int indexConf  = ConferenceManager.getIndex(conferences, idConf);

        if (indexConf == -1) {
            return indexConf;
        }

        try {
            conn = ConnectionManager.createConnection();
            pst = conn.prepareStatement(SQLConstants.SELECT_EVENTS);
            pst.setString(1, idConf);;
            rs = pst.executeQuery();

            List <Event> events = new ArrayList<Event>();

            while (rs.next()) {
                int id = rs.getInt(SQLConstants.ID_LABEL);
                String title = rs.getString(SQLConstants.TITLE_LABLE);
                String time = rs.getString(SQLConstants.TIME_LABLE);
                events.add(new Event(id, title, time));
            }
            conferences.get(indexConf).setEvents(events);

        } finally {
            ConnectionManager.closeResultSet(rs);
            ConnectionManager.closeStatement(pst);
            ConnectionManager.closeConnection();
        }

        return indexConf;
    }
}
