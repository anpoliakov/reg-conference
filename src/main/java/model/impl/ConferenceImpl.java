package model.impl;

import constants.SQLConstants;
import model.beans.Conference;
import model.db.ConnectionManager;
import model.enums.SelectionKindConf;
import model.interfaces.IConferenceDAO;

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

    public void fillConferenceEvents(List<Conference> conferences, String idConf) {

    }
}
