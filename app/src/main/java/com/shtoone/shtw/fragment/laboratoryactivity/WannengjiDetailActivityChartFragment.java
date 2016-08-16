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
import com.shtoone.shtw.bean.WannengjiDetailActivityChartFragmentData;
import com.shtoone.shtw.fragment.base.BaseFragment;
import com.shtoone.shtw.ui.MyMarkerView;

import java.util.ArrayList;

/**
 * Created by leguang on 2016/6/11.
 */
public class WannengjiDetailActivityChartFragment extends BaseFragment {
    private static final String TAG = WannengjiDetailActivityChartFragment.class.getSimpleName();
    private WannengjiDetailActivityChartFragmentData data;
    private LineChart mLineChart;
    private TextView tv0;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;

    public static WannengjiDetailActivityChartFragment newInstance(WannengjiDetailActivityChartFragmentData data) {
        Bundle args = new Bundle();
        args.putSerializable("WannengjiDetailActivityChartFragmentData", data);
        WannengjiDetailActivityChartFragment fragment = new WannengjiDetailActivityChartFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            data = (WannengjiDetailActivityChartFragmentData) args.getSerializable("WannengjiDetailActivityChartFragmentData");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chart_wannengji_detail_activity, container, false);
        initView(view);
        initData();
        return view;
    }


    private void initView(View view) {
        tv0 = (TextView) view.findViewById(R.id.tv0_fragment_chart_wannengji_detail_activity);
        tv1 = (TextView) view.findViewById(R.id.tv1_fragment_chart_wannengji_detail_activity);
        tv2 = (TextView) view.findViewById(R.id.tv2_fragment_chart_wannengji_detail_activity);
        tv3 = (TextView) view.findViewById(R.id.tv3_fragment_chart_wannengji_detail_activity);
        tv4 = (TextView) view.findViewById(R.id.tv4_fragment_chart_wannengji_detail_activity);
        mLineChart = (LineChart) view.findViewById(R.id.lineChart_fragment_chart_wannengji_detail_activity);
        setChart();
    }

    private void initData() {
        tv0.setText(data.getData1());
        tv1.setText(data.getData2());
        tv2.setText(data.getData3());
        tv3.setText(data.getData4());
        tv4.setText(data.getData5());
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
        mLineDataSet.setCircleRadius(0f);
        mLineDataSet.setHighLightColor(Color.BLACK);
        mLineDataSet.setDrawCircleHole(true);
        mLineDataSet.setValueTextSize(7f);
        mLineDataSet.setDrawFilled(true);
        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(mLineDataSet);
        LineData data = new LineData(xVals, dataSets);
        mLineChart.setData(data);
    }
}
