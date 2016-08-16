package com.shtoone.shtw.activity;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.shtoone.shtw.R;
import com.shtoone.shtw.activity.base.BaseActivity;
import com.shtoone.shtw.utils.ConstantsUtils;
import com.shtoone.shtw.utils.SharedPreferencesUtils;


public class GuideActivity extends BaseActivity {
    private static final String TAG = GuideActivity.class.getSimpleName();
    private Button bt_guide;
    private ViewPager mViewPager;
    private FrameLayout fl_container;
    private int[] resouces = {R.drawable.bg_welcome_0, R.drawable.bg_welcome_1, R.drawable.bg_welcome_2};
    private ArgbEvaluator mArgbEvaluator = new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
        initDate();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.vp_guide_activity);
        fl_container = (FrameLayout) findViewById(R.id.fl_container_guide_activity);
        bt_guide = (Button) findViewById(R.id.bt_guide_activity);
    }

    private void initDate() {
        mViewPager.setAdapter(new GuideViewPagerAdapter());
        bt_guide.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferencesUtils.put(GuideActivity.this, ConstantsUtils.ISFIRSTENTRY, false);
                // 页面跳转
                Intent intent = new Intent(GuideActivity.this, LoginActivity.class);
                startActivity(intent);
                // 结束自己
                finish();
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int evaluate;
                switch (position) {
                    case 0:
                        bt_guide.setVisibility(View.GONE);
                        evaluate = (Integer) mArgbEvaluator.evaluate(positionOffset, 0XFF76C5F0, 0XFF052CB8);
                        fl_container.setBackgroundColor(evaluate);
                        break;
                    case 1:
                        bt_guide.setVisibility(View.GONE);
                        evaluate = (Integer) mArgbEvaluator.evaluate(positionOffset, 0XFF052CB8, 0XFFFFFFFF);
                        fl_container.setBackgroundColor(evaluate);
                        break;
                    case 2:
                        bt_guide.setVisibility(View.VISIBLE);
                        break;
                }

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    class GuideViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            if (resouces != null) {
                return resouces.length;
            }
            return 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            View view = View.inflate(GuideActivity.this, R.layout.item_viewpager_guide_activity, null);
            FrameLayout fl_container = (FrameLayout) view.findViewById(R.id.fl_container_item_viewpager_guide_activity);
            fl_container.setBackgroundResource(resouces[position]);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

    }

    @Override
    public boolean swipeBackPriority() {
        return false;
    }
}
