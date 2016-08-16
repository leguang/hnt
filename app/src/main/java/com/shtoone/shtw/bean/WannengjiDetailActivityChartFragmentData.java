package com.shtoone.shtw.bean;

import java.io.Serializable;

/**
 * Created by leguang on 2016/7/13 0013.
 */
public class WannengjiDetailActivityChartFragmentData implements Serializable {
    private String data1;
    private String data2;
    private String data3;
    private String data4;
    private String data5;
    private String[] x;
    private String[] y;

    public WannengjiDetailActivityChartFragmentData(String data1, String data2, String data3, String data4, String data5, String[] x, String[] y) {
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
        this.data4 = data4;
        this.data5 = data5;
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

    public String getData3() {
        return data3;
    }

    public void setData3(String data3) {
        this.data3 = data3;
    }

    public String getData4() {
        return data4;
    }

    public void setData4(String data4) {
        this.data4 = data4;
    }

    public String getData5() {
        return data5;
    }

    public void setData5(String data5) {
        this.data5 = data5;
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
