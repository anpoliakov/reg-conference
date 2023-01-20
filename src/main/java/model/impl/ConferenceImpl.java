package model.impl;

import constants.SQLConstants;
import model.beans.Conference;
import model.beans.Event;
import model.db.ConnectionManager;
import model.enums.SelectionKindConf;
import model.interfaces.IConferenceDAO;
import model.managers.ConferenceManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConferenceImpl implements IConferenceDAO {

    public List<Conference> getConferences(Enum<?> select) throws SQLException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        SelectionKindConf kind = (SelectionKindConf) select;
        String sql = kind.getSql();
        List<Conference> conferences = new ArrayList<Conference>();

        try {
            conn = ConnectionManager.createConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(SQLConstants.ID_LABEL);
                String name = rs.getString(SQLConstants.NAME_LABEL);
                String place = rs.getString(SQLConstants.PLACE_LABEL);
                Date date = rs.getDate(SQLConstants.DATE_LABEl);
                conferences.add(new Conference(id, name, place, date));
            }
        } finally {
            ConnectionManager.closeResultSet(rs);
            ConnectionManager.closeStatement(st);
            ConnectionManager.closeConnection();
        }
        return conferences;
    }

    public int fillConferenceEvents(List<Conference> conferences, String idConf) throws SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<Event> events = new ArrayList<Event>();
        int id = ConferenceManager.getConfId(conferences, idConf);

        if (id == -1) {
            return id;
        }

        try {
            cn = ConnectionManager.createConnection();
            pst = cn.prepareStatement(SQLConstants.SELECT_EVENTS);
            pst.setString(1, idConf);;
            rs = pst.executeQuery();
            while (rs.next()) {
                int idEv = rs.getInt(SQLConstants.ID_LABEL);
                String name = rs.getString(SQLConstants.NAME_LABEL);
                Time time = rs.getTime(SQLConstants.TIME_LABEL);
                events.add(new Event(idEv, name, time));
            }
            conferences.get(id).setEvents(events);
        } finally {
            ConnectionManager.closeResultSet(rs);
            ConnectionManager.closeStatement(pst);
            ConnectionManager.closeConnection();
        }
        return id;
    }
}
