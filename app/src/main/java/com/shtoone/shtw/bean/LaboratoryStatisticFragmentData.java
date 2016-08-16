package com.shtoone.shtw.bean;

import java.util.List;

/**
 * Created by leguang on 2016/7/18 0018.
 */
public class LaboratoryStatisticFragmentData {
    /**
     * data : [{"qualifiedCount":"12381","testType":"100014","testName":"混凝土试件抗压强度试验","notqualifiedCount":"75","testCount":"12546","validCount":"8","userGroupId":"f89aff0750f942b60150fe99ff3f001f","qualifiedPer":"98.68"}]
     * success : true
     */

    private boolean success;
    /**
     * qualifiedCount : 12381
     * testType : 100014
     * testName : 混凝土试件抗压强度试验
     * notqualifiedCount : 75
     * testCount : 12546
     * validCount : 8
     * userGroupId : f89aff0750f942b60150fe99ff3f001f
     * qualifiedPer : 98.68
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
        private String qualifiedCount;
        private String testType;
        private String testName;
        private String notqualifiedCount;
        private String testCount;
        private String validCount;
        private String userGroupId;
        private String qualifiedPer;

        public String getQualifiedCount() {
            return qualifiedCount;
        }

        public void setQualifiedCount(String qualifiedCount) {
            this.qualifiedCount = qualifiedCount;
        }

        public String getTestType() {
            return testType;
        }

        public void setTestType(String testType) {
            this.testType = testType;
        }

        public String getTestName() {
            return testName;
        }

        public void setTestName(String testName) {
            this.testName = testName;
        }

        public String getNotqualifiedCount() {
            return notqualifiedCount;
        }

        public void setNotqualifiedCount(String notqualifiedCount) {
            this.notqualifiedCount = notqualifiedCount;
        }

        public String getTestCount() {
            return testCount;
        }

        public void setTestCount(String testCount) {
            this.testCount = testCount;
        }

        public String getValidCount() {
            return validCount;
        }

        public void setValidCount(String validCount) {
            this.validCount = validCount;
        }

        public String getUserGroupId() {
            return userGroupId;
        }

        public void setUserGroupId(String userGroupId) {
            this.userGroupId = userGroupId;
        }

        public String getQualifiedPer() {
            return qualifiedPer;
        }

        public void setQualifiedPer(String qualifiedPer) {
            this.qualifiedPer = qualifiedPer;
        }
    }
}
