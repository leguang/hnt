package com.shtoone.shtw.bean;

import java.util.List;

/**
 * Created by leguang on 2016/7/19 0019.
 */
public class ConcreteFragmentData {

    /**
     * data : [{"departName":"监理公司","hczlv":"3.29","hcblv":"7.42","cbpanshu":"1224","totalPanshu":"4919","hczpanshu":"12","bhjCount":"5","hcbpanshu":"365","mcblv":"3.96","czlv":"0.49","bhzCount":"2","mcbpanshu":"195","departId":"f89aff075317222c01531b866ec50010","cczpanshu":"6","cblv":"24.88","mczlv":"1.03","totalFangliang":"4933.398","mczpanshu":"2"}]
     * success : true
     */

    private boolean success;
    /**
     * departName : 监理公司
     * hczlv : 3.29
     * hcblv : 7.42
     * cbpanshu : 1224
     * totalPanshu : 4919
     * hczpanshu : 12
     * bhjCount : 5
     * hcbpanshu : 365
     * mcblv : 3.96
     * czlv : 0.49
     * bhzCount : 2
     * mcbpanshu : 195
     * departId : f89aff075317222c01531b866ec50010
     * cczpanshu : 6
     * cblv : 24.88
     * mczlv : 1.03
     * totalFangliang : 4933.398
     * mczpanshu : 2
     */

    private List<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String departName;
        private String hczlv;
        private String hcblv;
        private String cbpanshu;
        private String totalPanshu;
        private String hczpanshu;
        private String bhjCount;
        private String hcbpanshu;
        private String mcblv;
        private String czlv;
        private String bhzCount;
        private String mcbpanshu;
        private String departId;
        private String cczpanshu;
        private String cblv;
        private String mczlv;
        private String totalFangliang;
        private String mczpanshu;

        public String getDepartName() {
            return departName;
        }

        public void setDepartName(String departName) {
            this.departName = departName;
        }

        public String getHczlv() {
            return hczlv;
        }

        public void setHczlv(String hczlv) {
            this.hczlv = hczlv;
        }

        public String getHcblv() {
            return hcblv;
        }

        public void setHcblv(String hcblv) {
            this.hcblv = hcblv;
        }

        public String getCbpanshu() {
            return cbpanshu;
        }

        public void setCbpanshu(String cbpanshu) {
            this.cbpanshu = cbpanshu;
        }

        public String getTotalPanshu() {
            return totalPanshu;
        }

        public void setTotalPanshu(String totalPanshu) {
            this.totalPanshu = totalPanshu;
        }

        public String getHczpanshu() {
            return hczpanshu;
        }

        public void setHczpanshu(String hczpanshu) {
            this.hczpanshu = hczpanshu;
        }

        public String getBhjCount() {
            return bhjCount;
        }

        public void setBhjCount(String bhjCount) {
            this.bhjCount = bhjCount;
        }

        public String getHcbpanshu() {
            return hcbpanshu;
        }

        public void setHcbpanshu(String hcbpanshu) {
            this.hcbpanshu = hcbpanshu;
        }

        public String getMcblv() {
            return mcblv;
        }

        public void setMcblv(String mcblv) {
            this.mcblv = mcblv;
        }

        public String getCzlv() {
            return czlv;
        }

        public void setCzlv(String czlv) {
            this.czlv = czlv;
        }

        public String getBhzCount() {
            return bhzCount;
        }

        public void setBhzCount(String bhzCount) {
            this.bhzCount = bhzCount;
        }

        public String getMcbpanshu() {
            return mcbpanshu;
        }

        public void setMcbpanshu(String mcbpanshu) {
            this.mcbpanshu = mcbpanshu;
        }

        public String getDepartId() {
            return departId;
        }

        public void setDepartId(String departId) {
            this.departId = departId;
        }

        public String getCczpanshu() {
            return cczpanshu;
        }

        public void setCczpanshu(String cczpanshu) {
            this.cczpanshu = cczpanshu;
        }

        public String getCblv() {
            return cblv;
        }

        public void setCblv(String cblv) {
            this.cblv = cblv;
        }

        public String getMczlv() {
            return mczlv;
        }

        public void setMczlv(String mczlv) {
            this.mczlv = mczlv;
        }

        public String getTotalFangliang() {
            return totalFangliang;
        }

        public void setTotalFangliang(String totalFangliang) {
            this.totalFangliang = totalFangliang;
        }

        public String getMczpanshu() {
            return mczpanshu;
        }

        public void setMczpanshu(String mczpanshu) {
            this.mczpanshu = mczpanshu;
        }
    }
}
