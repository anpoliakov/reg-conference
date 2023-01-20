package model.interfaces;

import model.beans.Conference;

import java.sql.SQLException;
import java.util.List;

public interface IConferenceDAO {
    List<Conference> getConferences(Enum <?> select) throws SQLException;
    int fillConferenceEvents(List<Conference> conferences, String idConf) throws SQLException;
}
