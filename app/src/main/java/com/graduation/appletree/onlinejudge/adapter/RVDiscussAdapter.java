package com.graduation.appletree.onlinejudge.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.adapter.RVDiscussAdapter.RVHolder;
import com.graduation.appletree.onlinejudge.bean.RVDiscussData;
import com.graduation.appletree.onlinejudge.view.CircleImageView;

import java.util.List;

public class RVDiscussAdapter extends Adapter<RVHolder>{

    private final String TAG = this.getClass().getName();

    private LayoutInflater mLayoutInflater;
    private List<RVDiscussData> mDataList;
    private Context mContext;

    public RVDiscussAdapter(Context context, List<RVDiscussData> mDataList) {
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mDataList = mDataList;
        this.mContext = context;
    }

    @Override
    public RVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RVHolder holder = new RVHolder(mLayoutInflater.inflate(R.layout.rv_item_discuss, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(RVHolder holder, int position) {
        holder.discuss_avatar.setImageResource(mDataList.get(position).getHome_solution_avatar());
        holder.discuss_nickname.setText(mDataList.get(position).getHome_solution_nickname());
        holder.discuss_title.setText(mDataList.get(position).getHome_solution_title());
        holder.discuss_brief.setText(mDataList.get(position).getHome_solution_biref());
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    /**
     * Instance Method
     * */

    static class RVHolder extends RecyclerView.ViewHolder{
        //Discuss avatar
        CircleImageView discuss_avatar;
        //Discuss nickname
        TextView discuss_nickname;
        //Discuss title
        TextView discuss_title;
        //Discuss brief
        TextView discuss_brief;

        public RVHolder(View itemView) {
            super(itemView);
            discuss_avatar = itemView.findViewById(R.id.rv_discuss_post_avatar);
            discuss_nickname = itemView.findViewById(R.id.rv_discuss_post_nickname);
            discuss_title = itemView.findViewById(R.id.rv_discuss_post_title);
            discuss_brief = itemView.findViewById(R.id.rv_discuss_post_brief);
        }
    }
}
