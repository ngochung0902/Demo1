package com.company.qts.demo1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.company.qts.Object.ObjectPerson;
import com.google.gson.Gson;

import java.util.ArrayList;

public class ActSerializable extends AppCompatActivity {
    private Button bt_object,bt_array;
    private ArrayList<ObjectPerson> arr = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_serializable);
        initUI();
        final ObjectPerson object = new ObjectPerson("10","Ngoc Hung","hungnn0902@gmail.com","01265380215");

        Arr();

        bt_object.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActSerializable.this,ActShowObject.class);
                i.putExtra("serialize",object);
                startActivity(i);
            }
        });

        Gson gson = new Gson();
        final String jsonObjectPerson = gson.toJson(arr);
        bt_array.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActSerializable.this,ActShowArray.class);
                i.putExtra("array",jsonObjectPerson);
                startActivity(i);
            }
        });
    }

    private void initUI() {
        bt_object = (Button) findViewById(R.id.bt_object);
        bt_array = (Button) findViewById(R.id.bt_array);
    }

    private void Arr(){
        arr.add(new ObjectPerson("10","Hung","hungnn0902@gmail.com","01265"));
        arr.add(new ObjectPerson("11","Nguyen","abc@gmail.com","01234"));
        arr.add(new ObjectPerson("12","Ngoc","nguyen@gmail.com","01256"));
    }
}
