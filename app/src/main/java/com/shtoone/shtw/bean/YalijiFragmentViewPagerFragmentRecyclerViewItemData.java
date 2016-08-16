package com.shtoone.shtw.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by leguang on 2016/6/16 0016.
 */
public class YalijiFragmentViewPagerFragmentRecyclerViewItemData {
    /**
     * data : [{"GCMC":"杨柳河1#大桥","SYJID":"392E893E-F063-4C93-ACE4-8E8F5581903A","SYRQ":"2016-07-15","chuzhi":"0","testName":"混凝土试件抗压强度试验","SGBW":"右幅2-1T梁","SJQD":"C50","shebeiname":"二航项目部1号压力机","PDJG":"有效","SJBH":"1293","QDDBZ":"51.1"},{"GCMC":"杨柳河1#大桥","SYJID":"D49DB0CA-3F8E-4864-8341-B07E6E22EB18","SYRQ":"2016-07-15","chuzhi":"0","testName":"混凝土试件抗压强度试验","SGBW":"右幅8-4T梁","SJQD":"C50","shebeiname":"二航项目部1号压力机","PDJG":"有效","SJBH":"1294","QDDBZ":"51.9"},{"GCMC":"杨柳河1#大桥","SYJID":"7E124510-800F-4E17-B4D1-33BA81A3A37F","SYRQ":"2016-07-14","chuzhi":"0","testName":"混凝土试件抗压强度试验","SGBW":"右幅13-4T梁","SJQD":"C50","shebeiname":"二航项目部1号压力机","PDJG":"有效","SJBH":"1289","QDDBZ":"51.3"},{"GCMC":"杨柳河2#大桥","SYJID":"28D83842-4E84-475B-8227-4C9681F85E9C","SYRQ":"2016-07-14","chuzhi":"0","testName":"混凝土试件抗压强度试验","SGBW":"左幅4-5T梁","SJQD":"C50","shebeiname":"二航项目部1号压力机","PDJG":"有效","SJBH":"1290","QDDBZ":"51.6"},{"GCMC":"杨柳河1#大桥","SYJID":"5F9A4660-B032-4949-97DD-5D850333E64D","SYRQ":"2016-07-13","chuzhi":"0","testName":"混凝土试件抗压强度试验","SGBW":"左幅8-1T梁","SJQD":"C50","shebeiname":"二航项目部1号压力机","PDJG":"有效","SJBH":"1266","QDDBZ":"51.2"},{"GCMC":"杨柳河1#大桥","SYJID":"2E1904BF-1B84-4B42-9FEC-051299EB863E","SYRQ":"2016-07-13","chuzhi":"0","testName":"混凝土试件抗压强度试验","SGBW":"右幅13-3T梁","SJQD":"C50","shebeiname":"二航项目部1号压力机","PDJG":"有效","SJBH":"1267","QDDBZ":"51"},{"GCMC":"杨柳河1#大桥","SYJID":"31F568F9-90F7-404B-8397-D32F7A1286C8","SYRQ":"2016-07-13","chuzhi":"0","testName":"混凝土试件抗压强度试验","SGBW":"右幅5-3T梁","SJQD":"C50","shebeiname":"二航项目部1号压力机","PDJG":"有效","SJBH":"1268","QDDBZ":"52.5"},{"GCMC":"杨柳河1#大桥","SYJID":"FE0EFDEB-8CA9-4827-84DB-188774821447","SYRQ":"2016-07-12","chuzhi":"0","testName":"混凝土试件抗压强度试验","SGBW":"左幅13-1T梁","SJQD":"C50","shebeiname":"二航项目部1号压力机","PDJG":"有效","SJBH":"1264","QDDBZ":"51.4"},{"GCMC":"杨柳河2#大桥","SYJID":"F9E1BD09-6019-4A74-AC60-8954AC651555","SYRQ":"2016-07-12","chuzhi":"0","testName":"混凝土试件抗压强度试验","SGBW":"左幅4-4T梁","SJQD":"C50","shebeiname":"二航项目部1号压力机","PDJG":"有效","SJBH":"1265","QDDBZ":"52.1"},{"GCMC":"杨柳河1#大桥","SYJID":"1B965E20-19CF-489C-AEBA-2E1CDE9C8EA3","SYRQ":"2016-07-11","chuzhi":"0","testName":"混凝土试件抗压强度试验","SGBW":"左幅11-4T梁","SJQD":"C50","shebeiname":"二航项目部1号压力机","PDJG":"有效","SJBH":"1198","QDDBZ":"51.7"},{"GCMC":"杨柳河1#大桥","SYJID":"6A0F2D96-BDD7-49B7-A397-26B67DD4FEC3","SYRQ":"2016-07-11","chuzhi":"0","testName":"混凝土试件抗压强度试验","SGBW":"右幅6-4T梁","SJQD":"C50","shebeiname":"二航项目部1号压力机","PDJG":"有效","SJBH":"1199","QDDBZ":"51.7"},{"GCMC":"杨柳河2#大桥","SYJID":"7260B917-DDA2-4E0A-9720-2954A00F5E4E","SYRQ":"2016-07-10","chuzhi":"0","testName":"混凝土试件抗压强度试验","SGBW":"左幅4-3T梁","SJQD":"C50","shebeiname":"二航项目部1号压力机","PDJG":"有效","SJBH":"1194","QDDBZ":"51.9"},{"GCMC":"杨柳河1#大桥","SYJID":"9A8E5BC2-C2CA-4292-A64A-1216D36388DA","SYRQ":"2016-07-10","chuzhi":"0","testName":"混凝土试件抗压强度试验","SGBW":"右幅5-5T梁","SJQD":"C50","shebeiname":"二航项目部1号压力机","PDJG":"有效","SJBH":"1196","QDDBZ":"51.4"},{"GCMC":"盘龙河1#大桥","SYJID":"D710FA13-36B1-4962-9B2E-59F7B9DFA70E","SYRQ":"2016-06-12","chuzhi":"0","testName":"混凝土试件抗压强度试验","SGBW":"左幅6-1T梁","SJQD":"C50","shebeiname":"二航项目部1号压力机","PDJG":"有效","SJBH":"1089","QDDBZ":"50.6"},{"GCMC":"杨柳河3#大桥","SYJID":"0FDC8D5D-0549-4246-9C8B-03A6E76D78BF","SYRQ":"2016-06-12","chuzhi":"0","testName":"混凝土试件抗压强度试验","SGBW":"右幅1-5T梁","SJQD":"C50","shebeiname":"二航项目部1号压力机","PDJG":"有效","SJBH":"1090","QDDBZ":"51.1"},{"GCMC":"杨柳河1#大桥","SYJID":"52130032-F2AF-412F-BCA0-A9BCB8A98598","SYRQ":"2016-06-12","chuzhi":"0","testName":"混凝土试件抗压强度试验","SGBW":"右幅12-2T梁","SJQD":"C50","shebeiname":"二航项目部1号压力机","PDJG":"有效","SJBH":"1091","QDDBZ":"53"},{"GCMC":"盘龙河1#大桥","SYJID":"0A602D6C-AF0B-4FA7-BB13-8DD3A04453D0","SYRQ":"2016-06-11","chuzhi":"0","testName":"混凝土试件抗压强度试验","SGBW":"左幅3-3T梁","SJQD":"C50","shebeiname":"二航项目部1号压力机","PDJG":"有效","SJBH":"1086","QDDBZ":"51"},{"GCMC":"杨柳河3#大桥","SYJID":"50B7A576-4906-44D2-9D17-E2C91A6DAD47","SYRQ":"2016-06-11","chuzhi":"0","testName":"混凝土试件抗压强度试验","SGBW":"右幅1-2T梁","SJQD":"C50","shebeiname":"二航项目部1号压力机","PDJG":"有效","SJBH":"1087","QDDBZ":"50.4"},{"GCMC":"杨柳河3#大桥","SYJID":"7EB26A61-FC27-42E9-93ED-068EDD2FE05A","SYRQ":"2016-06-11","chuzhi":"0","testName":"混凝土试件抗压强度试验","SGBW":"右幅1-3T梁","SJQD":"C50","shebeiname":"二航项目部1号压力机","PDJG":"有效","SJBH":"1088","QDDBZ":"50.7"},{"GCMC":"盘龙河3#大桥","SYJID":"0DF5238D-E871-4B72-A707-D1EE20F6A550","SYRQ":"2016-06-10","chuzhi":"0","testName":"混凝土试件抗压强度试验","SGBW":"左幅2#墩5#块","SJQD":"C50","shebeiname":"二航项目部1号压力机","PDJG":"有效","SJBH":"1082","QDDBZ":"50.8"},{"GCMC":"杨柳河3#大桥","SYJID":"5E8F3B96-D6CC-43B6-9A95-4D6E6F58FD3E","SYRQ":"2016-06-10","chuzhi":"0","testName":"混凝土试件抗压强度试验","SGBW":"右幅1-1T梁","SJQD":"C50","shebeiname":"二航项目部1号压力机","PDJG":"有效","SJBH":"1082","QDDBZ":"51.1"},{"GCMC":"杨柳河2#大桥","SYJID":"E9227A77-B4B8-4D9F-B4DE-55F97300E43E","SYRQ":"2016-06-10","chuzhi":"0","testName":"混凝土试件抗压强度试验","SGBW":"右幅3-5T梁","SJQD":"C50","shebeiname":"二航项目部1号压力机","PDJG":"有效","SJBH":"1084","QDDBZ":"50.9"},{"GCMC":"盘龙河1#大桥","SYJID":"7F97435F-456B-4CD2-9DC7-8712E7CC67F0","SYRQ":"2016-06-10","chuzhi":"0","testName":"混凝土试件抗压强度试验","SGBW":"左幅3-1T梁","SJQD":"C50","shebeiname":"二航项目部1号压力机","PDJG":"有效","SJBH":"1085","QDDBZ":"50.5"},{"GCMC":"盘龙河1#大桥","SYJID":"D3F482FD-BCBC-4C69-97D8-018918C54FF8","SYRQ":"2016-06-09","chuzhi":"0","testName":"混凝土试件抗压强度试验","SGBW":"左幅6-2T梁","SJQD":"C50","shebeiname":"二航项目部1号压力机","PDJG":"有效","SJBH":"1080","QDDBZ":"50.8"},{"GCMC":"杨柳河2#大桥","SYJID":"801828C4-587D-480B-AF7D-7299040AF079","SYRQ":"2016-06-09","chuzhi":"0","testName":"混凝土试件抗压强度试验","SGBW":"右幅3-4T梁","SJQD":"C50","shebeiname":"二航项目部1号压力机","PDJG":"有效","SJBH":"1081","QDDBZ":"50.6"},{"GCMC":"杨柳河3#大桥","SYJID":"E1572A4E-D980-42F9-8BEF-24075199ADC9","SYRQ":"2016-06-08","chuzhi":"0","testName":"混凝土试件抗压强度试验","SGBW":"左幅1-3T梁","SJQD":"C50","shebeiname":"二航项目部1号压力机","PDJG":"有效","SJBH":"1077","QDDBZ":"51"},{"GCMC":"杨柳河2#大桥","SYJID":"6DAAAE3C-1DCA-44E4-BAAF-7DBA1FF1895B","SYRQ":"2016-06-08","chuzhi":"0","testName":"混凝土试件抗压强度试验","SGBW":"右幅2-4T梁","SJQD":"C50","shebeiname":"二航项目部1号压力机","PDJG":"有效","SJBH":"1078","QDDBZ":"50.9"},{"GCMC":"盘龙河1#大桥","SYJID":"402FEF52-2DD5-404D-B3D9-C4C3B0B1CDB1","SYRQ":"2016-06-08","chuzhi":"0","testName":"混凝土试件抗压强度试验","SGBW":"左幅6-4T梁","SJQD":"C50","shebeiname":"二航项目部1号压力机","PDJG":"有效","SJBH":"1079","QDDBZ":"51.1"},{"GCMC":"杨柳河3#大桥","SYJID":"AAE29333-4E60-4354-9E8C-EC65E9FA1C64","SYRQ":"2016-06-07","chuzhi":"0","testName":"混凝土试件抗压强度试验","SGBW":"左幅1-5T梁","SJQD":"C50","shebeiname":"二航项目部1号压力机","PDJG":"有效","SJBH":"1074","QDDBZ":"50.4"},{"GCMC":"盘龙河1#大桥","SYJID":"9A0620A6-5B67-483C-B70B-76397721C5EA","SYRQ":"2016-06-07","chuzhi":"0","testName":"混凝土试件抗压强度试验","SGBW":"左幅6-3T梁","SJQD":"C50","shebeiname":"二航项目部1号压力机","PDJG":"有效","SJBH":"1075","QDDBZ":"51"}]
     * success : true
     */

    private boolean success;
    /**
     * GCMC : 杨柳河1#大桥
     * SYJID : 392E893E-F063-4C93-ACE4-8E8F5581903A
     * SYRQ : 2016-07-15
     * chuzhi : 0
     * testName : 混凝土试件抗压强度试验
     * SGBW : 右幅2-1T梁
     * SJQD : C50
     * shebeiname : 二航项目部1号压力机
     * PDJG : 有效
     * SJBH : 1293
     * QDDBZ : 51.1
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
        private String SJQD;
        private String shebeiname;
        private String PDJG;
        private String SJBH;
        private String QDDBZ;

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

        public String getSJQD() {
            return SJQD;
        }

        public void setSJQD(String SJQD) {
            this.SJQD = SJQD;
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

        public String getSJBH() {
            return SJBH;
        }

        public void setSJBH(String SJBH) {
            this.SJBH = SJBH;
        }

        public String getQDDBZ() {
            return QDDBZ;
        }

        public void setQDDBZ(String QDDBZ) {
            this.QDDBZ = QDDBZ;
        }
    }
}
