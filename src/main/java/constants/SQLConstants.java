package constants;

public class SQLConstants {
    public static final String ID_LABEL = "id";
    public static final String LOGIN_LABEL = "login";
    public static final String SELECT_USER = "SELECT * FROM users where login=? and password=?";
    public static final String FOUND_USER = "select id from users where login=?";
    public static final String INSERT_USER = "insert into users(login,mail,password,firstname,lastname) values (?,?,?,?,?)";

    public static final String SELECT_CONF =
            "select * from conferences ";
    public static final String WHERE_ALL = "";
    public static final String WHERE_TODAY =
            "where date=NOW()";
    public static final String WHERE_TOMORROW =
            "where date=CURRENT_DATE(1)"; //пример mySQL запроса
    public static final String WHERE_SOON =
            "where date>CURRENT_DATE(1)";
    public static final String WHERE_FINISHED =
            "where date<CURRENT_DATE()";
    public static final String SELECT_EVENTS =
            "select events.id,events.name,events.time from events "
                    + "join conferences on events.idConf=conferences.id "
                    + "where events.idConf=?";

    public static final String NAME_LABEL = "name";
    public static final String PLACE_LABEL = "place";
    public static final String DATE_LABEl = "date";
    public static final String TIME_LABEL = "time";
}
