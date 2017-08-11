package com.company.qts.demo1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.company.qts.helper.QTSHelp;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class ActPicasso extends AppCompatActivity {
    private ImageView img_picasso;
    private int i, c=0;
    private Button bt_drawable,bt_placeholder,bt_url,bt_error,bt_callback,bt_resize,bt_rotate,bt_scale,bt_targets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_picasso);
        initUI();

        bt_drawable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Picasso.with(ActPicasso.this).load(R.drawable.flowerpicasso).into(img_picasso);
                c=0;
            }

        });

        bt_placeholder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Picasso.with(ActPicasso.this).load("www.journaldev.com").placeholder(R.drawable.img_f).into(img_picasso);
                c=1;
            }
        });

        bt_url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (QTSHelp.checkInternet(ActPicasso.this)){
                Glide.with(ActPicasso.this).load("https://media.giphy.com/media/l41lFw057lAJQMwg0/giphy.gif").into(img_picasso);
            }else {
                    QTSHelp.showToast(ActPicasso.this,"No internet connection");
                }
            }
        });
        bt_error.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Picasso.with(ActPicasso.this).load("www.journaldev.com").placeholder(R.drawable.img_o).error(R.drawable.error).into(img_picasso);
                c=3;
            }
        });

        bt_callback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Picasso.with(ActPicasso.this).load("www.journaldev.com").error(R.mipmap.ic_launcher).into(img_picasso, new Callback() {
                    @Override
                    public void onSuccess() {
                        Log.d("TAG", "onSuccess");
                        c=4;
                    }

                    @Override
                    public void onError() {
                        Toast.makeText(getApplicationContext(), "An error occurred", Toast.LENGTH_SHORT).show();
                        c=4;
                    }
                });
            }
        });

        bt_resize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Picasso.with(ActPicasso.this).load(R.drawable.flowerpicasso).resize(200, 200).into(img_picasso);
                c=5;
            }
        });

        bt_rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Picasso.with(ActPicasso.this).load(R.drawable.flowerpica).rotate(90f).into(img_picasso);
                c=6;
            }
        });

        bt_scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c=7;
                if (i == 3)
                    i = 0;

                else {
                    if (i == 0) {
                        Picasso.with(ActPicasso.this).load(R.drawable.flowerpicasso).fit().into(img_picasso);
                        Toast.makeText(getApplicationContext(), "Fit", Toast.LENGTH_SHORT).show();
                    } else if (i == 1) {
                        Picasso.with(ActPicasso.this).load(R.drawable.flowerpicasso).resize(200, 200).centerCrop().into(img_picasso);
                        Toast.makeText(getApplicationContext(), "Center Crop", Toast.LENGTH_SHORT).show();
                    } else if (i == 2) {
                        Picasso.with(ActPicasso.this).load(R.drawable.flowerpicasso).resize(200, 200).centerInside().into(img_picasso);
                        Toast.makeText(getApplicationContext(), "Center Inside", Toast.LENGTH_SHORT).show();
                    }
                    i++;
                }
            }
        });

        bt_targets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c=8;
                Picasso.with(ActPicasso.this).load("http://cdn.journaldev.com/wp-content/uploads/2017/01/android-constraint-layout-sdk-tool-install.png").placeholder(R.drawable.flowerpica).error(R.drawable.error).into(target);
            }
        });

        img_picasso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                img_picasso.buildDrawingCache();
//                Bitmap b=img_picasso.getDrawingCache();
                Intent i = new Intent(ActPicasso.this,ActZoomImage.class);
                i.putExtra("image", c);
                startActivity(i);
            }
        });
    }

    private void initUI() {
        img_picasso = (ImageView) findViewById(R.id.img_picasso);
        bt_drawable = (Button) findViewById(R.id.bt_drawable);
        bt_placeholder = (Button) findViewById(R.id.bt_placeholder);
        bt_url = (Button) findViewById(R.id.bt_url);
        bt_error = (Button) findViewById(R.id.bt_error);
        bt_callback = (Button) findViewById(R.id.bt_callback);
        bt_resize = (Button) findViewById(R.id.bt_resize);
        bt_rotate = (Button) findViewById(R.id.bt_rotate);
        bt_scale = (Button) findViewById(R.id.bt_scale);
        bt_targets = (Button) findViewById(R.id.bt_targets);
    }

    private Target target = new Target() {
        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {

            img_picasso.setImageBitmap(bitmap);
        }

        @Override
        public void onBitmapFailed(Drawable errorDrawable) {
            img_picasso.setImageDrawable(errorDrawable);
        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {
            img_picasso.setImageDrawable(placeHolderDrawable);
        }
    };
}
