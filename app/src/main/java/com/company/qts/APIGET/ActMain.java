package com.company.qts.APIGET;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.company.qts.demo1.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by MyPC on 04/08/2017.
 */
public class ActMain extends AppCompatActivity{
    private Button mJsonArray, mJsonObject;
    private ListView mLvPost;
    private PostAdapter postAdapter;
    ProgressDialog myProgress;

    private APIService mAPIService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apitest);
        initView();

        mJsonArray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CountDownTimer countDownTimer = new CountDownTimer(5000,5000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        myProgress = new ProgressDialog(ActMain.this);
                        myProgress.setTitle("Login ");
                        myProgress.setMessage("Loading...");
                        myProgress.setIndeterminate(true);
                        showProgressDialog();
                    }

                    @Override
                    public void onFinish() {
                        showProgressDialog();
                        getJsonRetrofitArray();
                    }
                };
                countDownTimer.start();
            }
        });

        mJsonObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CountDownTimer countDownTimer = new CountDownTimer(3000,3000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        myProgress = new ProgressDialog(ActMain.this);
                        myProgress.setTitle("Login ");
                        myProgress.setMessage("Loading...");
                        myProgress.setCancelable(true);
                        myProgress.show();
                    }

                    @Override
                    public void onFinish() {
                        getJsonRetrofitObject();
                        hideProgressDialog();
                    }
                };
                countDownTimer.start();
            }
        });
    }

    private void initView() {
        mJsonArray = (Button) findViewById(R.id.jsonArray);
        mJsonObject = (Button) findViewById(R.id.jsonObject);
        mLvPost = (ListView) findViewById(R.id.lvPost);
        mAPIService = ApiUtils.getAPIService();

    }
    private void getJsonRetrofitArray() {
        mAPIService.getPostsDetails().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                try {
                    final List<Post> postList = response.body();
                    postAdapter = new PostAdapter(ActMain.this, postList);
                    mLvPost.setAdapter(postAdapter);

                    mLvPost.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Intent intent = new Intent(ActMain.this, PostDetailActivity.class);
                            intent.putExtra("title", postList.get(i).getTitle());
                            intent.putExtra("content", postList.get(i).getContent());
                            intent.putExtra("nameCa", postList.get(i).getName_ca());
                            intent.putExtra("des", postList.get(i).getDescription());
                            startActivity(intent);
                        }
                    });
                } catch (Exception e) {
                    Log.d("onResponse", "Error");
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.d("onFailure", t.toString());
            }
        });
    }
    private void getJsonRetrofitObject() {
        mAPIService.getPostDetails().enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                try {
                    final List<Post> postList = new ArrayList<Post>();
                    postList.add(response.body());
                    postAdapter = new PostAdapter(ActMain.this, postList);
                    mLvPost.setAdapter(postAdapter);

                    mLvPost.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Intent intent = new Intent(ActMain.this, PostDetailActivity.class);
                            intent.putExtra("title", postList.get(i).getTitle());
                            intent.putExtra("content", postList.get(i).getContent());
                            intent.putExtra("nameCa", postList.get(i).getName_ca());
                            intent.putExtra("des", postList.get(i).getDescription());
                            startActivity(intent);
                        }
                    });
                } catch (Exception e) {
                    Log.d("onResponse", "Error");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.d("onFailure", t.toString());
            }
        });
    }


    private void hideProgressDialog() {
        if (myProgress != null && myProgress.isShowing()) {
            myProgress.hide();
        }
    }

    private void showProgressDialog() {
        if (myProgress == null) {
            myProgress = new ProgressDialog(this);
            myProgress.setMessage("Loading...");
            myProgress.setIndeterminate(true);
            myProgress.show();
        }else {
            myProgress.show();
        }
    }
}
