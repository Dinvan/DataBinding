package com.example.databinding;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import com.example.databinding.databinding.UserList;
import com.example.databinding.model.UserListViewModel;
import com.example.databinding.utills.UserListAdapter;
import java.util.ArrayList;

public class ScrollingActivity extends AppCompatActivity implements View.OnClickListener {

    UserListViewModel userListViewModel;
    ArrayList<String> userList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        userListViewModel= ViewModelProviders.of(this).get(UserListViewModel.class);;

        userListViewModel.getUserName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Log.e("New Data change ",s+" new String");
            }
        });

        UserDetailModel  userDetailModel = new UserDetailModel();
        userDetailModel.setAddress("10,Nanda Nagar Indore");
        userDetailModel.setEmailAddress("dinesh.b@advanz101.com");
        userDetailModel.setName("Dinesh Bagvan");

        ArrayList<UserDetailModel> list=new ArrayList<>();
        userDetailModel = new UserDetailModel();
        userDetailModel.setAddress("10,Nanda Nagar Indore");
        userDetailModel.setEmailAddress("dinesh.b@advanz101.com");
        userDetailModel.setName("Dinesh Bagvan");
        list.add(userDetailModel);
        userDetailModel = new UserDetailModel();
        userDetailModel.setAddress("10,Nanda Nagar Indore");
        userDetailModel.setEmailAddress("dinesh.b@advanz101.com");
        userDetailModel.setName("Dinesh sfsa");
        list.add(userDetailModel);
        userDetailModel = new UserDetailModel();
        userDetailModel.setAddress("10,Nanda Nagar Indore");
        userDetailModel.setEmailAddress("dinesh.b@advanz101.com");
        userDetailModel.setName("sfsa Bagvan");
        list.add(userDetailModel);
        userDetailModel = new UserDetailModel();
        userDetailModel.setAddress("10,Nanda Nagar Indore");
        userDetailModel.setEmailAddress("dinesh.b@advanz101.com");
        userDetailModel.setName("Dinesh sfd");
        list.add(userDetailModel);
        userDetailModel = new UserDetailModel();
        userDetailModel.setAddress("10,Nanda Nagar Indore");
        userDetailModel.setEmailAddress("dinesh.b@advanz101.com");
        userDetailModel.setName("3rer Bagvan");
        list.add(userDetailModel);
        userDetailModel = new UserDetailModel();
        userDetailModel.setAddress("10,Nanda Nagar Indore");
        userDetailModel.setEmailAddress("dinesh.b@advanz101.com");
        userDetailModel.setName("sfs sfsa");
        list.add(userDetailModel);

        UserList userList= DataBindingUtil.setContentView(this,R.layout.activity_scrolling);
        UserListAdapter userListAdapter=new UserListAdapter(this,list);
        userList.setAdapter(userListAdapter);
        userList.setUserDetail(userListViewModel);
        userList.setOnClickListener(this);
        userList.setButtonColor("#CCCCCC");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {

        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    public void onClick(View v) {
        userListViewModel.getUserList().add(System.currentTimeMillis()+" ");
        userList.add(System.currentTimeMillis()+" ");
        userListViewModel.getUserName().setValue(System.currentTimeMillis()+"DBZ");


        Log.e("View Model Size", userListViewModel.getUserList().size()+" Size");
        Log.e("Normal Model Size", userList.size()+" Size");

    }
}
