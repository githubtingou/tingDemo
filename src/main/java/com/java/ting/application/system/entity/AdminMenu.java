package com.java.ting.application.system.entity;


import com.java.ting.application.utils.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 菜单实体类
 *
 * @author TingOu
 */
@Getter
@Setter
@ToString
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

}
