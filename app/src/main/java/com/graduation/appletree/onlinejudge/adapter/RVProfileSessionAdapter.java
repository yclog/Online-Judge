package com.graduation.appletree.onlinejudge.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.adapter.RVProfileSessionAdapter.RVHolder;
import com.graduation.appletree.onlinejudge.bean.RVProfileSessionData;
import com.graduation.appletree.onlinejudge.view.CircleImageView;

import java.util.List;

public class RVProfileSessionAdapter extends Adapter<RVHolder>{

    private final String TAG = this.getClass().getName();

    private LayoutInflater mLayoutInflater;
    private List<RVProfileSessionData> mDataList;
    private Context mContext;

    public RVProfileSessionAdapter(Context mContext, List<RVProfileSessionData> mDataList) {
        this.mLayoutInflater = LayoutInflater.from(mContext);
        this.mDataList = mDataList;
        this.mContext = mContext;
    }

    @Override
    public RVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RVHolder holder = new RVHolder(mLayoutInflater.inflate(R.layout.rv_tiem_profile_session, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(RVHolder holder, int position) {
        holder.rv_profile_session_num.setText(mDataList.get(position).getRv_profile_session_num() + "");
        holder.rv_profile_session_mission.setText(mDataList.get(position).getRv_profile_session_mission());
        holder.rv_profile_session_publisher.setText(mDataList.get(position).getRv_profile_session_publisher());
        holder.rv_profile_session_starttime.setText(mDataList.get(position).getRv_profile_session_starttime());
        holder.rv_profile_session_endtime.setText(mDataList.get(position).getRv_profile_session_endtime());
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    static class RVHolder extends RecyclerView.ViewHolder{
        TextView rv_profile_session_num;
        TextView rv_profile_session_mission;
        TextView rv_profile_session_publisher;
        TextView rv_profile_session_starttime;
        TextView rv_profile_session_endtime;

        public RVHolder(View itemView) {
            super(itemView);
            rv_profile_session_num = itemView.findViewById(R.id.rv_profile_session_num);
            rv_profile_session_mission = itemView.findViewById(R.id.rv_profile_session_mission);
            rv_profile_session_publisher = itemView.findViewById(R.id.rv_profile_session_publisher);
            rv_profile_session_starttime = itemView.findViewById(R.id.rv_profile_session_starttime);
            rv_profile_session_endtime = itemView.findViewById(R.id.rv_profile_session_endtime);
        }
    }
}
