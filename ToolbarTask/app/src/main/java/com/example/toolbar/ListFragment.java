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

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListFragment extends Fragment {
    UserAdapter userAdapter;
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
        usersRecycleView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        diff = new UserListDiffCallback();
        userAdapter = new UserAdapter(diff);
        userAdapter.submitList(getUsers());
        usersRecycleView.setAdapter(userAdapter);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_sort, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        List<User> usersSorted = getUsers();
        switch (item.getItemId()) {
            case R.id.item_sort_by_age:
                Comparator<User> compAge = new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        return o1.getAge() - o2.getAge();
                    }
                };
                Collections.sort(usersSorted, compAge);
                userAdapter.submitList(usersSorted);
                Toast.makeText(getContext(), "pressed 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_sort_in_alf:
                Comparator<User> compAlf = new Comparator<User>() {
                    public int compare(User o1, User o2) {
                        return o1.getName().charAt(0) - o2.getName().charAt(0);
                    }
                };
                Collections.sort(usersSorted, compAlf);
                userAdapter.submitList(usersSorted);
                Toast.makeText(getContext(), "pressed 2", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    public List<User> getUsers() {
        return Arrays.asList(new User(1, "Aina", "Likes coffee, suicide jokes, tasty food and Marvel", 19),
                new User(2, "Liya", "Does IT homework at night", 19),
                new User(3, "Aliya", "Party girl from DD", 20),
                new User(4,"Kama", "Makes origami", 43),
                new User(5, "Lesya", "Loves her dog", 8),
                new User(6, "Elina", "Wants sushi", 24),
                new User(7, "Leyla", "Likes Marvel", 54)
        );
    }
}
