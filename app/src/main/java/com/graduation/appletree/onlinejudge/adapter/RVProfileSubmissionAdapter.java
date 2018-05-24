package com.graduation.appletree.onlinejudge.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.adapter.RVProfileSubmissionAdapter.RVHolder;
import com.graduation.appletree.onlinejudge.bean.RVProfileSubmissionData;

import java.util.List;

public class RVProfileSubmissionAdapter extends Adapter<RVHolder>{

    private final String TAG = this.getClass().getName();

    private LayoutInflater mLayoutInflater;
    private List<RVProfileSubmissionData> mDataList;
    private Context mContext;

    public RVProfileSubmissionAdapter(Context mContext, List<RVProfileSubmissionData> mDataList) {
        this.mLayoutInflater = LayoutInflater.from(mContext);
        this.mDataList = mDataList;
        this.mContext = mContext;
    }

    @Override
    public RVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RVHolder holder = new RVHolder(mLayoutInflater.inflate(R.layout.rv_tiem_profile_submission, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(RVHolder holder, int position) {
        holder.submission_question.setText(mDataList.get(position).getSubmission_question());
        holder.submission_status.setText(mDataList.get(position).getSubmission_status());
        if (mDataList.get(position).getSubmission_status().contains("Error"))
            holder.submission_status.setTextColor(mContext.getResources().getColor(R.color.error));
        holder.submission_runtime.setText(mDataList.get(position).getSubmission_runtime());
        holder.submission_language.setText(mDataList.get(position).getSubmission_language());
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    static class RVHolder extends RecyclerView.ViewHolder{
        TextView submission_question;
        TextView submission_status;
        TextView submission_runtime;
        TextView submission_language;

        public RVHolder(View itemView) {
            super(itemView);
            submission_question = itemView.findViewById(R.id.submission_question);
            submission_status = itemView.findViewById(R.id.submission_status);
            submission_runtime = itemView.findViewById(R.id.submission_runtime);
            submission_language = itemView.findViewById(R.id.submission_language);
        }
    }
}
