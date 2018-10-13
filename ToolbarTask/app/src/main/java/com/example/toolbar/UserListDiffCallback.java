package com.example.toolbar;

import android.support.v7.util.DiffUtil;

import java.util.Collection;

/**
 * Created by ${Aina} on 12.10.2018.
 */
public class UserListDiffCallback extends DiffUtil.ItemCallback<User> {
    private Collection<User> oldList;
    private Collection<User> newList;

    public UserListDiffCallback(Collection<User> oldList, Collection<User> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public boolean areItemsTheSame(User oldItem, User newItem) {
        return oldItem == newItem;
    }

    @Override
    public boolean areContentsTheSame(User oldItem, User newItem) {
        if (oldItem.getName().equals(newItem.getName())) {
            return oldItem.getDescription().equals(newItem.getDescription());
        }
        return false;
    }
}
