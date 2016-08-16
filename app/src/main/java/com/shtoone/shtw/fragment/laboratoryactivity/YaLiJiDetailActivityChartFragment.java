package com.shtoone.shtw.fragment.laboratoryactivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.shtoone.shtw.R;
import com.shtoone.shtw.bean.YaLiJiDetailActivityChartFragmentData;
import com.shtoone.shtw.fragment.base.BaseFragment;
import com.shtoone.shtw.ui.MyMarkerView;

import java.util.ArrayList;

import me.yokeyword.fragmentation.anim.FragmentAnimator;

/**
 * Created by leguang on 2016/6/11.
 */
public class YaLiJiDetailActivityChartFragment extends BaseFragment {
    private static final String TAG = "YaLiJiDetailActivityChartFragment";
    private YaLiJiDetailActivityChartFragmentData data;
    private LineChart mLineChart;
    private TextView tv_hz;
    private TextView tv_qd;

    public static YaLiJiDetailActivityChartFragment newInstance(YaLiJiDetailActivityChartFragmentData data) {
        Bundle args = new Bundle();
        args.putSerializable("YaLiJiDetailActivityChartFragmentData", data);
        YaLiJiDetailActivityChartFragment fragment = new YaLiJiDetailActivityChartFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            data = (YaLiJiDetailActivityChartFragmentData) args.getSerializable("YaLiJiDetailActivityChartFragmentData");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chart_yaliji_detail_activity, container, false);
        initView(view);
        initData();
        return view;
    }


    private void initView(View view) {
        tv_hz = (TextView) view.findViewById(R.id.tv_hz_fragment_chart_yaliji_detail_activity);
        tv_qd = (TextView) view.findViewById(R.id.tv_qd_fragment_chart_yaliji_detail_activity);
        mLineChart = (LineChart) view.findViewById(R.id.lineChart_fragment_chart_yaliji_detail_activity);
        setChart();
    }

    private void initData() {
        tv_hz.setText(data.getData1());
        tv_qd.setText(data.getData2());
        setChartData();
    }


    private void setChart() {
        mLineChart.setDescription("");
        mLineChart.setDrawGridBackground(true);
        mLineChart.setNoDataTextDescription("暂无数据表……");
        mLineChart.setTouchEnabled(true);
        mLineChart.setDragEnabled(true);
        mLineChart.setScaleEnabled(true);
        mLineChart.setPinchZoom(true);
        mLineChart.animateX(1500);
        mLineChart.getAxisRight().setEnabled(false);

        MyMarkerView mv = new MyMarkerView(_mActivity, R.layout.custom_marker_view);
        mLineChart.setMarkerView(mv);

        Typeface tf = Typeface.createFromAsset(_mActivity.getAssets(), "OpenSans-Light.ttf");
        Legend l = mLineChart.getLegend();
        l.setTypeface(tf);
        YAxis leftAxis = mLineChart.getAxisLeft();
        leftAxis.setTypeface(tf);
        leftAxis.setAxisMinValue(0f);
        leftAxis.removeAllLimitLines();
        leftAxis.setTypeface(tf);
        leftAxis.setTextColor(Color.RED);

        XAxis xAxis = mLineChart.getXAxis();
        xAxis.setEnabled(true);
        xAxis.setTypeface(tf);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextColor(Color.BLUE);
    }

    private void setChartData() {
        ArrayList<String> xVals = new ArrayList<String>();
        String[] x = data.getX();
        for (int i = 0; i < x.length; i++) {
            xVals.add(x[i]);
        }

        ArrayList<Entry> yVals = new ArrayList<Entry>();
        String[] y = data.getY();
        for (int i = 0; i < y.length; i++) {
            yVals.add(new Entry(Float.parseFloat(y[i]), i));
        }

        LineDataSet mLineDataSet = new LineDataSet(yVals, "曲线图");

        if (Utils.getSDKInt() >= 18) {
            Drawable drawable = ContextCompat.getDrawable(_mActivity, R.drawable.fade_red);
            mLineDataSet.setFillDrawable(drawable);
        }
        //设置样式
        mLineDataSet.enableDashedLine(10f, 5f, 0f);
        mLineDataSet.enableDashedHighlightLine(10f, 5f, 0f);
        mLineDataSet.setColor(Color.BLACK);
        mLineDataSet.setCircleColor(Color.BLUE);
        mLineDataSet.setLineWidth(1f);
        mLineDataSet.setCircleRadius(2f);
        mLineDataSet.setHighLightColor(Color.BLACK);
        mLineDataSet.setDrawCircleHole(true);
        mLineDataSet.setValueTextSize(7f);
        mLineDataSet.setDrawFilled(true);
        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(mLineDataSet);
        LineData data = new LineData(xVals, dataSets);
        mLineChart.setData(data);
    }

    @Override
    protected FragmentAnimator onCreateFragmentAnimator() {
        return new FragmentAnimator(0, 0, 0, 0);
    }
}
