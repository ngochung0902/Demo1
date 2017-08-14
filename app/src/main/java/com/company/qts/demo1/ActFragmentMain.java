package com.company.qts.demo1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.company.qts.fragment.Frm1;
import com.company.qts.fragment.Frm2;
import com.company.qts.fragment.Frm3;

public class ActFragmentMain extends FragmentActivity implements View.OnClickListener, Frm3.OnFragmentManager {
    private Button bt_frm1,bt_frm2,bt_frm3,bt_apply;
    private LinearLayout ln2;
    private String bien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_frament_main);
        callFragment(new Frm1());
        initUI();
        bt_frm1.setOnClickListener(this);
        bt_frm2.setOnClickListener(this);
        bt_frm3.setOnClickListener(this);
        bt_apply.setOnClickListener(this);
    }

    private void initUI() {
        bt_frm1 = (Button) findViewById(R.id.bt_frm1);
        bt_frm2 = (Button) findViewById(R.id.bt_frm2);
        bt_frm3 = (Button) findViewById(R.id.bt_frm3);
        bt_apply = (Button) findViewById(R.id.bt_apply);
        ln2 = (LinearLayout) findViewById(R.id.ln2);
    }

    public void callFragment(Fragment fragment) {
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();
        //Khi được goi, fragment truyền vào sẽ thay thế vào vị trí FrameLayout trong Activity chính
        transaction.replace(R.id.frlo, fragment);
        transaction.commit();
    }

    @Override
    public void onDataSelected(String data) {
        bien = data;
        Toast.makeText(ActFragmentMain.this, bien, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_frm1:
                bt_frm1.setBackgroundResource(R.drawable.custom_btfrm_click);
                bt_frm1.setTextColor(Color.WHITE);
                bt_frm2.setBackgroundResource(R.drawable.custom_btfrm);
                bt_frm2.setTextColor(Color.GREEN);
                bt_frm3.setBackgroundResource(R.drawable.custom_btfrm);
                bt_frm3.setTextColor(Color.GREEN);
                bt_apply.setBackgroundResource(R.drawable.custom_btfrm);
                bt_apply.setTextColor(Color.GREEN);
                ln2.setVisibility(View.GONE);
                callFragment(new Frm1());
                break;
            case R.id.bt_frm2:
                bt_frm2.setBackgroundResource(R.drawable.custom_btfrm_click);
                bt_frm2.setTextColor(Color.WHITE);
                bt_frm1.setBackgroundResource(R.drawable.custom_btfrm);
                bt_frm1.setTextColor(Color.GREEN);
                bt_frm3.setBackgroundResource(R.drawable.custom_btfrm);
                bt_frm3.setTextColor(Color.GREEN);
                bt_apply.setBackgroundResource(R.drawable.custom_btfrm);
                bt_apply.setTextColor(Color.GREEN);
                ln2.setVisibility(View.GONE);
                callFragment(new Frm2());
                break;
            case R.id.bt_frm3:
                bt_frm3.setBackgroundResource(R.drawable.custom_btfrm_click);
                bt_frm3.setTextColor(Color.WHITE);
                bt_frm2.setBackgroundResource(R.drawable.custom_btfrm);
                bt_frm2.setTextColor(Color.GREEN);
                bt_frm1.setBackgroundResource(R.drawable.custom_btfrm);
                bt_frm1.setTextColor(Color.GREEN);
                ln2.setVisibility(View.VISIBLE);
                bt_apply.setBackgroundResource(R.drawable.custom_btfrm);
                bt_apply.setTextColor(Color.GREEN);
                callFragment(new Frm3());
                break;
            case R.id.bt_apply:
                bt_frm1.setBackgroundResource(R.drawable.custom_btfrm);
                bt_frm1.setTextColor(Color.GREEN);
                bt_frm3.setBackgroundResource(R.drawable.custom_btfrm);
                bt_frm3.setTextColor(Color.GREEN);
                bt_frm2.setBackgroundResource(R.drawable.custom_btfrm);
                bt_frm2.setTextColor(Color.GREEN);
                bt_apply.setBackgroundResource(R.drawable.custom_btfrm_click);
                bt_apply.setTextColor(Color.WHITE);
                showText();
                break;

        }
    }

    public void showText(){
        Frm3 frmBottom
                = (Frm3) this.getSupportFragmentManager().findFragmentById(R.id.frm3);
        frmBottom.showRs();
    }
}
