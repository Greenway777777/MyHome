package com.livre.myhome.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "admin_menu")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class AdminMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * Menu access path.
     */
    private String routerPath;

    /**
     * Menu name.
     */
    private String routerName;

    /**
     * Menu name in Chinese.
     */
    private String menuNameZh;

    /**
     * Menu icon class(use element-ui icons).
     */
    private String menuIconCls;

    /**
     * Front-end component name corresponding to menu.
     */
    private String component;

    /**
     * Parent menu.
     */
    private int parentId;

    /**
     * Transient property for storing children menus.
     */
    @Transient
    private List<AdminMenu> children;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRouterPath() {
        return routerPath;
    }

    public void setRouterPath(String routerPath) {
        this.routerPath = routerPath;
    }

    public String getRouterName() {
        return routerName;
    }

    public void setRouterName(String routerName) {
        this.routerName = routerName;
    }

    public String getMenuNameZh() {
        return menuNameZh;
    }

    public void setMenuNameZh(String menuNameZh) {
        this.menuNameZh = menuNameZh;
    }

    public String getMenuIconCls() {
        return menuIconCls;
    }

    public void setMenuIconCls(String menuIconCls) {
        this.menuIconCls = menuIconCls;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public List<AdminMenu> getChildren() {
        return children;
    }

    public void setChildren(List<AdminMenu> children) {
        this.children = children;
    }
}
