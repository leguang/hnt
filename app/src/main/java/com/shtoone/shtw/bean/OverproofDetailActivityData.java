package com.shtoone.shtw.bean;

import java.util.List;

/**
 * Created by leguang on 2016/7/29 0029.
 */
public class OverproofDetailActivityData {

    /**
     * banhezhanminchen : 三公局三公司3分部1号站1号机
     * chaozuozhe : 系统管理员
     * chuli :
     * chuliaoshijian : 2015-11-20 00:20:29
     * chulifangshi :
     * chulijieguo :
     * chuliren :
     * chulishijian :
     * confirmdate :
     * filePath :
     * gongchengmingcheng : 0
     * gongdanhao :
     * gujifangshu : 1.286
     * id : 18455
     * jianliresult :
     * jianlishenpi :
     * jiaobanshijian : 120
     * jiaozuobuwei : 0
     * peifanghao : wc30水下
     * qiangdudengji : c30
     * shenhe :
     * shenpidate :
     * shenpiren :
     * shuinipingzhong :
     * sigongdidian : 0
     * waijiajipingzhong : 1.286
     * wentiyuanyin :
     * xinxibianhao :
     */

    private HeadMsgBean headMsg;
    /**
     * data : [{"cbGrade":"6","name":"砂1","peibi":"109","shiji":"126","wuchalv":"13.49","wuchazhi":"17"},{"cbGrade":"0","name":"砂2","peibi":"1145","shiji":"1132","wuchalv":"-1.15","wuchazhi":"-13"},{"cbGrade":"0","name":"碎石1","peibi":"730","shiji":"716","wuchalv":"-1.96","wuchazhi":"-14"},{"cbGrade":"0","name":"碎石2","peibi":"352","shiji":"352","wuchalv":"0.00","wuchazhi":"0"},{"cbGrade":"0","name":"水泥1","peibi":"0","shiji":"0","wuchalv":"0.00","wuchazhi":"0"},{"cbGrade":"0","name":"水泥2","peibi":"528","shiji":"528","wuchalv":"0.00","wuchazhi":"0"},{"cbGrade":"0","name":"矿粉","peibi":"0","shiji":"0","wuchalv":"0.00","wuchazhi":"0"},{"cbGrade":"0","name":"粉煤灰","peibi":"0","shiji":"0","wuchalv":"0.00","wuchazhi":"0"},{"cbGrade":"0","name":"水","peibi":"211","shiji":"212","wuchalv":"0.47","wuchazhi":"1"},{"cbGrade":"0","name":"减水剂1","peibi":"0.00","shiji":"0.00","wuchalv":"0.00","wuchazhi":"0.00"}]
     * headMsg : {"banhezhanminchen":"三公局三公司3分部1号站1号机","chaozuozhe":"系统管理员","chuli":"","chuliaoshijian":"2015-11-20 00:20:29","chulifangshi":"","chulijieguo":"","chuliren":"","chulishijian":"","confirmdate":"","filePath":"","gongchengmingcheng":"0","gongdanhao":"","gujifangshu":"1.286","id":"18455","jianliresult":"","jianlishenpi":"","jiaobanshijian":"120","jiaozuobuwei":"0","peifanghao":"wc30水下","qiangdudengji":"c30","shenhe":"","shenpidate":"","shenpiren":"","shuinipingzhong":"","sigongdidian":"0","waijiajipingzhong":"1.286","wentiyuanyin":"","xinxibianhao":""}
     * success : true
     */

