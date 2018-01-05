package com.globant.akshayshah.mvvm.data.source.localDataSource;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Insert;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.PluralsRes;

import com.globant.akshayshah.mvvm.data.User;
import com.globant.akshayshah.mvvm.data.source.DataSource;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Inject;

/**
 * Created by akshay.shah on 04/01/18.
 */

public class LocalDataSource implements DataSource {

    private Executor executor = Executors.newSingleThreadExecutor();
    private UserDao mUserDao;

    @Inject
    public LocalDataSource(UserDao mUserDao) {
        this.mUserDao = mUserDao;
    }

    @Override
    public void putUser(final User user) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mUserDao.insert(user);
            }
        });
    }

    @Override
    public void putListUsers(final List<User> users) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mUserDao.insertListUsers(users);
            }
        });
    }

    @Override
    public void removeUser(final User user) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mUserDao.delete(user.getId());
            }
        });
    }

    @Override
    public LiveData<List<User>> getListUsers() {
        return mUserDao.getUsers();
    }
}
