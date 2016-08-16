package com.shtoone.shtw.bean;


import java.util.List;

/**
 * 用户实体类
 * Created by leguang on 2016/5/11 0031.
 */
public class UserInfoData {

    /**
     * userPhoneNum : 15972036794
     * departName : 石银高速
     * quanxian : {"hntchaobiaoReal":true,"hntchaobiaoSp":true,"syschaobiaoReal":true}
     * xmmc : 徐宿淮盐试验室拌和站信息化物联网管理系统
     * updateDepartTime : 2015-12-02 12:12:36
     * departId : 297ee90c4447f8a4014447fbba1e0015
     * userRole : 4
     * userFullName : 上海同望
     * SMSGroup : []
     * type : GL
     * success : true
     */

    private String userPhoneNum;
    private String departName;
    /**
     * hntchaobiaoReal : true
     * hntchaobiaoSp : true
     * syschaobiaoReal : true
     */

    private QuanxianBean quanxian;
    private String xmmc;
    private String updateDepartTime;
    private String departId;
    private String userRole;
    private String userFullName;
    private String type;
    private boolean success;
    private List<?> SMSGroup;

    public String getUserPhoneNum() {
        return userPhoneNum;
    }

    public void setUserPhoneNum(String userPhoneNum) {
        this.userPhoneNum = userPhoneNum;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public QuanxianBean getQuanxian() {
        return quanxian;
    }

    public void setQuanxian(QuanxianBean quanxian) {
        this.quanxian = quanxian;
    }

    public String getXmmc() {
        return xmmc;
    }

    public void setXmmc(String xmmc) {
        this.xmmc = xmmc;
    }

    public String getUpdateDepartTime() {
        return updateDepartTime;
    }

    public void setUpdateDepartTime(String updateDepartTime) {
        this.updateDepartTime = updateDepartTime;
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<?> getSMSGroup() {
        return SMSGroup;
    }

    public void setSMSGroup(List<?> SMSGroup) {
        this.SMSGroup = SMSGroup;
    }

    public static class QuanxianBean {
        private boolean hntchaobiaoReal;
        private boolean hntchaobiaoSp;
        private boolean syschaobiaoReal;

        public boolean isHntchaobiaoReal() {
            return hntchaobiaoReal;
        }

        public void setHntchaobiaoReal(boolean hntchaobiaoReal) {
            this.hntchaobiaoReal = hntchaobiaoReal;
        }

        public boolean isHntchaobiaoSp() {
            return hntchaobiaoSp;
        }

        public void setHntchaobiaoSp(boolean hntchaobiaoSp) {
            this.hntchaobiaoSp = hntchaobiaoSp;
        }

        public boolean isSyschaobiaoReal() {
            return syschaobiaoReal;
        }

        public void setSyschaobiaoReal(boolean syschaobiaoReal) {
            this.syschaobiaoReal = syschaobiaoReal;
        }
    }
}
