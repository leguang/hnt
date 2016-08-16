package com.shtoone.shtw.activity;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.shtoone.shtw.BaseApplication;
import com.shtoone.shtw.R;
import com.shtoone.shtw.activity.base.BaseActivity;
import com.shtoone.shtw.adapter.ProduceQueryDetailActivityRecyclerViewAdapter;
import com.shtoone.shtw.bean.ProduceQueryDetailActivityData;
import com.shtoone.shtw.bean.ProduceQueryFragmentListData;
import com.shtoone.shtw.ui.PageStateLayout;
import com.shtoone.shtw.utils.NetworkUtils;
import com.shtoone.shtw.utils.URL;

import org.json.JSONException;
import org.json.JSONObject;

import in.srain.cube.views.ptr.PtrFrameLayout;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInLeftAnimationAdapter;


public class ProduceQueryDetailActivity extends BaseActivity {
    private static final String TAG = ProduceQueryDetailActivity.class.getSimpleName();
    private Toolbar mToolbar;
    private NestedScrollView mNestedScrollView;
    private PageStateLayout mPageStateLayout;
    private PtrFrameLayout mPtrFrameLayout;
    private ProduceQueryDetailActivityData data;
    private TextView tv0;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private TextView tv6;
    private TextView tv7;
    private TextView tv8;
    private TextView tv9;
    private TextView tv10;
    private TextView tv11;
    private TextView tv12;
    private RecyclerView mRecyclerView;
    private ProduceQueryDetailActivityRecyclerViewAdapter mAdapter;
    private ProduceQueryFragmentListData.DataBean mDataBean;
    private Gson mGson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produce_query_detail);
        initView();
        initDate();
    }

    private void initView() {
        mDataBean = (ProduceQueryFragmentListData.DataBean) getIntent().getSerializableExtra("producequerydetail");
        mToolbar = (Toolbar) findViewById(R.id.toolbar_toolbar);
        mNestedScrollView = (NestedScrollView) findViewById(R.id.nsv_produce_query_detail_activity);
        mPtrFrameLayout = (PtrFrameLayout) findViewById(R.id.ptr_produce_query_detail_activity);
        mPageStateLayout = (PageStateLayout) findViewById(R.id.psl_produce_query_detail_activity);
        tv0 = (TextView) findViewById(R.id.tv0_produce_query_detail_activity);
        tv1 = (TextView) findViewById(R.id.tv1_produce_query_detail_activity);
        tv2 = (TextView) findViewById(R.id.tv2_produce_query_detail_activity);
        tv3 = (TextView) findViewById(R.id.tv3_produce_query_detail_activity);
        tv4 = (TextView) findViewById(R.id.tv4_produce_query_detail_activity);
        tv5 = (TextView) findViewById(R.id.tv5_produce_query_detail_activity);
        tv6 = (TextView) findViewById(R.id.tv6_produce_query_detail_activity);
        tv7 = (TextView) findViewById(R.id.tv7_produce_query_detail_activity);
        tv8 = (TextView) findViewById(R.id.tv8_produce_query_detail_activity);
        tv9 = (TextView) findViewById(R.id.tv9_produce_query_detail_activity);
        tv10 = (TextView) findViewById(R.id.tv10_produce_query_detail_activity);
        tv11 = (TextView) findViewById(R.id.tv11_produce_query_detail_activity);
        tv12 = (TextView) findViewById(R.id.tv12_produce_query_detail_activity);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_produce_query_detail_activity);
    }

    private void initDate() {
        mGson = new Gson();
        setToolbarTitle();
        initToolbarBackNavigation(mToolbar);
        setSupportActionBar(mToolbar);
        initPageStateLayout(mPageStateLayout);
        initPtrFrameLayout(mPtrFrameLayout);
    }

    @Override
    public boolean isCanDoRefresh() {
        //判断是哪种状态的页面，都让其可下拉
        if (mNestedScrollView.getScrollY() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public String createRefreshULR() {
        mPageStateLayout.showLoading();
        return URL.getProduceDetailData(mDataBean.getId());
    }

    @Override
    public void onRefreshSuccess(String response) {
        if (!TextUtils.isEmpty(response)) {
            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(response);
            } catch (JSONException e) {
                e.printStackTrace();
                mPageStateLayout.showError();
                return;
            }
            if (jsonObject.optBoolean("success")) {
                data = mGson.fromJson(response, ProduceQueryDetailActivityData.class);
                if (null != data) {
                    if (data.isSuccess()) {
                        mPageStateLayout.showContent();
                        setAdapter();
                    } else {
                        //提示数据为空，展示空状态
                        mPageStateLayout.showEmpty();
                    }
                } else {
                    //提示数据解析异常，展示错误页面
                    mPageStateLayout.showError();
                }
            } else {
                //提示数据为空，展示空状态
                mPageStateLayout.showEmpty();
            }
        } else {
            //提示返回数据异常，展示错误页面
            mPageStateLayout.showError();
        }
    }

    @Override
    public void onRefreshFailed(VolleyError error) {
        //提示网络数据异常，展示网络错误页面。此时：1.可能是本机网络有问题，2.可能是服务器问题
        if (!NetworkUtils.isConnected(this)) {
            //提示网络异常,让用户点击设置网络
            mPageStateLayout.showNetError();
        } else {
            //服务器异常，展示错误页面，点击刷新
            mPageStateLayout.showError();
        }
    }

    //还是不能这样搞，可能会内存泄漏，重复创建Adapyer对象。后面解决
    private void setAdapter() {
        // 设置显示数据
        tv0.setText(data.getHeadMsg().getGujifangshu());//数量
        tv1.setText(data.getHeadMsg().getBanhezhanminchen());//拌合站名称
        tv2.setText(data.getHeadMsg().getGongdanhao());//工单号
        tv3.setText(data.getHeadMsg().getChaozuozhe());//操作者
        tv4.setText(data.getHeadMsg().getChuliaoshijian());//出料时间
        tv5.setText(data.getHeadMsg().getJiaobanshijian());//搅拌时长
        tv6.setText(data.getHeadMsg().getGongchengmingcheng());//工程名称
        tv7.setText(data.getHeadMsg().getSigongdidian());//地点里程
        tv8.setText(data.getHeadMsg().getJiaozuobuwei());//浇筑部位
        tv9.setText(data.getHeadMsg().getShuinipingzhong());//水泥品牌
        tv10.setText(data.getHeadMsg().getQiangdudengji());//强度等级
        tv11.setText(data.getHeadMsg().getWaijiajipingzhong());//外加剂品牌
        tv12.setText(data.getHeadMsg().getPeifanghao());//施工配比编号

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //设置动画与适配器
        SlideInLeftAnimationAdapter mSlideInLeftAnimationAdapter = new SlideInLeftAnimationAdapter(mAdapter = new ProduceQueryDetailActivityRecyclerViewAdapter(this, data.getData()));
        mSlideInLeftAnimationAdapter.setFirstOnly(true);
        mSlideInLeftAnimationAdapter.setDuration(500);
        mSlideInLeftAnimationAdapter.setInterpolator(new OvershootInterpolator(.5f));
        ScaleInAnimationAdapter mScaleInAnimationAdapter = new ScaleInAnimationAdapter(mSlideInLeftAnimationAdapter);
        mScaleInAnimationAdapter.setFirstOnly(true);
        mRecyclerView.setAdapter(mScaleInAnimationAdapter);
    }

    private void setToolbarTitle() {
        if (null != mToolbar && null != BaseApplication.mDepartmentData && !TextUtils.isEmpty(BaseApplication.mDepartmentData.departmentName)) {
            StringBuffer sb = new StringBuffer(BaseApplication.mDepartmentData.departmentName + " > ");
            sb.append(getString(R.string.banhezhan) + " > ");
            sb.append(getString(R.string.produce_query) + " > ");
            sb.append(getString(R.string.detail)).trimToSize();
            mToolbar.setTitle(sb.toString());
        }
    }
}
