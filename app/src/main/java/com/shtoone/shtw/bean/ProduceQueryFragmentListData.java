package com.shtoone.shtw.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by leguang on 2016/7/22 0022.
 */
public class ProduceQueryFragmentListData {

    /**
     * data : [{"chuliaoshijian":"2016-07-15 17:10:24","id":"842771","qiangdudengji":"C50","gujifangshu":"1","gongchengmingcheng":"荒寨2#大桥左幅第14跨湿接缝及横隔板","sigongdidian":"中交二航局蒙文砚高速","banhezhanminchen":"二航局2分部2号站3号机","jiaozuobuwei":""},{"chuliaoshijian":"2016-07-15 17:09:50","id":"842769","qiangdudengji":"C30盖板","gujifangshu":"0.999","gongchengmingcheng":"预制盖板","sigongdidian":"中交二航局蒙文砚高速公路","banhezhanminchen":"二航局2分部2号站4号机","jiaozuobuwei":""},{"chuliaoshijian":"2016-07-15 17:08:40","id":"842767","qiangdudengji":"C50","gujifangshu":"1.001","gongchengmingcheng":"荒寨2#大桥左幅第14跨湿接缝及横隔板","sigongdidian":"中交二航局蒙文砚高速","banhezhanminchen":"二航局2分部2号站3号机","jiaozuobuwei":""},{"chuliaoshijian":"2016-07-15 17:06:54","id":"842764","qiangdudengji":"C50","gujifangshu":"0.995","gongchengmingcheng":"荒寨2#大桥左幅第14跨湿接缝及横隔板","sigongdidian":"中交二航局蒙文砚高速","banhezhanminchen":"二航局2分部2号站3号机","jiaozuobuwei":""},{"chuliaoshijian":"2016-07-15 17:04:58","id":"842757","qiangdudengji":"C50","gujifangshu":"0.998","gongchengmingcheng":"荒寨2#大桥左幅第14跨湿接缝及横隔板","sigongdidian":"中交二航局蒙文砚高速","banhezhanminchen":"二航局2分部2号站3号机","jiaozuobuwei":""},{"chuliaoshijian":"2016-07-15 17:04:05","id":"842770","qiangdudengji":"C20","gujifangshu":"1.425","gongchengmingcheng":"蒙文砚高速公路项目经理部四分部","sigongdidian":"项目部","banhezhanminchen":"三公局三公司3分部2号站1号机","jiaozuobuwei":"基础"},{"chuliaoshijian":"2016-07-15 17:03:58","id":"842753","qiangdudengji":"C30二衬","gujifangshu":"0.997","gongchengmingcheng":"三角塘左洞二衬","sigongdidian":"中交二航局蒙文砚高速公路","banhezhanminchen":"二航局2分部2号站4号机","jiaozuobuwei":""},{"chuliaoshijian":"2016-07-15 17:03:36","id":"842755","qiangdudengji":"C25","gujifangshu":"1.248","gongchengmingcheng":"蒙文砚高速","sigongdidian":"梁场","banhezhanminchen":"四公局二分公司3分部1号站2号机","jiaozuobuwei":"抗滑桩.挡土板"},{"chuliaoshijian":"2016-07-15 17:02:50","id":"842745","qiangdudengji":"C50","gujifangshu":"0.999","gongchengmingcheng":"荒寨2#大桥左幅第14跨湿接缝及横隔板","sigongdidian":"中交二航局蒙文砚高速","banhezhanminchen":"二航局2分部2号站3号机","jiaozuobuwei":""},{"chuliaoshijian":"2016-07-15 17:02:40","id":"842756","qiangdudengji":"C25","gujifangshu":"1.254","gongchengmingcheng":"蒙文砚高速","sigongdidian":"梁场","banhezhanminchen":"四公局二分公司3分部1号站2号机","jiaozuobuwei":"抗滑桩.挡土板"}]
     * success : true
     */

    private boolean success;
    /**
     * chuliaoshijian : 2016-07-15 17:10:24
     * id : 842771
     * qiangdudengji : C50
     * gujifangshu : 1
     * gongchengmingcheng : 荒寨2#大桥左幅第14跨湿接缝及横隔板
     * sigongdidian : 中交二航局蒙文砚高速
     * banhezhanminchen : 二航局2分部2号站3号机
     * jiaozuobuwei :
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
        private String chuliaoshijian;
        private String id;
        private String qiangdudengji;
        private String gujifangshu;
        private String gongchengmingcheng;
        private String sigongdidian;
        private String banhezhanminchen;
        private String jiaozuobuwei;

        public String getChuliaoshijian() {
            return chuliaoshijian;
        }

        public void setChuliaoshijian(String chuliaoshijian) {
            this.chuliaoshijian = chuliaoshijian;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getQiangdudengji() {
            return qiangdudengji;
        }

        public void setQiangdudengji(String qiangdudengji) {
            this.qiangdudengji = qiangdudengji;
        }

        public String getGujifangshu() {
            return gujifangshu;
        }

        public void setGujifangshu(String gujifangshu) {
            this.gujifangshu = gujifangshu;
        }

        public String getGongchengmingcheng() {
            return gongchengmingcheng;
        }

        public void setGongchengmingcheng(String gongchengmingcheng) {
            this.gongchengmingcheng = gongchengmingcheng;
        }

        public String getSigongdidian() {
            return sigongdidian;
        }

        public void setSigongdidian(String sigongdidian) {
            this.sigongdidian = sigongdidian;
        }

        public String getBanhezhanminchen() {
            return banhezhanminchen;
        }

        public void setBanhezhanminchen(String banhezhanminchen) {
            this.banhezhanminchen = banhezhanminchen;
        }

        public String getJiaozuobuwei() {
            return jiaozuobuwei;
        }

        public void setJiaozuobuwei(String jiaozuobuwei) {
            this.jiaozuobuwei = jiaozuobuwei;
        }
    }
}
