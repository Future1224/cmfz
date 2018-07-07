package com.baizhi.cmfz.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * 描述:后台管理系统分类菜单类
 *
 * @author future_zwp
 * @create 2018-07-05 11:18
 */
@Component
@Scope("prototype")
public class Menu implements Serializable {
    private String menuId;
    private String menuName;
    private String menuCode;
    private String menuIcon;
    private String menuUrl;
    private Integer menuRank;
    private String menuParentId;
    private List<Menu> subMenus;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Integer getMenuRank() {
        return menuRank;
    }

    public void setMenuRank(Integer menuRank) {
        this.menuRank = menuRank;
    }

    public String getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(String menuParentId) {
        this.menuParentId = menuParentId;
    }

    public Menu() {
        super();
    }

    public List<Menu> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(List<Menu> subMenus) {
        this.subMenus = subMenus;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId='" + menuId + '\'' +
                ", menuName='" + menuName + '\'' +
                ", menuCode='" + menuCode + '\'' +
                ", menuIcon='" + menuIcon + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", menuRank=" + menuRank +
                ", menuParentId='" + menuParentId + '\'' +
                ", subMenus=" + subMenus +
                '}';
    }
}

