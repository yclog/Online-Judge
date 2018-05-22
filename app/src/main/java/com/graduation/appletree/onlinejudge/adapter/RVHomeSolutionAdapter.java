package com.graduation.appletree.onlinejudge.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.bean.RVHomeSolutionData;
import com.graduation.appletree.onlinejudge.adapter.RVHomeSolutionAdapter.RVHolder;
import com.graduation.appletree.onlinejudge.view.CircleImageView;

import java.util.List;

public class RVHomeSolutionAdapter extends Adapter<RVHolder>{

    private final String TAG = this.getClass().getName();

    private LayoutInflater mLayoutInflater;
    private List<RVHomeSolutionData> mDataList;
    private Context mContext;

    public RVHomeSolutionAdapter(Context context, List<RVHomeSolutionData> mDataList) {
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mDataList = mDataList;
        this.mContext = context;
    }

    @Override
    public RVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RVHolder holder = new RVHolder(mLayoutInflater.inflate(R.layout.rv_item_home_solution, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(RVHolder holder, int position) {
        holder.home_solution_avatar.setImageResource(mDataList.get(position).getHome_solution_avatar());
        holder.home_solution_nickname.setText(mDataList.get(position).getHome_solution_nickname());
        holder.home_solution_title.setText(mDataList.get(position).getHome_solution_title());
        holder.home_solution_brief.setText(mDataList.get(position).getHome_solution_biref());
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    /**
     * Instance Method
     * */

    static class RVHolder extends RecyclerView.ViewHolder{
        //Home Solution avatar
        CircleImageView home_solution_avatar;
        //Home Solution nickname
        TextView home_solution_nickname;
        //Home Solution title
        TextView home_solution_title;
        //Home Solution brief
        TextView home_solution_brief;

        public RVHolder(View itemView) {
            super(itemView);
            home_solution_avatar = itemView.findViewById(R.id.rv_home_solution_avatar);
            home_solution_nickname = itemView.findViewById(R.id.rv_home_solution_nickname);
            home_solution_title = itemView.findViewById(R.id.rv_home_solution_title);
            home_solution_brief = itemView.findViewById(R.id.rv_home_solution_brief);
        }
    }
}
