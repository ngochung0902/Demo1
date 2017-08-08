package com.company.qts.APIPOST;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.company.qts.demo1.R;
import com.company.qts.helper.QTSHelp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private final String TAG = "LoginActivity";

    public static final String BASE_URL = "http://qtsvn.com/";

    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    private TextView failedLoginMessage;

    View focusView = null;
    private ApiPost mAPIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);

        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);

        failedLoginMessage = (TextView)findViewById(R.id.failed_login);

        mPasswordView = (EditText) findViewById(R.id.password);

        mAPIService = ApiUtils.getApiPost();

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendPost(mEmailView.getText().toString(), QTSHelp.convertPassMd5(mPasswordView.getText().toString()),"f92e4c43791449f2a90646bd5d09bd60" );
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);

//        edt_appid.setText("f92e4c43791449f2a90646bd5d09bd60");
        mEmailView.setText("colin.qts@gmail.com");
//        mPasswordView.setText("e10adc3949ba59abbe56e057f20f883e");
    }


    private void sendPost(final String email, String password, String appid) {
        mAPIService.savePost(email,password,appid).enqueue(new Callback<PostAPI>() {
            @Override
            public void onResponse(Call<PostAPI> call, Response<PostAPI> response) {
                if (response.body().getSuccess()==1){
                    Intent intent = new Intent(LoginActivity.this,MainAct.class);
                    intent.putExtra("id",response.body().getUser().getId().toString());
                    intent.putExtra("fistname",response.body().getUser().getFirstname().toString());
                    intent.putExtra("lastname",response.body().getUser().getLastname().toString());
                    intent.putExtra("email",response.body().getUser().getEmail().toString());
                    intent.putExtra("created",response.body().getUser().getCreated().toString());
                    startActivity(intent);
                    QTSHelp.ShowpopupMessage(LoginActivity.this,""+response.body().toString());
                }
                if (response.body().getSuccess()==0){
                    QTSHelp.ShowpopupMessage(LoginActivity.this,""+response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<PostAPI> call, Throwable t) {
                QTSHelp.ShowpopupMessage(LoginActivity.this,"error");
            }
        });
    }

}
