package com.globant.akshayshah.mvvm.crudActivity;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.globant.akshayshah.mvvm.R;
import com.globant.akshayshah.mvvm.data.User;
import com.globant.akshayshah.mvvm.data.source.DataRepository;
import com.globant.akshayshah.mvvm.di.AppComponent;
import com.globant.akshayshah.mvvm.di.DaggerAppComponent;
import com.globant.akshayshah.mvvm.di.DataModule;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {


    @Inject
    DataRepository mDataRepository;
    private MainActivityViewModelFactory factory;
    private MainActivityViewModel viewModel;
    private ListView listViewAllUsers;
    private Button buttonAddUser;
    private Button buttonRemoveUser;
    private Button buttonGetUser;
    private List<User> users ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDependencyInjection();
        initViews();
        initUsers();
        factory = new MainActivityViewModelFactory(mDataRepository);
        viewModel = ViewModelProviders.of(this,factory).get(MainActivityViewModel.class);
        viewModel.getListUsers().observe(MainActivity.this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                if(users!=null) {
                    List userStrings = new ArrayList();
                    for (User u : users) {
                        userStrings.add(u.getName());
                    }
                    ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, userStrings);
                    listViewAllUsers.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }
        });
        buttonAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.putListUsers(users);
            }
        });
        buttonRemoveUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.removeUser(new User(1,"akshay"));
            }
        });

    }

    private void initDependencyInjection() {
        AppComponent appComponent = DaggerAppComponent.builder().dataModule(new DataModule(this)).build();
        appComponent.inject(this);

    }

    private void initUsers() {
        users = new ArrayList<>();
        users.add(new User(1, "akshay"));
        users.add(new User(2, "shriram"));
        users.add(new User(3, "piyush"));
        users.add(new User(4, "vikram"));
    }

    private void initViews() {
        buttonAddUser = (Button)findViewById(R.id.buttonAddUser);
        buttonRemoveUser = (Button)findViewById(R.id.buttonRemoveUser);
        buttonGetUser = (Button)findViewById(R.id.buttonGetUser);
        listViewAllUsers = (ListView)findViewById(R.id.listViewAllUsers);
    }


}
