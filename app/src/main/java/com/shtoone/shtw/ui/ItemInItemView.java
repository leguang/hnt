package com.shtoone.shtw.ui;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shtoone.shtw.R;

/**
 * Created by leguang on 2016/6/1 0021.
 */
public class ItemInItemView extends LinearLayout {

    private TextView tv_test_type;
    private TextView tv_test_count;
    private TextView tv_disqualification_count;
    private TextView tv_disposition_count;
    private TextView tv_disposition_rate;

    public ItemInItemView(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        View.inflate(getContext(), R.layout.item_in_item_view, this);
        tv_test_type = (TextView) findViewById(R.id.tv_test_type_item_in_item);
        tv_test_count = (TextView) findViewById(R.id.tv_test_count_item_in_item);
        tv_disqualification_count = (TextView) findViewById(R.id.tv_disqualification_count_item_in_item);
        tv_disposition_count = (TextView) findViewById(R.id.tv_disposition_count_item_in_item);
        tv_disposition_rate = (TextView) findViewById(R.id.tv_disposition_rate_item_in_item);
    }

    public ItemInItemView setTestType(String testType) {
        tv_test_type.setText(testType);
        return this;
    }

    public ItemInItemView setTestCount(String testCount) {
        tv_test_count.setText(testCount);
        return this;
    }

    public ItemInItemView setDisqualificationCount(String disqualificationCount) {
        tv_disqualification_count.setText(disqualificationCount);
        return this;
    }

    public ItemInItemView setDispositionCount(String dispositionCount) {
        tv_disposition_count.setText(dispositionCount);
        return this;
    }

    public ItemInItemView setDispositionRate(String dispositionRate) {
        tv_disposition_rate.setText(dispositionRate);
        return this;
    }

}
