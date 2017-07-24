package com.company.qts.helper;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by MyPC on 24/07/2017.
 */
public class QTSHelp {

    //show Toast
    public static void showToast(Context context, String str_message) {
        Toast toast = Toast.makeText(context, str_message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM, 0, 50);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }
    //show Toast Long
    public static void showToastLong(Context context, String str_message) {
        Toast toast = Toast.makeText(context, str_message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM, 0, 50);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }
    // /////////////////////////// Width device
    public static int GetWidthDevice(Context context) {
        int mode = Activity.MODE_PRIVATE;
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                QTSConstrains.SHAREPRE_ID, mode);
        return sharedPreferences.getInt("width_device", 480);
    }

    public static void SetWidthDevice(Context context, int num) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                QTSConstrains.SHAREPRE_ID, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("width_device", num);
        editor.commit();
    }
    // /////////////////////////// Height device
    public static int GetHeightDevice(Context context) {
        int mode = Activity.MODE_PRIVATE;
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                QTSConstrains.SHAREPRE_ID, mode);
        return sharedPreferences.getInt("height_device", 480);
    }

    public static void SetHeightDevice(Context context, int num) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                QTSConstrains.SHAREPRE_ID, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("height_device", num);
        editor.commit();
    }
    //set size  for view
    public static void setLayoutView(View view, int width, int height) {
        view.getLayoutParams().width = width;
        view.getLayoutParams().height = height;
    }
    //dialog
    public static void ShowpopupMessage(Activity activity, String message) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(activity);
        dialog.setMessage(message);
        dialog.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                return;
            }
        });
        AlertDialog alert = dialog.create();
        alert.show();
    }
    //check mail
    public static boolean checkEmailCorrect(String Email) {
        String pttn = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        Pattern p = Pattern.compile(pttn);
        Matcher m = p.matcher(Email);

        if (m.matches()) {
            return true;
        }
        return false;
    }
}
