package com.example.databinding;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
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


    /**
     * Get version name of application.
     * @param context reference to get application resources
     * @return returns version name
     */
    public static String getVersionName(Context context) {
        String versionName = "";
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            versionName = packageInfo.versionName;
            return versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * Get version code of application.
     * @param context reference to get application resources
     * @return returns version code
     */
    public static int getVersionCode(Context context) {
        int versionCode=0 ;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            versionCode = packageInfo.versionCode;
            return versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }
}
