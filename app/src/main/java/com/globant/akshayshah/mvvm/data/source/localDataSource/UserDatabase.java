package com.globant.akshayshah.mvvm.data.source.localDataSource;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.globant.akshayshah.mvvm.data.User;

import javax.inject.Inject;

/**
 * Created by akshay.shah on 04/01/18.
 */

@Database(entities = {User.class},version = 1,exportSchema = false)
public abstract class UserDatabase extends RoomDatabase{

    private static UserDatabase INSTANCE;

    public abstract UserDao userDao();

    private static final Object sLock = new Object();

    public static UserDatabase getInstance(Context context){
        synchronized (sLock){
            if(INSTANCE == null){
                return Room.databaseBuilder(context.getApplicationContext(),UserDatabase.class,"UserDatabase.db").build();
            }
            return INSTANCE;
        }
    }
}
