package com.example.databinding;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.databinding.databinding.MainActivityBinding;

public class MainActivity extends AppCompatActivity {
    OnClickHandler onClickHandler;
    UserDetailModel userDetailModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userDetailModel = new UserDetailModel();
        userDetailModel.setAddress("10,Nanda Nagar Indore");
        userDetailModel.setEmailAddress("dinesh.b@advanz101.com");
        userDetailModel.setName("Dinesh Bagvan");

        MainActivityBinding mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //mainBinding.txtEmailAddress.setText(userDetailModel.getEmailAddress());
        //mainBinding.txtFirstName.setText(userDetailModel.getName());
        mainBinding.setUserDetail(userDetailModel);
        onClickHandler=new OnClickHandler(this);
        mainBinding.setClickListener(onClickHandler);



    }


    public class OnClickHandler {
        Context context;

        public OnClickHandler(Context context) {
            this.context = context;
        }
        public void onButtonClick(View view){
            Toast.makeText(MainActivity.this, "Hello CLick", Toast.LENGTH_SHORT).show();
        }
    }
}
