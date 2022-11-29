package com.example.login1229219;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.*;

@Entity
public class UsersModel {

    @PrimaryKey(autoGenerate = true)

    private int id;
    private String username;
    private String password;
    private String email;

    public UsersModel(int id, String username, String password, String email) {
        this.password = password;
        this.username = username;
        this.email = email;
    }

    public UsersModel(){}


    @Override
    public String toString() {
        return  "id = " + id +
                ", username = '" + username + '\'' +
                ", email = " + email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
