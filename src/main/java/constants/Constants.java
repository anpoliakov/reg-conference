package constants;

public final class Constants {
    public static final String MESSAGE = "message";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String DRIVER_NAME = "org.postgresql.Driver";

    public static final String LOGIN_JSP = "/login.jsp";
    public static final String EMPTY = "";

    public static final String MESS_NULL = "fields are null";
    public static final String MESS_EMPTY = "fields are empty";

    //не безопасно так хранить (тестовая база)
    public static final String URL_DB = "jdbc:postgresql://localhost:5432/reg_conf_db";
    public static final String USER_DB = "postgres";
    public static final String PASS_DB = "Qwert070123";
}
