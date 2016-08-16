package com.shtoone.shtw.bean;

import java.util.List;

/**
 * Created by leguang on 2016/7/25 0025.
 */
public class OrganizationActivityData {

    /**
     * data : [{"departorderid":"","departname":"1标拌合站","description":"","lft":"12","parentdepartid":"f89aff075317222c01531b88aff70012","ID":"f89aff075317222c01531b892bc20014","rgt":"13","lng":"","type":"1","lat":""},{"departorderid":"","departname":"3标拌合站","description":"","lft":"6","parentdepartid":"f89b12c254c7c0920154c7d1eae6000f","ID":"f89b12c254c7c0920154c7d24b480011","rgt":"7","lng":"","type":"1","lat":""},{"departorderid":"","departname":"石银1标","description":"中铁12局","lft":"9","parentdepartid":"f89aff075317222c01531b866ec50010","ID":"f89aff075317222c01531b88aff70012","rgt":"14","lng":"","type":"4","lat":""},{"departorderid":"","departname":"石银3标","description":"宁夏路桥","lft":"3","parentdepartid":"f89aff075317222c01531b866ec50010","ID":"f89b12c254c7c0920154c7d1eae6000f","rgt":"8","lng":"","type":"4","lat":""},{"departorderid":"","departname":"监理公司","description":"监理","lft":"2","parentdepartid":"297ee90c4447f8a4014447fbba1e0015","ID":"f89aff075317222c01531b866ec50010","rgt":"15","lng":"","type":"4","lat":""},{"departorderid":"","departname":"石银高速","description":"石银高速","lft":"1","parentdepartid":"","ID":"297ee90c4447f8a4014447fbba1e0015","rgt":"16","lng":"","type":"4","lat":""}]
     * success : true
     */

    private boolean success;
    /**
     * departorderid :
     * departname : 1标拌合站
     * description :
     * lft : 12
     * parentdepartid : f89aff075317222c01531b88aff70012
     * ID : f89aff075317222c01531b892bc20014
     * rgt : 13
     * lng :
     * type : 1
     * lat :
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
        private String departorderid;
        private String departname;
        private String description;
        private String lft;
        private String parentdepartid;
        private String ID;
        private String rgt;
        private String lng;
        private String type;
        private String lat;

        public String getDepartorderid() {
            return departorderid;
        }

        public void setDepartorderid(String departorderid) {
            this.departorderid = departorderid;
        }

        public String getDepartname() {
            return departname;
        }

        public void setDepartname(String departname) {
            this.departname = departname;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getLft() {
            return lft;
        }

        public void setLft(String lft) {
            this.lft = lft;
        }

        public String getParentdepartid() {
            return parentdepartid;
        }

        public void setParentdepartid(String parentdepartid) {
            this.parentdepartid = parentdepartid;
        }

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getRgt() {
            return rgt;
        }

        public void setRgt(String rgt) {
            this.rgt = rgt;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }
    }
}
