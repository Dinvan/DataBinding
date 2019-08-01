package com.example.databinding.model;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.databinding.UserDetailModel;

public class UserLiveDataModel extends ViewModel {

    MutableLiveData<String> name=new MutableLiveData<>();
    MutableLiveData<String> lastName=new MutableLiveData<>();
    MutableLiveData<UserDetailModel> userDetail=new MutableLiveData<>();

    public MutableLiveData<String> getName() {
        return name;
    }

    public void setName(MutableLiveData<String> name) {
        this.name = name;
    }

    public MutableLiveData<String> getLastName() {
        return lastName;
    }

    public void setLastName(MutableLiveData<String> lastName) {
        this.lastName = lastName;
    }

    public MutableLiveData<UserDetailModel> getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(MutableLiveData<UserDetailModel> userDetail) {
        this.userDetail = userDetail;
    }
}
