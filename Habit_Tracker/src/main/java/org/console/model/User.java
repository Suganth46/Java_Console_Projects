package org.console.model;

public class User {
    private static int count=0;
    private int userId;
    private String userName;
    private String password;
    private String email;
    private  int points=0;
    private  int level=0;
    public User(String userName, String password, String email) {
        this.userId = ++count ;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void addPoints(int pts) {
        this.points += pts;
        int newLevel=(this.points/100)+1;
        if(newLevel>this.level){
            this.level=newLevel;
        }
    }
}
