package com.shtoone.shtw.bean;

import java.util.List;

/**
 * Created by leguang on 2016/7/20 0020.
 */
public class MaterialStatisticFragmentData {

    /**
     * data : [{"peibi":"1251925.000","name":"砂1","shiji":"714998.000","wuchazhi":"-536927.00"},{"peibi":"","name":"砂2","shiji":"1240037.000","wuchazhi":"1240037.00"},{"peibi":"1977298.000","name":"碎石1","shiji":"1969219.000","wuchazhi":"-8079.00"},{"peibi":"229449.000","name":"碎石2","shiji":"228237.000","wuchazhi":"-1212.00"},{"peibi":"461481.000","name":"水泥1","shiji":"459936.000","wuchazhi":"-1545.00"},{"peibi":"247220.600","name":"水泥2","shiji":"246005.900","wuchazhi":"-1214.70"},{"peibi":"0.000","name":"矿粉","shiji":"0.000","wuchazhi":"0.00"},{"peibi":"0.000","name":"粉煤灰","shiji":"0.000","wuchazhi":"0.00"},{"peibi":"419574.700","name":"水","shiji":"419570.000","wuchazhi":"-4.70"},{"peibi":"3167.850","name":"减水剂1","shiji":"3173.190","wuchazhi":"5.34"}]
     * success : true
     */

    private boolean success;
    /**
     * peibi : 1251925.000
     * name : 砂1
     * shiji : 714998.000
     * wuchazhi : -536927.00
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
        private String peibi;
        private String name;
        private String shiji;
        private String wuchazhi;

        public String getPeibi() {
            return peibi;
        }

        public void setPeibi(String peibi) {
            this.peibi = peibi;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getShiji() {
            return shiji;
        }

        public void setShiji(String shiji) {
            this.shiji = shiji;
        }

        public String getWuchazhi() {
            return wuchazhi;
        }

        public void setWuchazhi(String wuchazhi) {
            this.wuchazhi = wuchazhi;
        }
    }
}
