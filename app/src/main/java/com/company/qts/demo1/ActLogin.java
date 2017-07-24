package com.company.qts.demo1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.company.qts.helper.QTSHelp;

/**
 * Created by MyPC on 24/07/2017.
 */
public class ActLogin extends AppCompatActivity {

    EditText edt_username,edt_password;
    ImageView logotop;
    Button bt_submit;
    TextView tv_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initUI();
        QTSHelp.setLayoutView(logotop,QTSHelp.GetWidthDevice(this)/2,QTSHelp.GetHeightDevice(this)/405*103/4);

        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt_username.getText().toString().equals(""))
                {
                    QTSHelp.ShowpopupMessage(ActLogin.this,"Username or password is invalid !!!");
                }
                else {
                    if ( edt_password.getText().toString().equals(""))
                    {
                        QTSHelp.ShowpopupMessage(ActLogin.this,"Username or password is invalid !!!");
                    }
                    else
                    {
                        QTSHelp.ShowpopupMessage(ActLogin.this,"Success!!!");
                    }

                }
            }
        });
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActLogin.this,ActNewUser.class);
                startActivity(intent);
            }
        });
    }
    public void initUI(){
        logotop = (ImageView) findViewById(R.id.img_logotop);
        edt_password = (EditText) findViewById(R.id.edt_password);
        edt_username = (EditText) findViewById(R.id.edt_username);
        bt_submit = (Button) findViewById(R.id.bt_submit);
        tv_register = (TextView)findViewById(R.id.tv_register);
    }
}
