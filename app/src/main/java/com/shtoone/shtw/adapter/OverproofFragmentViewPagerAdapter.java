package com.shtoone.shtw.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.shtoone.shtw.BaseApplication;
import com.shtoone.shtw.bean.ParametersData;
import com.shtoone.shtw.fragment.concreteactivity.OverproofFragmentViewPagerFragment;
import com.shtoone.shtw.utils.ConstantsUtils;
import com.socks.library.KLog;
import com.squareup.otto.Subscribe;

/**
 * Created by leguang on 2016/6/9 0009.
 */
public class OverproofFragmentViewPagerAdapter extends FragmentPagerAdapter {
    private static final String TAG = OverproofFragmentViewPagerAdapter.class.getSimpleName();
    private String[] tabTitles = {"初级", "中级", "高级"};
    private ParametersData mParametersData;
    private boolean isRegistered = false;

    public OverproofFragmentViewPagerAdapter(FragmentManager fm, ParametersData mParametersData) {
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
                mParametersData.alarmLevel = "1";
                break;
            case 1:
                mParametersData.alarmLevel = "2";
                break;
            case 2:
                mParametersData.alarmLevel = "3";
                break;
        }

        return OverproofFragmentViewPagerFragment.newInstance(mParametersData);
    }

    @Override
    public int getCount() {
        if (null != tabTitles) {
            return tabTitles.length;
        }
        return 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (null != tabTitles) {
            return tabTitles[position];
        }
        return null;
    }

    @Subscribe
    public void updateSearch(ParametersData mParametersData) {
        if (mParametersData != null) {
            if (mParametersData.fromTo == ConstantsUtils.OVERPROOFFRAGMENT) {
                this.mParametersData.startDateTime = mParametersData.startDateTime;
                this.mParametersData.endDateTime = mParametersData.endDateTime;
                this.mParametersData.equipmentID = mParametersData.equipmentID;
                this.mParametersData.handleType = mParametersData.handleType;
                KLog.e("mParametersData:" + mParametersData.startDateTime);
                KLog.e("mParametersData:" + mParametersData.endDateTime);
                KLog.e("mParametersData:" + mParametersData.equipmentID);
                KLog.e("mParametersData:" + mParametersData.handleType);
            }
        }
    }

    public void unRegister() {
        BaseApplication.bus.unregister(this);
    }
}
