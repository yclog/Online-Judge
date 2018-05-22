package com.graduation.appletree.onlinejudge.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.adapter.RVChatMessageAdapter.RVHolder;
import com.graduation.appletree.onlinejudge.bean.RVChatMessageData;
import com.graduation.appletree.onlinejudge.view.CircleImageView;

import java.util.List;

public class RVChatMessageAdapter extends Adapter<RVHolder>{

    private final String TAG = this.getClass().getName();

    private LayoutInflater mLayoutInflater;
    private List<RVChatMessageData> mDataList;
    private Context mContext;

    public RVChatMessageAdapter(Context mContext, List<RVChatMessageData> mDataList) {
        this.mLayoutInflater = LayoutInflater.from(mContext);
        this.mDataList = mDataList;
        this.mContext = mContext;
    }

    @Override
    public RVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RVHolder holder = new RVHolder(mLayoutInflater.inflate(R.layout.rv_item_chat_message, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(RVHolder holder, int position) {
        holder.chat_message_avatar.setImageResource(mDataList.get(position).getChat_message_avatar());
        holder.chat_message_name.setText(mDataList.get(position).getChat_message_name());
        holder.chat_message_time.setText(mDataList.get(position).getChat_message_time());
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    static class RVHolder extends RecyclerView.ViewHolder{
        CircleImageView chat_message_avatar;
        TextView chat_message_name;
        TextView chat_message_time;

        public RVHolder(View itemView) {
            super(itemView);
            chat_message_avatar = itemView.findViewById(R.id.chat_message_avatar);
            chat_message_name = itemView.findViewById(R.id.chat_message_name);
            chat_message_time = itemView.findViewById(R.id.chat_message_time);
        }
    }
}
