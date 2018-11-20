package com.example.toolbar;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import org.reactivestreams.Subscription;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class ListFragment extends Fragment {
    UserAdapter userAdapter;
    Data data;
    UserListDiffCallback diff;
    Toolbar toolbar;
    RecyclerView usersRecycleView;
    private ProgressBar progressBar;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        toolbar = view.findViewById(R.id.toolbar);
        progressBar = view.findViewById(R.id.progressBar);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);

        usersRecycleView = view.findViewById(R.id.recycleView);
        usersRecycleView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        userAdapter.submitList(data.getUsers());
        diff = new UserListDiffCallback();
        userAdapter = new UserAdapter(diff);
        usersRecycleView.setAdapter(userAdapter);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_sort, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        List<User> usersSorted = data.getUsers();
        switch (item.getItemId()) {
            case R.id.item_sort_by_age:
                sortUsers(usersSorted, (user1, user2) -> user2.getAge() - user1.getAge());
                userAdapter.submitList(usersSorted);
                Toast.makeText(getContext(), "pressed 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_sort_in_alf:
                sortUsers(usersSorted, (user1, user2) -> user1.getName().compareTo(user2.getName()));
                Toast.makeText(getContext(), "pressed 2", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    public void sortUsers(List<User> oldList, Comparator<User> comparator) {
        Flowable.fromIterable(oldList)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .take(8)
                .sorted(comparator)
                .map(user -> new User(user.getName(),
                user.getDescription(), user.getAge()))
                .doOnSubscribe(this::showLoading)
                .toList()
                .doAfterTerminate(this::hideLoading)
                .doOnSuccess(newUsers -> userAdapter.submitList(newUsers))
                .subscribe();
    }

    private void showLoading(Subscription subscription) {
        progressBar.setVisibility(ProgressBar.VISIBLE);
    }

    private void hideLoading() {
        progressBar.setVisibility(ProgressBar.INVISIBLE);
    }
}
