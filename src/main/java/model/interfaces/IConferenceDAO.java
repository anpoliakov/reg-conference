package model.interfaces;

import model.beans.Conference;

import java.util.List;

public interface IConferenceDAO {
    List<Conference> getConferences(Enum <?> select);
    void fillConferenceEvents(List<Conference> conferences, String idConf);
}
