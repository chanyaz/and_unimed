package com.puzzlersworld.wp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class Menu implements Serializable {
    @JsonProperty("ID")
    private Long ID;
    @JsonProperty("icon")
    private String icon;
    private Boolean isHome = Boolean.valueOf(false);
    @JsonProperty("link")
    private String link;
    @JsonProperty("object_type")
    private MenuItemType menuItemType;
    @JsonProperty("name")
    private String name;
    @JsonProperty("object_id")
    private Long objectId;
    @JsonProperty("parent_id")
    private Long parentId;
    @JsonProperty("slug")
    private String slug;
    @JsonProperty("taxonomy_name")
    private String taxonomy_name;

    public Long getID() {
        return this.ID;
    }

    public String getIcon() {
        return this.icon;
    }

    public Boolean getIsHome() {
        return this.isHome;
    }

    public String getLink() {
        return this.link;
    }

    public MenuItemType getMenuItemType() {
        return this.menuItemType;
    }

    public String getName() {
        return this.name;
    }

    public Long getObjectId() {
        return this.objectId;
    }

    public Long getParentId() {
        return this.parentId;
    }

    public String getSlug() {
        return this.slug;
    }

    public String getTaxonomy_name() {
        return this.taxonomy_name;
    }

    public void setID(Long l) {
        this.ID = l;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setIsHome(Boolean bool) {
        this.isHome = bool;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public void setMenuItemType(MenuItemType menuItemType) {
        this.menuItemType = menuItemType;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setObjectId(Long l) {
        this.objectId = l;
    }

    public void setParentId(Long l) {
        this.parentId = l;
    }

    public void setSlug(String str) {
        this.slug = str;
    }

    public void setTaxonomy_name(String str) {
        this.taxonomy_name = str;
    }
}
