package com.shtoone.shtw.bean;

import java.io.Serializable;

/**
 * Created by leguang on 2016/8/4 0004.
 */
public class DepartmentData implements Cloneable, Serializable {
    public String departmentID;
    public String departmentName;
    public int fromto;


    public DepartmentData() {
    }

    public DepartmentData(String departmentID, String departmentName, int fromto) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.fromto = fromto;
    }

    //克隆
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
