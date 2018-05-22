package com.graduation.appletree.onlinejudge.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.adapter.RVProfilePointAdapter.RVHolder;
import com.graduation.appletree.onlinejudge.bean.RVProfilePointData;
import com.graduation.appletree.onlinejudge.view.CircleImageView;

import java.util.List;

public class RVProfilePointAdapter extends Adapter<RVHolder>{

    private final String TAG = this.getClass().getName();

    private LayoutInflater mLayoutInflater;
    private List<RVProfilePointData> mDataList;
    private Context mContext;

    public RVProfilePointAdapter(Context mContext, List<RVProfilePointData> mDataList) {
        this.mLayoutInflater = LayoutInflater.from(mContext);
        this.mDataList = mDataList;
        this.mContext = mContext;
    }

    @Override
    public RVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RVHolder holder = new RVHolder(mLayoutInflater.inflate(R.layout.rv_item_profile_point, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(RVHolder holder, int position) {
        holder.rv_profile_point_date.setText(mDataList.get(position).getRv_profile_point_date());
        holder.rv_profile_point_add.setText(mDataList.get(position).getRv_profile_point_add());
        holder.rv_profile_point_title.setText(mDataList.get(position).getRv_profile_point_title());
        holder.rv_profile_point_content.setText(mDataList.get(position).getRv_profile_point_content());
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    static class RVHolder extends RecyclerView.ViewHolder{
        TextView rv_profile_point_date;
        TextView rv_profile_point_add;
        TextView rv_profile_point_title;
        TextView rv_profile_point_content;

        public RVHolder(View itemView) {
            super(itemView);
            rv_profile_point_date = itemView.findViewById(R.id.rv_profile_point_date);
            rv_profile_point_add = itemView.findViewById(R.id.rv_profile_point_add);
            rv_profile_point_title = itemView.findViewById(R.id.rv_profile_point_title);
            rv_profile_point_content = itemView.findViewById(R.id.rv_profile_point_content);
        }
    }
}
