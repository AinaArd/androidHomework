package com.example.toolbar;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {
    UserAdapter userAdapter;
    Data data;
    UserListDiffCallback diff;
    Toolbar toolbar;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        toolbar = view.findViewById(R.id.toolbar);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);

        RecyclerView usersRecycleView = view.findViewById(R.id.recycleView);
        usersRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));

        data = new Data();
        List<User> users = (List<User>) data.getUsers();
        diff = new UserListDiffCallback(users, users);
        userAdapter = new UserAdapter(diff);
        usersRecycleView.setAdapter(userAdapter);
        loadUsers();
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_sort, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_sort_by_age:
                Toast.makeText(getContext(), "pressed list", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_sort_in_alf:
                Toast.makeText(getContext(), "pressed pager", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    /*private void initRecyclerView() {
        RecyclerView usersRecycleView = findViewById(R.id.recycleView);
        usersRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));

        data = new Data();
        List<User> users = (List<User>) data.getUsers();
        List<User> users2 = (List<User>) data.getOtherUsers();

        // TODO: sorting

        diff = new UserListDiffCallback(users, users2);
        userAdapter = new UserAdapter(diff);
        usersRecycleView.setAdapter(userAdapter);
    }*/

    private void loadUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("Aina", "Likes coffee, suicide jokes, tasty food and Marvel", 19));
        users.add(new User("Liya", "Does IT homework at night", 19));
        users.add(new User("Aliya", "Party girl from DD", 20));
        users.add(new User("Kama", "Makes origami", 43));
        users.add(new User("Lesya", "Loves her dog", 8));
        users.add(new User("Leyla", "Likes Marvel", 54));
        userAdapter.setUsers(users);
    }
}
