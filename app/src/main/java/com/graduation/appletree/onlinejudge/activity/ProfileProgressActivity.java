package com.graduation.appletree.onlinejudge.activity;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;

import com.graduation.appletree.onlinejudge.R;
import com.graduation.appletree.onlinejudge.eventbus.EventCenter;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.charts.ValueLineChart;
import org.eazegraph.lib.models.PieModel;
import org.eazegraph.lib.models.ValueLinePoint;
import org.eazegraph.lib.models.ValueLineSeries;

import butterknife.BindView;

public class ProfileProgressActivity extends BaseActivity{
    @BindView(R.id.titlebar_back)
    protected ImageView titlebar_back;
    @BindView(R.id.profile_progress_graph)
    protected PieChart profile_progress_graph;
    @BindView(R.id.profile_progress_linechart)
    protected ValueLineChart profile_progress_linechart;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_profile_progress;
    }

    @Override
    protected void initViewAndEvent() {
        initView();
        initChart();
    }

    @Override
    protected void onEventComing(EventCenter eventCenter) {

    }

    @Override
    protected Context getContext() {
        return this;
    }

    /**
     * Instance Method
     * */

    private void initView(){
        titlebar_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProfileProgressActivity.this.finish();
            }
        });
    }

    private void initChart(){
        /**
         * Init Circle Chart
         * */
        profile_progress_graph.addPieSlice(new PieModel("Freetime", 15, Color.parseColor("#FE6DA8")));
        profile_progress_graph.addPieSlice(new PieModel("Error", 25, Color.parseColor("#56B7F1")));
        profile_progress_graph.addPieSlice(new PieModel("Accept", 35, Color.parseColor("#CDA67F")));
        profile_progress_graph.addPieSlice(new PieModel("Attempted", 9, Color.parseColor("#FED70E")));

        profile_progress_graph.startAnimation();

        /**
         * Init Line Chart
         * */
        ValueLineSeries series = new ValueLineSeries();
        series.setColor(0xFF56B7F1);

        series.addPoint(new ValueLinePoint("Jan", 2.4f));
        series.addPoint(new ValueLinePoint("Feb", 3.4f));
        series.addPoint(new ValueLinePoint("Mar", .4f));
        series.addPoint(new ValueLinePoint("Apr", 1.2f));
        series.addPoint(new ValueLinePoint("Mai", 2.6f));
        series.addPoint(new ValueLinePoint("Jun", 1.0f));
        series.addPoint(new ValueLinePoint("Jul", 3.5f));
        series.addPoint(new ValueLinePoint("Aug", 2.4f));
        series.addPoint(new ValueLinePoint("Sep", 2.4f));
        series.addPoint(new ValueLinePoint("Oct", 3.4f));
        series.addPoint(new ValueLinePoint("Nov", .4f));
        series.addPoint(new ValueLinePoint("Dec", 1.3f));

        profile_progress_linechart.addSeries(series);
        profile_progress_linechart.startAnimation();
    }
}
