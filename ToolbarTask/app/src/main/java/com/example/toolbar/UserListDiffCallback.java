package com.example.toolbar;

import android.support.v7.util.DiffUtil;

import java.util.Collection;

/**
 * Created by ${Aina} on 12.10.2018.
 */
public class UserListDiffCallback extends DiffUtil.ItemCallback<User> {

    @Override
    public boolean areItemsTheSame(User oldItem, User newItem) {
        return oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(User oldItem, User newItem) {
        return oldItem.getName().equals(newItem.getName());
    }
}
