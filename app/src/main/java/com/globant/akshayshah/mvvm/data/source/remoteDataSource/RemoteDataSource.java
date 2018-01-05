package com.globant.akshayshah.mvvm.data.source.remoteDataSource;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Insert;

import com.globant.akshayshah.mvvm.data.User;
import com.globant.akshayshah.mvvm.data.source.DataSource;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by akshay.shah on 04/01/18.
 */

public class RemoteDataSource implements DataSource {


    @Inject
    public RemoteDataSource() {
    }

    @Override

    public void putUser(User user) {

    }

    @Override
    public void putListUsers(List<User> users) {

    }

    @Override
    public void removeUser(User user) {

    }

    @Override
    public LiveData<List<User>> getListUsers() {
        return null;
    }
}
