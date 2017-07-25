package com.company.qts.demo1;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.company.qts.Utili.Utility;
import com.company.qts.helper.QTSConstrains;
import com.company.qts.helper.QTSHelp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ActNewUser2 extends AppCompatActivity {

    ImageView img_avatar,bt_arrow2;
    Button bt_submit1;
    String userChoosenTask;
    ProgressBar pb_loadhome;
    private final int REQUEST_CAMERA = 0, CAPTURE_PICTURE = 1, SELECT_FILE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_new_user2);
        initUI();

        img_avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();
            }
        });

        QTSHelp.setLayoutView(img_avatar,QTSHelp.GetWidthDevice(this)/2,QTSHelp.GetWidthDevice(this)/2);

        img_avatar.setImageBitmap(QTSConstrains.bmAvatar);

        bt_arrow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        bt_submit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(QTSConstrains.bmAvatar == null)
                {
                    QTSHelp.ShowpopupMessage(ActNewUser2.this,"Image is invalid !!!");
                }
                else
                {
                    CountDownTimer countDownTimer = new CountDownTimer(10000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            int dem = pb_loadhome.getProgress();
                            if ( dem >= pb_loadhome.getMax()){
                                dem = 0;
                            }
                            pb_loadhome.setProgress(dem + 20);
                        }
                        @Override
                        public void onFinish() {
                            this.start();
                            loadHome();
                        }
                    };
                    countDownTimer.start();
                }
            }

            });
        }

    public void loadHome(){
        Intent intent = new Intent(ActNewUser2.this,ActHome.class);
        startActivity(intent);
        finish();
    }

    public void initUI(){
        img_avatar = (ImageView) findViewById(R.id.img_avatar);
        bt_arrow2 = (ImageView) findViewById(R.id.bt_arrow2);
        bt_submit1 = (Button) findViewById(R.id.bt_submit1);
        pb_loadhome = (ProgressBar) findViewById(R.id.pb_loadhome);
    }

    private void selectImage() {
        final CharSequence[] items = {"Capture photo", "Choose photo from Gallery"};

        AlertDialog.Builder builder = new AlertDialog.Builder(ActNewUser2.this);
//        builder.setTitle("Select a picture");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                boolean result = Utility.checkPermission(ActNewUser2.this);

                if (items[item].equals("Capture photo")) {
                    userChoosenTask = "Capture photo";
                    if (result)
                        cameraIntent();

                } else if (items[item].equals("Choose photo from Gallery")) {
                    userChoosenTask = "Choose photo from Gallery";
                    if (result)
                        galleryIntent();
                }
            }
        });
        builder.show();
    }

    private void galleryIntent() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);//
        startActivityForResult(Intent.createChooser(intent, "Select File"), SELECT_FILE);
    }

    public void cameraIntent() {
        Log.e("MainActivity", "Showing camera");
        try {
            if (Build.VERSION.SDK_INT < 30) {
                Uri imageUri = Uri.fromFile(getTempFile(ActNewUser2.this));
                Intent intent = createIntentForCamera(imageUri);
                startActivityForResult(intent, CAPTURE_PICTURE);
            } else {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                this.startActivityForResult(intent, REQUEST_CAMERA);
            }
        } catch (Exception e) {
            Toast.makeText(ActNewUser2.this, "Please grant camera permission for the app in Settings", Toast.LENGTH_LONG).show();
            Log.e("MainActivity", "" + e.toString());
            ActivityCompat.requestPermissions(ActNewUser2.this, new String[]{android.Manifest.permission.CAMERA}, 2);
        }
    }

    private File getTempFile(Context context) {
        String fileName = "temp_hva_photo.jpg";
        File path = new File(Environment.getExternalStorageDirectory(), context.getPackageName());
        if (!path.exists()) {
            path.mkdir();
        }
        return new File(path, fileName);
    }

    private Intent createIntentForCamera(Uri imageUri) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
        return intent;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_FILE) {
                Uri uri = data.getData();
                setPhoto(3, uri);
                Log.e("MainActivity", "SELECT_FILE:" + data.getData().toString());
            } else if (requestCode == REQUEST_CAMERA) {
                Uri uri = data.getData();
                setPhoto(1, uri);
                Log.e("MainActivity", "REQUEST_CAMERA:" + data.getData().toString());
            } else if (requestCode == CAPTURE_PICTURE) {
                Uri uri = Uri.fromFile(getTempFile(ActNewUser2.this));
                setPhoto(2, uri);
                Log.e("MainActivity", "CAPTURE_PICTURE:" + uri.toString());
            }
        }
    }

    private void setPhoto(int is_scase, Uri imageUri) {
        if (QTSConstrains.bmAvatar != null) {
            QTSConstrains.bmAvatar.recycle();
            QTSConstrains.bmAvatar = null;
        }
        if (is_scase == 1) {
            try {
                QTSConstrains.bmAvatar = getThumbnail(imageUri);
                int rotation = QTSHelp.checkRotation(imageUri);
                if (rotation != 0) {
                    try {
                        QTSConstrains.bmAvatar = QTSHelp.scaleDown(QTSHelp.rotateImage(QTSConstrains.bmAvatar, rotation), true);
                    } catch (Exception e) {
                        QTSConstrains.bmAvatar = QTSHelp.scaleDown(QTSConstrains.bmAvatar, true);
                    }
                } else {
                    QTSConstrains.bmAvatar = QTSHelp.scaleDown(QTSConstrains.bmAvatar, true);
                }
                img_avatar.setImageBitmap(QTSConstrains.bmAvatar);
                img_avatar.setScaleType(ImageView.ScaleType.CENTER_CROP);
                QTSConstrains.pictureFile = getFiles(QTSConstrains.bmAvatar, "hungQTS");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        } else
            if (is_scase == 2) {
            try {
                QTSConstrains.bmAvatar = MediaStore.Images.Media.getBitmap(ActNewUser2.this.getContentResolver(), imageUri);
                int rotation = QTSHelp.checkRotation(imageUri);
                if (rotation != 0) {
                    try {
                        QTSConstrains.bmAvatar = QTSHelp.scaleDown(QTSHelp.rotateImage(QTSConstrains.bmAvatar, rotation), true);
                    } catch (Exception e) {
                        QTSConstrains.bmAvatar = QTSHelp.scaleDown(QTSConstrains.bmAvatar, true);
                    }
                } else {
                    QTSConstrains.bmAvatar = QTSHelp.scaleDown(QTSConstrains.bmAvatar, true);
                }
                img_avatar.setImageBitmap(QTSConstrains.bmAvatar);
                img_avatar.setScaleType(ImageView.ScaleType.CENTER_CROP);
                QTSConstrains.pictureFile = getFiles(QTSConstrains.bmAvatar, "hungQTS");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            else
            if (is_scase == 3) {
            try {
               QTSConstrains.bmAvatar = QTSHelp.scaleImage(ActNewUser2.this, imageUri);// MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), imageUri);
                int rotation = QTSHelp.checkRotation(imageUri);
                Log.e("PictureFragment", "rotation:" + rotation);
                if (rotation != 0) {
                    try {
                        QTSConstrains.bmAvatar = QTSHelp.rotateImage(QTSConstrains.bmAvatar, rotation);
                    } catch (Exception e) {
                        QTSConstrains.bmAvatar = QTSHelp.scaleDown(QTSConstrains.bmAvatar, true);
                    }
                } else {
                    QTSConstrains.bmAvatar = QTSHelp.scaleDown(QTSConstrains.bmAvatar, true);
                }
                img_avatar.setImageBitmap(QTSConstrains.bmAvatar);
                img_avatar.setScaleType(ImageView.ScaleType.CENTER_CROP);
                QTSConstrains.pictureFile = getFiles(QTSConstrains.bmAvatar, "hungQTS");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Nullable
    private Bitmap getThumbnail(Uri imageUri) throws IOException {
        InputStream input = getActivity().getContentResolver().openInputStream(imageUri);

        BitmapFactory.Options onlyBoundsOptions = new BitmapFactory.Options();
        onlyBoundsOptions.inJustDecodeBounds = true;
        onlyBoundsOptions.inDither = true;//optional
        onlyBoundsOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;//optional
        BitmapFactory.decodeStream(input, null, onlyBoundsOptions);
        input.close();
        if ((onlyBoundsOptions.outWidth == -1) || (onlyBoundsOptions.outHeight == -1))
            return null;

        int originalSize = (onlyBoundsOptions.outHeight > onlyBoundsOptions.outWidth) ? onlyBoundsOptions.outHeight : onlyBoundsOptions.outWidth;

        double ratio = (originalSize > 1280) ? (originalSize / 1280) : 1.0;

        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inSampleSize = getPowerOfTwoForSampleRatio(ratio);
        bitmapOptions.inDither = true;//optional
        bitmapOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;//optional
        input = getActivity().getContentResolver().openInputStream(imageUri);
        Bitmap bitmap = BitmapFactory.decodeStream(input, null, bitmapOptions);
        try {
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    private Context getActivity() {
        return ActNewUser2.this;
    }

    public static int getPowerOfTwoForSampleRatio(double ratio) {
        int k = Integer.highestOneBit((int) Math.floor(ratio));
        if (k == 0) return 1;
        else return k;
    }

    private File getFiles(Bitmap bitmap, String file_name) {
        File file = null;
        try {
            String path = Environment.getExternalStorageDirectory().toString();
            OutputStream fOut = null;
            file = new File(path, file_name + ".jpg");
            fOut = new FileOutputStream(file);

            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fOut); // saving the Bitmap to a file compressed as a JPEG with 85% compression rate
            fOut.flush(); // Not really required
            fOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

}
