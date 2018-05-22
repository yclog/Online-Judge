package com.graduation.appletree.onlinejudge.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.adapter.RVHomeRankAdapter.RVHolder;
import com.graduation.appletree.onlinejudge.bean.RVHomeRankData;
import com.graduation.appletree.onlinejudge.view.CircleImageView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RVHomeRankAdapter extends Adapter<RVHolder>{

    private final String TAG = this.getClass().getName();

    private LayoutInflater mLayoutInflater;
    private List<RVHomeRankData> mDataList;
    private Context mContext;

    public RVHomeRankAdapter(Context context, List<RVHomeRankData> mDataList) {
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mDataList = mDataList;
        this.mContext = context;
    }

    @Override
    public RVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RVHolder holder = new RVHolder(mLayoutInflater.inflate(R.layout.rv_item_home_rank, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(RVHolder holder, int position) {
        setRankAvatar(holder, position);
        holder.home_rank_nickname.setText(mDataList.get(position).getHome_rank_name());
        holder.home_rank_num.setText("No."+mDataList.get(position).getHome_rank_num());
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    /**
     * Instance Method
     * */
    private void setRankAvatar(RVHolder holder, int position){
        holder.home_rank_avatar.setImageResource(mDataList.get(position).getHome_rank_avatar());
        Log.d(TAG, "setRankAvatar: "+position);
        /**
         * Set Avatar border
         * */
        switch (position + 1){
            case 1:{
                holder.home_rank_avatar.setBorderColor(mContext.getResources().getColor(R.color.home_rank_no_1));
                break;
            }
            case 2:{
                holder.home_rank_avatar.setBorderColor(mContext.getResources().getColor(R.color.home_rank_no_2));
                break;
            }
            case 3:{
                holder.home_rank_avatar.setBorderColor(mContext.getResources().getColor(R.color.home_rank_no_3));
                break;
            }
            default:{
                Log.d(TAG, "Home Rank No.Common");
                break;
            }
        }

    }

    static class RVHolder extends RecyclerView.ViewHolder{
        //Home Rank avatar
        CircleImageView home_rank_avatar;
        //Home Rank nickname
        TextView home_rank_nickname;
        //Home Rank No.num
        TextView home_rank_num;

        public RVHolder(View itemView) {
            super(itemView);
            home_rank_avatar = itemView.findViewById(R.id.home_rank_avatar);
            home_rank_nickname = itemView.findViewById(R.id.home_rank_nickname);
            home_rank_num = itemView.findViewById(R.id.home_rank_num);
        }
    }
}
