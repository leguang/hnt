package com.shtoone.shtw.bean;

import java.util.List;

/**
 * Created by leguang on 2016/7/28 0028.
 */
public class EquipmentAndTestTypeData {
    private DataBean data;
    /**
     * data : {"yljtp":[{"id":0,"testType":"1","testName":"混凝土试件抗压强度试验","testId":"100014"}],"wnjtp":[{"id":0,"testType":"2","testName":"钢筋试验","testId":"100047"}],"yljsb":[{"departid":"","banhezhanminchen":"二航试验段分部1号压力机","gprsbianhao":"TWSYS00012-000012"},{"departid":"","banhezhanminchen":"二航三分部1号压力机","gprsbianhao":"TWSYS00009-000025"},{"departid":"","banhezhanminchen":"四公二分部1号压力机","gprsbianhao":"TWSYS00017-000017"},{"departid":"","banhezhanminchen":"一航二分部1号压力机","gprsbianhao":"TWSYS00014-000014"},{"departid":"","banhezhanminchen":"三公三分部2号压力机","gprsbianhao":"TWSYS00021-000021"},{"departid":"","banhezhanminchen":"四公一分部1号压力机","gprsbianhao":"TWSYS00016-000016"}],"wnjsb":[{"departid":"","banhezhanminchen":"三公三分部1号压力机","gprsbianhao":"TWSYS00022-000023"},{"departid":"","banhezhanminchen":"三公一分部1号压力机","gprsbianhao":"TWSYS00020-000020"},{"departid":"","banhezhanminchen":"四公二分部1号压力机","gprsbianhao":"TWSYS00017-000017"},{"departid":"","banhezhanminchen":"二航二分部1号压力机","gprsbianhao":"TWSYS00008-000010"},{"departid":"","banhezhanminchen":"三公二分部1号压力机","gprsbianhao":"TWSYS00019-000019"},{"departid":"","banhezhanminchen":"二航试验段分部1号压力机","gprsbianhao":"TWSYS00012-000012"},{"departid":"","banhezhanminchen":"二航三分部1号压力机","gprsbianhao":"TWSYS00009-000025"},{"departid":"","banhezhanminchen":"二航三分部1号压力机","gprsbianhao":"TWSYS00009-000011"},{"departid":"","banhezhanminchen":"二航项目部1号压力机","gprsbianhao":"TWSYS00006-000008"},{"departid":"","banhezhanminchen":"一航一分部1号压力机","gprsbianhao":"TWSYS00013-000013"},{"departid":"","banhezhanminchen":"三公三分部2号压力机","gprsbianhao":"TWSYS00021-000021"},{"departid":"","banhezhanminchen":"二航局一分部1号压力机","gprsbianhao":"TWSYS00007-000009"},{"departid":"","banhezhanminchen":"四公一分部1号压力机","gprsbianhao":"TWSYS00016-000016"},{"departid":"","banhezhanminchen":"一航三分部1号压力机","gprsbianhao":"TWSYS00015-000015"},{"departid":"","banhezhanminchen":"一航二分部1号压力机","gprsbianhao":"TWSYS00014-000014"}]}
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
        /**
         * id : 0
         * testType : 1
         * testName : 混凝土试件抗压强度试验
         * testId : 100014
         */

        private List<YljtpBean> yljtp;
        /**
         * id : 0
         * testType : 2
         * testName : 钢筋试验
         * testId : 100047
         */

        private List<WnjtpBean> wnjtp;
        /**
         * departid :
         * banhezhanminchen : 二航试验段分部1号压力机
         * gprsbianhao : TWSYS00012-000012
         */

        private List<YljsbBean> yljsb;
        /**
         * departid :
         * banhezhanminchen : 三公三分部1号压力机
         * gprsbianhao : TWSYS00022-000023
         */

        private List<WnjsbBean> wnjsb;

        public List<YljtpBean> getYljtp() {
            return yljtp;
        }

        public void setYljtp(List<YljtpBean> yljtp) {
            this.yljtp = yljtp;
        }

        public List<WnjtpBean> getWnjtp() {
            return wnjtp;
        }

        public void setWnjtp(List<WnjtpBean> wnjtp) {
            this.wnjtp = wnjtp;
        }

        public List<YljsbBean> getYljsb() {
            return yljsb;
        }

        public void setYljsb(List<YljsbBean> yljsb) {
            this.yljsb = yljsb;
        }

        public List<WnjsbBean> getWnjsb() {
            return wnjsb;
        }

        public void setWnjsb(List<WnjsbBean> wnjsb) {
            this.wnjsb = wnjsb;
        }

        public static class YljtpBean {
            private int id;
            private String testType;
            private String testName;
            private String testId;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
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

            public String getTestId() {
                return testId;
            }

            public void setTestId(String testId) {
                this.testId = testId;
            }
        }

        public static class WnjtpBean {
            private int id;
            private String testType;
            private String testName;
            private String testId;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
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

            public String getTestId() {
                return testId;
            }

            public void setTestId(String testId) {
                this.testId = testId;
            }
        }

        public static class YljsbBean {
            private String departid;
            private String banhezhanminchen;
            private String gprsbianhao;

            public String getDepartid() {
                return departid;
            }

            public void setDepartid(String departid) {
                this.departid = departid;
            }

            public String getBanhezhanminchen() {
                return banhezhanminchen;
            }

            public void setBanhezhanminchen(String banhezhanminchen) {
                this.banhezhanminchen = banhezhanminchen;
            }

            public String getGprsbianhao() {
                return gprsbianhao;
            }

            public void setGprsbianhao(String gprsbianhao) {
                this.gprsbianhao = gprsbianhao;
            }
        }

        public static class WnjsbBean {
            private String departid;
            private String banhezhanminchen;
            private String gprsbianhao;

            public String getDepartid() {
                return departid;
            }

            public void setDepartid(String departid) {
                this.departid = departid;
            }

            public String getBanhezhanminchen() {
                return banhezhanminchen;
            }

            public void setBanhezhanminchen(String banhezhanminchen) {
                this.banhezhanminchen = banhezhanminchen;
            }

            public String getGprsbianhao() {
                return gprsbianhao;
            }

            public void setGprsbianhao(String gprsbianhao) {
                this.gprsbianhao = gprsbianhao;
            }
        }
    }
}
