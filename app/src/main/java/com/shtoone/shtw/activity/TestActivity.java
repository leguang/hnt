package com.shtoone.shtw.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.shtoone.shtw.R;


public class TestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        TextView textView = (TextView) findViewById(R.id.test_text_view);


    }
}