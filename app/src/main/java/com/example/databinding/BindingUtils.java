package com.example.databinding;

import android.databinding.BindingAdapter;
import android.graphics.Color;
import android.widget.Button;
import java.util.HashMap;

public class BindingUtils {
    public static HashMap<Integer,String> monthColorMap=new HashMap<>();
    static {
        monthColorMap.put(1,"#CCCCCC");
        monthColorMap.put(2,"#CCe3CC");
        monthColorMap.put(3,"#000000");
        monthColorMap.put(4,"#86CCCCC");
    }
    public static String capitalize(String text) {
        return text.toUpperCase();
    }

    @BindingAdapter("setMonthTextColor")
    public static void setButtonTextColor(Button button, String textColorCode) {
        button.setTextColor(Color.parseColor(textColorCode));
    }

    @BindingAdapter("setMonthTextColor")
    public static void setMonthTextColor(Button button, int month) {
        button.setTextColor(Color.parseColor(monthColorMap.get(month)));
    }
}
