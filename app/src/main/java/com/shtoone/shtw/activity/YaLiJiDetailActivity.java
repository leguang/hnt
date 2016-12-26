package com.shtoone.shtw.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.sdsmdg.tastytoast.TastyToast;
import com.shtoone.shtw.BaseApplication;
import com.shtoone.shtw.R;
import com.shtoone.shtw.activity.base.BaseActivity;
import com.shtoone.shtw.adapter.YaLiJiDetailActivityChartViewPagerAdapter;
import com.shtoone.shtw.bean.UserInfoData;
import com.shtoone.shtw.bean.YalijiDetailData;
import com.shtoone.shtw.bean.YalijiFragmentViewPagerFragmentRecyclerViewItemData;
import com.shtoone.shtw.event.EventData;
import com.shtoone.shtw.ui.PageStateLayout;
import com.shtoone.shtw.utils.ConstantsUtils;
import com.shtoone.shtw.utils.HttpUtils;
import com.shtoone.shtw.utils.NetworkUtils;
import com.shtoone.shtw.utils.URL;
import com.socks.library.KLog;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import in.srain.cube.views.ptr.PtrFrameLayout;


public class YaLiJiDetailActivity extends BaseActivity {
    private static final String TAG = YaLiJiDetailActivity.class.getSimpleName();
    private Toolbar mToolbar;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private NestedScrollView mNestedScrollView;
    private PageStateLayout mPageStateLayout;
    private PtrFrameLayout mPtrFrameLayout;
    private YalijiDetailData mYalijiDetailData;
    private TextView tv_datetime;
    private TextView tv_equipment;
    private TextView tv_project;
    private TextView tv_position;
    private TextView tv_testtype;
    private TextView tv_design_strength;
    private TextView tv_size;
    private TextView tv_age;
    private TextView tv_central_value;
    private TextInputLayout et_handle_reason;
    private Button bt_submit;
    private Button bt_reset;
    private UserInfoData mUserInfoData;
    private String handleReason;
    private CardView cv_handle;
    private YalijiFragmentViewPagerFragmentRecyclerViewItemData.DataBean mDataBean;
    private Gson mGson;
    private boolean isSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yaliji_detail);

        initView();
        initDate();
    }

    private void initView() {
        mDataBean = (YalijiFragmentViewPagerFragmentRecyclerViewItemData.DataBean) getIntent().getSerializableExtra("yalijidetail");
        mToolbar = (Toolbar) findViewById(R.id.toolbar_toolbar);
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout_yaliji_detail_activity);
        mNestedScrollView = (NestedScrollView) findViewById(R.id.nsv_yaliji_detail_activity);
        mViewPager = (ViewPager) findViewById(R.id.vp_yaliji_detail_activity);
        mPtrFrameLayout = (PtrFrameLayout) findViewById(R.id.ptr_yaliji_detail_activity);
        mPageStateLayout = (PageStateLayout) findViewById(R.id.psl_yaliji_detail_activity);
        tv_datetime = (TextView) findViewById(R.id.tv_datetime_yaliji_detail_activity);
        tv_equipment = (TextView) findViewById(R.id.tv_equipment_yaliji_detail_activity);
        tv_project = (TextView) findViewById(R.id.tv_project_name_yaliji_detail_activity);
        tv_position = (TextView) findViewById(R.id.tv_position_yaliji_detail_activity);
        tv_testtype = (TextView) findViewById(R.id.tv_testtype_yaliji_detail_activity);
        tv_design_strength = (TextView) findViewById(R.id.tv_design_strength_yaliji_detail_activity);
        tv_size = (TextView) findViewById(R.id.tv_size_yaliji_detail_activity);
        tv_age = (TextView) findViewById(R.id.tv_age_yaliji_detail_activity);
        tv_central_value = (TextView) findViewById(R.id.tv_central_value_yaliji_detail_activity);
        cv_handle = (CardView) findViewById(R.id.cv_handle_yaliji_detail_activity);
        et_handle_reason = (TextInputLayout) findViewById(R.id.et_handle_reason_yaliji_detail_activity);
        bt_submit = (Button) findViewById(R.id.bt_submit_yaliji_detail_activity);
        bt_reset = (Button) findViewById(R.id.bt_reset_yaliji_detail_activity);
    }

    private void initDate() {
        mGson = new Gson();
        mUserInfoData = BaseApplication.mUserInfoData;
        if ("不合格".equals(mDataBean.getPDJG()) || "无效".equals(mDataBean.getPDJG())) {
            cv_handle.setVisibility(View.VISIBLE);
            if (mUserInfoData.getQuanxian().isSyschaobiaoReal()) {
                bt_submit.setEnabled(true);
                bt_reset.setEnabled(true);
            }
        }
        setToolbarTitle();
        initToolbarBackNavigation(mToolbar);
        setSupportActionBar(mToolbar);

        et_handle_reason.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (TextUtils.isEmpty(s)) {
                    et_handle_reason.getEditText().setError("处置原因不能为空");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleReason = et_handle_reason.getEditText().getText().toString().trim();
                if (!TextUtils.isEmpty(handleReason)) {
                    //弹出对话框，确定提交
                    new MaterialDialog.Builder(YaLiJiDetailActivity.this)
                            .title("确认")
                            .content("请问您确定填写无误并提交吗？")
                            .positiveText("确定")
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                                    MaterialDialog progressDialog = new MaterialDialog.Builder(YaLiJiDetailActivity.this)
                                            .title("提交")
                                            .content("正在提交中，请稍等……")
                                            .progress(true, 0)
                                            .progressIndeterminateStyle(true)
                                            .cancelable(false)
                                            .show();
                                    submit(progressDialog);
                                }
                            })
                            .negativeText("放弃")
                            .show();
                } else {
                    et_handle_reason.getEditText().setError("处置原因不能为空");
                }
            }
        });

        bt_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //弹出对话框,确定重置
                new MaterialDialog.Builder(YaLiJiDetailActivity.this)
                        .title("确认")
                        .content("请问您确定要重置吗？那样您就要重新填写哟……")
                        .positiveText("确定")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                et_handle_reason.getEditText().setText("");
                                handleReason = "";
                                et_handle_reason.setFocusable(false);
                                TastyToast.makeText(getApplicationContext(), "已经重置!", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS);
                            }
                        })
                        .negativeText("放弃")
                        .show();
            }
        });
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
        return URL.getYalijiDetailData(mDataBean.getSYJID());
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
                mYalijiDetailData = mGson.fromJson(response, YalijiDetailData.class);
                if (null != mYalijiDetailData) {
                    if (mYalijiDetailData.isSuccess()) {
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

    private void submit(final MaterialDialog progressDialog) {
        Map<String, String> paramsMap = new HashMap<String, String>();
        paramsMap.put("SYJID", mDataBean.getSYJID());
        paramsMap.put("chaobiaoyuanyin", handleReason);

        HttpUtils.postRequest(URL.SYS_CHAOBIAO_DO_URL, paramsMap, new HttpUtils.HttpListener() {
            @Override
            public void onSuccess(String response) {
                progressDialog.dismiss();
                KLog.json(response);
                if (!TextUtils.isEmpty(response)) {
                    JSONObject jsonObject = null;
                    try {
                        jsonObject = new JSONObject(response);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        TastyToast.makeText(getApplicationContext(), "上传失败，请重试！", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                        return;
                    }

                    if (jsonObject.optBoolean("success")) {
                        TastyToast.makeText(getApplicationContext(), "上传成功!", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS);
                        isSubmit = true;
                    } else {
                        TastyToast.makeText(getApplicationContext(), "上传失败，请重试！", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                    }

                } else {
                    TastyToast.makeText(getApplicationContext(), "上传失败，请重试！", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                }
            }

            @Override
            public void onFailed(VolleyError error) {
                progressDialog.dismiss();
                if (!NetworkUtils.isConnected(YaLiJiDetailActivity.this)) {
                    //提示网络异常,让用户点击设置网络，
                    View view = YaLiJiDetailActivity.this.getWindow().getDecorView();
                    Snackbar.make(view, "当前网络已断开！", Snackbar.LENGTH_LONG)
                            .setAction("设置网络", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    // 跳转到系统的网络设置界面
                                    NetworkUtils.openSetting(YaLiJiDetailActivity.this);
                                }
                            }).show();
                } else {
                    //服务器异常，展示错误页面，点击刷新
                    TastyToast.makeText(getApplicationContext(), "服务器异常！", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                }
            }
        });
    }

    //还是不能这样搞，可能会内存泄漏，重复创建Adapyer对象。后面解决
    private void setAdapter() {
        // 设置显示数据
        tv_datetime.setText(mYalijiDetailData.getData().getSYRQ());
        tv_equipment.setText(mYalijiDetailData.getData().getShebeiname());
        tv_project.setText(mYalijiDetailData.getData().getGCMC());
        tv_position.setText(mYalijiDetailData.getData().getSGBW());
        tv_testtype.setText(mYalijiDetailData.getData().getTestName());
        tv_design_strength.setText(mYalijiDetailData.getData().getSJQD());
        tv_size.setText(mYalijiDetailData.getData().getSJCC());
        tv_age.setText(mYalijiDetailData.getData().getLQ());
        tv_central_value.setText(mYalijiDetailData.getData().getQDDBZ());
        mViewPager.setAdapter(new YaLiJiDetailActivityChartViewPagerAdapter(getSupportFragmentManager(), mYalijiDetailData));
        mTabLayout.setupWithViewPager(mViewPager);
        if (!TextUtils.isEmpty(mYalijiDetailData.getData().getChuli())) {
            et_handle_reason.getEditText().setText(mYalijiDetailData.getData().getChuli());
            et_handle_reason.setEnabled(false);
            bt_submit.setEnabled(false);
            bt_reset.setEnabled(false);
        }
    }

    private void setToolbarTitle() {
        if (null != mToolbar && null != BaseApplication.mDepartmentData && !TextUtils.isEmpty(BaseApplication.mDepartmentData.departmentName)) {
            StringBuffer sb = new StringBuffer(BaseApplication.mDepartmentData.departmentName + " > ");
            sb.append(getString(R.string.laboratory) + " > ");
            sb.append(getString(R.string.yaliji) + " > ");
            sb.append(getString(R.string.detail)).trimToSize();
            mToolbar.setTitle(sb.toString());
        }
    }

    @Override
    public void onBackPressed() {
        if (isSubmit) {
            BaseApplication.bus.post(new EventData(ConstantsUtils.NOTIFY_REFRESH));
        }
        super.onBackPressed();
    }
}