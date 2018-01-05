package com.globant.akshayshah.mvvm.crudActivity;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.globant.akshayshah.mvvm.data.User;
import com.globant.akshayshah.mvvm.data.source.DataRepository;

import java.util.List;

/**
 * Created by akshay.shah on 04/01/18.
 */

public class MainActivityViewModel extends ViewModel implements MainActivityContract{

    private DataRepository mDataRepository;

    public MainActivityViewModel(DataRepository mDataRepository) {
        this.mDataRepository = mDataRepository;
    }

    @Override
    public void putUser(User user) {
        mDataRepository.putUser(user);
    }

    @Override
    public void removeUser(User user) {
        mDataRepository.removeUser(user);
    }

    @Override
    public void putListUsers(List<User> users) {
        mDataRepository.putListUsers(users);
    }

    @Override
    public LiveData<List<User>> getListUsers(){
        return mDataRepository.getListUsers();
    }

}
