package model.managers;

import model.beans.Conference;

import java.util.List;

public class ConferenceManager {
    public static int getConfId(List<Conference> conferences, String idConf) {
        int id;
        try {
            id = Integer.parseInt(idConf);
        } catch (NumberFormatException e) {
            return -1;
        }
        int i;
        for (i = 0; i < conferences.size(); i++) {
            if (conferences.get(i).getId() == id) {
                break;
            }
        }
        if (i == conferences.size()) {
            return -1;
        }
        return i;
    }
}
