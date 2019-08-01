package com.example.databinding.utills;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.databinding.R;
import com.example.databinding.UserDetailModel;
import com.example.databinding.databinding.UserItemBinder;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {

    Context context;
    ArrayList<UserDetailModel> usersList;

    public UserListAdapter(Context context, ArrayList<UserDetailModel> usersList) {
        this.context = context;
        this.usersList = usersList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        UserItemBinder userItemBinder = DataBindingUtil.inflate(inflater, R.layout.item_users, viewGroup, false);
        return new ViewHolder(userItemBinder);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final UserDetailModel userDetailModel=usersList.get(i);
        viewHolder.userItemBinder.setUser(userDetailModel);
        viewHolder.userItemBinder.setClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Hello, "+userDetailModel.name, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        UserItemBinder userItemBinder;

        public ViewHolder(@NonNull UserItemBinder userItemBinder) {
            super(userItemBinder.getRoot());
            this.userItemBinder = userItemBinder;
        }
    }
}
