package com.example.login1229219;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UsersModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UsersDAO usersDAO();

    private static AppDatabase INSTANCE;

    public static AppDatabase getINSTANCE(Context ctx) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(ctx, AppDatabase.class, "users.db").allowMainThreadQueries().build();

        }
        return INSTANCE;
    }



}
