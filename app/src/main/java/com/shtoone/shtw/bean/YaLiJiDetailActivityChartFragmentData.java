package com.shtoone.shtw.bean;

import java.io.Serializable;

/**
 * Created by leguang on 2016/7/13 0013.
 */
public class YaLiJiDetailActivityChartFragmentData implements Serializable {
    private String data1;
    private String data2;
    private String[] x;
    private String[] y;

    public YaLiJiDetailActivityChartFragmentData(String data1, String data2, String[] x, String[] y) {
        this.data1 = data1;
        this.data2 = data2;
        this.x = x;
        this.y = y;
    }

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

    public String[] getX() {
        return x;
    }

    public void setX(String[] x) {
        this.x = x;
    }

    public String[] getY() {
        return y;
    }

    public void setY(String[] y) {
        this.y = y;
    }
}
