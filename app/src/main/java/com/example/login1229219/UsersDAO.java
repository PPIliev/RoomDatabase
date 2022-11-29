package com.example.login1229219;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UsersDAO {

    @Insert
    void addUser(UsersModel u);

    @Query("SELECT * FROM usersmodel WHERE username = :name AND password = :pass")
    List<UsersModel> getUser(String name, String pass);



}
