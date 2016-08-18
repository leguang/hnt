package com.shtoone.shtw.activity.base;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import com.android.volley.VolleyError;
import com.sdsmdg.tastytoast.TastyToast;
import com.shtoone.shtw.R;
import com.shtoone.shtw.ui.PageStateLayout;
import com.shtoone.shtw.utils.ActivityManagerUtils;
import com.shtoone.shtw.utils.ConstantsUtils;
import com.shtoone.shtw.utils.DisplayUtils;
import com.shtoone.shtw.utils.HttpUtils;
import com.shtoone.shtw.utils.NetworkUtils;
import com.socks.library.KLog;
import com.umeng.analytics.MobclickAgent;

import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.header.StoreHouseHeader;
import in.srain.cube.views.ptr.indicator.PtrIndicator;
import me.yokeyword.fragmentation.SwipeBackLayout;
import me.yokeyword.fragmentation.anim.FragmentAnimator;
import me.yokeyword.fragmentation_swipeback.SwipeBackActivity;


public abstract class BaseActivity extends SwipeBackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //把每一个Activity加入栈中
        ActivityManagerUtils.getInstance().addActivity(this);

        if (!NetworkUtils.isConnected(getApplicationContext())) {
            View view = getWindow().getDecorView();
            Snackbar mSnackbar = Snackbar.make(view, "当前网络已断开！", Snackbar.LENGTH_LONG)
                    .setAction("设置网络", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // 跳转到系统的网络设置界面
                            NetworkUtils.openSetting(BaseActivity.this);
                        }
                    });
            View v = mSnackbar.getView();
            v.setBackgroundColor(Color.parseColor("#FFCC00"));
            mSnackbar.show();
        }
        if (Build.VERSION_CODES.KITKAT <= Build.VERSION.SDK_INT) {
            // 透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        getSwipeBackLayout().setEdgeOrientation(SwipeBackLayout.EDGE_LEFT);
    }

    protected void initToolbarBackNavigation(Toolbar toolbar) {
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    protected void initToolbarMenu(Toolbar toolbar) {
        toolbar.inflateMenu(R.menu.menu_hierarchy);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_hierarchy:
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean swipeBackPriority() {
        return true;
    }

    @Override
    protected FragmentAnimator onCreateFragmentAnimator() {
        return new FragmentAnimator(android.R.anim.fade_in, android.R.anim.fade_out, 0, 0);
    }

    public void initPageStateLayout(final PageStateLayout mPageStateLayout) {
        if (null == mPageStateLayout) return;

        mPageStateLayout.setOnRetryClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPageStateLayout.showLoading();
                refresh();
            }
        });

        mPageStateLayout.setOnNetErrorClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPageStateLayout.showEmpty();
                NetworkUtils.openSetting(BaseActivity.this);
            }
        });
    }

    public void initPtrFrameLayout(final PtrFrameLayout mPtrFrameLayout) {
        if (null == mPtrFrameLayout) return;

        // 下拉刷新头部
        final StoreHouseHeader ptrHeader = new StoreHouseHeader(this);
        final String[] mStringList = {ConstantsUtils.DOMAIN_1, ConstantsUtils.DOMAIN_2};
        ptrHeader.setTextColor(Color.BLACK);
        ptrHeader.setPadding(0, DisplayUtils.dp2px(15), 0, 0);
        ptrHeader.initWithString(mStringList[0]);
        mPtrFrameLayout.addPtrUIHandler(new PtrUIHandler() {
            private int mLoadTime = 0;

            @Override
            public void onUIReset(PtrFrameLayout frame) {
                mLoadTime++;
                String string = mStringList[mLoadTime % mStringList.length];
                ptrHeader.initWithString(string);
            }

            @Override
            public void onUIRefreshPrepare(PtrFrameLayout frame) {
                String string = mStringList[mLoadTime % mStringList.length];
            }

            @Override
            public void onUIRefreshBegin(PtrFrameLayout frame) {

            }

            @Override
            public void onUIRefreshComplete(PtrFrameLayout frame) {

            }

            @Override
            public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator) {

            }
        });
        mPtrFrameLayout.setHeaderView(ptrHeader);
        mPtrFrameLayout.addPtrUIHandler(ptrHeader);
        mPtrFrameLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPtrFrameLayout.autoRefresh(true);
            }
        }, 100);
        mPtrFrameLayout.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return isCanDoRefresh();

            }

            @Override
            public void onRefreshBegin(final PtrFrameLayout frame) {
                refresh();
                frame.refreshComplete();
            }
        });
    }

    public void refresh() {
        String URL = createRefreshULR();

        //联网获取数据
        //还没有判断url，用户再判断
        HttpUtils.getRequest(URL, new HttpUtils.HttpListener() {
            @Override
            public void onSuccess(String response) {
                KLog.json(response);
                onRefreshSuccess(response);
            }

            @Override
            public void onFailed(VolleyError error) {
                KLog.d(error);
                onRefreshFailed(error);
            }
        });
    }

    public void onRefreshSuccess(String response) {
    }

    public void onRefreshFailed(VolleyError error) {
    }

    public void loadMore() {
        String URL = createLoadMoreULR();

        //联网获取数据
        //还没有判断url，用户再判断
        HttpUtils.getRequest(URL, new HttpUtils.HttpListener() {
            @Override
            public void onSuccess(String response) {
                KLog.json(response);
                loadMoreSuccess(response);
            }

            @Override
            public void onFailed(VolleyError error) {
                KLog.d(error);
                loadMoreFailed(error);
            }
        });
    }

    public void loadMoreSuccess(String response) {
    }

    public void loadMoreFailed(VolleyError error) {
        if (!NetworkUtils.isConnected(this)) {
            //提示网络异常,让用户点击设置网络，
            View view = getWindow().getDecorView();
            Snackbar.make(view, "当前网络已断开！", Snackbar.LENGTH_LONG)
                    .setAction("设置网络", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // 跳转到系统的网络设置界面
                            NetworkUtils.openSetting(BaseActivity.this);
                        }
                    }).show();
        } else {
            //服务器异常，展示错误页面，点击刷新
            TastyToast.makeText(getApplicationContext(), "服务器异常!", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
        }
    }

    public boolean isCanDoRefresh() {
        return true;
    }

    public String createRefreshULR() {
        return null;
    }

    public String createLoadMoreULR() {
        return null;
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //把每一个Activity弹出栈
        ActivityManagerUtils.getInstance().removeActivity(this);
    }
}
