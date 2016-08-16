package com.shtoone.shtw.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.shtoone.shtw.BaseApplication;
import com.shtoone.shtw.bean.ParametersData;
import com.shtoone.shtw.fragment.laboratoryactivity.WannengjiFragmentViewPagerFragment;
import com.shtoone.shtw.utils.ConstantsUtils;
import com.socks.library.KLog;
import com.squareup.otto.Subscribe;

/**
 * Created by leguang on 2016/6/9 0009.
 */
public class WannengjiFragmentViewPagerAdapter extends FragmentPagerAdapter {
    private static final String TAG = WannengjiFragmentViewPagerAdapter.class.getSimpleName();
    private String[] titleType = {"不合格", "合格", "未处置", "已处置"};
    private ParametersData mParametersData;
    private boolean isRegistered = false;

    public WannengjiFragmentViewPagerAdapter(FragmentManager fm, ParametersData mParametersData) {
        super(fm);
        this.mParametersData = mParametersData;

        if (!isRegistered) {
            BaseApplication.bus.register(this);
            isRegistered = true;
        }
    }

    @Override
    public Fragment getItem(int position) {
        ParametersData mParametersData = (ParametersData) this.mParametersData.clone();

        switch (position) {
            case 0:
                mParametersData.isQualified = "0";
                mParametersData.isReal = "0";
                break;
            case 1:
                mParametersData.isQualified = "1";
                mParametersData.isReal = "0";
                break;
            case 2:
                mParametersData.isQualified = "0";
                mParametersData.isReal = "1";
                break;
            case 3:
                mParametersData.isQualified = "0";
                mParametersData.isReal = "2";
                break;
        }
        return WannengjiFragmentViewPagerFragment.newInstance(mParametersData);
    }

    @Override
    public int getCount() {
        if (null != titleType) {
            return titleType.length;
        }
        return 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (null != titleType) {
            return titleType[position];
        }
        return null;
    }

    @Subscribe
    public void updateSearch(ParametersData mParametersData) {
        if (mParametersData != null) {
            if (mParametersData.fromTo == ConstantsUtils.WANNENGJIFRAGMENT) {
                this.mParametersData.startDateTime = mParametersData.startDateTime;
                this.mParametersData.endDateTime = mParametersData.endDateTime;
                this.mParametersData.equipmentID = mParametersData.equipmentID;
                this.mParametersData.testTypeID = mParametersData.testTypeID;
                KLog.e("mParametersData:" + mParametersData.startDateTime);
                KLog.e("mParametersData:" + mParametersData.endDateTime);
                KLog.e("mParametersData:" + mParametersData.equipmentID);
                KLog.e("mParametersData:" + mParametersData.testTypeID);
            }
        }
    }

    public void unRegister() {
        BaseApplication.bus.unregister(this);
    }
}
