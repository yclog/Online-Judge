package com.graduation.appletree.onlinejudge.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.adapter.RVChatContactAdapter.RVHolder;
import com.graduation.appletree.onlinejudge.bean.RVChatContactData;
import com.graduation.appletree.onlinejudge.view.CircleImageView;

import java.util.List;

public class RVChatContactAdapter extends Adapter<RVHolder>{

    private final String TAG = this.getClass().getName();

    private LayoutInflater mLayoutInflater;
    private List<RVChatContactData> mDataList;
    private Context mContext;

    public RVChatContactAdapter(Context mContext, List<RVChatContactData> mDataList) {
        this.mLayoutInflater = LayoutInflater.from(mContext);
        this.mDataList = mDataList;
        this.mContext = mContext;
    }

    @Override
    public RVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RVHolder holder = new RVHolder(mLayoutInflater.inflate(R.layout.rv_item_chat_contact, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(RVHolder holder, int position) {
        holder.chat_contact_avatar.setImageResource(mDataList.get(position).getContact_avatar());
        holder.chat_contact_name.setText(mDataList.get(position).getContact_name());
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    static class RVHolder extends RecyclerView.ViewHolder{
        CircleImageView chat_contact_avatar;
        TextView chat_contact_name;

        public RVHolder(View itemView) {
            super(itemView);
            chat_contact_avatar = itemView.findViewById(R.id.chat_contact_avatar);
            chat_contact_name = itemView.findViewById(R.id.chat_contact_name);
        }
    }
}
