package com.shtoone.shtw.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.dd.CircularProgressButton;
import com.google.gson.Gson;
import com.shtoone.shtw.BaseApplication;
import com.shtoone.shtw.R;
import com.shtoone.shtw.activity.base.BaseActivity;
import com.shtoone.shtw.bean.BHZEquipment;
import com.shtoone.shtw.bean.EquipmentAndTestTypeData;
import com.shtoone.shtw.bean.ParametersData;
import com.shtoone.shtw.utils.ConstantsUtils;
import com.shtoone.shtw.utils.DateUtils;
import com.shtoone.shtw.utils.URL;
import com.socks.library.KLog;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import fr.ganfra.materialspinner.MaterialSpinner;

/**
 * Created by leguang on 2016/6/01 0031.
 */

public class DialogActivity extends BaseActivity implements View.OnClickListener, TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {
    private static final String TAG = DialogActivity.class.getSimpleName();
    private TextInputLayout start_date_time;
    private TextInputLayout end_date_time;
    private CircularProgressButton bt_search;
    private MaterialSpinner ms_select_equipment;
    private MaterialSpinner ms_select_test_type;
    private ImageView iv_cancel;
    private boolean isStartDateTime;
    private String startDateTime;
    private String endDateTime;
    private ParametersData mParametersData;
    private FrameLayout fl_container;
    private String url;
    private EquipmentAndTestTypeData mEquipmentTestData;
    private BHZEquipment mBHZEquipment;
    private List<String> equipmentNames;
    private List<String> equipmentIDs;
    private List<String> testTypeNames;
    private List<String> testTypeIDs;
    private RadioGroup rg_handle;
    private RadioGroup rg_examine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        initView();
    }

    private void initView() {
        //获取传过来的参数对象
        fl_container = (FrameLayout) findViewById(R.id.fl_container_dialog_activity);
        mParametersData = (ParametersData) getIntent().getSerializableExtra(ConstantsUtils.PARAMETERS);
        start_date_time = (TextInputLayout) findViewById(R.id.start_date_time_dialog);
        end_date_time = (TextInputLayout) findViewById(R.id.end_date_time_dialog);
        start_date_time.getEditText().setText(startDateTime = mParametersData.startDateTime);
        end_date_time.getEditText().setText(endDateTime = mParametersData.endDateTime);
        bt_search = (CircularProgressButton) findViewById(R.id.bt_search_dialog);
        iv_cancel = (ImageView) findViewById(R.id.iv_cancel_dialog);
        ms_select_equipment = (MaterialSpinner) findViewById(R.id.ms_select_equipment_dialog);
        ms_select_test_type = (MaterialSpinner) findViewById(R.id.ms_select_test_type_dialog);
        rg_handle = (RadioGroup) findViewById(R.id.rg_handle_dialog);
        rg_examine = (RadioGroup) findViewById(R.id.rg_examine_dialog);
        start_date_time.getEditText().setInputType(InputType.TYPE_NULL);
        end_date_time.getEditText().setInputType(InputType.TYPE_NULL);
        iv_cancel.setOnClickListener(this);
        bt_search.setOnClickListener(this);

        start_date_time.getEditText().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        setStartDateTime();
                        break;
                }
                return true;
            }
        });

        end_date_time.getEditText().setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        end_date_time.setError("");
                        end_date_time.setErrorEnabled(false);
                        setEndDateTime();
                        break;
                }
                return true;
            }
        });


        ms_select_equipment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                KLog.e("equipment选择第：" + i + "个");
                if (i >= 0) {
                    mParametersData.equipmentID = equipmentIDs.get(i);
                    KLog.e("equipmentIDs[i]:" + equipmentNames.get(i));
                } else if (i == -1) {
                    mParametersData.equipmentID = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ms_select_test_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                KLog.e("test_type选择第：" + i + "个");
                if (i >= 0) {
                    mParametersData.testTypeID = testTypeIDs.get(i);
                    KLog.e("testTypeIDs[i]:" + testTypeNames.get(i));
                } else if (i == -1) {
                    mParametersData.testTypeID = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        rg_handle.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.rb_all_handle_dialog) {
                    rg_examine.setVisibility(View.INVISIBLE);
                    mParametersData.handleType = "";
                } else if (i == R.id.rb_not_handle_dialog) {
                    rg_examine.setVisibility(View.INVISIBLE);
                    rg_examine.check(R.id.rb_all_examine_dialog);
                    mParametersData.handleType = "0";
                } else if (i == R.id.rb_handled_dialog) {
                    rg_examine.setVisibility(View.VISIBLE);
                    mParametersData.handleType = "1";
                }
            }
        });

        rg_examine.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.rb_all_examine_dialog) {
                    mParametersData.handleType = "1";
                } else if (i == R.id.rb_not_examine_dialog) {
                    mParametersData.handleType = "2";
                } else if (i == R.id.rb_examined_dialog) {
                    mParametersData.handleType = "3";
                }
            }
        });


        //设置哪些条件选择该显示，默认只有时间选择是显示的
        switch (mParametersData.fromTo) {
            case ConstantsUtils.LABORATORYFRAGMENT:
            case ConstantsUtils.CONCRETEFRAGMENT:
                //默认开始和结束时间是可见的
                break;
            case ConstantsUtils.YALIJIFRAGMENT:
            case ConstantsUtils.WANNENGJIFRAGMENT:
                //设置设备和试验类型的下拉选择可见
                ms_select_equipment.setVisibility(View.VISIBLE);
                ms_select_test_type.setVisibility(View.VISIBLE);
                url = URL.getLibEquipmentTest(mParametersData.userGroupID);
                refresh();
                break;
            case ConstantsUtils.MATERIALSTATISTICFRAGMENT:
            case ConstantsUtils.PRODUCEQUERYFRAGMENT:
                //设置设备的下拉选择可见
                ms_select_equipment.setVisibility(View.VISIBLE);
                url = URL.getBHZEquipment(mParametersData.userGroupID);
                refresh();
                break;

            case ConstantsUtils.OVERPROOFFRAGMENT:
                //设置设备的下拉选择可见
                ms_select_equipment.setVisibility(View.VISIBLE);
                rg_handle.setVisibility(View.VISIBLE);
                rg_examine.setVisibility(View.INVISIBLE);
                url = URL.getBHZEquipment(mParametersData.userGroupID);
                refresh();
                break;
        }

        if (mParametersData.handleType.equals("")) {
            rg_handle.check(R.id.rb_all_handle_dialog);
        } else if (mParametersData.handleType.equals("0")) {
            rg_handle.check(R.id.rb_not_handle_dialog);
        } else if (mParametersData.handleType.equals("1")) {
            rg_handle.check(R.id.rb_handled_dialog);
            rg_examine.check(R.id.rb_all_examine_dialog);
            rg_examine.setVisibility(View.VISIBLE);
        } else if (mParametersData.handleType.equals("2")) {
            rg_handle.check(R.id.rb_handled_dialog);
            rg_examine.check(R.id.rb_not_examine_dialog);
            rg_examine.setVisibility(View.VISIBLE);
        } else if (mParametersData.handleType.equals("3")) {
            rg_handle.check(R.id.rb_handled_dialog);
            rg_examine.check(R.id.rb_examined_dialog);
            rg_examine.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onRefreshSuccess(String response) {

        switch (mParametersData.fromTo) {
            case ConstantsUtils.LABORATORYFRAGMENT:
            case ConstantsUtils.CONCRETEFRAGMENT:

                break;

            case ConstantsUtils.YALIJIFRAGMENT:
                mEquipmentTestData = new Gson().fromJson(response, EquipmentAndTestTypeData.class);
                setYalijiQueryView();
                break;

            case ConstantsUtils.WANNENGJIFRAGMENT:
                mEquipmentTestData = new Gson().fromJson(response, EquipmentAndTestTypeData.class);
                setWannengjiQueryView();
                break;

            case ConstantsUtils.MATERIALSTATISTICFRAGMENT:
            case ConstantsUtils.PRODUCEQUERYFRAGMENT:
            case ConstantsUtils.OVERPROOFFRAGMENT:
                mBHZEquipment = new Gson().fromJson(response, BHZEquipment.class);
                setBHZQueryView();
                break;
        }

    }


    private void setBHZQueryView() {
        equipmentNames = new ArrayList<>();
        equipmentIDs = new ArrayList<>();
        for (BHZEquipment.DataBean temp : mBHZEquipment.getData()) {
            equipmentNames.add(temp.getBanhezhanminchen());
            equipmentIDs.add(temp.getGprsbianhao());
        }

        ArrayAdapter<String> equipmentsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, equipmentNames);
        equipmentsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ms_select_equipment.setAdapter(equipmentsAdapter);

        for (int i = 0; i < equipmentIDs.size(); i++) {
            if (mParametersData.equipmentID.equals(equipmentIDs.get(i))) {
                ms_select_equipment.setSelection(i + 1);
                KLog.e("默认：" + (i + 1) + "个");
            }
        }
    }

    private void setWannengjiQueryView() {
        equipmentNames = new ArrayList<>();
        equipmentIDs = new ArrayList<>();
        for (EquipmentAndTestTypeData.DataBean.WnjsbBean temp : mEquipmentTestData.getData().getWnjsb()) {
            equipmentNames.add(temp.getBanhezhanminchen());
            equipmentIDs.add(temp.getGprsbianhao());
        }
        ArrayAdapter<String> equipmentsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, equipmentNames);
        equipmentsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ms_select_equipment.setAdapter(equipmentsAdapter);


        testTypeNames = new ArrayList<>();
        testTypeIDs = new ArrayList<>();
        for (EquipmentAndTestTypeData.DataBean.WnjtpBean temp : mEquipmentTestData.getData().getWnjtp()) {
            testTypeNames.add(temp.getTestName());
            testTypeIDs.add(temp.getTestId());
        }
        ArrayAdapter<String> testTypessAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, testTypeNames);
        testTypessAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ms_select_test_type.setAdapter(testTypessAdapter);

        //根据传过来的参数对象来设置这些选择框该显示的内容
        for (int i = 0; i < equipmentIDs.size(); i++) {
            if (mParametersData.equipmentID.equals(equipmentIDs.get(i))) {
                ms_select_equipment.setSelection(i + 1);
                KLog.e("默认：" + (i + 1) + "个");
            }
        }

        for (int i = 0; i < testTypeIDs.size(); i++) {
            if (mParametersData.testTypeID.equals(testTypeIDs.get(i))) {
                ms_select_test_type.setSelection(i + 1);
            }
        }
    }

    private void setYalijiQueryView() {
        equipmentNames = new ArrayList<>();
        equipmentIDs = new ArrayList<>();
        for (EquipmentAndTestTypeData.DataBean.YljsbBean temp : mEquipmentTestData.getData().getYljsb()) {
            equipmentNames.add(temp.getBanhezhanminchen());
            equipmentIDs.add(temp.getGprsbianhao());
        }
        ArrayAdapter<String> equipmentsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, equipmentNames);
        equipmentsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ms_select_equipment.setAdapter(equipmentsAdapter);


        testTypeNames = new ArrayList<>();
        testTypeIDs = new ArrayList<>();
        for (EquipmentAndTestTypeData.DataBean.YljtpBean temp : mEquipmentTestData.getData().getYljtp()) {
            testTypeNames.add(temp.getTestName());
            testTypeIDs.add(temp.getTestId());
        }
        ArrayAdapter<String> testTypessAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, testTypeNames);
        testTypessAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ms_select_test_type.setAdapter(testTypessAdapter);

        //根据传过来的参数对象来设置这些选择框该显示的内容
        for (int i = 0; i < equipmentIDs.size(); i++) {
            if (mParametersData.equipmentID.equals(equipmentIDs.get(i))) {
                ms_select_equipment.setSelection(i + 1);
                KLog.e("默认：" + (i + 1) + "个");
            }
        }

        KLog.e("mParametersData.testTypeID:" + mParametersData.testTypeID);
        for (int i = 0; i < testTypeIDs.size(); i++) {
            if (mParametersData.testTypeID.equals(testTypeIDs.get(i))) {
                KLog.e("111111111testTypeID：" + (i + 1) + "个");
                ms_select_test_type.setSelection(i + 1);
                KLog.e("22222222222testTypeID：" + (i + 1) + "个");
            }
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_cancel_dialog:
                onBackPressed();
                break;

            case R.id.bt_search_dialog:
                String startTime = DateUtils.ChangeTimeToLong(start_date_time.getEditText().getText().toString());
                String endTime = DateUtils.ChangeTimeToLong(end_date_time.getEditText().getText().toString());
                if (Integer.valueOf(startTime) <= Integer.valueOf(endTime)) {
                    BaseApplication.bus.post(mParametersData);
                    onBackPressed();
                } else {
                    end_date_time.setError("结束时间不能小于开始时间");
                    end_date_time.setErrorEnabled(true);
                }
                break;
        }
    }


    private void setStartDateTime() {
        isStartDateTime = true;
        showDatePicker();
    }

    private void setEndDateTime() {
        isStartDateTime = false;
        showDatePicker();
    }

    private void showDatePicker() {
        Calendar now = Calendar.getInstance();
        if (isStartDateTime) {
            now.add(Calendar.MONTH, -3);
        }
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

    private void revealView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            fl_container.post(new Runnable() {
                @Override
                public void run() {

                    int cx = fl_container.getRight();
                    int cy = fl_container.getBottom();
                    int radius = Math.max(fl_container.getWidth(), fl_container.getHeight());
                    Animator mAnimator = ViewAnimationUtils.createCircularReveal(fl_container, cx, cy, 0, radius);
                    mAnimator.setDuration(300);
                    mAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                    mAnimator.start();
                }
            });
        }
    }

    private void hideView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int cx = fl_container.getRight();
            int cy = fl_container.getBottom();
            int radius = Math.max(fl_container.getWidth(), fl_container.getHeight());
            Animator mAnimator = ViewAnimationUtils.createCircularReveal(fl_container, cx, cy, radius, 0);
            mAnimator.setDuration(500);
            mAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
            mAnimator.addListener(new AnimatorListenerAdapter() {

                @Override
                public void onAnimationStart(Animator animation) {
                    super.onAnimationStart(animation);
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    fl_container.setVisibility(View.INVISIBLE);
                    finish();
                }
            });
            mAnimator.start();
        } else {
            finish();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        TimePickerDialog tpd = (TimePickerDialog) getFragmentManager().findFragmentByTag("Timepickerdialog");
        DatePickerDialog dpd = (DatePickerDialog) getFragmentManager().findFragmentByTag("Datepickerdialog");

        if (tpd != null) tpd.setOnTimeSetListener(this);
        if (dpd != null) dpd.setOnDateSetListener(this);

        revealView();
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {
        String hourString = hourOfDay < 10 ? "0" + hourOfDay : "" + hourOfDay;
        String minuteString = minute < 10 ? "0" + minute : "" + minute;
        String secondString = second < 10 ? "0" + second : "" + second;
        String timeString = hourString + ":" + minuteString + ":" + secondString;
        if (isStartDateTime) {
            startDateTime = startDateTime + timeString;
            start_date_time.getEditText().setText(startDateTime);
            mParametersData.startDateTime = startDateTime;
        } else {
            endDateTime = endDateTime + timeString;
            end_date_time.getEditText().setText(endDateTime);
            mParametersData.endDateTime = endDateTime;
        }
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String monthString = (++monthOfYear) < 10 ? "0" + (monthOfYear) : "" + (monthOfYear);
        String dayString = dayOfMonth < 10 ? "0" + dayOfMonth : "" + dayOfMonth;
        String dateString = year + "-" + monthString + "-" + dayString + " ";
        if (isStartDateTime) {
            startDateTime = dateString;
        } else {
            endDateTime = dateString;
        }
        showTimePicker();
    }

    @Override
    public void onBackPressed() {
        hideView();
    }

    @Override
    public String createRefreshULR() {
        return url;
    }

    @Override
    public boolean swipeBackPriority() {
        return false;
    }
}
