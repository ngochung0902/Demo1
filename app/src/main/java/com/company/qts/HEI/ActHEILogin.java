package com.company.qts.HEI;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.company.qts.demo1.R;
import com.company.qts.helper.QTSHelp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActHEILogin extends AppCompatActivity {
    private EditText edt_email,edt_password;
    private Button bt_signin;
    private APIService mAPIService;
    private ProgressDialog mProgressDialog;
    private String email = "";
    private String password = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heilogin);
        initUI();
        edt_email.setText("colin.qts@gmail.com");
        edt_password.setText("123456");
        mAPIService = APIUtils.getAPIService();

        bt_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = edt_email.getText().toString().trim();
                password = edt_password.getText().toString().trim();
                QTSHelp.setUsername(ActHEILogin.this,email);
                QTSHelp.setPassword(ActHEILogin.this,password);
                new GetData().execute();
//                sendPost(edt_email.getText().toString(),QTSHelp.convertPassMd5(edt_password.getText().toString()),"f92e4c43791449f2a90646bd5d09bd60");
            }
        });

    }

    private void sendPost(String email, String password, String appid) {
        mAPIService.savePost(email, password, appid).enqueue(new Callback<PostHEI>() {
            @Override
            public void onResponse(Call<PostHEI> call, Response<PostHEI> response) {
                if (response.body().getSuccess()==1){

                }
                if (response.body().getSuccess()==0){
                    QTSHelp.ShowpopupMessage(ActHEILogin.this,response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<PostHEI> call, Throwable t) {

            }
        });
    }

    private void initUI() {
        edt_email = (EditText) findViewById(R.id.edt_email);
        edt_password = (EditText) findViewById(R.id.edt_password);
        bt_signin = (Button) findViewById(R.id.bt_signin);
    }
    class GetData extends AsyncTask<String, Void, String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(ActHEILogin.this);
            mProgressDialog.setMessage("Logging you in...");
            mProgressDialog.show();
            mProgressDialog.setCancelable(false);
        }

        @Override
        protected String doInBackground(String... params) {
            final String status = "";
            mAPIService.savePost(email,QTSHelp.convertPassMd5(password),"f92e4c43791449f2a90646bd5d09bd60").enqueue(new Callback<PostHEI>() {
                @Override
                public void onResponse(Call<PostHEI> call, Response<PostHEI> response) {
                    if (response.body().getSuccess()==1){
                        Intent intent = new Intent(ActHEILogin.this,ActHEISpirits.class);
                        startActivity(intent);
                        mProgressDialog.cancel();
                        finish();
                    }
                    if (response.body().getSuccess()==0){
                        QTSHelp.ShowpopupMessage(ActHEILogin.this,response.body().getMessage());
                    }
                }

                @Override
                public void onFailure(Call<PostHEI> call, Throwable t) {

                }
            });
            return status;
        }
    }
}

