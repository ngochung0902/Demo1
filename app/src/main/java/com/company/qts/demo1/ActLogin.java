package com.company.qts.demo1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
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
    ProgressDialog myProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initUI();

        QTSHelp.setLayoutView(logotop,QTSHelp.GetWidthDevice(this)/2,QTSHelp.GetHeightDevice(this)/405*103/4);

        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActLogin.this,ActNewUser.class);
                startActivity(intent);
            }
        });

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
                        CountDownTimer countDownTimer = new CountDownTimer(5000,5000) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                                myProgress = new ProgressDialog(ActLogin.this);
                                myProgress.setTitle("Login ");
                                myProgress.setMessage("Loading...");
                                myProgress.setCancelable(true);
                                QTSHelp.hideKeyboard(ActLogin.this);
                                myProgress.show();
                            }

                            @Override
                            public void onFinish() {
                                hideProgressDialog();
                                String us = edt_username.getText().toString();
                                QTSHelp.setUsername(ActLogin.this,us);
                                String password = edt_password.getText().toString();
                                QTSHelp.setPassword(ActLogin.this,password);
                                Intent intent = new Intent(ActLogin.this,ActHome.class);
                                startActivity(intent);
                                QTSHelp.setIsLogin(ActLogin.this,true);
                                finish();
                            }
                        };
                        countDownTimer.start();
                    }
                }
            }
        });
        edt_password.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = true;
                if (actionId == EditorInfo.IME_ACTION_DONE) {

                    QTSHelp.hideKeyboard(ActLogin.this);

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
                            CountDownTimer countDownTimer = new CountDownTimer(5000,5000) {
                                @Override
                                public void onTick(long millisUntilFinished) {
                                    myProgress = new ProgressDialog(ActLogin.this);
                                    myProgress.setTitle("Demo1");
                                    myProgress.setMessage("Loading...");
                                    myProgress.setCancelable(true);
                                    myProgress.show();
                                }
                                @Override
                                public void onFinish() {
                                    hideProgressDialog();
                                    String us = edt_username.getText().toString();
                                    QTSHelp.setUsername(ActLogin.this,us);
                                    String password = edt_password.getText().toString();
                                    QTSHelp.setPassword(ActLogin.this,password);
                                    Intent intent = new Intent(ActLogin.this,ActHome.class);
                                    startActivity(intent);
                                    QTSHelp.setIsLogin(ActLogin.this,true);
                                    finish();
                                }
                            };
                            countDownTimer.start();

                        }
                    }
                    handled = true;
                }
                return handled;
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

    private void hideProgressDialog() {
        if (myProgress != null && myProgress.isShowing()) {
            myProgress.hide();
        }
    }
}
