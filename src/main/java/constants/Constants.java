package constants;

public final class Constants {
    public static final String LOGIN_JSP = "/login.jsp";
    public static final String INDEX_JSP = "/index.jsp";
    public static final String REGIST_JSP = "/regist.jsp";
    public static final String CONF_JSP = "/conf.jsp";
    public static final String CONF_CONTR = "/conf";
    public static final String INDEX_CONF = "indexConf";
    public static final String OUT_INDEX_JSP = "/reg-conferences/index.jsp";
    public static final String EMPTY = "";
    public static final String USER = "user";

    public static final String MESSAGE = "message";
    public static final String MESS_NULL = "fields are null";
    public static final String MESS_EMPTY = "fields are empty";
    public static final String USER_NOT_FOUND = "User not found";
    public static final String USER_IS_FOUND = "User is found";
    public static final String ERROR_MESS = "error data";

    //не безопасно так хранить (тестовая база)
    public static final String URL_DB = "jdbc:postgresql://localhost:5432/reg_conf_db";
    public static final String USER_DB = "postgres";
    public static final String PASS_DB = "Qwert070123";

    public static final String DRIVER_NAME = "org.postgresql.Driver";

    public static final String LOGIN = "login";
    public static final String ID_CONF = "idConf";
    public static final String PASSWORD = "password";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String MAIL = "mail";

    public static final String SECTION = "section";
    public static final String TODAY_SECT = "today";
    public static final String CONF_LIST = "conferences";
    public static final String CONF_INDEX = "indexConf";
}
