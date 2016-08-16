package com.shtoone.shtw.bean;

/**
 * Created by leguang on 2016/8/5 0005.
 */
public class LaboratoryMainActivityData {
    /**
     * ylNoHandle : 125
     * ylDisqual : 128
     * wnHandle : 4
     * ylHandle : 3
     * ylQual : 19504
     * wnQual : 9
     * wnNoHandle : 6
     * wnDisqual : 10
     */

    private DataBean data;
    /**
     * data : {"ylNoHandle":"125","ylDisqual":"128","wnHandle":"4","ylHandle":"3","ylQual":"19504","wnQual":"9","wnNoHandle":"6","wnDisqual":"10"}
     * success : true
     */

    private boolean success;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class DataBean {
        private String ylNoHandle;
        private String ylDisqual;
        private String wnHandle;
        private String ylHandle;
        private String ylQual;
        private String wnQual;
        private String wnNoHandle;
        private String wnDisqual;

        public String getYlNoHandle() {
            return ylNoHandle;
        }

        public void setYlNoHandle(String ylNoHandle) {
            this.ylNoHandle = ylNoHandle;
        }

        public String getYlDisqual() {
            return ylDisqual;
        }

        public void setYlDisqual(String ylDisqual) {
            this.ylDisqual = ylDisqual;
        }

        public String getWnHandle() {
            return wnHandle;
        }

        public void setWnHandle(String wnHandle) {
            this.wnHandle = wnHandle;
        }

        public String getYlHandle() {
            return ylHandle;
        }

        public void setYlHandle(String ylHandle) {
            this.ylHandle = ylHandle;
        }

        public String getYlQual() {
            return ylQual;
        }

        public void setYlQual(String ylQual) {
            this.ylQual = ylQual;
        }

        public String getWnQual() {
            return wnQual;
        }

        public void setWnQual(String wnQual) {
            this.wnQual = wnQual;
        }

        public String getWnNoHandle() {
            return wnNoHandle;
        }

        public void setWnNoHandle(String wnNoHandle) {
            this.wnNoHandle = wnNoHandle;
        }

        public String getWnDisqual() {
            return wnDisqual;
        }

        public void setWnDisqual(String wnDisqual) {
            this.wnDisqual = wnDisqual;
        }
    }
}
