package com.globant.akshayshah.mvvm.di;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import com.globant.akshayshah.mvvm.data.User;
import com.globant.akshayshah.mvvm.data.source.DataRepository;
import com.globant.akshayshah.mvvm.data.source.localDataSource.LocalDataSource;
import com.globant.akshayshah.mvvm.data.source.localDataSource.UserDao;
import com.globant.akshayshah.mvvm.data.source.localDataSource.UserDatabase;
import com.globant.akshayshah.mvvm.data.source.remoteDataSource.RemoteDataSource;

import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by akshay.shah on 04/01/18.
 */

@Module
public class DataModule {

    private Context context;

    public DataModule(Context context){
        this.context = context;
    }

    @Provides
    @Singleton
    DataRepository providesDataRepository(LocalDataSource mLocalDataSource, RemoteDataSource mRemoteDataSource){
        return new DataRepository(mLocalDataSource,mRemoteDataSource);
    }

    @Provides
    @Singleton
    LocalDataSource providesLocalDataSource(UserDao mUserDao){
        return new LocalDataSource(mUserDao);
    }

    @Provides
    @Singleton
    RemoteDataSource providesRemoteDataSource(){
        return new RemoteDataSource();
    }
    @Provides
    @Singleton
    UserDao providesUserDao(UserDatabase database){
        return database.userDao();
    }

    @Provides
    @Singleton
    UserDatabase providesUserDatabase(){
        return UserDatabase.getInstance(context);
    }
}
