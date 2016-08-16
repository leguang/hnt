package com.shtoone.shtw.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.shtoone.shtw.bean.WannengjiDetailActivityChartFragmentData;
import com.shtoone.shtw.bean.WannengjiDetailData;
import com.shtoone.shtw.fragment.laboratoryactivity.WannengjiDetailActivityChartFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leguang on 2016/6/9 0009.
 */
public class WannengjiDetailActivityChartViewPagerAdapter extends FragmentPagerAdapter {
    private static final String TAG = WannengjiDetailActivityChartViewPagerAdapter.class.getSimpleName();
    private String[] mTitles;
    private List<WannengjiDetailActivityChartFragmentData> listDatas;

    public WannengjiDetailActivityChartViewPagerAdapter(FragmentManager fm, WannengjiDetailData mWannengjiDetailData) {
        super(fm);
        if (null != mWannengjiDetailData) {
            String[] arr_lz = mWannengjiDetailData.getData().getLZ().split("&");
            String[] arr_lzqd = mWannengjiDetailData.getData().getLZQD().split("&");
            String[] arr_qflz = mWannengjiDetailData.getData().getQFLZ().split("&");
            String[] arr_qfqd = mWannengjiDetailData.getData().getQFQD().split("&");
            String[] arr_scl = mWannengjiDetailData.getData().getSCL().split("&");
            String[] arrx = mWannengjiDetailData.getData().getF_SJ().split("&");
            String[] arry = mWannengjiDetailData.getData().getF_LZ().split("&");
            listDatas = new ArrayList<WannengjiDetailActivityChartFragmentData>();
            if (arrx.length > 0) {
                mTitles = new String[arrx.length];
            }
            String lz = "";
            String lzqd = "";
            String qflz = "";
            String qfqd = "";
            String scl = "";
            String title = "曲线图";

            for (int i = 0; i < arrx.length; i++) {
                mTitles[i] = title + (i + 1);
                if (arr_lz.length >= arrx.length) {
                    lz = arr_lz[i];
                }

                if (arr_lzqd.length >= arrx.length) {
                    lzqd = arr_lzqd[i];
                }

                if (arr_qflz.length >= arrx.length) {
                    qflz = arr_qflz[i];
                }

                if (arr_qfqd.length >= arrx.length) {
                    qfqd = arr_qfqd[i];
                }

                if (arr_scl.length >= arrx.length) {
                    scl = arr_scl[i];
                }

                String[] x = arrx[i].split(",");
                String[] y = arry[i].split(",");
                listDatas.add(new WannengjiDetailActivityChartFragmentData(lz, lzqd, qflz, qfqd, scl, x, y));
            }
        }
    }

    @Override
    public Fragment getItem(int position) {
        return WannengjiDetailActivityChartFragment.newInstance(listDatas.get(position));
    }


    @Override
    public int getCount() {
        if (null != mTitles) {
            return mTitles.length;
        } else {
            return 0;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (null != mTitles) {
            return mTitles[position];
        } else {
            return "";
        }
    }
}
