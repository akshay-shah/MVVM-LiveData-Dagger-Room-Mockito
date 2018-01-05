package com.globant.akshayshah.mvvm.data.source;

import android.arch.lifecycle.LiveData;

import com.globant.akshayshah.mvvm.data.User;

import java.util.List;

/**
 * Created by akshay.shah on 04/01/18.
 */

public interface DataSource {
    void putUser(User user);
    void putListUsers(List<User> users);
    void removeUser(User user);
    LiveData<List<User>> getListUsers();
}
