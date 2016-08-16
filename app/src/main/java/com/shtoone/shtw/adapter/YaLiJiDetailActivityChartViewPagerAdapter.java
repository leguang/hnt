package com.shtoone.shtw.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.shtoone.shtw.bean.YaLiJiDetailActivityChartFragmentData;
import com.shtoone.shtw.bean.YalijiDetailData;
import com.shtoone.shtw.fragment.laboratoryactivity.YaLiJiDetailActivityChartFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leguang on 2016/6/9 0009.
 */
public class YaLiJiDetailActivityChartViewPagerAdapter extends FragmentPagerAdapter {
    private static final String TAG = YaLiJiDetailActivityChartViewPagerAdapter.class.getSimpleName();
    private String[] mTitles;
    private List<YaLiJiDetailActivityChartFragmentData> listDatas;

    public YaLiJiDetailActivityChartViewPagerAdapter(FragmentManager fm, YalijiDetailData mYalijiDetailData) {
        super(fm);

        String[] arr_hz = mYalijiDetailData.getData().getKYLZ().split("&");
        String[] arr_qd = mYalijiDetailData.getData().getKYQD().split("&");
        String[] arrx = mYalijiDetailData.getData().getF_SJ().split("&");
        String[] arry = mYalijiDetailData.getData().getF_LZ().split("&");
        listDatas = new ArrayList<YaLiJiDetailActivityChartFragmentData>();
        mTitles = new String[arrx.length];
        for (int i = 0; i < arrx.length; i++) {
            mTitles[i] = "曲线图" + (i + 1);
            String hz = arr_hz[i];
            String qd = arr_qd[i];
            String[] x = arrx[i].split(",");
            String[] y = arry[i].split(",");
            listDatas.add(new YaLiJiDetailActivityChartFragmentData(hz, qd, x, y));
        }
    }

    @Override
    public Fragment getItem(int position) {
        return YaLiJiDetailActivityChartFragment.newInstance(listDatas.get(position));
    }


    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
