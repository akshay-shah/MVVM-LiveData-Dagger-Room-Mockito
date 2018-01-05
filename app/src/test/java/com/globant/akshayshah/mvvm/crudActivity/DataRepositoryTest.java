package com.globant.akshayshah.mvvm.crudActivity;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.globant.akshayshah.mvvm.data.User;
import com.globant.akshayshah.mvvm.data.source.DataRepository;
import com.globant.akshayshah.mvvm.data.source.localDataSource.LocalDataSource;
import com.globant.akshayshah.mvvm.data.source.remoteDataSource.RemoteDataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.eq;

/**
 * Created by akshay.shah on 05/01/18.
 */

public class DataRepositoryTest {
    private DataRepository mDataRepository;
    @Mock
    LocalDataSource mLocalDataSource;
    @Mock
    RemoteDataSource mRemoteDataSource;

    @Mock
    Observer<List<User>> liveDataListUsers;

    List<User> listUsers = Arrays.asList(new User(1,"akshay"),
                                        new User(2,"shriram"),
                                        new User(3,"piyush"),
                                        new User(4,"vikram"));

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mDataRepository = new DataRepository(mLocalDataSource,mRemoteDataSource);
    }

    @Test
    public void putUserTest(){
        User akshay = new User(1,"akshay");
        mDataRepository.putUser(akshay);
        Mockito.verify(mLocalDataSource).putUser(eq(akshay));
        Mockito.verify(mRemoteDataSource).putUser(eq(akshay));
    }

    @Test
    public void putListUserTest(){
        mDataRepository.putListUsers(listUsers);
        Mockito.verify(mLocalDataSource).putListUsers(listUsers);
        Mockito.verify(mRemoteDataSource).putListUsers(listUsers);
    }

    @Test
    public void getUsers(){
        mDataRepository.putListUsers(listUsers);
        mDataRepository.getListUsers();
        Mockito.verify(mLocalDataSource).getListUsers().observeForever(liveDataListUsers);
        Mockito.verify(liveDataListUsers).onChanged(listUsers);
    }
}
