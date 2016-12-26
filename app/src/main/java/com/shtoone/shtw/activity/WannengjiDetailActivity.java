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
import com.shtoone.shtw.adapter.WannengjiDetailActivityChartViewPagerAdapter;
import com.shtoone.shtw.bean.UserInfoData;
import com.shtoone.shtw.bean.WannengjiDetailData;
import com.shtoone.shtw.bean.WannengjiFragmentViewPagerFragmentRecyclerViewItemData;
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
import in.srain.cube.views.ptr.header.StoreHouseHeader;

public class WannengjiDetailActivity extends BaseActivity {
    private static final String TAG = WannengjiDetailActivity.class.getSimpleName();
    private Toolbar mToolbar;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private NestedScrollView mNestedScrollView;
    private StoreHouseHeader header;
    private PageStateLayout mPageStateLayout;
    private PtrFrameLayout mPtrFrameLayout;
    private WannengjiDetailData mWannengjiDetailData;
    private TextView tv_datetime;
    private TextView tv_equipment;
    private TextView tv_project;
    private TextView tv_position;
    private TextView tv_testtype;
    private TextView tv_identifier;
    private TextView tv_diameter;
    private TextView tv_kind;
    private TextInputLayout et_handle_reason;
    private CardView cv_handle;
    private Button bt_submit;
    private Button bt_reset;
    private UserInfoData mUserInfoData;
    private String handleReason;
    private WannengjiFragmentViewPagerFragmentRecyclerViewItemData.DataBean mDataBean;
    private Gson mGson;
    private boolean isSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wannengji_detail);

        initView();
        initDate();
    }

    private void initView() {
        mDataBean = (WannengjiFragmentViewPagerFragmentRecyclerViewItemData.DataBean) getIntent().getSerializableExtra("wannengjidetail");
        mToolbar = (Toolbar) findViewById(R.id.toolbar_toolbar);
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout_wannengji_detail_activity);
        mNestedScrollView = (NestedScrollView) findViewById(R.id.nsv_wannengji_detail_activity);
        mViewPager = (ViewPager) findViewById(R.id.vp_wannengji_detail_activity);
        mPtrFrameLayout = (PtrFrameLayout) findViewById(R.id.ptr_wannengji_detail_activity);
        mPageStateLayout = (PageStateLayout) findViewById(R.id.psl_wannengji_detail_activity);
        tv_datetime = (TextView) findViewById(R.id.tv_datetime_wannengji_detail_activity);
        tv_equipment = (TextView) findViewById(R.id.tv_equipment_wannengji_detail_activity);
        tv_project = (TextView) findViewById(R.id.tv_project_name_wannengji_detail_activity);
        tv_position = (TextView) findViewById(R.id.tv_position_wannengji_detail_activity);
        tv_testtype = (TextView) findViewById(R.id.tv_testtype_wannengji_detail_activity);
        tv_identifier = (TextView) findViewById(R.id.tv_identifier_wannengji_detail_activity);
        tv_diameter = (TextView) findViewById(R.id.tv_diameter_wannengji_detail_activity);
        tv_kind = (TextView) findViewById(R.id.tv_kind_wannengji_detail_activity);
        cv_handle = (CardView) findViewById(R.id.cv_handle_wannengji_detail_activity);
        et_handle_reason = (TextInputLayout) findViewById(R.id.et_handle_reason_wannengji_detail_activity);
        bt_submit = (Button) findViewById(R.id.bt_submit_wannengji_detail_activity);
        bt_reset = (Button) findViewById(R.id.bt_reset_wannengji_detail_activity);
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
                    new MaterialDialog.Builder(WannengjiDetailActivity.this)
                            .title("确认")
                            .content("请问您确定填写无误并提交吗？")
                            .positiveText("确定")
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                                    MaterialDialog progressDialog = new MaterialDialog.Builder(WannengjiDetailActivity.this)
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
                new MaterialDialog.Builder(WannengjiDetailActivity.this)
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
        return URL.getWannengjiDetailData(mDataBean.getSYJID());
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
                mWannengjiDetailData = mGson.fromJson(response, WannengjiDetailData.class);
                if (null != mWannengjiDetailData) {
                    if (mWannengjiDetailData.isSuccess()) {
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
                if (!NetworkUtils.isConnected(WannengjiDetailActivity.this)) {
                    //提示网络异常,让用户点击设置网络，
                    View view = WannengjiDetailActivity.this.getWindow().getDecorView();
                    Snackbar.make(view, "当前网络已断开！", Snackbar.LENGTH_LONG)
                            .setAction("设置网络", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    // 跳转到系统的网络设置界面
                                    NetworkUtils.openSetting(WannengjiDetailActivity.this);
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
        tv_datetime.setText(mWannengjiDetailData.getData().getSYRQ());
        tv_equipment.setText(mWannengjiDetailData.getData().getShebeiname());
        tv_project.setText(mWannengjiDetailData.getData().getGCMC());
        tv_position.setText(mWannengjiDetailData.getData().getSGBW());
        tv_testtype.setText(mWannengjiDetailData.getData().getTestName());
        tv_identifier.setText(mWannengjiDetailData.getData().getSJBH());
        tv_diameter.setText(mWannengjiDetailData.getData().getGGZL());
        tv_kind.setText(mWannengjiDetailData.getData().getPZBM());
        mViewPager.setAdapter(new WannengjiDetailActivityChartViewPagerAdapter(getSupportFragmentManager(), mWannengjiDetailData));
        mTabLayout.setupWithViewPager(mViewPager);
        if (!TextUtils.isEmpty(mWannengjiDetailData.getData().getChuli())) {
            et_handle_reason.getEditText().setText(mWannengjiDetailData.getData().getChuli());
            et_handle_reason.setEnabled(false);
            bt_submit.setEnabled(false);
            bt_reset.setEnabled(false);
        }
    }

    private void setToolbarTitle() {
        if (null != mToolbar && null != BaseApplication.mDepartmentData && !TextUtils.isEmpty(BaseApplication.mDepartmentData.departmentName)) {
            StringBuffer sb = new StringBuffer(BaseApplication.mDepartmentData.departmentName + " > ");
            sb.append(getString(R.string.laboratory) + " > ");
            sb.append(getString(R.string.wannengji) + " > ");
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
