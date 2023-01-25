package model.beans;

import constants.Constants;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Event {
    private int id;
    private String name;
    private Time time;

    public Event(String name, String time) throws ParseException {
        this.name = name;
        setTime(time);
    }

    public Event(int id, String name, Time time) {
        this.id = id;
        this.name = name;
        this.time = time;
    }

    public Event(int id, String name, String time) throws ParseException {
        this.id = id;
        this.name = name;
        setTime(time);
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

    public Time getTime() {
        return time;
    }

    public void setTime(String time) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(Constants.TIME_PATTERN);
        this.time = new Time(format.parse(time).getTime());
    }
}
