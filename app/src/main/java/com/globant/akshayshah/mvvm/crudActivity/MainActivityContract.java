package com.globant.akshayshah.mvvm.crudActivity;

import android.arch.lifecycle.LiveData;

import com.globant.akshayshah.mvvm.data.User;

import java.util.List;

/**
 * Created by akshay.shah on 04/01/18.
 */

public interface MainActivityContract {

    void putUser(User user);
    void removeUser(User user);
    void putListUsers(List<User> users);
    LiveData<List<User>> getListUsers();

}
