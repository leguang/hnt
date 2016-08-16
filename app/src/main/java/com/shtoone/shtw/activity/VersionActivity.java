package com.shtoone.shtw.activity;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.dd.CircularProgressButton;
import com.dinuscxj.progressbar.CircleProgressBar;
import com.google.gson.Gson;
import com.shtoone.shtw.BaseApplication;
import com.shtoone.shtw.R;
import com.shtoone.shtw.activity.base.BaseActivity;
import com.shtoone.shtw.bean.VersionInfoData;
import com.shtoone.shtw.utils.AppUtils;
import com.shtoone.shtw.utils.HttpUtils;
import com.shtoone.shtw.utils.NetworkUtils;
import com.socks.library.KLog;

import cn.pedant.SweetAlert.SweetAlertDialog;


public class VersionActivity extends BaseActivity {
    private static final String TAG = VersionActivity.class.getSimpleName();
    private TextView tv_project_name;
    private TextView tv_app_name;
    private TextView tv_version;
    private TextView tv_copyright;
    private TextView tv_describe;
    private CircularProgressButton bt_update;
    private VersionInfoData mVersionInfoData;
    private CircleProgressBar cpb_progress;
    private DownloadManager mDownloadManager;
    private long ID;
    private Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_version);

        initView();
        initDate();
    }

    private void initView() {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar_toolbar);
        mToolbar.setTitle("版本更新");
        initToolbarBackNavigation(mToolbar);
        tv_project_name = (TextView) findViewById(R.id.tv_project_name_version_activity);
        tv_app_name = (TextView) findViewById(R.id.tv_app_name_version_activity);
        tv_version = (TextView) findViewById(R.id.tv_version_version_activity);
        tv_copyright = (TextView) findViewById(R.id.tv_copyright_version_activity);
        tv_describe = (TextView) findViewById(R.id.tv_describe_version_activity);
        bt_update = (CircularProgressButton) findViewById(R.id.bt_update_version_activity);
        cpb_progress = (CircleProgressBar) findViewById(R.id.cpb_progress_version_activity);
    }

    private void initDate() {
        if (!TextUtils.isEmpty(BaseApplication.mUserInfoData.getXmmc())) {
            tv_project_name.setText(BaseApplication.mUserInfoData.getXmmc());
        }
        tv_version.setText(AppUtils.getVersionName(this));
        bt_update.setIndeterminateProgressMode(true);
        bt_update.setOnClickListener(new CheckUpdateOnClickListener());

        registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
        registerReceiver(onNotificationClick, new IntentFilter(DownloadManager.ACTION_NOTIFICATION_CLICKED));
    }

    public class JumpToSettingOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (!NetworkUtils.isConnected(VersionActivity.this)) {
                NetworkUtils.openSetting(VersionActivity.this);
            }
            bt_update.setProgress(0);
            bt_update.setOnClickListener(new CheckUpdateOnClickListener());
        }
    }

    public class JumpToInstallOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            JumpToInstall();
            bt_update.setProgress(0);
            bt_update.setOnClickListener(new CheckUpdateOnClickListener());
        }
    }

    public class DownloadOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (!NetworkUtils.isConnected(VersionActivity.this)) {
                //提示网络异常
                bt_update.setIdleText("准备下载");
                bt_update.setProgress(0);
                bt_update.setProgress(50);
                bt_update.setErrorText("网络异常,点击设置");
                bt_update.setProgress(-1);

                bt_update.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //点击跳转到设置页面
                        bt_update.setOnClickListener(new JumpToSettingOnClickListener());
                    }
                }, 500);

            } else {
                if (!NetworkUtils.isWifiConnected(VersionActivity.this)) {

                    new SweetAlertDialog(VersionActivity.this, SweetAlertDialog.WARNING_TYPE)
                            .setTitleText("确定要下载吗？")
                            .setContentText("当前网络不是Wifi网络,是否继续下载？")
                            .setCancelText("取消")
                            .setConfirmText("确定")
                            .showCancelButton(true)
                            .setCancelClickListener(null)
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {
                                    download();
                                    sDialog.dismissWithAnimation();
                                }
                            })
                            .show();
                } else {
                    download();
                }
            }
        }
    }

    public class CheckUpdateOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            bt_update.setProgress(0);
            bt_update.setProgress(50);
            //检测
            HttpUtils.getRequest("http://192.168.11.119:8080/zgjjqms/update.json", new HttpUtils.HttpListener() {
                @Override
                public void onSuccess(String response) {
                    if (!TextUtils.isEmpty(response)) {
                        KLog.e(response);
                        mVersionInfoData = new Gson().fromJson(response, VersionInfoData.class);
                        if (null != mVersionInfoData) {
                            if (Integer.parseInt(mVersionInfoData.versionCode) > AppUtils.getVersionCode(VersionActivity.this)) {
                                tv_describe.setVisibility(View.VISIBLE);
                                tv_describe.setText(mVersionInfoData.describe);
                                bt_update.setCompleteText("有新版本，点击下载");
                                bt_update.setProgress(100);
                                bt_update.setOnClickListener(new DownloadOnClickListener());
                            } else {
                                bt_update.setCompleteText("当前版本为最新版本");
                                bt_update.setProgress(100);
                            }

                        } else {
                            //提示数据解析异常
                            bt_update.setErrorText("解析数据异常");
                            bt_update.setProgress(-1);
                        }
                    } else {
                        //提示返回数据异常
                        bt_update.setErrorText("返回数据异常");
                        bt_update.setProgress(-1);
                    }
                }

                @Override
                public void onFailed(VolleyError error) {
                    //提示网络数据异常。1.可能是本机网络机场。2.可能是服务器异常。
                    if (!NetworkUtils.isConnected(VersionActivity.this)) {
                        //提示网络异常
                        bt_update.setErrorText("网络异常,点击设置");
                        bt_update.setProgress(-1);
                        //点击跳转到设置页面
                        bt_update.setOnClickListener(new JumpToSettingOnClickListener());

                    } else {

                        //服务器异常
                        bt_update.setErrorText("服务器异常");
                        bt_update.setProgress(-1);
                    }
                }
            });
        }
    }

    BroadcastReceiver onComplete = new BroadcastReceiver() {
        public void onReceive(Context ctxt, Intent intent) {
            //findViewById(R.id.start).setEnabled(true);

            Bundle extras = intent.getExtras();
            DownloadManager.Query q = new DownloadManager.Query();
            q.setFilterById(extras.getLong(DownloadManager.EXTRA_DOWNLOAD_ID));
            c = mDownloadManager.query(q);

            if (c.moveToFirst()) {
                int status = c.getInt(c.getColumnIndex(DownloadManager.COLUMN_STATUS));
                if (status == DownloadManager.STATUS_SUCCESSFUL) {
                    cpb_progress.setVisibility(View.INVISIBLE);
                    bt_update.setVisibility(View.VISIBLE);
                    bt_update.setEnabled(true);
                    bt_update.setIdleText("点击安装");
                    bt_update.setProgress(0);
                    bt_update.setOnClickListener(new JumpToInstallOnClickListener());
                    JumpToInstall();
                }
            }
        }
    };

    BroadcastReceiver onNotificationClick = new BroadcastReceiver() {
        public void onReceive(Context ctxt, Intent intent) {
//            Toast.makeText(ctxt, "Ummmm...hi!", Toast.LENGTH_LONG).show();
        }
    };

    private void JumpToInstall() {
        Intent promptInstall = new Intent(Intent.ACTION_VIEW).setDataAndType(Uri.parse(c.getString(c.getColumnIndex(DownloadManager.COLUMN_LOCAL_URI))), "application/vnd.android.package-archive");
        startActivity(promptInstall);
    }

    private void download() {
        bt_update.setEnabled(false);
        bt_update.setIdleText("正在下载……");
        bt_update.setProgress(0);
        bt_update.postDelayed(new Runnable() {
            @Override
            public void run() {
                bt_update.setProgress(50);
            }
        }, 500);
        bt_update.setVisibility(View.INVISIBLE);
        cpb_progress.setVisibility(View.VISIBLE);
        //bt_update本身自带进度。所以不需要cpb_progress，后期研究
        Uri uri = Uri.parse(mVersionInfoData.appURL);
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).mkdirs();
        mDownloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        ID = mDownloadManager.enqueue(new DownloadManager.Request(uri)
                .setAllowedOverRoaming(false)
                .setTitle("正在下载……")
                .setDescription("下载最新版本")
                .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "shtw.apk"));
    }
}
