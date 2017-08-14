package com.company.qts.demo1;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.company.qts.database.SQLite;
import com.company.qts.database.SQLiteSource;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ActViewContacts extends AppCompatActivity {

    private ImageView img_arrow,img_delete;
    private EditText edt_name,edt_phone;
    private TextView tv_birthday;
    private SQLiteSource datasource;
    private int ID;
    private DatePickerDialog fromDatePickerDialog;
    private SimpleDateFormat dateFormatter;
    private Button bt_save;
    private SQLite db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_view_contacts);
        initUI();
        setDateTimeField();
        img_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        // get id of note
        ID = getIntent().getExtras().getInt("id");
        final String fistname = getIntent().getExtras().getString("fistname");
        String lastname = getIntent().getExtras().getString("lastname");
        String birthday = getIntent().getExtras().getString("birthday");
        String number = getIntent().getExtras().getString("number");

        edt_name.setText(fistname + " " + lastname);
        edt_phone.setText(number);
        tv_birthday.setText(birthday);

        img_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ActViewContacts.this);
                builder.setIcon(R.drawable.img_error);
                builder.setTitle("Demo1");
                builder.setMessage("Are you sure you want to delete?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        datasource.deleteNote(ID);
                        finish();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });
        tv_birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fromDatePickerDialog.show();
            }
        });

        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ActViewContacts.this);
                builder.setIcon(R.drawable.img_error);
                builder.setTitle("Demo1");
                builder.setMessage("Are you sure you want to update?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        finish();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });
        datasource = new SQLiteSource(this);
        datasource.open();
    }


    private void initUI() {
        img_delete = (ImageView) findViewById(R.id.img_delete);
        img_arrow = (ImageView) findViewById(R.id.img_arrow);
        edt_name = (EditText) findViewById(R.id.tv_name);
        edt_phone = (EditText) findViewById(R.id.tv_phone);
        tv_birthday = (TextView) findViewById(R.id.tv_birthday);
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        bt_save = (Button) findViewById(R.id.bt_save);
    }

    private void setDateTimeField() {
        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(ActViewContacts.this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                tv_birthday.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }
}
