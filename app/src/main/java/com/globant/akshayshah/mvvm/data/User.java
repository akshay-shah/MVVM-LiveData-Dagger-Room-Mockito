package com.globant.akshayshah.mvvm.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by akshay.shah on 04/01/18.
 */

@Entity
public class User {

    public String name;
    public @PrimaryKey int id;

    public User(int id,String name){
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
