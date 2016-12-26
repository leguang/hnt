package com.shtoone.shtw.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import com.shtoone.shtw.R;

/**
 * 测试之用，无具体用途。
 */
public class TestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Button mButton = (Button) findViewById(R.id.test_text_view);

//        mButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                MaterialDialog dialog = new MaterialDialog.Builder(TestActivity.this)
//                        .title("异常")
//                        .content("当前应用程序发生异常，请您选择退出应用或重启应用！")
//
//                        .positiveText("重启")
//                        .cancelable(false)
//                        .onPositive(new MaterialDialog.SingleButtonCallback() {
//                            @Override
//                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
////                                Intent intent = new Intent(mContext, SplashActivity.class);
////                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
////                                mContext.startActivity(intent);
////                                ActivityManagerUtils.getInstance().appExit();
//                            }
//                        })
//                        .negativeText("退出")
//                        .onNegative(new MaterialDialog.SingleButtonCallback() {
//                            @Override
//                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
////                                ActivityManagerUtils.getInstance().appExit();
//                            }
//                        })
//                        .build();
//
//                ImageView iv_dialog = (ImageView) dialog.getCustomView().findViewById(R.id.iv_dialog_exception_customview);
//
//                Glide.with(getApplicationContext()).load(R.drawable.bg_exception_dialog).asGif().into(iv_dialog);
//                dialog.show();
//            }
//        });


    }
}