package com.shtoone.shtw.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.android.volley.VolleyError;
import com.dd.CircularProgressButton;
import com.google.gson.Gson;
import com.shtoone.shtw.BaseApplication;
import com.shtoone.shtw.R;
import com.shtoone.shtw.activity.base.BaseActivity;
import com.shtoone.shtw.bean.UserInfoData;
import com.shtoone.shtw.utils.AESCryptUtils;
import com.shtoone.shtw.utils.AnimationUtils;
import com.shtoone.shtw.utils.ConstantsUtils;
import com.shtoone.shtw.utils.HttpUtils;
import com.shtoone.shtw.utils.KeyBoardUtils;
import com.shtoone.shtw.utils.NetworkUtils;
import com.shtoone.shtw.utils.SharedPreferencesUtils;
import com.shtoone.shtw.utils.URL;
import com.socks.library.KLog;

import java.security.GeneralSecurityException;

public class LoginActivity extends BaseActivity {
    private static final String TAG = LoginActivity.class.getSimpleName();
    private TextInputLayout login_username;
    private TextInputLayout login_password;
    private CircularProgressButton login_button;
    private UserInfoData userInfoData;
    private ScrollView mScrollView;
    private LinearLayout ll_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        initData();
    }

    private void initView() {
        mScrollView = (ScrollView) findViewById(R.id.sv_login_activity);
        ll_container = (LinearLayout) findViewById(R.id.ll_container_login_register_activity);
        login_username = (TextInputLayout) findViewById(R.id.login_username);
        login_username.getEditText().clearFocus();
        login_password = (TextInputLayout) findViewById(R.id.login_password);
        login_button = (CircularProgressButton) findViewById(R.id.login_button);
    }

    private void initData() {
        login_username.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                login_button.setProgress(0);
                if (TextUtils.isEmpty(s)) {
                    login_username.setError("用户名不能为空");
                    login_username.setErrorEnabled(true);
                } else {
                    login_username.setError("");
                    login_username.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        login_username.getEditText().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login_button.setProgress(0);
                login_username.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mScrollView.fullScroll(ScrollView.FOCUS_DOWN);
                    }
                }, 300);
            }
        });

        login_password.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                login_button.setProgress(0);
                if (TextUtils.isEmpty(s)) {
                    login_password.setError("密码不能为空");
                    login_password.setErrorEnabled(true);
                } else {
                    login_password.setError("");
                    login_password.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        login_password.getEditText().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login_button.setProgress(0);
                login_password.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mScrollView.fullScroll(ScrollView.FOCUS_DOWN);
                    }
                }, 300);
            }
        });

        login_button.setIndeterminateProgressMode(true);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                KeyBoardUtils.hideKeybord(v, LoginActivity.this);
                String username = login_username.getEditText().getText().toString().trim();
                String password = login_password.getEditText().getText().toString().trim();
                //进行加密
                try {
                    final String usernameEncrypted = AESCryptUtils.encrypt(ConstantsUtils.ENCRYPT_KEY, username);
                    final String passwordEncrypted = AESCryptUtils.encrypt(ConstantsUtils.ENCRYPT_KEY, password);
                    KLog.e("username加密后:" + usernameEncrypted);
                    KLog.e("password加密后:" + passwordEncrypted);
                    if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
                        login_button.setProgress(0);
                        login_button.setProgress(50);
                        //联网校对密码正确后保存
                        //没有加url健壮性判断……………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………………
                        HttpUtils.getRequest(URL.loginCheck(username, password), new HttpUtils.HttpListener() {
                            @Override
                            public void onSuccess(String response) {
                                KLog.json(response);
                                if (!TextUtils.isEmpty(response)) {
                                    userInfoData = new Gson().fromJson(response, UserInfoData.class);
                                    if (null != userInfoData) {
                                        if (userInfoData.isSuccess()) {
                                            BaseApplication.mUserInfoData = userInfoData;
                                            SharedPreferencesUtils.put(LoginActivity.this, ConstantsUtils.USERNAME, usernameEncrypted);
                                            SharedPreferencesUtils.put(LoginActivity.this, ConstantsUtils.PASSWORD, passwordEncrypted);
                                            initParametersData();
                                            login_button.setProgress(100);
                                            login_button.postDelayed(new Runnable() {
                                                @Override
                                                public void run() {
                                                    jumpToMain();
                                                }
                                            }, 500);
                                        } else {
                                            //提示用户名或密码错误
                                            login_button.setErrorText("用户名或密码错误");
                                            login_button.setProgress(-1);
                                        }
                                    } else {
                                        //提示数据解析异常
                                        login_button.setErrorText("解析数据异常");
                                        login_button.setProgress(-1);
                                    }
                                } else {
                                    //提示返回数据异常
                                    login_button.setErrorText("返回数据异常");
                                    login_button.setProgress(-1);
                                }
                            }

                            @Override
                            public void onFailed(VolleyError error) {
                                //提示网络数据异常。1.可能是本机网络机场。2.可能是服务器异常。
                                if (!NetworkUtils.isConnected(LoginActivity.this)) {
                                    //提示网络异常
                                    login_button.setErrorText("网络异常");
                                } else {
                                    //服务器异常
                                    login_button.setErrorText("服务器异常");
                                }
                                login_button.setProgress(-1);
                            }
                        });

                    } else if (TextUtils.isEmpty(username)) {
                        login_username.setErrorEnabled(true);
                        login_username.setError("");
                        login_username.setError("用户名不能为空");
                    } else if (TextUtils.isEmpty(password)) {
                        login_username.setErrorEnabled(true);
                        login_username.setError("");
                        login_password.setError("密码不能为空");
                    }

                } catch (GeneralSecurityException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //进入MainActivity
    private void jumpToMain() {
        Intent intent = null;
        if ("GL".equals(userInfoData.getType())) {
            intent = new Intent(this, MainActivity.class);
        } else if ("SG".equals(userInfoData.getType())) {
            switch (userInfoData.getUserRole()) {
                case "1":
                    intent = new Intent(this, ConcreteMainActivity.class);
                    break;
                case "3":
                    intent = new Intent(this, LaboratoryMainActivity.class);
                    break;
            }
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AnimationUtils.startActivityFinish(this, intent, login_button, R.color.login_reveal, 500);
        } else {
            startActivity(intent);
            finish();
        }
    }

    private void initParametersData() {
        BaseApplication.parametersData.userGroupID = userInfoData.getDepartId();
        BaseApplication.mDepartmentData.departmentID = userInfoData.getDepartId();
        BaseApplication.mDepartmentData.departmentName = userInfoData.getDepartName();
    }

    @Override
    public boolean swipeBackPriority() {
        return false;
    }
}
