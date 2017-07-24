package com.company.qts.demo1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.company.qts.helper.QTSHelp;

public class ActNewUser extends AppCompatActivity {

    Button bt_next;
    EditText edt_fistname,edt_lastname,edt_email,edt_username,edt_phonenumber;
    Spinner sp_gender,sp_birthday;
    String arr[] = {
            "Male",
            "Female",
            "Other"};

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
                        if (edt_email.getText().toString().equals(""))
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
                                Intent intent = new Intent(ActNewUser.this,ActNewUser1.class);
                                startActivity(intent);
                            }
                        }
                    }
                }

            }
        });

        Gender();
    }

    public void initUI(){
        bt_next = (Button) findViewById(R.id.bt_next);
        edt_fistname = (EditText) findViewById(R.id.edt_fistname);
        edt_lastname = (EditText) findViewById(R.id.edt_lastname);
        edt_email = (EditText) findViewById(R.id.edt_email);
        edt_username = (EditText) findViewById(R.id.edt_username);
        edt_phonenumber = (EditText) findViewById(R.id.edt_phonenumber);
        sp_gender = (Spinner)findViewById(R.id.sp_gender);
        sp_birthday = (Spinner)findViewById(R.id.sp_birthday);
    }
    public void Gender(){
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arr);
        sp_gender.setAdapter(adapter);
    }
}
