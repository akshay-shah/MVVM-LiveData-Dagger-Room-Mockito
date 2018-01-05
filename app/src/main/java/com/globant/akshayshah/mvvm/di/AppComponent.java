package com.globant.akshayshah.mvvm.di;

import com.globant.akshayshah.mvvm.crudActivity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by akshay.shah on 04/01/18.
 */

@Component(modules = {DataModule.class})
@Singleton
public interface AppComponent {
    void inject(MainActivity activity);
}
