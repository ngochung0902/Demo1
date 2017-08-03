package com.company.qts.demo1;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.company.qts.Database.SQLiteSource;
import com.company.qts.helper.QTSHelp;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ActNewContacts extends AppCompatActivity {

    private ImageView img_arrow;
    private EditText edt_fistname,edt_lastname,edt_phone;
    private TextView tv_birthday;
    private Button bt_save;
    private SQLiteSource datasource;
    private DatePickerDialog fromDatePickerDialog;
    private SimpleDateFormat dateFormatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contacts);
        initUI();
        img_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        datasource = new SQLiteSource(this);
        datasource.open();

        setDateTimeField();

        tv_birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fromDatePickerDialog.show();
            }
        });

        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt_fistname.getText().toString().equals("")){
                    QTSHelp.ShowpopupMessage(ActNewContacts.this,"Fistname is invalid !!!");
                }else
                {
                    if (edt_lastname.getText().toString().equals(""))
                    {
                        QTSHelp.ShowpopupMessage(ActNewContacts.this,"Lastname is invalid !!!");
                    }else
                    {
                        if (edt_phone.getText().toString().equals("")) {
                            QTSHelp.ShowpopupMessage(ActNewContacts.this, "Phone is invalid !!!");
                        }
                        else
                        {
                            if (tv_birthday.getText().toString().trim().length()==0)
                            {
                                QTSHelp.ShowpopupMessage(ActNewContacts.this, "Birthday is invalid !!!");
                            }
                            else
                            {
                                // save note to SQLite
                                datasource.add(edt_fistname.getText().toString(), edt_lastname.getText().toString(), edt_phone.getText().toString(), tv_birthday.getText().toString());
                                QTSHelp.showToast(ActNewContacts.this,"Add new contacts successfully");
                                finish();
                            }
                        }
                    }
                }
            }
        });
    }

    private void initUI() {
        img_arrow = (ImageView) findViewById(R.id.img_arrow);
        edt_fistname = (EditText) findViewById(R.id.edt_fistname);
        edt_lastname = (EditText) findViewById(R.id.edt_lastname);
        edt_phone = (EditText) findViewById(R.id.edt_phonenumber);
        tv_birthday = (TextView) findViewById(R.id.tv_birthday);
        bt_save = (Button) findViewById(R.id.bt_save);
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        datasource.close();
    }

    private void setDateTimeField() {
        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(ActNewContacts.this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                tv_birthday.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }
}
