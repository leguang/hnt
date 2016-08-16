package com.shtoone.shtw.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by leguang on 2016/6/23 0016.
 */
public class WannengjiFragmentViewPagerFragmentRecyclerViewItemData {
    /**
     * data : [{"GCMC":"桥梁工程","SYJID":"6E678FB6-333D-4F51-8A01-FF2ED3F01158","SYRQ":"2016-06-01","chuzhi":"0","testName":"钢筋试验","SGBW":"周家寨大桥右幅11空心墩4.5-9m","LZQD":"","shebeiname":"二航试验段分部1号压力机","PDJG":"合格","QFLZ":"","SJBH":"1","PZBM":""},{"GCMC":"桥梁工程","SYJID":"6D7CD53E-7DD3-4C0F-BBE6-B650D3C9B842","SYRQ":"2016-05-24","chuzhi":"0","testName":"钢筋试验","SGBW":"周家寨大桥左幅5空心墩63-65.25m","LZQD":"","shebeiname":"二航试验段分部1号压力机","PDJG":"合格","QFLZ":"","SJBH":"1","PZBM":""}]
     * success : true
     */

    private boolean success;
    /**
     * GCMC : 桥梁工程
     * SYJID : 6E678FB6-333D-4F51-8A01-FF2ED3F01158
     * SYRQ : 2016-06-01
     * chuzhi : 0
     * testName : 钢筋试验
     * SGBW : 周家寨大桥右幅11空心墩4.5-9m
     * LZQD :
     * shebeiname : 二航试验段分部1号压力机
     * PDJG : 合格
     * QFLZ :
     * SJBH : 1
     * PZBM :
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

    public static class DataBean implements Serializable {
        private String GCMC;
        private String SYJID;
        private String SYRQ;
        private String chuzhi;
        private String testName;
        private String SGBW;
        private String LZQD;
        private String shebeiname;
        private String PDJG;
        private String QFLZ;
        private String SJBH;
        private String PZBM;

        public String getGCMC() {
            return GCMC;
        }

        public void setGCMC(String GCMC) {
            this.GCMC = GCMC;
        }

        public String getSYJID() {
            return SYJID;
        }

        public void setSYJID(String SYJID) {
            this.SYJID = SYJID;
        }

        public String getSYRQ() {
            return SYRQ;
        }

        public void setSYRQ(String SYRQ) {
            this.SYRQ = SYRQ;
        }

        public String getChuzhi() {
            return chuzhi;
        }

        public void setChuzhi(String chuzhi) {
            this.chuzhi = chuzhi;
        }

        public String getTestName() {
            return testName;
        }

        public void setTestName(String testName) {
            this.testName = testName;
        }

        public String getSGBW() {
            return SGBW;
        }

        public void setSGBW(String SGBW) {
            this.SGBW = SGBW;
        }

        public String getLZQD() {
            return LZQD;
        }

        public void setLZQD(String LZQD) {
            this.LZQD = LZQD;
        }

        public String getShebeiname() {
            return shebeiname;
        }

        public void setShebeiname(String shebeiname) {
            this.shebeiname = shebeiname;
        }

        public String getPDJG() {
            return PDJG;
        }

        public void setPDJG(String PDJG) {
            this.PDJG = PDJG;
        }

        public String getQFLZ() {
            return QFLZ;
        }

        public void setQFLZ(String QFLZ) {
            this.QFLZ = QFLZ;
        }

        public String getSJBH() {
            return SJBH;
        }

        public void setSJBH(String SJBH) {
            this.SJBH = SJBH;
        }

        public String getPZBM() {
            return PZBM;
        }

        public void setPZBM(String PZBM) {
            this.PZBM = PZBM;
        }
    }
}
