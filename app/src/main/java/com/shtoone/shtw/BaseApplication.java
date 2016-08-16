package com.shtoone.shtw;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.shtoone.shtw.bean.DepartmentData;
import com.shtoone.shtw.bean.ParametersData;
import com.shtoone.shtw.bean.UserInfoData;
import com.socks.library.KLog;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.squareup.otto.Bus;

/**
 * Created by leguang on 2016/5/20 0031.
 */
public class BaseApplication extends Application {

    private static final String TAG = BaseApplication.class.getSimpleName();
    public static BaseApplication application;
    public static Context context;
    public static final Bus bus = new Bus();
    public static ParametersData parametersData = new ParametersData();
    public static RequestQueue mRequestQueue;
    public static UserInfoData mUserInfoData;
    public static DepartmentData mDepartmentData = new DepartmentData();
    public static boolean isExpand;
    public RefWatcher mRefWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        KLog.init(true, "SHTW");
        application = this;
        context = getApplicationContext();
        // 添加功能：程序异常关闭1s之后重新启动

        mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        mRefWatcher = LeakCanary.install(this);
    }
}
