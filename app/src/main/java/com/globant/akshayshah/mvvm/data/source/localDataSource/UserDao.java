package com.globant.akshayshah.mvvm.data.source.localDataSource;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.globant.akshayshah.mvvm.data.User;

import java.util.List;

/**
 * Created by akshay.shah on 04/01/18.
 */

@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(User user);

    @Query("DELETE FROM User WHERE id = :userId")
    void delete(int userId);

    @Query("SELECT * FROM User")
    LiveData<List<User>> getUsers();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertListUsers(List<User> users);
}
