package com.shtoone.shtw.bean;

import java.util.List;

/**
 * Created by leguang on 2016/6/15 0015.
 */
public class EquipmentData {

    /**
     * data : [{"departid":"f89aff075317222c01531b8b25b0001b","banhezhanminchen":"1标压力机","gprsbianhao":"sphntyl0101"},{"departid":"f89aff075317222c01531b8b25b0001b","banhezhanminchen":"1标万能机","gprsbianhao":"sphntwn0101"},{"departid":"f89b12c254c7c0920154c7d2bce40013","banhezhanminchen":"3标压力机","gprsbianhao":"sphntyl0301"},{"departid":"f89b12c254c7c0920154c7d2bce40013","banhezhanminchen":"3标万能机","gprsbianhao":"sphntwn0301"}]
     * success : true
     */

    private boolean success;
    /**
     * departid : f89aff075317222c01531b8b25b0001b
     * banhezhanminchen : 1标压力机
     * gprsbianhao : sphntyl0101
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
