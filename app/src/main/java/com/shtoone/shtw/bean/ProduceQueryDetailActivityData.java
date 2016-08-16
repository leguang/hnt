package com.shtoone.shtw.bean;

import java.util.List;

/**
 * Created by leguang on 2016/7/25 0025.
 */
public class ProduceQueryDetailActivityData {

    /**
     * chuliaoshijian : 2016-07-15 16:39:18
     * peifanghao : 1833_8
     * xinxibianhao :
     * shenhe :
     * qiangdudengji : C50
     * chuli :
     * gongchengmingcheng : 蒙文砚高速第四合同段
     * chaozuozhe : 中交第二航务工程局有限公司
     * id :
     * gongdanhao : 0012
     * gujifangshu : 1.002
     * waijiajipingzhong : 1.002
     * sigongdidian :
     * jiaobanshijian : 105
     * banhezhanminchen : 二航局试验段分部1号站2号机
     * shuinipingzhong : 1833_4_1|3
     * jiaozuobuwei : 岩子头左线3-4T梁
     */

    private HeadMsgBean headMsg;
    /**
     * headMsg : {"chuliaoshijian":"2016-07-15 16:39:18","peifanghao":"1833_8","xinxibianhao":"","shenhe":"","qiangdudengji":"C50","chuli":"","gongchengmingcheng":"蒙文砚高速第四合同段","chaozuozhe":"中交第二航务工程局有限公司","id":"","gongdanhao":"0012","gujifangshu":"1.002","waijiajipingzhong":"1.002","sigongdidian":"","jiaobanshijian":"105","banhezhanminchen":"二航局试验段分部1号站2号机","shuinipingzhong":"1833_4_1|3","jiaozuobuwei":"岩子头左线3-4T梁"}
     * data : [{"peibi":"766","name":"砂1","shiji":"771","cbGrade":"","wuchazhi":"5","wuchalv":"0.65"},{"peibi":"1145","name":"砂2","shiji":"1128","cbGrade":"","wuchazhi":"-17","wuchalv":"-1.51"},{"peibi":"0","name":"碎石1","shiji":"0","cbGrade":"","wuchazhi":"0","wuchalv":"0.00"},{"peibi":"206","name":"碎石2","shiji":"223","cbGrade":"","wuchazhi":"17","wuchalv":"7.62"},{"peibi":"520","name":"水泥1","shiji":"521","cbGrade":"","wuchazhi":"1","wuchalv":"0.19"},{"peibi":"0","name":"水泥2","shiji":"0","cbGrade":"","wuchazhi":"0","wuchalv":"0.00"},{"peibi":"0","name":"矿粉","shiji":"0","cbGrade":"","wuchazhi":"0","wuchalv":"0.00"},{"peibi":"0","name":"粉煤灰","shiji":"0","cbGrade":"","wuchazhi":"0","wuchalv":"0.00"},{"peibi":"159","name":"水","shiji":"158","cbGrade":"","wuchazhi":"-1","wuchalv":"-0.63"},{"peibi":"0.00","name":"减水剂1","shiji":"0.00","cbGrade":"","wuchazhi":"0.00","wuchalv":"0.00"}]
     * success : true
     */

    private boolean success;
    /**
     * peibi : 766
     * name : 砂1
     * shiji : 771
     * cbGrade :
     * wuchazhi : 5
     * wuchalv : 0.65
     */

    private List<DataBean> data;

    public HeadMsgBean getHeadMsg() {
        return headMsg;
    }

    public void setHeadMsg(HeadMsgBean headMsg) {
        this.headMsg = headMsg;
    }

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

    public static class HeadMsgBean {
        private String chuliaoshijian;
        private String peifanghao;
        private String xinxibianhao;
        private String shenhe;
        private String qiangdudengji;
        private String chuli;
        private String gongchengmingcheng;
        private String chaozuozhe;
        private String id;
        private String gongdanhao;
        private String gujifangshu;
        private String waijiajipingzhong;
        private String sigongdidian;
        private String jiaobanshijian;
        private String banhezhanminchen;
        private String shuinipingzhong;
        private String jiaozuobuwei;

        public String getChuliaoshijian() {
            return chuliaoshijian;
        }

        public void setChuliaoshijian(String chuliaoshijian) {
            this.chuliaoshijian = chuliaoshijian;
        }

        public String getPeifanghao() {
            return peifanghao;
        }

        public void setPeifanghao(String peifanghao) {
            this.peifanghao = peifanghao;
        }

        public String getXinxibianhao() {
            return xinxibianhao;
        }

        public void setXinxibianhao(String xinxibianhao) {
            this.xinxibianhao = xinxibianhao;
        }

        public String getShenhe() {
            return shenhe;
        }

        public void setShenhe(String shenhe) {
            this.shenhe = shenhe;
        }

        public String getQiangdudengji() {
            return qiangdudengji;
        }

        public void setQiangdudengji(String qiangdudengji) {
            this.qiangdudengji = qiangdudengji;
        }

        public String getChuli() {
            return chuli;
        }

        public void setChuli(String chuli) {
            this.chuli = chuli;
        }

        public String getGongchengmingcheng() {
            return gongchengmingcheng;
        }

        public void setGongchengmingcheng(String gongchengmingcheng) {
            this.gongchengmingcheng = gongchengmingcheng;
        }

        public String getChaozuozhe() {
            return chaozuozhe;
        }

        public void setChaozuozhe(String chaozuozhe) {
            this.chaozuozhe = chaozuozhe;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getGongdanhao() {
            return gongdanhao;
        }

        public void setGongdanhao(String gongdanhao) {
            this.gongdanhao = gongdanhao;
        }

        public String getGujifangshu() {
            return gujifangshu;
        }

        public void setGujifangshu(String gujifangshu) {
            this.gujifangshu = gujifangshu;
        }

        public String getWaijiajipingzhong() {
            return waijiajipingzhong;
        }

        public void setWaijiajipingzhong(String waijiajipingzhong) {
            this.waijiajipingzhong = waijiajipingzhong;
        }

        public String getSigongdidian() {
            return sigongdidian;
        }

        public void setSigongdidian(String sigongdidian) {
            this.sigongdidian = sigongdidian;
        }

        public String getJiaobanshijian() {
            return jiaobanshijian;
        }

        public void setJiaobanshijian(String jiaobanshijian) {
            this.jiaobanshijian = jiaobanshijian;
        }

        public String getBanhezhanminchen() {
            return banhezhanminchen;
        }

        public void setBanhezhanminchen(String banhezhanminchen) {
            this.banhezhanminchen = banhezhanminchen;
        }

        public String getShuinipingzhong() {
            return shuinipingzhong;
        }

        public void setShuinipingzhong(String shuinipingzhong) {
            this.shuinipingzhong = shuinipingzhong;
        }

        public String getJiaozuobuwei() {
            return jiaozuobuwei;
        }

        public void setJiaozuobuwei(String jiaozuobuwei) {
            this.jiaozuobuwei = jiaozuobuwei;
        }
    }

    public static class DataBean {
        private String peibi;
        private String name;
        private String shiji;
        private String cbGrade;
        private String wuchazhi;
        private String wuchalv;

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

        public String getCbGrade() {
            return cbGrade;
        }

        public void setCbGrade(String cbGrade) {
            this.cbGrade = cbGrade;
        }

        public String getWuchazhi() {
            return wuchazhi;
        }

        public void setWuchazhi(String wuchazhi) {
            this.wuchazhi = wuchazhi;
        }

        public String getWuchalv() {
            return wuchalv;
        }

        public void setWuchalv(String wuchalv) {
            this.wuchalv = wuchalv;
        }
    }
}
