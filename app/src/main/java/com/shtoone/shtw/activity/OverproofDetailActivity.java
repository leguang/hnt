package com.shtoone.shtw.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.sdsmdg.tastytoast.TastyToast;
import com.shtoone.shtw.BaseApplication;
import com.shtoone.shtw.R;
import com.shtoone.shtw.activity.base.BaseActivity;
import com.shtoone.shtw.adapter.OverproofDetailActivityRecyclerViewAdapter;
import com.shtoone.shtw.event.EventData;
import com.shtoone.shtw.bean.OverproofDetailActivityData;
import com.shtoone.shtw.bean.OverproofFragmentViewPagerFragmentListData;
import com.shtoone.shtw.bean.UserInfoData;
import com.shtoone.shtw.ui.PageStateLayout;
import com.shtoone.shtw.utils.ConstantsUtils;
import com.shtoone.shtw.utils.DateUtils;
import com.shtoone.shtw.utils.HttpUtils;
import com.shtoone.shtw.utils.KeyBoardUtils;
import com.shtoone.shtw.utils.NetworkUtils;
import com.shtoone.shtw.utils.URL;
import com.socks.library.KLog;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import in.srain.cube.views.ptr.PtrFrameLayout;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInLeftAnimationAdapter;

public class OverproofDetailActivity extends BaseActivity implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {
    private static final String TAG = OverproofDetailActivity.class.getSimpleName();
    private Toolbar mToolbar;
    private NestedScrollView mNestedScrollView;
    private PageStateLayout mPageStateLayout;
    private PtrFrameLayout mPtrFrameLayout;
    private OverproofDetailActivityData data;
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
    private ImageView iv_photo_select;
    private ImageView iv_camera_select;
    private ImageView iv_album_select;
    private TextInputLayout et_handle_person;
    private TextInputLayout et_handle_time;
    private TextInputLayout et_handle_reason;
    private TextInputLayout et_handle_way;
    private TextInputLayout et_handle_result;
    private Button bt_handle_submit;
    private Button bt_handle_reset;
    private TextInputLayout et_examine_person;
    private TextInputLayout et_examine_result;
    private TextInputLayout et_examine_approve;
    private TextInputLayout et_confirm_date;
    private TextInputLayout et_approve_date;
    private Button bt_examine_submit;
    private Button bt_examine_reset;
    private LinearLayout ll_camera_album;
    private UserInfoData mUserInfoData;
    private String handlePerson;
    private String handleTime;
    private String handleReason;
    private String handleWay;
    private String handleResult;
    private Bitmap bitmap;
    private OverproofDetailActivityRecyclerViewAdapter mAdapter;
    private OverproofFragmentViewPagerFragmentListData.DataBean mDataBean;
    private String examinePerson;
    private String examineResult;
    private String examineApprove;
    private String confirmTime;
    private String approveTime;
    private boolean isHandleDateTime;
    private boolean isConfirmDateTime;
    private boolean isApproveDateTime;
    private Gson mGson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overproof_detail);
        initView();
        initDate();
    }

    private void initView() {
        mUserInfoData = BaseApplication.mUserInfoData;
        mDataBean = (OverproofFragmentViewPagerFragmentListData.DataBean) getIntent().getSerializableExtra("overproofdetail");
        mToolbar = (Toolbar) findViewById(R.id.toolbar_toolbar);
        mNestedScrollView = (NestedScrollView) findViewById(R.id.nsv_overproof_detail_activity);
        mPtrFrameLayout = (PtrFrameLayout) findViewById(R.id.ptr_overproof_detail_activity);
        mPageStateLayout = (PageStateLayout) findViewById(R.id.psl_overproof_detail_activity);
        tv0 = (TextView) findViewById(R.id.tv0_overproof_detail_activity);
        tv1 = (TextView) findViewById(R.id.tv1_overproof_detail_activity);
        tv2 = (TextView) findViewById(R.id.tv2_overproof_detail_activity);
        tv3 = (TextView) findViewById(R.id.tv3_overproof_detail_activity);
        tv4 = (TextView) findViewById(R.id.tv4_overproof_detail_activity);
        tv5 = (TextView) findViewById(R.id.tv5_overproof_detail_activity);
        tv6 = (TextView) findViewById(R.id.tv6_overproof_detail_activity);
        tv7 = (TextView) findViewById(R.id.tv7_overproof_detail_activity);
        tv8 = (TextView) findViewById(R.id.tv8_overproof_detail_activity);
        tv9 = (TextView) findViewById(R.id.tv9_overproof_detail_activity);
        tv10 = (TextView) findViewById(R.id.tv10_overproof_detail_activity);
        tv11 = (TextView) findViewById(R.id.tv11_overproof_detail_activity);
        tv12 = (TextView) findViewById(R.id.tv12_overproof_detail_activity);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_overproof_detail_activity);
        //处置部分
        iv_photo_select = (ImageView) findViewById(R.id.iv_photo_select_overproof_detail_activity);
        iv_camera_select = (ImageView) findViewById(R.id.iv_camera_select_overproof_detail_activity);
        iv_album_select = (ImageView) findViewById(R.id.iv_album_select_overproof_detail_activity);
        ll_camera_album = (LinearLayout) findViewById(R.id.ll_camera_album_overproof_detail_activity);
        et_handle_person = (TextInputLayout) findViewById(R.id.et_handle_person_overproof_detail_activity);
        et_handle_time = (TextInputLayout) findViewById(R.id.et_handle_time_overproof_detail_activity);
        et_handle_reason = (TextInputLayout) findViewById(R.id.et_handle_reason_overproof_detail_activity);
        et_handle_way = (TextInputLayout) findViewById(R.id.et_handle_way_overproof_detail_activity);
        et_handle_result = (TextInputLayout) findViewById(R.id.et_handle_result_overproof_detail_activity);
        et_handle_person.getEditText().setInputType(InputType.TYPE_NULL);
        et_handle_time.getEditText().setInputType(InputType.TYPE_NULL);
        bt_handle_submit = (Button) findViewById(R.id.bt_handle_submit_overproof_detail_activity);
        bt_handle_reset = (Button) findViewById(R.id.bt_handle_reset_overproof_detail_activity);
        //审批部分
        et_examine_person = (TextInputLayout) findViewById(R.id.et_examine_person_overproof_detail_activity);
        et_examine_result = (TextInputLayout) findViewById(R.id.et_examine_result_overproof_detail_activity);
        et_examine_approve = (TextInputLayout) findViewById(R.id.et_examine_approve_overproof_detail_activity);
        et_confirm_date = (TextInputLayout) findViewById(R.id.et_confirm_time_overproof_detail_activity);
        et_approve_date = (TextInputLayout) findViewById(R.id.et_approve_time_overproof_detail_activity);
        bt_examine_submit = (Button) findViewById(R.id.bt_examine_submit_overproof_detail_activity);
        bt_examine_reset = (Button) findViewById(R.id.bt_examine_reset_overproof_detail_activity);
        et_examine_person.getEditText().setInputType(InputType.TYPE_NULL);
        et_confirm_date.getEditText().setInputType(InputType.TYPE_NULL);
        et_approve_date.getEditText().setInputType(InputType.TYPE_NULL);
    }

    private void initDate() {
        mGson = new Gson();
        setToolbarTitle();
        initToolbarBackNavigation(mToolbar);
        setSupportActionBar(mToolbar);

        et_handle_time.getEditText().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        isHandleDateTime = true;
                        isConfirmDateTime = false;
                        isApproveDateTime = false;
                        showDatePicker();
                        break;
                }
                return true;
            }
        });

        et_confirm_date.getEditText().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        isHandleDateTime = false;
                        isConfirmDateTime = true;
                        isApproveDateTime = false;
                        showDatePicker();
                        break;
                }
                return true;
            }
        });

        et_approve_date.getEditText().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        isHandleDateTime = false;
                        isConfirmDateTime = false;
                        isApproveDateTime = true;
                        showDatePicker();
                        break;
                }
                return true;
            }
        });

        iv_photo_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    int cx = (ll_camera_album.getLeft() + view.getRight()) / 2;
                    int cy = (ll_camera_album.getTop() + view.getBottom()) / 2;
                    int radius = Math.max(view.getWidth(), ll_camera_album.getHeight());
                    Animator mAnimator = ViewAnimationUtils.createCircularReveal(ll_camera_album, cx, cy, 0, radius);
                    mAnimator.setDuration(500);
                    mAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                    mAnimator.addListener(new AnimatorListenerAdapter() {

                        @Override
                        public void onAnimationStart(Animator animation) {
                            super.onAnimationStart(animation);
                            ll_camera_album.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            iv_photo_select.setVisibility(View.INVISIBLE);
                        }
                    });
                    mAnimator.start();
                } else {
                    iv_photo_select.setVisibility(View.GONE);
                    ll_camera_album.setVisibility(View.VISIBLE);
                }
            }
        });

        iv_camera_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, ConstantsUtils.CAMERA);
            }
        });

        iv_album_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");// 相片类型
                startActivityForResult(intent, ConstantsUtils.ALBUM);
            }
        });

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

        et_handle_way.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (TextUtils.isEmpty(s)) {
                    et_handle_way.getEditText().setError("处置方式不能为空");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        et_handle_result.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (TextUtils.isEmpty(s)) {
                    et_handle_result.getEditText().setError("处置结果不能为空");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        bt_handle_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                KeyBoardUtils.hideKeybord(view, OverproofDetailActivity.this);
                handlePerson = et_handle_person.getEditText().getText().toString().trim();
                handleTime = et_handle_time.getEditText().getText().toString().trim();
                handleReason = et_handle_reason.getEditText().getText().toString().trim();
                handleWay = et_handle_way.getEditText().getText().toString().trim();
                handleResult = et_handle_result.getEditText().getText().toString().trim();
                if (!TextUtils.isEmpty(handlePerson) && !TextUtils.isEmpty(handleTime) && !TextUtils.isEmpty(handleReason) && !TextUtils.isEmpty(handleWay) && !TextUtils.isEmpty(handleResult)) {
                    //弹出对话框，确定提交
                    new MaterialDialog.Builder(OverproofDetailActivity.this)
                            .title("确认")
                            .content("请问您确定填写无误并提交吗？")
                            .positiveText("确定")
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    MaterialDialog progressDialog = new MaterialDialog.Builder(OverproofDetailActivity.this)
                                            .title("提交")
                                            .content("正在提交中，请稍等……")
                                            .progress(true, 0)
                                            .progressIndeterminateStyle(true)
                                            .cancelable(false)
                                            .show();
                                    handleSubmit(progressDialog);
                                }
                            })
                            .negativeText("放弃")
                            .show();
                } else {
                    if (TextUtils.isEmpty(handlePerson)) {
                        et_handle_person.getEditText().setError("处置人不能为空");
                    } else if (TextUtils.isEmpty(handleTime)) {
                        et_handle_time.getEditText().setError("处置时间不能为空");
                    } else if (TextUtils.isEmpty(handleReason)) {
                        et_handle_reason.getEditText().setError("处置原因不能为空");
                    } else if (TextUtils.isEmpty(handleWay)) {
                        et_handle_way.getEditText().setError("处置方式不能为空");
                    } else if (TextUtils.isEmpty(handleResult)) {
                        et_handle_result.getEditText().setError("处置结果不能为空");
                    }
                }
            }
        });

        bt_handle_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //弹出对话框,确定重置
                new MaterialDialog.Builder(OverproofDetailActivity.this)
                        .title("确认")
                        .content("请问您确定要重置吗？那样您就要重新填写哟……")
                        .positiveText("确定")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                //提交到服务器
                                TastyToast.makeText(getApplicationContext(), "已经重置!", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS);
                                et_handle_reason.getEditText().setText("");
                                et_handle_reason.setFocusable(false);
                                et_handle_way.getEditText().setText("");
                                et_handle_result.getEditText().setText("");
                                handleResult = "";
                                handleReason = "";
                                handleWay = "";
                                bitmap = null;
                                iv_photo_select.setImageResource(R.drawable.ic_camera_album);
                            }
                        })
                        .negativeText("放弃")
                        .show();
            }
        });

        bt_examine_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KeyBoardUtils.hideKeybord(view, OverproofDetailActivity.this);
                examinePerson = et_examine_person.getEditText().getText().toString().trim();
                examineResult = et_examine_result.getEditText().getText().toString().trim();
                examineApprove = et_examine_approve.getEditText().getText().toString().trim();
                confirmTime = et_confirm_date.getEditText().getText().toString().trim();
                approveTime = et_approve_date.getEditText().getText().toString().trim();

                if (!TextUtils.isEmpty(examinePerson) && !TextUtils.isEmpty(examineResult) && !TextUtils.isEmpty(examineApprove) && !TextUtils.isEmpty(confirmTime) && !TextUtils.isEmpty(approveTime)) {
                    //弹出对话框，确定提交
                    new MaterialDialog.Builder(OverproofDetailActivity.this)
                            .title("确认")
                            .content("请问您确定填写无误并提交吗？")
                            .positiveText("确定")
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    MaterialDialog progressDialog = new MaterialDialog.Builder(OverproofDetailActivity.this)
                                            .title("提交")
                                            .content("正在提交中，请稍等……")
                                            .progress(true, 0)
                                            .progressIndeterminateStyle(true)
                                            .cancelable(false)
                                            .show();
                                    examineSubmit(progressDialog);
                                }
                            })
                            .negativeText("放弃")
                            .show();
                } else {
                    if (TextUtils.isEmpty(examinePerson)) {
                        et_examine_person.getEditText().setError("审批人不能为空");
                    } else if (TextUtils.isEmpty(examineResult)) {
                        et_examine_result.getEditText().setError("监理结果不能为空");
                    } else if (TextUtils.isEmpty(examineApprove)) {
                        et_examine_approve.getEditText().setError("监理审批不能为空");
                    } else if (TextUtils.isEmpty(confirmTime)) {
                        et_confirm_date.getEditText().setError("确认时间不能为空");
                    } else if (TextUtils.isEmpty(approveTime)) {
                        et_approve_date.getEditText().setError("审批时间不能为空");
                    }
                }
            }
        });

        bt_examine_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //弹出对话框,确定重置
                new MaterialDialog.Builder(OverproofDetailActivity.this)
                        .title("确认")
                        .content("请问您确定要重置吗？那样您就要重新填写哟……")
                        .positiveText("确定")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                et_examine_result.getEditText().setText("");
                                et_examine_approve.getEditText().setText("");
                                examineResult = "";
                                examineApprove = "";
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
        return URL.getOverproofDetailData(mDataBean.getXinxibianhao());
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
                data = mGson.fromJson(response, OverproofDetailActivityData.class);
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

    private void handleSubmit(final MaterialDialog progressDialog) {
        String person = null, time = null, reason = null, way = null, result = null;
        try {
            person = URLEncoder.encode(handlePerson, "UTF-8");
            time = handleTime;
            reason = URLEncoder.encode(handleReason, "UTF-8");
            way = URLEncoder.encode(handleWay, "UTF-8");
            result = URLEncoder.encode(handleResult, "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }

        final String url = URL.BHZ_CHAOBIAO_DO_URL.replace("%1", data.getHeadMsg().getId()).replace("%2", reason).replace("%3", way).replace("%4", result).replace("%5", person).replace("%6", DateUtils.ChangeTimeToLong(time));

        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 1) {
                    progressDialog.dismiss();
                    TastyToast.makeText(getApplicationContext(), "上传成功!", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS);
                    BaseApplication.bus.post(new EventData(ConstantsUtils.REFRESH));
                } else {
                    progressDialog.dismiss();
                    TastyToast.makeText(getApplicationContext(), "上传失败，请重试！", TastyToast.LENGTH_SHORT, TastyToast.ERROR);

                }
            }
        };
        new Thread(new Runnable() {
            public void run() {
                boolean flag = uploadPic(url); //返回为 true 表示上传成功 ； false 上传失败
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (flag) {
                    handler.sendEmptyMessage(1);  // 上传成功 发送消息到 handler 关闭详情页并提示上传成功
                } else {
                    handler.sendEmptyMessage(2);  // 上传失败 则什么都不做 停留在此页面
                }
            }
        }).start();
    }

    private void examineSubmit(final MaterialDialog progressDialog) {
        Map<String, String> paramsMap = new HashMap<String, String>();
        paramsMap.put("jieguobianhao", data.getHeadMsg().getId());
        paramsMap.put("jianliresult", examineResult);
        paramsMap.put("jianlishenpi", examineApprove);
        paramsMap.put("confirmdate", DateUtils.ChangeTimeToLong(confirmTime));
        paramsMap.put("shenpiren", examinePerson);
        paramsMap.put("shenpidate", DateUtils.ChangeTimeToLong(approveTime));

        HttpUtils.postRequest(URL.BHZ_CHAOBIAO_SP, paramsMap, new HttpUtils.HttpListener() {
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
                        TastyToast.makeText(getApplicationContext(), "解析异常！", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                    }

                    if (jsonObject.optBoolean("success")) {

                        BaseApplication.bus.post(new EventData(ConstantsUtils.REFRESH));
                        TastyToast.makeText(getApplicationContext(), "上传成功!", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS);
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
                if (!NetworkUtils.isConnected(OverproofDetailActivity.this)) {
                    //提示网络异常,让用户点击设置网络，
                    View view = OverproofDetailActivity.this.getWindow().getDecorView();
                    Snackbar.make(view, "当前网络已断开！", Snackbar.LENGTH_LONG)
                            .setAction("设置网络", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    // 跳转到系统的网络设置界面
                                    NetworkUtils.openSetting(OverproofDetailActivity.this);
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
        SlideInLeftAnimationAdapter mSlideInLeftAnimationAdapter = new SlideInLeftAnimationAdapter(mAdapter = new OverproofDetailActivityRecyclerViewAdapter(this, data.getData()));
        mSlideInLeftAnimationAdapter.setFirstOnly(true);
        mSlideInLeftAnimationAdapter.setDuration(500);
        mSlideInLeftAnimationAdapter.setInterpolator(new OvershootInterpolator(.5f));
        ScaleInAnimationAdapter mScaleInAnimationAdapter = new ScaleInAnimationAdapter(mSlideInLeftAnimationAdapter);
        mScaleInAnimationAdapter.setFirstOnly(true);
        mRecyclerView.setAdapter(mScaleInAnimationAdapter);


        //设置处置部分是否显示
        if (mUserInfoData.getQuanxian().isSyschaobiaoReal()) {
            bt_handle_submit.setEnabled(true);
            bt_handle_reset.setEnabled(true);

            if (!TextUtils.isEmpty(data.getHeadMsg().getFilePath())) {

                String imageURL = URL.BaseURL + data.getHeadMsg().getFilePath();
                Glide.with(getApplicationContext()).load(imageURL).crossFade().into(iv_photo_select);
            }

            if (TextUtils.isEmpty(data.getHeadMsg().getChuliren())) {
                et_handle_person.getEditText().setText(handlePerson = mUserInfoData.getUserFullName());
            } else {
                et_handle_person.getEditText().setText(data.getHeadMsg().getChuliren());
            }
            if (TextUtils.isEmpty(data.getHeadMsg().getChulishijian())) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
                et_handle_time.getEditText().setText(sdf.format(Calendar.getInstance().getTime()));
            } else {
                et_handle_time.getEditText().setText(data.getHeadMsg().getChulishijian());
            }

            if (!TextUtils.isEmpty(data.getHeadMsg().getWentiyuanyin())) {
                et_handle_reason.getEditText().setText(data.getHeadMsg().getWentiyuanyin());
            }

            if (!TextUtils.isEmpty(data.getHeadMsg().getChulifangshi())) {
                et_handle_way.getEditText().setText(data.getHeadMsg().getChulifangshi());

            }

            if (!TextUtils.isEmpty(data.getHeadMsg().getChulijieguo())) {
                et_handle_result.getEditText().setText(data.getHeadMsg().getChulijieguo());
            }
        }

        //设置审批部分是否显示
        if (mUserInfoData.getQuanxian().isHntchaobiaoSp() && !TextUtils.isEmpty(data.getHeadMsg().getWentiyuanyin())) {
            bt_examine_submit.setEnabled(true);
            bt_examine_reset.setEnabled(true);

            if (TextUtils.isEmpty(data.getHeadMsg().getShenpiren())) {
                et_examine_person.getEditText().setText(examinePerson = mUserInfoData.getUserFullName());
            } else {
                et_examine_person.getEditText().setText(data.getHeadMsg().getShenpiren());
            }

            if (!TextUtils.isEmpty(data.getHeadMsg().getJianliresult())) {
                et_examine_result.getEditText().setText(data.getHeadMsg().getJianliresult());
            }

            if (!TextUtils.isEmpty(data.getHeadMsg().getJianlishenpi())) {
                et_examine_approve.getEditText().setText(data.getHeadMsg().getJianlishenpi());
            }

            if (TextUtils.isEmpty(data.getHeadMsg().getConfirmdate())) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
                et_confirm_date.getEditText().setText(sdf.format(Calendar.getInstance().getTime()));
            } else {
                et_confirm_date.getEditText().setText(data.getHeadMsg().getConfirmdate());
            }

            if (TextUtils.isEmpty(data.getHeadMsg().getShenpidate())) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
                et_approve_date.getEditText().setText(sdf.format(Calendar.getInstance().getTime()));
            } else {
                et_approve_date.getEditText().setText(data.getHeadMsg().getShenpidate());
            }
        }
    }

    private void setToolbarTitle() {
        if (null != mToolbar && null != BaseApplication.mDepartmentData && !TextUtils.isEmpty(BaseApplication.mDepartmentData.departmentName)) {
            StringBuffer sb = new StringBuffer(BaseApplication.mDepartmentData.departmentName + " > ");
            sb.append(getString(R.string.banhezhan) + " > ");
            sb.append(getString(R.string.overproof) + " > ");
            sb.append(getString(R.string.detail)).trimToSize();
            mToolbar.setTitle(sb.toString());
        }
    }

    private void showDatePicker() {
        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(this, now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));
        dpd.vibrate(true);
        dpd.dismissOnPause(false);
        dpd.setAccentColor(Color.parseColor("#3F51B5"));
        dpd.show(getFragmentManager(), "Datepickerdialog");
    }

    private void showTimePicker() {
        Calendar now = Calendar.getInstance();
        TimePickerDialog tpd = TimePickerDialog.newInstance(this, now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), false);
        tpd.vibrate(true);
        tpd.dismissOnPause(false);
        tpd.setAccentColor(Color.parseColor("#3F51B5"));
        tpd.show(getFragmentManager(), "Timepickerdialog");
    }

    @Override
    public void onResume() {
        super.onResume();
        TimePickerDialog tpd = (TimePickerDialog) getFragmentManager().findFragmentByTag("Timepickerdialog");
        DatePickerDialog dpd = (DatePickerDialog) getFragmentManager().findFragmentByTag("Datepickerdialog");

        if (tpd != null) tpd.setOnTimeSetListener(this);
        if (dpd != null) dpd.setOnDateSetListener(this);
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {
        String hourString = hourOfDay < 10 ? "0" + hourOfDay : "" + hourOfDay;
        String minuteString = minute < 10 ? "0" + minute : "" + minute;
        String secondString = second < 10 ? "0" + second : "" + second;
        String timeString = hourString + ":" + minuteString + ":" + secondString;
        if (isHandleDateTime) {
            handleTime = handleTime + timeString;
            et_handle_time.getEditText().setText(handleTime);
        } else if (isConfirmDateTime) {
            confirmTime = confirmTime + timeString;
            et_confirm_date.getEditText().setText(confirmTime);
        } else if (isApproveDateTime) {
            approveTime = approveTime + timeString;
            et_approve_date.getEditText().setText(approveTime);
        }
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String monthString = (++monthOfYear) < 10 ? "0" + (monthOfYear) : "" + (monthOfYear);
        String dayString = dayOfMonth < 10 ? "0" + dayOfMonth : "" + dayOfMonth;
        String dateString = year + "-" + monthString + "-" + dayString + " ";

        if (isHandleDateTime) {
            handleTime = dateString;
        } else if (isConfirmDateTime) {
            confirmTime = dateString;
        } else if (isApproveDateTime) {
            approveTime = dateString;
        }

        showTimePicker();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        if (requestCode == ConstantsUtils.CAMERA) { // 表示是从相机拍照页返回
            // 判断内存卡是否可用
            String sdStatus = Environment.getExternalStorageState();
            if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) {
                KLog.e("SD卡不可用");
                TastyToast.makeText(getApplicationContext(), "SD卡不可用！", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                return;
            }
            //对 返回的 bitmap 进行对应的保存操作
            String photoName = new DateFormat().format("yyyyMMdd_hhmmss", Calendar.getInstance(Locale.CHINA)) + ".jpg";
            TastyToast.makeText(getApplicationContext(), photoName, TastyToast.LENGTH_SHORT, TastyToast.INFO);
            Bundle bundle = data.getExtras();
            bitmap = (Bitmap) bundle.get("data");

            FileOutputStream b = null;
            File file = new File("/sdcard/shtw/");
            file.mkdirs();
            String fileName = "/sdcard/shtw/" + photoName;

            try {
                b = new FileOutputStream(fileName);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    b.flush();
                    b.close();
                } catch (Exception e2) {
                }
            }
        } else if (requestCode == ConstantsUtils.ALBUM) { // 表示是从相册选择图片返回
            Uri uri = data.getData(); //得到图片 uri
            ContentResolver resolver = getContentResolver(); //处理器
            try {
                bitmap = MediaStore.Images.Media.getBitmap(resolver, uri); //  将对应 uri 通过处理器转化为 bitmap
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (bitmap != null) {
            ll_camera_album.setVisibility(View.GONE);
            iv_photo_select.setVisibility(View.VISIBLE);
            iv_photo_select.setImageBitmap(bitmap);
        }
    }

    /**
     * 上传图片的方法
     *
     * @param path
     * @return
     */
    private boolean uploadPic(String path) {
        try {
            java.net.URL url = new java.net.URL(path);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            // 设置每次传输的流大小，可以有效防止手机因为内存不足崩溃
            // 此方法用于在预先不知道内容长度时启用没有进行内部缓冲的 HTTP 请求正文的流。
            httpURLConnection.setChunkedStreamingMode(128 * 1024);// 128K
            // 允许输入输出流
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("charset", "UTF-8");
            httpURLConnection.setRequestProperty("Content-Type", "text/html");
            DataOutputStream dos = new DataOutputStream(httpURLConnection.getOutputStream());
            // 将要上传的内容写入流中
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            if (bitmap != null) {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 30, baos);
            }
            InputStream inputStream = new ByteArrayInputStream(baos.toByteArray());

            byte[] buffer = new byte[8192]; // 8k
            int length = 0;
            // 读取流 并写入到 上传流中
            while ((length = inputStream.read(buffer)) != -1) {
                dos.write(buffer, 0, length);
            }
            inputStream.close();
            dos.flush();

            InputStream is = httpURLConnection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String sl;
            String result = "";
            while ((sl = br.readLine()) != null)
                result = result + sl;
            JSONObject jo = new JSONObject(result);
            KLog.e(jo.toString());
            br.close();
            is.close();
            if (jo.getBoolean("success")) { //服务器返回json success 为 true 表示上传成功
                return true;
            } else {
                return false;
            }
            // dos.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
