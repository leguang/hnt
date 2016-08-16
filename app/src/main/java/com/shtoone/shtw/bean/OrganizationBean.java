package com.shtoone.shtw.bean;

import com.shtoone.shtw.ui.treeview.annotation.TreeNodeId;
import com.shtoone.shtw.ui.treeview.annotation.TreeNodeLabel;
import com.shtoone.shtw.ui.treeview.annotation.TreeNodePid;

/**
 * Created by leguang on 2016/7/25 0025.
 */
public class OrganizationBean {
    @TreeNodeId
    private String _id;
    @TreeNodePid
    private String parentId;
    @TreeNodeLabel
    private String name;


    public OrganizationBean(String _id, String parentId, String name) {
        this._id = _id;
        this.parentId = parentId;
        this.name = name;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
