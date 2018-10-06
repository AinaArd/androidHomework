package com.example.userslist.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.userslist.R;
import com.example.userslist.activites.MyCallback;
import com.example.userslist.entity.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by ${Aina} on 04.10.2018.
 */
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<User> listOfUsers = new ArrayList<>();
    private LinearLayout linearLayout;
    private Context c;
    private MyCallback callback;

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_user, parent, false);
        c = view.getContext();
        linearLayout = view.findViewById(R.id.linear_l);
        callback = (MyCallback) view.getContext();
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int id) {
        holder.bindView(listOfUsers.get(id));
    }

    @Override
    public int getItemCount() {
        return listOfUsers.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        private ImageView userPic;
        private TextView userName;
        private TextView userInfo;

        private UserViewHolder(View itemView) {
            super(itemView);
            userPic = itemView.findViewById(R.id.imv_avatar);
            userName = itemView.findViewById(R.id.tv_name);
            userInfo = itemView.findViewById(R.id.tv_info);
        }

        private void bindView(User user) {
            userPic.setImageDrawable(ContextCompat.getDrawable(c, R.drawable.pic1));
            userName.setText(user.getName());
            userInfo.setText(user.getContext());
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String infoFromUser = userInfo.getText().toString();
                    callback.callBack(infoFromUser);
                }
            });
        }
    }

    public void setUsers(Collection<User> users) {
        listOfUsers.addAll(users);
        notifyDataSetChanged(); // to let adapter know when smth is changed
    }
}
