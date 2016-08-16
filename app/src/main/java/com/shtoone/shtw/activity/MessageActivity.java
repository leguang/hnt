package com.shtoone.shtw.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.shtoone.shtw.BaseApplication;
import com.shtoone.shtw.R;
import com.shtoone.shtw.activity.base.BaseActivity;
import com.shtoone.shtw.adapter.MessageActivityViewPagerAdapter;

/**
 * Created by leguang on 2016/6/11.
 */

public class MessageActivity extends BaseActivity {
    private static final String TAG = MessageActivity.class.getSimpleName();
    private Toolbar mToolbar;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private AppBarLayout mAppBarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        initView();
        initDate();
    }

    private void initView() {
        mAppBarLayout = (AppBarLayout) findViewById(R.id.appbar_toolbar_tablayout);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_toolbar_tablayout);
        mTabLayout = (TabLayout) findViewById(R.id.tablayout_toolbar_tablayout);
        mViewPager = (ViewPager) findViewById(R.id.vp_message_activity);
    }

    private void initDate() {
        mToolbar.setTitle("消息中心");
        initToolbarBackNavigation(mToolbar);
        mToolbar.inflateMenu(R.menu.menu_hierarchy);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_hierarchy:

                        break;
                }
                return true;
            }
        });

        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (0 == verticalOffset) {
                    BaseApplication.isExpand = true;
                } else {
                    BaseApplication.isExpand = false;
                }
            }
        });

        mViewPager.setAdapter(new MessageActivityViewPagerAdapter(getSupportFragmentManager()));
        mTabLayout.setupWithViewPager(mViewPager);
    }

}
