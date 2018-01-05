package com.globant.akshayshah.mvvm.data.source;

import android.arch.lifecycle.LiveData;
import android.icu.lang.UScript;
import android.util.Log;

import com.globant.akshayshah.mvvm.data.User;
import com.globant.akshayshah.mvvm.data.source.localDataSource.LocalDataSource;
import com.globant.akshayshah.mvvm.data.source.remoteDataSource.RemoteDataSource;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by akshay.shah on 04/01/18.
 */

public class DataRepository implements DataSource {

    private LocalDataSource mLocalDataSource;
    private RemoteDataSource mRemoteDataSource;

    @Inject
    public DataRepository(LocalDataSource mLocalDataSource, RemoteDataSource mRemoteDataSource) {
        this.mLocalDataSource = mLocalDataSource;
        this.mRemoteDataSource = mRemoteDataSource;
    }

    @Override
    public void putUser(User user) {
        mLocalDataSource.putUser(user);
        mRemoteDataSource.putUser(user);
    }

    @Override
    public void putListUsers(List<User> users) {
        mLocalDataSource.putListUsers(users);
        mRemoteDataSource.putListUsers(users);
    }

    @Override
    public void removeUser(User user) {
        mLocalDataSource.removeUser(user);
        mRemoteDataSource.removeUser(user);
    }

    @Override
    public LiveData<List<User>> getListUsers() {
        if (true) {
            return mLocalDataSource.getListUsers();
        } else
            return mRemoteDataSource.getListUsers();
    }
}
