package com.company.qts.demo1;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

import com.company.qts.adapter.AdapterGallery;
import com.company.qts.helper.QTSHelp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActProduct extends AppCompatActivity{
    ImageView img_arrow;
    MyRecyclerViewAdapter adapter;
    AdapterGallery adapterGallery;
    int [] images = {R.drawable.img_o,R.drawable.img_t,R.drawable.img_th,R.drawable.img_f,R.drawable.img_fa,R.drawable.img_o,
            R.drawable.img_o,R.drawable.img_t,R.drawable.img_th,R.drawable.img_f,R.drawable.img_fa,R.drawable.img_o};
    Gallery gallery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_product);
        img_arrow = (ImageView) findViewById(R.id.img_arrow);
        gallery = (Gallery) findViewById(R.id.gallery);
        adapterGallery = new AdapterGallery(getApplicationContext(), images); // initialize the adapter
        gallery.setAdapter(adapterGallery); // set the adapter
        gallery.setSpacing(10);

//        DisplayMetrics metrics = new DisplayMetrics();
//        ctx.getWindowManager().getDefaultDisplay().getMetrics(metrics);
//
//        Gallery gallery = (Gallery) ctx.findViewById(R.id.gallery);
//
//        ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) gallery.getLayoutParams();
//        mlp.setMargins(-(metrics.widthPixels/2),
//                mlp.topMargin,
//                mlp.rightMargin,
//                mlp.bottomMargin);
//        gallery.setOnTouchListener(new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//                return true;
//            }
//        });
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                QTSHelp.showToast(ActProduct.this,"position"+position);
            }
        });
        gallery.setFadingEdgeLength(0);
        gallery.setSelection(1);
        img_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ArrayList<Integer> viewColoers = new ArrayList<>();
        viewColoers.add(Color.BLUE);
        viewColoers.add(Color.YELLOW);
        viewColoers.add(Color.MAGENTA);
        viewColoers.add(Color.RED);
        viewColoers.add(Color.BLACK);
        viewColoers.add(Color.BLUE);
        viewColoers.add(Color.YELLOW);
        viewColoers.add(Color.MAGENTA);
        viewColoers.add(Color.RED);
        viewColoers.add(Color.BLACK);

        ArrayList<String> animalNames = new ArrayList<>();
        animalNames.add("Horse");
        animalNames.add("Cow");
        animalNames.add("Camel");
        animalNames.add("Sheep");
        animalNames.add("Goat");
        animalNames.add("Horse");
        animalNames.add("Cow");
        animalNames.add("Camel");
        animalNames.add("Sheep");
        animalNames.add("Goat");

        // set up the RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rcv_products);
        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(ActProduct.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManagaer);
        adapter = new MyRecyclerViewAdapter(this, viewColoers, animalNames);
        recyclerView.setAdapter(adapter);
    }

    public static class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

        private List<Integer> mViewColors = Collections.emptyList();
        private List<String> mAnimals = Collections.emptyList();
        private LayoutInflater mInflater;
        private ItemClickListener mClickListener;

        // data is passed into the constructor
        public MyRecyclerViewAdapter(Context context, List<Integer> colors, List<String> animals) {
            this.mInflater = LayoutInflater.from(context);
            this.mViewColors = colors;
            this.mAnimals = animals;
        }

        // inflates the row layout from xml when needed
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = mInflater.inflate(R.layout.recyclerview_item, parent, false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        // binds the data to the view and textview in each row
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            int color = mViewColors.get(position);
            String animal = mAnimals.get(position);
            holder.myView.setBackgroundColor(color);
            holder.myTextView.setText(animal);
        }

        // total number of rows
        @Override
        public int getItemCount() {
            return mAnimals.size();
        }

        // stores and recycles views as they are scrolled off screen
        public class ViewHolder extends RecyclerView.ViewHolder {
            public View myView;
            public TextView myTextView;

            public ViewHolder(View itemView) {
                super(itemView);
                myView = itemView.findViewById(R.id.colorView);
                myTextView = (TextView) itemView.findViewById(R.id.tvAnimalName);
//                itemView.setOnClickListener(this);
            }

//            @Override
//            public void onClick(View view) {
//                if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
//            }
        }

        // convenience method for getting data at click position
        public String getItem(int id) {
            return mAnimals.get(id);
        }

        // allows clicks events to be caught
        public void setClickListener(ItemClickListener itemClickListener) {
            this.mClickListener = itemClickListener;
        }

        // parent activity will implement this method to respond to click events
        public interface ItemClickListener {
            void onItemClick(View view, int position);
        }
    }
}
