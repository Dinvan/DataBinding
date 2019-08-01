package com.example.databinding.model;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.graphics.Color;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class UserListViewModel extends ViewModel {

    List<String> userList = new ArrayList<>();
    final MutableLiveData<String> userName=new MutableLiveData<>();

    public List<String> getUserList() {
        return userList;
    }

    public void setUserList(List<String> userList) {
        this.userList = userList;
    }

    public MutableLiveData<String> getUserName() {
        return userName;
    }

}
