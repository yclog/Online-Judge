package com.graduation.appletree.onlinejudge.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import com.graduation.appletree.onlinejudge.adapter.RVChatTalkAdapter.RVHolder;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.bean.RVChatTalkData;
import com.graduation.appletree.onlinejudge.view.CircleImageView;

import java.util.List;

public class RVChatTalkAdapter extends Adapter<RVHolder>{

    private final String TAG = this.getClass().getName();

    private LayoutInflater mLayoutInflater;
    private List<RVChatTalkData> mDataList;
    private Context mContext;

    public RVChatTalkAdapter(Context mContext, List<RVChatTalkData> mDataList) {
        this.mLayoutInflater = LayoutInflater.from(mContext);
        this.mDataList = mDataList;
        this.mContext = mContext;
    }

    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view , String talk_name);
    }

    private RVChatTalkAdapter.OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public void setOnItemClickListener(RVChatTalkAdapter.OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    @Override
    public RVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RVHolder holder = new RVHolder(mLayoutInflater.inflate(R.layout.rv_item_chat_talk, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(RVHolder holder, final int position) {
        switch (mDataList.get(position).getChat_talk_status()){
            case 0:{
                holder.chat_talk_status.setImageResource(R.color.chat_online);
                break;
            }
            case 1:{
                holder.chat_talk_status.setImageResource(R.color.chat_busy);
                break;
            }
            case 2:{
                holder.chat_talk_status.setImageResource(R.color.chat_offline);
                break;
            }
            default:{
                Log.d(TAG, "Chat Talk Status is Invalid");
            }
        }
        holder.chat_talk_avatar.setImageResource(mDataList.get(position).getChat_talk_avatar());
        holder.chat_talk_name.setText(mDataList.get(position).getChat_talk_name());
        holder.chat_talk_brief.setText(mDataList.get(position).getChat_talk_brief());
        holder.chat_talk_date.setText(mDataList.get(position).getChat_talk_date());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickListener.onItemClick(view, mDataList.get(position).getChat_talk_name());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    static class RVHolder extends RecyclerView.ViewHolder{
        CircleImageView chat_talk_avatar;
        CircleImageView chat_talk_status;
        TextView chat_talk_name;
        TextView chat_talk_brief;
        TextView chat_talk_date;

        public RVHolder(View itemView) {
            super(itemView);
            chat_talk_avatar = itemView.findViewById(R.id.chat_talk_avatar);
            chat_talk_status = itemView.findViewById(R.id.chat_talk_status);
            chat_talk_name = itemView.findViewById(R.id.chat_talk_name);
            chat_talk_brief = itemView.findViewById(R.id.chat_talk_brief);
            chat_talk_date = itemView.findViewById(R.id.chat_talk_date);
        }
    }
}
