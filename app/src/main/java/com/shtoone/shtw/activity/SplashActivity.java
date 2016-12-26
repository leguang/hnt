package com.shtoone.shtw.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.shtoone.shtw.BaseApplication;
import com.shtoone.shtw.R;
import com.shtoone.shtw.activity.base.BaseActivity;
import com.shtoone.shtw.bean.UserInfoData;
import com.shtoone.shtw.utils.AESCryptUtils;
import com.shtoone.shtw.utils.ConstantsUtils;
import com.shtoone.shtw.utils.HttpUtils;
import com.shtoone.shtw.utils.SharedPreferencesUtils;
import com.shtoone.shtw.utils.URL;
import com.socks.library.KLog;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.service.XGPushService;

import java.security.GeneralSecurityException;

public class SplashActivity extends BaseActivity {
    private static final String TAG = SplashActivity.class.getSimpleName();
    private UserInfoData userInfoData;
    private boolean isBackPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        XGPushConfig.enableDebug(this, true);
        Context context = getApplicationContext();
        XGPushManager.registerPush(context);

        // 2.36（不包括）之前的版本需要调用以下2行代码
        Intent service = new Intent(context, XGPushService.class);
        context.startService(service);


        //延迟执行，尽量看到闪屏页
        new Handler().postDelayed(new Runnable() {
            public void run() {
                initView();
                initData();
            }
        }, 2500);
    }

    private void initView() {
    }

    private void initData() {
        String usernameEncrypted = (String) SharedPreferencesUtils.get(this, ConstantsUtils.USERNAME, "");
        String passwordEncrypted = (String) SharedPreferencesUtils.get(this, ConstantsUtils.PASSWORD, "");
//        String loginCheck = (String) SharedPreferencesUtils.get(this, ConstantsUtils.LOGINCHECK, "");
        KLog.e("username加密从sp中:" + usernameEncrypted);
        KLog.e("password加密从sp中:" + passwordEncrypted);
        //进行解密
        String username = null;
        String password = null;
        if (!(TextUtils.isEmpty(usernameEncrypted) && TextUtils.isEmpty(passwordEncrypted))) {
            try {
                username = AESCryptUtils.decrypt("leguang", usernameEncrypted);
                password = AESCryptUtils.decrypt("leguang", passwordEncrypted);
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            }
        }

        KLog.e("username解密:" + username);
        KLog.e("password解密:" + password);

        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
            //联网校对密码正确后保存
            HttpUtils.getRequest(URL.loginCheck(username, password), new HttpUtils.HttpListener() {
                @Override
                public void onSuccess(String response) {
                    KLog.json(response);
                    if (!TextUtils.isEmpty(response)) {
                        userInfoData = new Gson().fromJson(response, UserInfoData.class);
                        if (null != userInfoData) {
                            if (userInfoData.isSuccess()) {
                                BaseApplication.mUserInfoData = userInfoData;
                                initParametersData();
                                //在跳转之前判断是否按了返回键返回桌面了，这代表用户不想进应用了
                                jumpToMain();

                            } else {
                                //提示用户名或密码错误,有可能用户在Web端改了密码
                                jumpToLogin();

                            }
                        } else {
                            //提示数据解析异常，与硬件和系统有关的问题，几乎不可能出现
                            jumpToLogin();
                        }
                    } else {
                        //提示返回数据异常，丢包的情况，几乎不会出现
                        jumpToLogin();
                    }
                }

                @Override
                public void onFailed(VolleyError error) {
                    //提示网络数据异常，无网络
                    jumpToLogin();
                }
            });

        } else {
            jumpToLogin();
        }


    }

    //进入LoginActivity
    private void jumpToLogin() {
        if (isBackPressed) {
            return;
        }
        Boolean isFirstentry = (Boolean) SharedPreferencesUtils.get(this, ConstantsUtils.ISFIRSTENTRY, true);
        Intent intent;
        if (isFirstentry) {
            intent = new Intent(this, GuideActivity.class);
        } else {
            intent = new Intent(this, LoginActivity.class);
        }
        startActivity(intent);
        finish();
    }

    //进入MainActivity
    private void jumpToMain() {
        if (isBackPressed) {
            return;
        }
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
        startActivity(intent);
        finish();
    }

    private void initParametersData() {
        BaseApplication.parametersData.userGroupID = userInfoData.getDepartId();
        BaseApplication.mDepartmentData.departmentID = userInfoData.getDepartId();
        BaseApplication.mDepartmentData.departmentName = userInfoData.getDepartName();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        isBackPressed = true;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);// 必须要调用这句，信鸽推送中的要求
    }

    @Override
    public boolean swipeBackPriority() {
        return false;
    }
}
