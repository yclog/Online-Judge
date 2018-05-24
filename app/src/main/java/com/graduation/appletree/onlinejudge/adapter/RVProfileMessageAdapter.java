package com.graduation.appletree.onlinejudge.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.adapter.RVProfileMessageAdapter.RVHolder;
import com.graduation.appletree.onlinejudge.bean.RVProfileMessageData;
import com.graduation.appletree.onlinejudge.view.CircleImageView;

import java.util.List;

public class RVProfileMessageAdapter extends Adapter<RVHolder>{

    private final String TAG = this.getClass().getName();

    private LayoutInflater mLayoutInflater;
    private List<RVProfileMessageData> mDataList;
    private Context mContext;

    public RVProfileMessageAdapter(Context mContext, List<RVProfileMessageData> mDataList) {
        this.mLayoutInflater = LayoutInflater.from(mContext);
        this.mDataList = mDataList;
        this.mContext = mContext;
    }

    @Override
    public RVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RVHolder holder = new RVHolder(mLayoutInflater.inflate(R.layout.rv_item_profile_message, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(RVHolder holder, int position) {
        holder.profile_message_avatar.setImageResource(mDataList.get(position).getProfile_message_avatar());
        holder.profile_message_name.setText(mDataList.get(position).getProfile_message_name());
        holder.profile_message_time.setText(mDataList.get(position).getProfile_message_time());
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    static class RVHolder extends RecyclerView.ViewHolder{
        CircleImageView profile_message_avatar;
        TextView profile_message_name;
        TextView profile_message_time;

        public RVHolder(View itemView) {
            super(itemView);
            profile_message_avatar = itemView.findViewById(R.id.profile_message_avatar);
            profile_message_name = itemView.findViewById(R.id.profile_message_name);
            profile_message_time = itemView.findViewById(R.id.profile_message_time);
        }
    }
}
