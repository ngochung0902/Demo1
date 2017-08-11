package com.company.qts.demo1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.company.qts.Object.ObjectPerson;
import com.company.qts.helper.QTSHelp;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class ActShowArray extends AppCompatActivity {
    private ImageView img_arrow;
    private TextView tv_showarray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_show_array);
        initUI();

        img_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        String carListAsString = getIntent().getStringExtra("array");
        Gson gson = new Gson();
        java.lang.reflect.Type type = new TypeToken<List<ObjectPerson>>(){}.getType();
        List<ObjectPerson> List = gson.fromJson(carListAsString, type);
        for (ObjectPerson object : List){
            QTSHelp.ShowpopupMessage(ActShowArray.this,"Id: "+object.id+"\n"
                                +"name: "+object.name+"\n"
                                +"email: "+object.email+"\n"
                                +"phone: "+object.phone+"\n\n\n");
        }

    }

    private void initUI() {
        img_arrow = (ImageView) findViewById(R.id.img_arrow);
        tv_showarray = (TextView) findViewById(R.id.tv_showarray);
    }
}
