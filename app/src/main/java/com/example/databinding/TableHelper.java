package com.example.databinding;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.TableRow;
import android.widget.TextView;

public class TableHelper {

    public static TextView addHeaderColumn(TableRow tableRow, String columnName, int color, int width,int gravity, Context context) {
        Typeface mTfLight; //= Typeface.createFromAsset(context.getAssets(), "OpenSans-Light.ttf");
        tableRow.setBackgroundColor(Color.parseColor("#7A8284"));
        TableRow.LayoutParams tableRowParams = new TableRow.LayoutParams(width, TableRow.LayoutParams.MATCH_PARENT);
        //  tableRowParams.setMargins(1, 1, 1, 1);
        tableRowParams.weight = 1;
        TextView textView = new TextView(context);
        textView.setText(columnName);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setTextColor(Color.parseColor("#3B91B4"));
        textView.setTextSize(16);
        textView.setBackgroundColor(Color.parseColor("#F1F1F1"));
        textView.setGravity(gravity);
        textView.setPadding(8,6,8,6);
        tableRow.addView(textView, tableRowParams);
        return textView;

    }


    public static TextView addTextViewColumn(TableRow tableRow,
                                             String columnData,
                                             int style,
            int textColor
            ,
                                             int width,
                                             int gravity,
                                             Context context) {
       // Typeface mTfLight = Typeface.createFromAsset(context.getAssets(), "OpenSans-Light.ttf");
        tableRow.setBackgroundColor(Color.parseColor("#E0E0E0"));
        TableRow.LayoutParams tableRowParams = new TableRow.LayoutParams(width, TableRow.LayoutParams.MATCH_PARENT);
        tableRowParams.setMargins(1, 1, 1, 1);
        tableRowParams.weight = 1;


        TextView textView = new TextView(context);
        textView.setText(columnData);
        textView.setTypeface(null, style);
        textView.setPadding(15,15,15,15);
        textView.setTextColor(textColor);
        textView.setBackgroundColor(Color.parseColor("#F7F7F7"));
        textView.setGravity(gravity);
        textView.setTextSize(14);
        tableRow.addView(textView, tableRowParams);
        return textView;

    }

}
