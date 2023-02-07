package model.beans;

public class User {
    private int id;
    private String login;
    private String firstName;
    private String secondName;
    private String email;

    public User(int id, String login, String email, String firstName, String secondName) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    //используется для уточнения "есть ли user в data base"
    public User(int id, String login) {
        this.id = id;
        this.login = login;
    }

    public User(String login, String email, String firstName, String secondName) {
        this.login = login;
        this.email = email;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
