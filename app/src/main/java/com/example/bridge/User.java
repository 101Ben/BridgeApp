package com.example.bridge;

public class User {
    private String email;
    private String password;
    private String fullName;
    //private String language;
    public User(String email, String password, String fullName)
    {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }

    public User() {
    }

    public String getEmail()
    {
        return email;
    }
    public String getFullName() {return fullName;}
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
/*    public String getLanguage()
    {
        return language;
    }
    public void setLanguage(String language)
    {
        this.language = language;
    }*/
}