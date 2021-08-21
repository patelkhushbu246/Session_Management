package com.example.sessionmanagement;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.HashMap;



public class SessionManager {


    SharedPreferences.Editor editor;

    Context context;

    public SessionManager(){
    }
    public static boolean saveuname(String uname,Context context){
        SharedPreferences pref= PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor=pref.edit();
        editor.putString(DBHelper.KEY_UNAME,uname);
        editor.apply();
        return true;
    }
    public static String getuname(Context context){
        SharedPreferences pref= PreferenceManager.getDefaultSharedPreferences(context);
        return pref.getString(DBHelper.KEY_UNAME,null);
    }
    public static boolean savepass(String pass,Context context){
        SharedPreferences pref= PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor=pref.edit();
        editor.putString(DBHelper.KEY_PASS,pass);
        editor.apply();
        return true;
    }
    public static String getpass(Context context){
        SharedPreferences pref= PreferenceManager.getDefaultSharedPreferences(context);
        return pref.getString(DBHelper.KEY_PASS,null);
    }
    public static boolean saveemail(String email,Context context){
        SharedPreferences pref= PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor=pref.edit();
        editor.putString(DBHelper.KEY_EMAIL,email);
        editor.apply();
        return true;
    }
    public static String getemail(Context context){
        SharedPreferences pref= PreferenceManager.getDefaultSharedPreferences(context);
        return pref.getString(DBHelper.KEY_EMAIL,null);
    }
}
