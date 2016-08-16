package com.shtoone.shtw.bean;

import java.util.List;

/**
 * Created by leguang on 2016/5/18 0018.
 */
public class LaboratoryFragmentRecyclerViewItemData {


    /**
     * data : [[{"realCount":"0","departName":"中交三公局","testName":"混凝土试件抗压强度试验","testtype":"100014","syjCount":"4","realPer":"0.00","testCount":"3","notQualifiedCount":"3","sysCount":"4","userGroupId":"f89aff0750caf1a80150cb03b6910008"}]]
     * success : true
     */

    private boolean success;
    /**
     * realCount : 0
     * departName : 中交三公局
     * testName : 混凝土试件抗压强度试验
     * testtype : 100014
     * syjCount : 4
     * realPer : 0.00
     * testCount : 3
     * notQualifiedCount : 3
     * sysCount : 4
     * userGroupId : f89aff0750caf1a80150cb03b6910008
     */

    private List<List<DataBean>> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<List<DataBean>> getData() {
        return data;
    }

    public void setData(List<List<DataBean>> data) {
        this.data = data;
    }

    public static class DataBean {
        private String realCount;
        private String departName;
        private String testName;
        private String testtype;
        private String syjCount;
        private String realPer;
        private String testCount;
        private String notQualifiedCount;
        private String sysCount;
        private String userGroupId;

        public String getRealCount() {
            return realCount;
        }

        public void setRealCount(String realCount) {
            this.realCount = realCount;
        }

        public String getDepartName() {
            return departName;
        }

        public void setDepartName(String departName) {
            this.departName = departName;
        }

        public String getTestName() {
            return testName;
        }

        public void setTestName(String testName) {
            this.testName = testName;
        }

        public String getTesttype() {
            return testtype;
        }

        public void setTesttype(String testtype) {
            this.testtype = testtype;
        }

        public String getSyjCount() {
            return syjCount;
        }

        public void setSyjCount(String syjCount) {
            this.syjCount = syjCount;
        }

        public String getRealPer() {
            return realPer;
        }

        public void setRealPer(String realPer) {
            this.realPer = realPer;
        }

        public String getTestCount() {
            return testCount;
        }

        public void setTestCount(String testCount) {
            this.testCount = testCount;
        }

        public String getNotQualifiedCount() {
            return notQualifiedCount;
        }

        public void setNotQualifiedCount(String notQualifiedCount) {
            this.notQualifiedCount = notQualifiedCount;
        }

        public String getSysCount() {
            return sysCount;
        }

        public void setSysCount(String sysCount) {
            this.sysCount = sysCount;
        }

        public String getUserGroupId() {
            return userGroupId;
        }

        public void setUserGroupId(String userGroupId) {
            this.userGroupId = userGroupId;
        }
    }
}
