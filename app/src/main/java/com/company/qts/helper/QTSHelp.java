package com.company.qts.helper;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.company.qts.demo1.R;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by MyPC on 24/07/2017.
 */
public class QTSHelp {

    private static final float MAX_IMAGE_DIMENSION = 1280;

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

//    // Save image to internal memory
//    public static boolean saveImageToInternalStorage(Context context, Bitmap image, String name) {
//        try {
//            // Use the compress method on the Bitmap object to write image to
//            // the OutputStream
//            FileOutputStream fos = context.openFileOutput(name, Context.MODE_PRIVATE);
//
//            // Writing the bitmap to the output stream
//            image.compress(Bitmap.CompressFormat.PNG, 100, fos);
//            fos.close();
//
//            return true;
//        } catch (Exception e) {
//            Log.e("saveToInternalStorage()", e.getMessage());
//            return false;
//        }
//    }
//
//    public static boolean saveImageToSDCard(Bitmap image, String folder, String name) {
//        String fullPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + folder + "/";
//
//        try {
//            File dir = new File(fullPath);
//            if (!dir.exists()) {
//                dir.mkdirs();
//            }
//
//            OutputStream fOut = null;
//            File file = new File(fullPath, name);
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//            fOut = new FileOutputStream(file);
//
//            // 100 means no compression, the lower you go, the stronger the compression
//            image.compress(Bitmap.CompressFormat.PNG, 100, fOut);
//            fOut.flush();
//            fOut.close();
//
//            //MediaStore.Images.Media.insertImage(this.getContentResolver(), file.getAbsolutePath(), file.getName(), file.getName());
//            return true;
//
//        } catch (Exception e) {
//            Log.e("saveToExternalStorage()", e.getMessage());
//            return false;
//        }
//    }
    public static int checkRotation(Uri uri) throws IOException {
        ExifInterface ei = new ExifInterface(uri.getPath());
        int orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
        switch (orientation) {
            case ExifInterface.ORIENTATION_ROTATE_90:
                return 90;
            case ExifInterface.ORIENTATION_ROTATE_180:
                return 180;
            case ExifInterface.ORIENTATION_ROTATE_270:
                return 270;
            default:
                return 0;
        }
    }

    public static Bitmap scaleDown(Bitmap realImage, boolean filter) {
        float ratio = Math.min(
                (float) MAX_IMAGE_DIMENSION / realImage.getWidth(),
                (float) MAX_IMAGE_DIMENSION / realImage.getHeight());
        int width = Math.round((float) ratio * realImage.getWidth());
        int height = Math.round((float) ratio * realImage.getHeight());

        Bitmap newBitmap = Bitmap.createScaledBitmap(realImage, width,
                height, filter);
        return newBitmap;
    }

    public static Bitmap rotateImage(Bitmap source, float angle) {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix,
                true);
    }

    public static Bitmap scaleImage(Context context, Uri photoUri) throws IOException, FileNotFoundException {
        InputStream is = context.getContentResolver().openInputStream(photoUri);
        BitmapFactory.Options dbo = new BitmapFactory.Options();
        dbo.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(is, null, dbo);
        is.close();

        int rotatedWidth, rotatedHeight;
        int orientation = getOrientation(context, photoUri);

        if (orientation == 90 || orientation == 270) {
            rotatedWidth = dbo.outHeight;
            rotatedHeight = dbo.outWidth;
        } else {
            rotatedWidth = dbo.outWidth;
            rotatedHeight = dbo.outHeight;
        }

        Bitmap srcBitmap;
        is = context.getContentResolver().openInputStream(photoUri);
        if (rotatedWidth > MAX_IMAGE_DIMENSION || rotatedHeight > MAX_IMAGE_DIMENSION) {
            float widthRatio = ((float) rotatedWidth) / ((float) MAX_IMAGE_DIMENSION);
            float heightRatio = ((float) rotatedHeight) / ((float) MAX_IMAGE_DIMENSION);
            float maxRatio = Math.max(widthRatio, heightRatio);

            // Create the bitmap from file
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = (int) maxRatio;
            srcBitmap = BitmapFactory.decodeStream(is, null, options);
        } else {
            srcBitmap = BitmapFactory.decodeStream(is);
        }
        is.close();

        /*
         * if the orientation is not 0 (or -1, which means we don't know), we
         * have to do a rotation.
         */
        if (orientation > 0) {
            Matrix matrix = new Matrix();
            matrix.postRotate(orientation);

            srcBitmap = Bitmap.createBitmap(srcBitmap, 0, 0, srcBitmap.getWidth(),
                    srcBitmap.getHeight(), matrix, true);
        }

        String type = context.getContentResolver().getType(photoUri);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        if (type.equals("image/png")) {
            srcBitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        } else if (type.equals("image/jpg") || type.equals("image/jpeg")) {
            srcBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        }
        byte[] bMapArray = baos.toByteArray();
        baos.close();
        return BitmapFactory.decodeByteArray(bMapArray, 0, bMapArray.length);
    }

    public static int getOrientation(Context context, Uri photoUri) {
        /* it's on the external media. */
        Cursor cursor = context.getContentResolver().query(photoUri,
                new String[] { MediaStore.Images.ImageColumns.ORIENTATION }, null, null, null);

        if (cursor.getCount() != 1) {
            return -1;
        }

        cursor.moveToFirst();
        return cursor.getInt(0);
    }
// Set and get username
    public static void setUsername(Context context, String username) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                QTSConstrains.SHAREPRE_ID, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Username", username);
        editor.commit();
    }
    public static String getUsername(Context context) {
        int mode = Activity.MODE_PRIVATE;
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                QTSConstrains.SHAREPRE_ID, mode);
        return sharedPreferences.getString("Username", "Not found");
    }
    //Set and get password
    public static void setPassword(Context context, String password) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                QTSConstrains.SHAREPRE_ID, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Password", password);
        editor.commit();
    }
    public static String getPassword(Context context) {
        int mode = Activity.MODE_PRIVATE;
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                QTSConstrains.SHAREPRE_ID, mode);
        return sharedPreferences.getString("Password", "Not found");
    }
    // Check INTERNET connection
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    //set and get color
    public static void setColor(Context context, int color) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                QTSConstrains.SHAREPRE_ID, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("Color", color);
        editor.commit();
    }
    public static int getColor(Context context) {
        int mode = Activity.MODE_PRIVATE;
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                QTSConstrains.SHAREPRE_ID, mode);
        return sharedPreferences.getInt("Color", R.color.edtRegister);
    }
//    public static int Getnum(Context context) {
//        int mode = Activity.MODE_PRIVATE;
//        SharedPreferences sharedPreferences = context.getSharedPreferences(
//                LakConst.PREFERENCES, mode);
//        return sharedPreferences.getInt("numrate", 0);
//    }
//
//    public static void Setnum(Context context, int num) {
//        SharedPreferences sharedPreferences = context.getSharedPreferences(
//                LakConst.PREFERENCES, 0);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putInt("numrate", num);
//        editor.commit();
//    }
}
