package com.example.userslist.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.userslist.data.Data;
import com.example.userslist.R;
import com.example.userslist.adapter.UserAdapter;
import com.example.userslist.entity.User;

import java.util.Collection;

public class MainActivity extends AppCompatActivity implements MyCallback {
    private UserAdapter userAdapter;
    Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
        loadUsers();
    }

    @Override
    public void callBack(String info) {
        Intent intent = new Intent(this, DetailedActivity.class);
        intent.putExtra("info", info);
        startActivity(intent);
    }

    private void initRecyclerView() {
        RecyclerView usersRecycleView = findViewById(R.id.recycleView);
        usersRecycleView.setLayoutManager(new LinearLayoutManager(this));
        userAdapter = new UserAdapter();
        usersRecycleView.setAdapter(userAdapter);
    }

    private void loadUsers() {
        data = new Data();
        Collection<User> users = data.getUsers();
        userAdapter.setUsers(users);
    }
}
