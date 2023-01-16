package model.beans;

import java.sql.Date;
import java.util.List;

public class Conference {
    private int id;
    private String name;
    private String place;
    private Date date;
    private List<Event> events;

    public Conference(int id, String name, String place, Date date, List<Event> events) {
        super();
        this.id = id;
        this.name = name;
        this.place = place;
        this.date = date;
        this.events = events;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
