package com.tech.cablebill;

public class Planet_agent {

    public String Id;
    public String Name;
    public String Username;
    public String Password;
    public String Area;

    public Planet_agent(String id, String name, String username, String password, String area){
        this.Id = id;
        this.Name = name;
        this.Username = username;
        this.Password = password;
        this.Area = area;
    }
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        this.Area = area;
    }
}
