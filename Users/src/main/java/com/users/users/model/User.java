package com.users.users.model;

public class User {

    private int id;
    private String name;
    private int role_id;

    public User(int id, String name,int role_id) {
        this.id = id;
        this.name = name;
        this.role_id = role_id;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
}
