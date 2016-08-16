package com.shtoone.shtw.bean;

import java.util.List;

/**
 * Created by leguang on 2016/7/29 0029.
 */
public class BHZEquipment {

    /**
     * data : [{"departid":"f89aff0750caf1a80150cb1dbd1e003f","banhezhanminchen":"三公局四公司2分部1号站1号机","gprsbianhao":"TWBHJ000078"},{"departid":"f89aff0750caf1a80150cb1dbd1e003f","banhezhanminchen":"三公局四公司2分部1号站2号机","gprsbianhao":"TWBHJ000081"},{"departid":"f89aff0750caf1a80150cb1c7f370039","banhezhanminchen":"三公局三公司1分部3号站1号机","gprsbianhao":"TWBHJ000072"},{"departid":"f89aff0750caf1a80150cb1c170d0037","banhezhanminchen":"三公局一分部2号站1号机","gprsbianhao":"TWBHJ000074"},{"departid":"f89aff0750caf1a80150cb1c7f370039","banhezhanminchen":"三公局一分部1号站1号机","gprsbianhao":"TWBHJ000075"},{"departid":"f89aff0750caf1a80150cb1cdcc6003b","banhezhanminchen":"三公局三公司3分部1号站1号机","gprsbianhao":"TWBHJ000076"},{"departid":"f89aff0750caf1a80150cb1d39e9003d","banhezhanminchen":"三公局三公司3分部2号站1号机","gprsbianhao":"TWBHJ000077"},{"departid":"f89aff0750caf1a80150cb17c6d6002d","banhezhanminchen":"二航局昆明分公司3分部1号站1号机","gprsbianhao":"TWBHJ000082"},{"departid":"f89aff0750caf1a80150cb17c6d6002d","banhezhanminchen":"二航局昆明分公司3分部1号站2号机","gprsbianhao":"TWBHJ000083"},{"departid":"f89aff0750caf1a80150cb15aa250027","banhezhanminchen":"二航局五公司1分部1号站1号机","gprsbianhao":"TWBHJ000067"},{"departid":"f89aff0750caf1a80150cb15aa250027","banhezhanminchen":"二航局五公司1分部1号站2号机","gprsbianhao":"TWBHJ000068"},{"departid":"f89aff0750caf1a80150cb162e470029","banhezhanminchen":"二航局2分部2号站3号机","gprsbianhao":"TWBHJ000069"},{"departid":"f89aff0750caf1a80150cb162e470029","banhezhanminchen":"二航局2分部2号站4号机","gprsbianhao":"TWBHJ000070"},{"departid":"f89aff0750caf1a80150cb162e470029","banhezhanminchen":"二航局2分部2号站5号机","gprsbianhao":"TWBHJ000071"},{"departid":"f89aff0750caf1a80150cb1fcdb60047","banhezhanminchen":"四公局一分部1号站1号机","gprsbianhao":"TWBHJ000086"},{"departid":"f89aff0750caf1a80150cb1fcdb60047","banhezhanminchen":"四公局一分部1号站2号机","gprsbianhao":"TWBHJ000087"},{"departid":"f89aff0750ccb6e60150cd8b9222000d","banhezhanminchen":"四公局一分部2号站1号机","gprsbianhao":"TWBHJ000079"},{"departid":"f89aff0750ccb6e60150cd8b9222000d","banhezhanminchen":"四公局一分部2号站2号机","gprsbianhao":"TWBHJ000080"},{"departid":"f89aff0750caf1a80150cb21e324004b","banhezhanminchen":"四公局桥隧公司2分部1号站1号机","gprsbianhao":"TWBHJ000084"},{"departid":"f89aff0750caf1a80150cb21e324004b","banhezhanminchen":"四公局桥隧公司2分部1号站2号机","gprsbianhao":"TWBHJ000085"},{"departid":"f89aff0750caf1a80150cb20e58c0049","banhezhanminchen":"四公局二分公司3分部1号站1号机","gprsbianhao":"TWBHJ000088"},{"departid":"f89aff0750caf1a80150cb20e58c0049","banhezhanminchen":"四公局二分公司3分部1号站2号机","gprsbianhao":"TWBHJ000089"},{"departid":"f89aff0750caf1a80150cb12e3b70023","banhezhanminchen":"二航局试验段分部1号站1号机","gprsbianhao":"TWBHJ000090"},{"departid":"f89aff0750caf1a80150cb12e3b70023","banhezhanminchen":"二航局试验段分部1号站2号机","gprsbianhao":"TWBHJ000091"},{"departid":"f39d33284e5bf952014e5c51124300d8","banhezhanminchen":"一航局一分部1号站1号机","gprsbianhao":"TWBHJ000092"},{"departid":"f39d33284e5bf952014e5c51124300d8","banhezhanminchen":"一航局一分部1号站2号机","gprsbianhao":"TWBHJ000093"},{"departid":"f89aff074fe35898014fe875550c0025","banhezhanminchen":"一航局一分部2号站1号机","gprsbianhao":"TWBHJ000094"},{"departid":"f89aff0750caf1a80150cb0ba4860010","banhezhanminchen":"一航局一分部3号站1号机","gprsbianhao":"TWBHJ000095"},{"departid":"f89aff0750caf1a80150cb0d44c90015","banhezhanminchen":"一航局三分部1号站1号机","gprsbianhao":"TWBHJ000101"},{"departid":"f89aff0750caf1a80150cb0dcc0d0017","banhezhanminchen":"一航局三分部2号站1号机","gprsbianhao":"TWBHJ000102"},{"departid":"f89aff0750caf1a80150cb0dcc0d0017","banhezhanminchen":"一航局三分部2号站2号机","gprsbianhao":"TWBHJ000103"},{"departid":"f89aff0750caf1a80150cb0f29e6001b","banhezhanminchen":"一航局二分部1号站1号机","gprsbianhao":"TWBHJ000096"},{"departid":"f89aff0750caf1a80150cb0fb4f0001d","banhezhanminchen":"一航局二分部2号站1号机","gprsbianhao":"TWBHJ000097"},{"departid":"f89aff0750caf1a80150cb0fb4f0001d","banhezhanminchen":"一航局二分部2号站2号机","gprsbianhao":"TWBHJ000098"},{"departid":"f89aff0750caf1a80150cb1046c2001f","banhezhanminchen":"一航局二分部3号站1号机","gprsbianhao":"TWBHJ000099"},{"departid":"f89aff0750caf1a80150cb1046c2001f","banhezhanminchen":"一航局二分部3号站2号机","gprsbianhao":"TWBHJ000100"}]
     * success : true
     */

    private boolean success;
    /**
     * departid : f89aff0750caf1a80150cb1dbd1e003f
     * banhezhanminchen : 三公局四公司2分部1号站1号机
     * gprsbianhao : TWBHJ000078
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
