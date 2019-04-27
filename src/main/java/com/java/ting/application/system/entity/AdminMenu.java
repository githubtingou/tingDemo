package com.java.ting.application.system.entity;


import com.java.ting.application.utils.BaseEntity;

/**
 * 菜单实体类
 *
 * @author TingOu
 */
public class AdminMenu extends BaseEntity<AdminMenu> {

    /**
     * 父级菜单id
     */
    private String parentId;
    /**
     * 所有父级菜单id
     */

    private String parentIds;
    /**
     * 排序编号
     */
    private String treeCode;
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 菜单连接
     */
    private String menuHref;
    /**
     * 目标（ mainFrame、_blank、_self、_parent、_top）
     */
    private String menuTarget;
    /**
     * 菜单图表
     */
    private String menuIcon;
    /**
     * 权限
     */
    private String permission;
    /**
     * 是否显示（1显示 0隐藏）
     */
    private String isShow;
    /**
     * 状态（0正常 1删除 2停用）
     */
    private String status;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public String getTreeCode() {
        return treeCode;
    }

    public void setTreeCode(String treeCode) {
        this.treeCode = treeCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuHref() {
        return menuHref;
    }

    public void setMenuHref(String menuHref) {
        this.menuHref = menuHref;
    }

    public String getMenuTarget() {
        return menuTarget;
    }

    public void setMenuTarget(String menuTarget) {
        this.menuTarget = menuTarget;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
