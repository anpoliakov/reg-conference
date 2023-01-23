package constants;

public class SQLConstants {
    public static final String SELECT_USER = "select * from users where login=? and password=?";
    public static final String INSERT_USER = "insert into users(login, password, firstname, secondname, email) values(?,?,?,?,?)";
    public static final String FOUND_LOGIN = "select id from users where login=?";

    public static final String SELECT_CONF = "select * from conferences ";
    public static final String WHERE_ALL = "";
    public static final String WHERE_TODAY = "where date=CURRENT_DATE";
    public static final String WHERE_TOMORROW = "where date=DATE_ADD(CURRENT_DATE(), INTERVAL 1 DAY)";
    public static final String WHERE_SOON ="where date>DATE_ADD(CURRENT_DATE(), INTERVAL 1 DAY)";
    public static final String WHERE_PAST ="where date<CURRENT_DATE()";
    public static final String WHERE_CONF_BY_USER = "where idUser = ?";

    public static final String SELECT_EVENTS = "select events.id, events.title, events.time from events join conferences on idConf = conferences.id "
            + "where idConf=? order by time";

    public static final String LOGIN_LABEL = "login";
    public static final String ID_LABEL = "id";
    public static final String TITLE_LABLE ="title";
    public static final String DESCR_LABLE = "descr";
    public static final String PLACE_LABLE ="place";
    public static final String DATE_LABLE ="date";
    public static final String TIME_LABLE = "time";
    public static final String FNAME_LABEL = "firstname";
    public static final String SNAME_LABEL = "secondname";
    public static final String EMAIL_LABEL = "email";
}
