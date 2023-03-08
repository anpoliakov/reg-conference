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

    public List<Conference> getConferences(Enum<?> section, User user) throws SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        SectionKind sect = (SectionKind) section;
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
                String title = rs.getString(SQLConstants.TITLE_LABEL);
                String descr = rs.getString(SQLConstants.DESCR_LABEL);
                String place = rs.getString(SQLConstants.PLACE_LABEL);
                Date date = rs.getDate(SQLConstants.DATE_LABEL);
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
            pst.setInt(1, Integer.valueOf(idConf));
            rs = pst.executeQuery();

            List <Event> events = new ArrayList<Event>();

            while (rs.next()) {
                int id = rs.getInt(SQLConstants.ID_LABEL);
                String name = rs.getString(SQLConstants.NAME_LABEL);
                String time = rs.getString(SQLConstants.TIME_LABEL);
                events.add(new Event(id, name, time));
            }
            conferences.get(indexConf).setEvents(events);

        } finally {
            ConnectionManager.closeResultSet(rs);
            ConnectionManager.closeStatement(pst);
            ConnectionManager.closeConnection();
        }

        return indexConf;
    }

    @Override
    public int addConference(Conference conference, User user) throws SQLException {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        int idConf = -1;

        /**
         * Реализую возможность добавления конференции в БД и сразу же получаю ID конференции,
         * для дальнейшего использования как FK в таблице events
         * **/
        try {
            conn = ConnectionManager.createConnection();
            pst = conn.prepareStatement(SQLConstants.INSERT_CONF, Statement.RETURN_GENERATED_KEYS);

            pst.setInt(1, user.getId());
            pst.setString(2, conference.getTitle());
            pst.setString(3, conference.getDescr());
            pst.setString(4, conference.getPlace());
            pst.setDate(5, conference.getDate());

            // метод executeUpdate возвращает кол-во строк которые были изменены(внесены) в бд
            if(pst.executeUpdate() != 0){
                rs = pst.getGeneratedKeys();

                // получаю ID внесённой конференции
                if(rs.next()){
                    //нумерация колонок с №1
                    idConf = rs.getInt(1);
                }
            }
        } finally {
            ConnectionManager.closeResultSet(rs);
            ConnectionManager.closeStatement(pst);
            ConnectionManager.closeConnection();
        }
        return idConf;
    }

    @Override
    public void addConferenceEvents(List<Event> events, int idConf) throws SQLException {
        Connection conn = null;
        PreparedStatement pst = null;

        try {
            conn = ConnectionManager.createConnection();
            pst = conn.prepareStatement(SQLConstants.INSERT_EVENTS);
            pst.setInt(1, idConf);
            for (Event event : events) {
                pst.setString(2, event.getName());
                pst.setTime(3, event.getTime());
                pst.executeUpdate();
            }

        } finally {
            ConnectionManager.closeStatement(pst);
            ConnectionManager.closeConnection();
        }

    }

    @Override
    public void removeConferences(String[] idConferences, User user) throws SQLException {
        Connection conn = null;
        PreparedStatement pst = null;

        try {
            conn = ConnectionManager.createConnection();
            pst = conn.prepareStatement(SQLConstants.DELETE_CONF);
            pst.setInt(2, user.getId());
            for (String idConf : idConferences) {
                pst.setInt(1, Integer.valueOf(idConf));
                pst.executeUpdate();
            }
        } finally {
            ConnectionManager.closeStatement(pst);
            ConnectionManager.closeConnection();
        }

    }

    @Override
    public Conference getConference(int idConf) throws SQLException {
        Conference conf = null;

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try{
            conn = ConnectionManager.createConnection();
            pst = conn.prepareStatement(SQLConstants.SELECT_CONF_AND_EVENTS);
            pst.setInt(1, idConf);
            rs = pst.executeQuery();

            if(rs.next()){
                String title_conf = rs.getString(SQLConstants.TITLE_LABEL);
                String descr_conf = rs.getString(SQLConstants.DESCR_LABEL);
                String place_conf = rs.getString(SQLConstants.PLACE_LABEL);
                Date date_conf = rs.getDate(SQLConstants.DATE_LABEL);

                //TODO: доработать получение ВСЕХ событий в пределах одной конф
                String name_event = rs.getString(SQLConstants.NAME_LABEL);
                Time time_event = rs.getTime(SQLConstants.TIME_LABEL);
            }
        }finally {
            ConnectionManager.closeConnection();
        }

        return conf;
    }
}

/**
 *
 * можно сделать передачу прав на конференцию - другому User
 *
 * */
