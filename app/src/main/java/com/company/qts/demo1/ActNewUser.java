package com.company.qts.demo1;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.company.qts.helper.QTSHelp;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ActNewUser extends AppCompatActivity {

    Button bt_next;
    EditText edt_fistname,edt_lastname,edt_email,edt_rs_username,edt_phonenumber,edt_rs_password;
    TextView tv_birthday,tv_gender;
    ImageView bt_arrow;

    private DatePickerDialog fromDatePickerDialog;
    private SimpleDateFormat dateFormatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_new_user);

        initUI();

        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edt_fistname.getText().toString().equals(""))
                {
                    QTSHelp.ShowpopupMessage(ActNewUser.this,"Fistname is invalid !!!");
                }
                else
                {
                    if (edt_lastname.getText().toString().equals(""))
                    {
                        QTSHelp.ShowpopupMessage(ActNewUser.this,"Lastname is invalid !!!");
                    }
                    else
                    {
                        if (edt_email.getText().toString().equals(""))//||QTSHelp.checkEmailCorrect(edt_email.getText().toString())==false)
                        {
                            QTSHelp.ShowpopupMessage(ActNewUser.this,"Email is invalid !!!");
                        }
                        else
                        {
                            if (edt_phonenumber.getText().toString().equals(""))
                            {
                                QTSHelp.ShowpopupMessage(ActNewUser.this,"Phonenumber is invalid !!!");
                            }
                            else
                            {
                                if (tv_birthday.getText().toString().trim().length()==0){
                                    QTSHelp.ShowpopupMessage(ActNewUser.this,"Birthday is invalid !!!");
                                }
                                else
                                {
                                    if (edt_rs_username.getText().toString().trim().length()==0){
                                        QTSHelp.ShowpopupMessage(ActNewUser.this,"Username is invalid !!!");
                                    }
                                    else {
                                        if (tv_gender.getText().toString().trim().length()==0){
                                            QTSHelp.ShowpopupMessage(ActNewUser.this,"Gender is invalid !!!");
                                        }
                                        else {
                                            if (edt_email.getText().toString().trim().length()>0) {
                                                String rs_us = edt_rs_username.getText().toString();
                                                QTSHelp.setUsername(ActNewUser.this,rs_us);
                                                String rs_ps = edt_rs_password.getText().toString();
                                                QTSHelp.setPassword(ActNewUser.this,rs_ps);
                                                Intent intent = new Intent(ActNewUser.this, ActNewUser1.class);
                                                startActivity(intent);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                }
            }
        });

        bt_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tv_birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fromDatePickerDialog.show();
            }
        });

        setDateTimeField();

        tv_gender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectGender();
            }
        });
    }

    public void initUI(){
        bt_next = (Button) findViewById(R.id.bt_next);
        edt_fistname = (EditText) findViewById(R.id.edt_fistname);
        edt_lastname = (EditText) findViewById(R.id.edt_lastname);
        edt_email = (EditText) findViewById(R.id.edt_email);
        edt_rs_username = (EditText) findViewById(R.id.edt_rs_username);
        edt_rs_password = (EditText) findViewById(R.id.edt_rs_password);
        edt_phonenumber = (EditText) findViewById(R.id.edt_phonenumber);
        tv_gender = (TextView) findViewById(R.id.tv_gender);
        tv_birthday = (TextView) findViewById(R.id.tv_birthday);
        bt_arrow = (ImageView)findViewById(R.id.bt_arrow);
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy",Locale.US);
    }

    private void setDateTimeField() {
        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(ActNewUser.this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                tv_birthday.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    private void selectGender() {
        final CharSequence[] itemGender =  {"Male", "Female"};
        AlertDialog.Builder builder = new AlertDialog.Builder(ActNewUser.this);
        builder.setTitle("SELECT GENDER");
        builder.setItems(itemGender, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                tv_gender.setText(itemGender[item]);
            }
        });
        builder.show();
    }
}
