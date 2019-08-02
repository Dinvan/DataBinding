package com.example.databinding;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.databinding.databinding.UserList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UsersList extends AppCompatActivity {
    private TableLayout tableLayout;
    ArrayList<TableRow> tableRowList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_screen);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tableLayout=findViewById(R.id.tableLayout);
        tableLayout.setBackgroundColor(Color.GRAY);
        tableRowList.clear();
        TableRow.LayoutParams tableRowParams = new TableRow.LayoutParams();
        tableRowParams.setMargins(1, 1, 1, 1);
        tableRowParams.weight = 1;

        String[] headers = {
                "SName"
                , "MM"
                , "OM", "GR"


        };
        List<UserData> userDataList = new ArrayList<>();
        UserData userData = new UserData();
        userData.setGr("A");
        userData.setMm(100);
        userData.setOm(60);
        userData.setsName("Hello 1");
        userDataList.add(userData);

        userData = new UserData();
        userData.setGr("A");
        userData.setMm(100);
        userData.setOm(58);
        userData.setsName("Hello 1");
        userDataList.add(userData);

        userData = new UserData();
        userData.setGr("A");
        userData.setMm(100);
        userData.setOm(88);
        userData.setsName("Music");
        userDataList.add(userData);


        userData = new UserData();
        userData.setGr("D");
        userData.setMm(100);
        userData.setOm(35);
        userData.setsName("Movie");
        userDataList.add(userData);


        userData = new UserData();
        userData.setGr("B");
        userData.setMm(100);
        userData.setOm(95);
        userData.setsName("Animation");
        userDataList.add(userData);


        userData = new UserData();
        userData.setGr("C");
        userData.setMm(100);
        userData.setOm(46);
        userData.setsName("VFX");
        userDataList.add(userData);


        userData = new UserData();
        userData.setGr("A");
        userData.setMm(100);
        userData.setOm(68);
        userData.setsName("Graphics");
        userDataList.add(userData);

        userData = new UserData();
        userData.setGr("A");
        userData.setMm(100);
        userData.setOm(90);
        userData.setsName("Gaana");
        userDataList.add(userData);

        int widthRColumn = LinearLayout.LayoutParams.WRAP_CONTENT;
        int[] width = {widthRColumn, widthRColumn, widthRColumn,widthRColumn};
        TableRow tableRowHeader = new TableRow(UsersList.this);

        for (int c = 0; c < headers.length; c++) {
            TableHelper.addHeaderColumn(tableRowHeader, headers[c], Color.parseColor("#4D4D4D"), width[c], Gravity.CENTER, UsersList.this);
        }
        tableRowList.add(tableRowHeader);

        for (int dataListIndex = 0; dataListIndex < userDataList.size(); dataListIndex++) {
            final UserData userData1 = userDataList.get(dataListIndex);
            TableRow tableRow = new TableRow(UsersList.this);

            TableHelper.addTextViewColumn(tableRow, userData1.getsName(),Typeface.BOLD,Color.parseColor("#000000"), LinearLayout.LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL, UsersList.this);

            TableHelper.addTextViewColumn(tableRow, userData1.getMm() + "",Typeface.NORMAL,Color.parseColor("#656565"), LinearLayout.LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL, UsersList.this);
            TableHelper.addTextViewColumn(tableRow, userData1.getOm() + "",Typeface.NORMAL,Color.parseColor("#656565"), LinearLayout.LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL, UsersList.this);
            TableHelper.addTextViewColumn(tableRow, userData1.getGr() + "",Typeface.NORMAL,Color.parseColor("#656565"), LinearLayout.LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL, UsersList.this);

            tableRowList.add(tableRow);

            tableRow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(UsersList.this, "Hello " + userData1.getsName(), Toast.LENGTH_SHORT).show();
                }
            });

        }

        for (int i = 0; i < tableRowList.size(); i++) {
            tableLayout.addView(tableRowList.get(i));
        }

    }

}
