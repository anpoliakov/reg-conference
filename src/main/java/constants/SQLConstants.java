package constants;

public class SQLConstants {
    public static final String SELECT_USER = "SELECT * FROM users where login=? and password=?";
    public static final String ID_LABEL = "id";
    public static final String LOGIN_LABEL = "login";
    public static final String FOUND_USER = "select id from users where login=?";

    public static final String INSERT_USER = "insert into users(login,mail,password,firstname,lastname) values (?,?,?,?,?)";
}
