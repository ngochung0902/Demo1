package com.company.qts.demo1;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.company.qts.object.LineLVBackground;
import com.company.qts.helper.QTSHelp;

import java.util.ArrayList;
import java.util.List;

public class ActBackground extends AppCompatActivity implements AdapterView.OnItemClickListener {

    RecyclerView rclview;
    ImageView img_arrow;
    TextView tv_save;
    public int color;
    private List<LineLVBackground> mSingleCheckList = new ArrayList<>();
    private SingleCheckAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_background);

        initUI();

        dataarr();

        mAdapter = new SingleCheckAdapter(this, mSingleCheckList);
        rclview.setLayoutManager(new LinearLayoutManager(this));
        rclview.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(this);

        img_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tv_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ActBackground.this);
                builder.setIcon(R.drawable.img_error);
                builder.setTitle("Demo1");
                builder.setMessage("Do you agree?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        QTSHelp.setColor(ActBackground.this, color);
                        onBackPressed();
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
    }

    private void dataarr() {
        mSingleCheckList.add((new LineLVBackground("Blue", R.color.blue)));
        mSingleCheckList.add((new LineLVBackground("Red", R.color.red)));
        mSingleCheckList.add((new LineLVBackground("Gray", R.color.gray)));
        mSingleCheckList.add((new LineLVBackground("Green", R.color.green)));
        mSingleCheckList.add((new LineLVBackground("Black",R.color.black)));
        mSingleCheckList.add((new LineLVBackground("Cyan", R.color.cyan)));
        mSingleCheckList.add((new LineLVBackground("Dkhgray", R.color.dkgray)));
        mSingleCheckList.add((new LineLVBackground("Yellow", R.color.yellow)));
    }

    private void initUI() {
        img_arrow = (ImageView) findViewById(R.id.img_arrow);
        tv_save = (TextView) findViewById(R.id.tv_save);
        rclview = (RecyclerView) findViewById(R.id.rclview);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
                    case 0:
                        color = Color.BLUE;
                        QTSHelp.setNumColor(ActBackground.this,position);
                        break;
                    case 1:
                        color = Color.RED;
                        QTSHelp.setNumColor(ActBackground.this,position);
                        break;
                    case 2:
                        color = Color.GRAY;
                        QTSHelp.setNumColor(ActBackground.this,position);
                        break;
                    case 3:
                        color = Color.GREEN;
                        QTSHelp.setNumColor(ActBackground.this,position);
                        break;
                    case 4:
                        color = Color.BLACK;
                        QTSHelp.setNumColor(ActBackground.this,position);
                        break;
                    case 5:
                        color = Color.CYAN;
                        QTSHelp.setNumColor(ActBackground.this,position);
                        break;
                    case 6:
                        color = Color.DKGRAY;
                        QTSHelp.setNumColor(ActBackground.this,position);
                        break;
                    case 7:
                        color = Color.YELLOW;
                        QTSHelp.setNumColor(ActBackground.this,position);
                        break;
                }
    }

    public class SingleCheckAdapter extends RecyclerView.Adapter<SingleCheckAdapter.SingleCheckViewHolder> {

        private int mSelectedItem = -1;
        private List<LineLVBackground> mSingleCheckList;
        private Context mContext;
        private AdapterView.OnItemClickListener onItemClickListener;

        public SingleCheckAdapter(Context context, List<LineLVBackground> listItems) {
            mContext = context;
            mSingleCheckList = listItems;
        }

        @Override
        public SingleCheckViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            final View view = inflater.inflate(R.layout.line_lv_background, viewGroup, false);
            return new SingleCheckViewHolder(view, this);
        }

        @Override
        public void onBindViewHolder(SingleCheckViewHolder viewHolder, final int position) {
            LineLVBackground item = mSingleCheckList.get(position);
            try {
                viewHolder.setDateToView(item, position);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public int getItemCount() {
            return mSingleCheckList.size();
        }

        public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
            this.onItemClickListener = onItemClickListener;
        }

        public void onItemHolderClick(SingleCheckViewHolder holder) {
            if (onItemClickListener != null)
                onItemClickListener.onItemClick(null, holder.itemView, holder.getAdapterPosition(), holder.getItemId());
        }

        class SingleCheckViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            private SingleCheckAdapter mAdapter;
            private RadioButton mRadio;
            private TextView mText,tv_colorview;

            public SingleCheckViewHolder(View itemView, final SingleCheckAdapter mAdapter) {
                super(itemView);
                this.mAdapter = mAdapter;

                mText = (TextView) itemView.findViewById(R.id.tv_namecolor);
                mRadio = (RadioButton) itemView.findViewById(R.id.img_nocheck);
                tv_colorview = (TextView) itemView.findViewById(R.id.tv_viewcolor);
                itemView.setOnClickListener(this);
                mRadio.setOnClickListener(this);
            }

            public void setDateToView(LineLVBackground item, int position) throws Exception {
                mRadio.setChecked(position == mSelectedItem);
                if (QTSHelp.getColor(ActBackground.this)==Color.BLUE) {
                    mRadio.setChecked(position ==0);
                }
                else{
                    if (QTSHelp.getColor(ActBackground.this)==Color.RED)
                    {
                        mRadio.setChecked(position ==1);
                    }
                    else
                    {
                        if (QTSHelp.getColor(ActBackground.this)==Color.GRAY)
                        {
                            mRadio.setChecked(position ==2);
                        }
                        else
                        {
                            if (QTSHelp.getColor(ActBackground.this)==Color.GREEN)
                            {
                                mRadio.setChecked(position ==3);
                            }
                            else
                            {
                                if (QTSHelp.getColor(ActBackground.this)==Color.BLACK)
                                {
                                    mRadio.setChecked(position == 4);
                                }
                                else
                                {
                                    if (QTSHelp.getColor(ActBackground.this)==Color.CYAN)
                                    {
                                        mRadio.setChecked(position == 5);
                                    }
                                    else
                                    {
                                        if (QTSHelp.getColor(ActBackground.this)==Color.DKGRAY)
                                        {
                                            mRadio.setChecked(position == 6);
                                        }
                                        else
                                        {
                                            if (QTSHelp.getColor(ActBackground.this)==Color.YELLOW)
                                            {
                                                mRadio.setChecked(position == 7);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                mText.setText(item.getNamecolor());
                tv_colorview.setBackgroundResource(item.getImg_colorview());
            }

            @Override
            public void onClick(View v) {
                mSelectedItem = getAdapterPosition();
                notifyItemRangeChanged(0, mSingleCheckList.size());
                mAdapter.onItemHolderClick(SingleCheckViewHolder.this);

            }
        }
}
}