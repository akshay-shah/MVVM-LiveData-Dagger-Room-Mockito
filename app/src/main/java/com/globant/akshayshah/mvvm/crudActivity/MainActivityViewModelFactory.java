package com.globant.akshayshah.mvvm.crudActivity;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;

import com.globant.akshayshah.mvvm.data.source.DataRepository;

/**
 * Created by akshay.shah on 04/01/18.
 */

public class MainActivityViewModelFactory implements ViewModelProvider.Factory {

    private DataRepository mDataRepository;

    public MainActivityViewModelFactory(DataRepository mDataRepository) {
        this.mDataRepository = mDataRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainActivityViewModel.class)) {
            return (T) new MainActivityViewModel(mDataRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
