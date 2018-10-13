package com.example.toolbar;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by ${Aina} on 04.10.2018.
 */
public class UserAdapter extends ListAdapter<User, UserAdapter.UserViewHolder> {
    private List<User> listOfUsers = new ArrayList<>();

    protected UserAdapter(@NonNull DiffUtil.ItemCallback<User> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        return new UserViewHolder(inflater.inflate(R.layout.recycler_view_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int id) {
        holder.bindView(listOfUsers.get(id));
    }

    @Override
    public void submitList(List<User> list) {
        super.submitList(list != null ? new ArrayList<>(list) : null);
    }

    @Override
    public int getItemCount() {
        return listOfUsers.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        private TextView userName;
        private TextView userInfo;
        private TextView userAge;

        private UserViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cv_user);
            userName = itemView.findViewById(R.id.tv_name);
            userInfo = itemView.findViewById(R.id.tv_info);
            userAge = itemView.findViewById(R.id.tv_age);
        }

        private void bindView(User user) {
            userName.setText(user.getName());
            userInfo.setText(user.getDescription());
            userAge.setText(String.valueOf(user.getAge()));
        }
    }

    public void setUsers(Collection<User> users) {
        listOfUsers.addAll(users);
        notifyDataSetChanged(); // to let adapter know when smth is changed
    }
}
