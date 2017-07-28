package com.company.qts.demo1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.company.qts.Object.LineGv;

import java.util.ArrayList;

public class ActDocuments extends AppCompatActivity {
    ImageView img_arrow;
    GridView gv_documents;
    private ArrayList<LineGv> arraydocuments = new ArrayList<>();
    private AdapterImageGV mAdapter;
    Integer[]mThumbIds;
    Bundle myBackupBundle;
    public boolean a = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_documents);
        myBackupBundle=savedInstanceState;
        initUI();
        dataarr();
        mAdapter = new AdapterImageGV(this, arraydocuments);
        gv_documents.setAdapter(mAdapter);

        mThumbIds=new Integer[]{R.drawable.im_flower,R.drawable.img_o,
                R.drawable.img_t,R.drawable.img_th,
                R.drawable.img_f,R.drawable.img_fa,};
        gv_documents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setContentView(R.layout.lineimg_gv_documents);
                Button bt_back = (Button) findViewById(R.id.bt_back);
                bt_back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent2 = new Intent(ActDocuments.this,ActDocuments.class);
                        startActivity(intent2);
                        finish();
                    }
                });
                TextView tv_nameflower=(TextView) findViewById(R.id.tv_nameimage);
                switch (position){
                    case 0:
                        tv_nameflower.setText("Hoa Huong Duong");
                        break;
                    case 1:
                        tv_nameflower.setText("Hoa Tigon");
                        break;
                    case 2:
                        tv_nameflower.setText("Hoa Bi");
                        break;
                    case 3:
                        tv_nameflower.setText("Hoa Lan");
                        break;
                    case 4:
                        tv_nameflower.setText("Hoa Cuc");
                        break;
                    case 5:
                        tv_nameflower.setText("Hoa Hong");
                        break;
                }
                ImageView img_showimg=(ImageView) findViewById(R.id.img_showimg);
                img_showimg.setImageResource(mThumbIds[position]);
            }
        });

        gv_documents.setLongClickable(true);
        gv_documents.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                a = false;
                Intent intent = new Intent(ActDocuments.this,ActLongClickGV.class);
                intent.putExtra("positon",position);
                startActivity(intent);
                return false;
            }
        });

        img_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void dataarr() {
        arraydocuments.add((new LineGv(R.drawable.im_flower,"Hoa Huong Duong")));
        arraydocuments.add((new LineGv(R.drawable.img_o,"Hoa Tigon")));
        arraydocuments.add((new LineGv(R.drawable.img_t,"Hoa Bi")));
        arraydocuments.add((new LineGv(R.drawable.img_th,"Hoa Lan")));
        arraydocuments.add((new LineGv(R.drawable.img_f,"Hoa Cuc")));
        arraydocuments.add((new LineGv(R.drawable.img_fa,"Hoa Hong")));
    }

    private void initUI() {
        img_arrow = (ImageView) findViewById(R.id.img_arrow);
        gv_documents = (GridView) findViewById(R.id.gv_documents);
    }

    //--------------------------------------------------------------------------------------------------
    public class AdapterImageGV extends BaseAdapter {

        Context context;
        ArrayList<LineGv> arrayList;

        public AdapterImageGV(Context context, ArrayList<LineGv> arrayList) {
            this.context = context;
            this.arrayList = arrayList;
        }

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return arrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.line_gv,null);

            LineGv lineGv = arrayList.get(position);

            ImageView img_flower = (ImageView) convertView.findViewById(R.id.imggv);
            TextView tv_name    = (TextView) convertView.findViewById(R.id.tv_name);

            tv_name.setText(lineGv.getName());
            img_flower.setImageResource(lineGv.getImg_flowerr());
            return convertView;
        }
    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event)  {
//        if (Integer.parseInt(android.os.Build.VERSION.SDK) > 5
//                && keyCode == KeyEvent.KEYCODE_BACK
//                && event.getRepeatCount() == 0) {
//            Log.d("CDA", "onKeyDown Called");
//            onBackPressed();
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }
    @Override
    public void onBackPressed() {
        Log.d("CDA", "onBackPressed Called");
//        Intent setIntent = new Intent(Intent.ACTION_MAIN);
//        setIntent.addCategory(Intent.CATEGORY_HOME);
//        setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(setIntent);
        Intent intent2 = new Intent(ActDocuments.this,ActDocuments.class);
        startActivity(intent2);
        finish();
    }
}
