package com.shtoone.shtw.bean;

import java.util.List;

/**
 * Created by leguang on 2016/7/12 0012.
 */
public class TestTypeData {

    /**
     * data : [{"id":0,"testId":"100047","testName":"钢筋试验","testType":"2"},{"id":0,"testId":"100048","testName":"钢筋焊接接头试验","testType":"2"},{"id":0,"testId":"100049","testName":"钢筋机械连接接头试验","testType":"2"}]
     * success : true
     */

    private boolean success;
    /**
     * id : 0
     * testId : 100047
     * testName : 钢筋试验
     * testType : 2
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
        private int id;
        private String testId;
        private String testName;
        private String testType;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTestId() {
            return testId;
        }

        public void setTestId(String testId) {
            this.testId = testId;
        }

        public String getTestName() {
            return testName;
        }

        public void setTestName(String testName) {
            this.testName = testName;
        }

        public String getTestType() {
            return testType;
        }

        public void setTestType(String testType) {
            this.testType = testType;
        }
    }
}
