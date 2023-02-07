package model.interfaces;

import model.beans.Conference;
import model.beans.Event;
import model.beans.User;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface IConferenceDAO {
    List<Conference> getConferences(Enum <?> select, User user) throws SQLException;
    int fillConferenceEvents(List<Conference> conferences, String idConf) throws SQLException, ParseException;
    int addConference(Conference conference, User user) throws SQLException;
    void addConferenceEvents(List<Event> events, int idConf) throws SQLException;
	void removeConferences(String[] idConferences, User user) throws SQLException;
}