    private boolean success;
    /**
     * cbGrade : 6
     * name : 砂1
     * peibi : 109
     * shiji : 126
     * wuchalv : 13.49
     * wuchazhi : 17
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
        private String banhezhanminchen;
        private String chaozuozhe;
        private String chuli;
        private String chuliaoshijian;
        private String chulifangshi;
        private String chulijieguo;
        private String chuliren;
        private String chulishijian;
        private String confirmdate;
        private String filePath;
        private String gongchengmingcheng;
        private String gongdanhao;
        private String gujifangshu;
        private String id;
        private String jianliresult;
        private String jianlishenpi;
        private String jiaobanshijian;
        private String jiaozuobuwei;
        private String peifanghao;
        private String qiangdudengji;
        private String shenhe;
        private String shenpidate;
        private String shenpiren;
        private String shuinipingzhong;
        private String sigongdidian;
        private String waijiajipingzhong;
        private String wentiyuanyin;
        private String xinxibianhao;

        public String getBanhezhanminchen() {
            return banhezhanminchen;
        }

        public void setBanhezhanminchen(String banhezhanminchen) {
            this.banhezhanminchen = banhezhanminchen;
        }

        public String getChaozuozhe() {
            return chaozuozhe;
        }

        public void setChaozuozhe(String chaozuozhe) {
            this.chaozuozhe = chaozuozhe;
        }

        public String getChuli() {
            return chuli;
        }

        public void setChuli(String chuli) {
            this.chuli = chuli;
        }

        public String getChuliaoshijian() {
            return chuliaoshijian;
        }

        public void setChuliaoshijian(String chuliaoshijian) {
            this.chuliaoshijian = chuliaoshijian;
        }

        public String getChulifangshi() {
            return chulifangshi;
        }

        public void setChulifangshi(String chulifangshi) {
            this.chulifangshi = chulifangshi;
        }

        public String getChulijieguo() {
            return chulijieguo;
        }

        public void setChulijieguo(String chulijieguo) {
            this.chulijieguo = chulijieguo;
        }

        public String getChuliren() {
            return chuliren;
        }

        public void setChuliren(String chuliren) {
            this.chuliren = chuliren;
        }

        public String getChulishijian() {
            return chulishijian;
        }

        public void setChulishijian(String chulishijian) {
            this.chulishijian = chulishijian;
        }

        public String getConfirmdate() {
            return confirmdate;
        }

        public void setConfirmdate(String confirmdate) {
            this.confirmdate = confirmdate;
        }

        public String getFilePath() {
            return filePath;
        }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }

        public String getGongchengmingcheng() {
            return gongchengmingcheng;
        }

        public void setGongchengmingcheng(String gongchengmingcheng) {
            this.gongchengmingcheng = gongchengmingcheng;
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

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getJianliresult() {
            return jianliresult;
        }

        public void setJianliresult(String jianliresult) {
            this.jianliresult = jianliresult;
        }

        public String getJianlishenpi() {
            return jianlishenpi;
        }

        public void setJianlishenpi(String jianlishenpi) {
            this.jianlishenpi = jianlishenpi;
        }

        public String getJiaobanshijian() {
            return jiaobanshijian;
        }

        public void setJiaobanshijian(String jiaobanshijian) {
            this.jiaobanshijian = jiaobanshijian;
        }

        public String getJiaozuobuwei() {
            return jiaozuobuwei;
        }

        public void setJiaozuobuwei(String jiaozuobuwei) {
            this.jiaozuobuwei = jiaozuobuwei;
        }

        public String getPeifanghao() {
            return peifanghao;
        }

        public void setPeifanghao(String peifanghao) {
            this.peifanghao = peifanghao;
        }

        public String getQiangdudengji() {
            return qiangdudengji;
        }

        public void setQiangdudengji(String qiangdudengji) {
            this.qiangdudengji = qiangdudengji;
        }

        public String getShenhe() {
            return shenhe;
        }

        public void setShenhe(String shenhe) {
            this.shenhe = shenhe;
        }

        public String getShenpidate() {
            return shenpidate;
        }

        public void setShenpidate(String shenpidate) {
            this.shenpidate = shenpidate;
        }

        public String getShenpiren() {
            return shenpiren;
        }

        public void setShenpiren(String shenpiren) {
            this.shenpiren = shenpiren;
        }

        public String getShuinipingzhong() {
            return shuinipingzhong;
        }

        public void setShuinipingzhong(String shuinipingzhong) {
            this.shuinipingzhong = shuinipingzhong;
        }

        public String getSigongdidian() {
            return sigongdidian;
        }

        public void setSigongdidian(String sigongdidian) {
            this.sigongdidian = sigongdidian;
        }

        public String getWaijiajipingzhong() {
            return waijiajipingzhong;
        }

        public void setWaijiajipingzhong(String waijiajipingzhong) {
            this.waijiajipingzhong = waijiajipingzhong;
        }

        public String getWentiyuanyin() {
            return wentiyuanyin;
        }

        public void setWentiyuanyin(String wentiyuanyin) {
            this.wentiyuanyin = wentiyuanyin;
        }

        public String getXinxibianhao() {
            return xinxibianhao;
        }

        public void setXinxibianhao(String xinxibianhao) {
            this.xinxibianhao = xinxibianhao;
        }
    }

    public static class DataBean {
        private String cbGrade;
        private String name;
        private String peibi;
        private String shiji;
        private String wuchalv;
        private String wuchazhi;

        public String getCbGrade() {
            return cbGrade;
        }

        public void setCbGrade(String cbGrade) {
            this.cbGrade = cbGrade;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPeibi() {
            return peibi;
        }

        public void setPeibi(String peibi) {
            this.peibi = peibi;
        }

        public String getShiji() {
            return shiji;
        }

        public void setShiji(String shiji) {
            this.shiji = shiji;
        }

        public String getWuchalv() {
            return wuchalv;
        }

        public void setWuchalv(String wuchalv) {
            this.wuchalv = wuchalv;
        }

        public String getWuchazhi() {
            return wuchazhi;
        }

        public void setWuchazhi(String wuchazhi) {
            this.wuchazhi = wuchazhi;
        }
    }
}
