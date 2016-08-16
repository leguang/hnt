package com.shtoone.shtw.bean;

/**
 * Created by leguang on 2016/8/5 0005.
 */
public class ConcreteMainActivityData {

    /**
     * weekCount : 0
     * primary : 352182
     * high : 44246
     * monthCount : 0
     * dayCount : 0
     * middle : 100734
     */

    private DataBean data;
    /**
     * data : {"weekCount":"0","primary":"352182","high":"44246","monthCount":"0","dayCount":"0","middle":"100734"}
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
        private String weekCount;
        private String primary;
        private String high;
        private String monthCount;
        private String dayCount;
        private String middle;

        public String getWeekCount() {
            return weekCount;
        }

        public void setWeekCount(String weekCount) {
            this.weekCount = weekCount;
        }

        public String getPrimary() {
            return primary;
        }

        public void setPrimary(String primary) {
            this.primary = primary;
        }

        public String getHigh() {
            return high;
        }

        public void setHigh(String high) {
            this.high = high;
        }

        public String getMonthCount() {
            return monthCount;
        }

        public void setMonthCount(String monthCount) {
            this.monthCount = monthCount;
        }

        public String getDayCount() {
            return dayCount;
        }

        public void setDayCount(String dayCount) {
            this.dayCount = dayCount;
        }

        public String getMiddle() {
            return middle;
        }

        public void setMiddle(String middle) {
            this.middle = middle;
        }
    }
}
