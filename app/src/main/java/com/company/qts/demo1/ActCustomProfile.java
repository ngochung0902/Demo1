package com.company.qts.demo1;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.company.qts.helper.QTSHelp;

public class ActCustomProfile extends AppCompatActivity {

    private ImageView img_arrow;
    private TextView tv_phonenumber,tv;
    private SeekBar sb_age;
    private Switch sw_married;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__custom_profile);
        initUI();
        img_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tv_phonenumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogListView();
            }
        });

        sb_age.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress1 = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress1 = progress;
                tv.setText(progress1+"/"+seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                tv.setText(progress1+"/"+seekBar.getMax());
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tv.setText(progress1+"/"+seekBar.getMax());
                Toast.makeText(getApplicationContext(), "Stopped tracking seekbar", Toast.LENGTH_SHORT).show();
            }
        });

        sw_married.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    QTSHelp.showToast(ActCustomProfile.this,"swith YES checked");
                }
                else {
                    QTSHelp.showToast(ActCustomProfile.this,"swith NO checked");
                }
            }
        });
    }

    private void initUI() {
        tv = (TextView) findViewById(R.id.tv);
        img_arrow = (ImageView) findViewById(R.id.img_arrow);
        tv_phonenumber = (TextView) findViewById(R.id.tv_numberphone);
        sb_age = (SeekBar) findViewById(R.id.sb_age);
        sw_married = (Switch) findViewById(R.id.sw_married);
    }

    public void showDialogListView(){
            final CharSequence[] itemGender = {"Call", "SMS","Cancel"};
            AlertDialog.Builder builder = new AlertDialog.Builder(ActCustomProfile.this);
            builder.setTitle("SELECT ");
            builder.setItems(itemGender, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int item) {
//                    tv_gender.setText(itemGender[item]);
                    if (itemGender[item]=="Call")
                    {
                        String phoneNumber = String.format("tel: %s", tv_phonenumber.getText().toString());
                        Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                        dialIntent.setData(Uri.parse(phoneNumber));
                        if (dialIntent.resolveActivity(getPackageManager()) != null) {
                            startActivity(dialIntent);
                        }
                        else {}
                    }
                    if (itemGender[item]=="SMS"){
                        // Find the TextView number_to_call and assign it to textView.
                        // Concatenate "smsto:" with phone number to create smsNumber.
                        String smsNumber = "smsto:" + tv_phonenumber.getText().toString();
                        // Find the sms_message view.
                        // Get the text of the sms message.
                        String sms = tv_phonenumber.getText().toString();
                        // Create the intent.
                        Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
                        // Set the data for the intent as the phone number.
                        smsIntent.setData(Uri.parse(smsNumber));
                        // Add the message (sms) with the key ("sms_body").
                        smsIntent.putExtra("sms", sms);
                        // If package resolves (target app installed), send intent.
                        if (smsIntent.resolveActivity(getPackageManager()) != null) {
                            startActivity(smsIntent);
                        } else {
                        }
                    }
                    if (itemGender[item]=="Cancel")
                    {
                        dialog.dismiss();
                    }
                }
            });
            builder.show();
    }
}
