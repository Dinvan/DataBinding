package com.example.databinding;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.databinding.databinding.LiveBinding;
import com.example.databinding.model.UserLiveDataModel;

public class DataBindingWithLiveData extends AppCompatActivity {
    UserLiveDataModel userLiveDataModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_binding_with_live_data);
        userLiveDataModel = ViewModelProviders.of(this).get(UserLiveDataModel.class);

        LiveBinding liveBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_with_live_data);
        liveBinding.setLifecycleOwner(this);
        liveBinding.setUserLiveDataModel(userLiveDataModel);
        liveBinding.setDetailCallback(this);

        userLiveDataModel.getLastName().setValue("Bagvan");
        userLiveDataModel.getName().setValue("Dinesh");


    }

   public void onButtonClick(View view){
       userLiveDataModel.getLastName().setValue(System.currentTimeMillis()+"");
       userLiveDataModel.getName().setValue(System.currentTimeMillis()+"");

       UserDetailModel    userDetailModel = new UserDetailModel();
       userDetailModel.setAddress("10,Nanda Nagar Indore");
       userDetailModel.setEmailAddress("dinesh.b@advanz101.com");
       userDetailModel.setName("Dinesh Bagvan");

       userLiveDataModel.getUserDetail().setValue(userDetailModel);
   }
}
