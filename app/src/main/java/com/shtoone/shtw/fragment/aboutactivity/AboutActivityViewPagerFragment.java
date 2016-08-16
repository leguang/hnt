package com.shtoone.shtw.fragment.aboutactivity;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.shtoone.shtw.R;
import com.shtoone.shtw.fragment.base.BaseFragment;
import com.shtoone.shtw.ui.PageStateLayout;
import com.shtoone.shtw.utils.ConstantsUtils;
import com.socks.library.KLog;

import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by leguang on 2016/6/9 0031.
 */
public class AboutActivityViewPagerFragment extends BaseFragment {
    private static final String TAG = AboutActivityViewPagerFragment.class.getSimpleName();
    private PageStateLayout mPageStateLayout;
    private PtrFrameLayout mPtrFrameLayout;
    private int aboutWhat;
    private WebView mWebView;
    private WebSettings mWebSettings;
    private String url = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            aboutWhat = args.getInt(ConstantsUtils.ABOUTWHAT);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_pager_about_activity, container, false);
        initView(view);
        initData();
        return view;
    }

    public static AboutActivityViewPagerFragment newInstance(int position) {

        Bundle args = new Bundle();
        args.putInt(ConstantsUtils.ABOUTWHAT, position);
        AboutActivityViewPagerFragment fragment = new AboutActivityViewPagerFragment();
        fragment.setArguments(args);
        return fragment;
    }


    private void initView(View view) {
        mPtrFrameLayout = (PtrFrameLayout) view.findViewById(R.id.ptr_view_pager_fragment_about_activity);
        mPageStateLayout = (PageStateLayout) view.findViewById(R.id.psl_view_pager_fragment_about_activity);
        mWebView = (WebView) view.findViewById(R.id.wv_view_pager_fragment_about_activity);
    }

    private void initData() {
        initPageStateLayout(mPageStateLayout);
        initPtrFrameLayout(mPtrFrameLayout);
        initWebView();

        if (aboutWhat == 0) {
            url = ConstantsUtils.ABOUTAPP;
        } else if (aboutWhat == 1) {
            url = ConstantsUtils.ABOUTCOMPANY;
        }
        mWebView.loadUrl(url);
    }

    @Override
    public boolean isCanDoRefresh() {
        //判断是哪种状态的页面，都让其可下拉
        KLog.e("mWebView.getScrollY():" + mWebView.getScrollY());
        if (mWebView.getScrollY() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void refresh() {
        mWebView.reload();
    }

    private void initWebView() {
        mWebSettings = mWebView.getSettings();
        mWebSettings.setJavaScriptEnabled(true);// 表示支持js
        mWebSettings.setUseWideViewPort(true);// 支持双击缩放
        mWebSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        mWebSettings.setCacheMode(WebSettings.LOAD_DEFAULT); // 设置 缓存模式
        mWebSettings.setDomStorageEnabled(true);
        String cacheDirPath = _mActivity.getCacheDir().getAbsolutePath() + "/webViewCache ";
        mWebSettings.setDatabasePath(cacheDirPath);
        mWebSettings.setDatabaseEnabled(true);
        mWebSettings.setAppCachePath(cacheDirPath);
        mWebSettings.setAppCacheEnabled(true);
        mWebSettings.setLoadWithOverviewMode(true);

        if (Build.VERSION.SDK_INT >= 19) {
            mWebSettings.setLoadsImagesAutomatically(true);
        } else {
            mWebSettings.setLoadsImagesAutomatically(false);
        }

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                mPageStateLayout.showLoading();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                mPageStateLayout.showContent();
                mWebSettings.setLoadsImagesAutomatically(true);
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                mPageStateLayout.showError();

            }

            /**
             * 所有跳转的链接都会在此方法中回调
             */
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }
}
