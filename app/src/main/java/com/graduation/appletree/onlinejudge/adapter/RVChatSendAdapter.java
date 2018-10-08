package com.graduation.appletree.onlinejudge.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.adapter.RVChatSendAdapter.RVHolder;
import com.graduation.appletree.onlinejudge.bean.RVChatRoomData;
import com.graduation.appletree.onlinejudge.view.CircleImageView;

import java.util.List;

public class RVChatSendAdapter extends Adapter<RVHolder>{

    private final String TAG = this.getClass().getName();

    private LayoutInflater mLayoutInflater;
    private List<RVChatRoomData> mDataList;
    private Context mContext;

    public RVChatSendAdapter(Context mContext, List<RVChatRoomData> mDataList) {
        this.mLayoutInflater = LayoutInflater.from(mContext);
        this.mDataList = mDataList;
        this.mContext = mContext;
    }

    @Override
    public RVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RVHolder holder = new RVHolder(mLayoutInflater.inflate(R.layout.rv_item_chat_send, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(RVHolder holder, int position) {
        holder.rv_chat_send_text.setText(mDataList.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public void addData(int side, String text, int position) {
        mDataList.add(new RVChatRoomData(side, text));
        notifyItemInserted(position);
    }

    static class RVHolder extends RecyclerView.ViewHolder{
        CircleImageView rv_chat_send_avatar;
        TextView rv_chat_send_text;

        public RVHolder(View itemView) {
            super(itemView);
            rv_chat_send_avatar = itemView.findViewById(R.id.rv_chat_send_avatar);
            rv_chat_send_text = itemView.findViewById(R.id.rv_chat_send_text);
        }
    }
}
