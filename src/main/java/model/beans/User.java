package model.beans;

public class User {
    private int id;
    private String login;
    private String mail;
    private String firstName;
    private String lastName;

    public User(int id, String login, String mail, String firstName, String lastName) {
        this.id = id;
        this.login = login;
        this.mail = mail;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //используется для уточнения "есть ли user в data base"
    public User(int id, String login) {
        this.id = id;
        this.login = login;
    }

    public User(String login, String mail, String firstName, String lastName) {
        this.login = login;
        this.mail = mail;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
