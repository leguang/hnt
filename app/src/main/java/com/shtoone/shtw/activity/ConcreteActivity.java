package com.shtoone.shtw.activity;

import android.animation.Animator;
import android.os.Build;
import android.os.Bundle;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.shtoone.shtw.BaseApplication;
import com.shtoone.shtw.R;
import com.shtoone.shtw.activity.base.BaseActivity;
import com.shtoone.shtw.event.EventData;
import com.shtoone.shtw.fragment.concreteactivity.MaterialStatisticFragment;
import com.shtoone.shtw.fragment.concreteactivity.OverproofFragment;
import com.shtoone.shtw.fragment.concreteactivity.ProduceQueryFragment;

import java.util.ArrayList;

import me.yokeyword.fragmentation.SupportFragment;

public class ConcreteActivity extends BaseActivity {
    private static final String TAG = ConcreteActivity.class.getSimpleName();
    private ArrayList<AHBottomNavigationItem> bottomNavigationItems = new ArrayList<>();
    private AHBottomNavigation bottomNavigation;
    private int bottomNavigationPreposition = 0;
    private SupportFragment[] mFragments = new SupportFragment[3];
    private FrameLayout fl_container;
    private String itemFromSG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concrete);
        itemFromSG = getIntent().getStringExtra("SG");

        if (savedInstanceState == null) {
            mFragments[0] = ProduceQueryFragment.newInstance();
            mFragments[1] = OverproofFragment.newInstance();
            mFragments[2] = MaterialStatisticFragment.newInstance();
            int showPosition = 0;
            loadMultipleRootFragment(R.id.fl_container_concrete_activity, showPosition, mFragments[0], mFragments[1], mFragments[2]);
        } else {
            mFragments[0] = findFragment(ProduceQueryFragment.class);
            mFragments[1] = findFragment(OverproofFragment.class);
            mFragments[2] = findFragment(MaterialStatisticFragment.class);
        }

        initView();
        initData();
    }

    private void initView() {
        bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation_concrete_activity);
        fl_container = (FrameLayout) findViewById(R.id.fl_container_concrete_activity);
    }

    public void initData() {
        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.produce_query, R.drawable.ic_search_white_18dp, R.color.white);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.overproof, R.drawable.ic_overproof, R.color.material_green_100);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.material_statistic, R.drawable.ic_statistic, R.color.material_yellow_100);
        bottomNavigationItems.add(item1);
        bottomNavigationItems.add(item2);
        bottomNavigationItems.add(item3);
        bottomNavigation.addItems(bottomNavigationItems);
        bottomNavigation.setDefaultBackgroundColor(getResources().getColor(R.color.white));
        bottomNavigation.setBehaviorTranslationEnabled(false);
        bottomNavigation.setColored(true);
        bottomNavigation.setForceTint(false);
        bottomNavigation.setAccentColor(getResources().getColor(R.color.base_color));
        bottomNavigation.setInactiveColor(getResources().getColor(R.color.gray));
        bottomNavigation.setForceTitlesDisplay(true);

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, final boolean wasSelected) {
                showHideFragment(mFragments[position], mFragments[bottomNavigationPreposition]);
                bottomNavigationPreposition = position;
                if (wasSelected) {
                    BaseApplication.bus.post(new EventData(position));
                }

                fl_container.post(new Runnable() {
                    @Override
                    public void run() {
                        if (!wasSelected && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            int cx = (fl_container.getLeft() + fl_container.getRight()) / 2;
                            int cy = fl_container.getBottom();
                            int radius = Math.max(fl_container.getWidth(), fl_container.getHeight());
                            Animator mAnimator = ViewAnimationUtils.createCircularReveal(fl_container, cx, cy, 0, radius);
                            mAnimator.setDuration(300);
                            mAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                            mAnimator.start();
                        }
                    }
                });

            }
        });

        int currentItem = 0;
        if ("SG".equals(BaseApplication.mUserInfoData.getType())) {
            switch (itemFromSG) {
                case "producequery":
                    currentItem = 0;
                    break;

                case "overproof":
                    currentItem = 1;
                    break;

                case "statistic":
                    currentItem = 2;
                    break;
            }
        }

        bottomNavigation.setCurrentItem(currentItem);
    }
}
