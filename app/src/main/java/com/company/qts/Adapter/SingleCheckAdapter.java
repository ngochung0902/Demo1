package com.company.qts.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.company.qts.Object.LineLVBackground;
import com.company.qts.demo1.R;

import java.util.List;

/**
 * Created by MyPC on 26/07/2017.
 */
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
