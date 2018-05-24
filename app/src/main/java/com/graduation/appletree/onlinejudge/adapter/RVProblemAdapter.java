package com.graduation.appletree.onlinejudge.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;

import com.graduation.appletree.onlinejudge.activity.ProblemDetailsActivity;
import com.graduation.appletree.onlinejudge.adapter.RVProblemAdapter.RVHolder;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.bean.RVProblemData;
import com.graduation.appletree.onlinejudge.view.CircleImageView;

import java.util.List;

public class RVProblemAdapter extends Adapter<RVHolder>{

    private final String TAG = this.getClass().getName();

    private LayoutInflater mLayoutInflater;
    private List<RVProblemData> mDataList;
    private Context mContext;

    public RVProblemAdapter(Context mContext, List<RVProblemData> mDataList) {
        mLayoutInflater = LayoutInflater.from(mContext);
        this.mDataList = mDataList;
        this.mContext = mContext;
    }

    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view , int problem_id);
    }

    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    @Override
    public RVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RVHolder holder = new RVHolder(mLayoutInflater.inflate(R.layout.rv_item_problems, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final RVHolder holder, final int position) {
        switch (mDataList.get(position).getProblem_status()){
            case 0:{
                holder.problem_attempted.setVisibility(View.INVISIBLE);
                holder.problem_accept.setVisibility(View.INVISIBLE);
                break;
            }
            case 1:{
                holder.problem_accept.setVisibility(View.VISIBLE);
                holder.problem_attempted.setVisibility(View.INVISIBLE);
                break;
            }
            case 2:{
                holder.problem_accept.setVisibility(View.INVISIBLE);
                holder.problem_attempted.setVisibility(View.VISIBLE);
                break;
            }
            default:{
                Log.d(TAG, "Problem Status Invalid ");
            }
        }
        holder.problem_num.setText((mDataList.get(position).getProblem_num()+""));
        holder.problem_title.setText(mDataList.get(position).getProblem_title());
        holder.problem_rate.setText(mDataList.get(position).getProblem_rate());
        switch (mDataList.get(position).getProblem_diffculty()){
            case 0:{
                holder.problem_difficulty.setText("Easy");
                holder.problem_difficulty.setBackgroundResource(R.drawable.problem_easy);
                break;
            }
            case 1:{
                holder.problem_difficulty.setText("Medium");
                holder.problem_difficulty.setBackgroundResource(R.drawable.problem_medium);
                break;
            }
            case 2:{
                holder.problem_difficulty.setText("Hard");
                holder.problem_difficulty.setBackgroundResource(R.drawable.problem_hard);
                break;
            }
            default:{
                Log.d(TAG, "Problem Difficulty Status Invalid ");
            }
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickListener.onItemClick(view, mDataList.get(position).getProblem_id());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    static class RVHolder extends RecyclerView.ViewHolder{
        ImageView problem_attempted;
        ImageView problem_accept;
        TextView problem_num;
        TextView problem_title;
        TextView problem_rate;
        TextView problem_difficulty;

        public RVHolder(View itemView) {
            super(itemView);
            problem_attempted = itemView.findViewById(R.id.rv_problem_attempted);
            problem_accept = itemView.findViewById(R.id.rv_problem_accept);
            problem_num = itemView.findViewById(R.id.rv_problem_num);
            problem_title = itemView.findViewById(R.id.rv_problem_title);
            problem_rate = itemView.findViewById(R.id.rv_problem_rate);
            problem_difficulty = itemView.findViewById(R.id.rv_problem_difficulty);
        }
    }
}
