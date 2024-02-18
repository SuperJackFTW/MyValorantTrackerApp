package com.example.myvaloranttrackerapp;

import org.litepal.crud.LitePalSupport;

public class DatabaseColumn extends LitePalSupport {
    private String displayname;
    private String uuid;
    private String description;
    private String developer;
    private String icon;
    private String portrait;

    public String getDisplayName() {
        return displayname;
    }

    public void setDisplayName(String displayname) {
        this.displayname = displayname;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeveloperName() {
        return developer;
    }

    public void setDeveloperName(String developerName) {
        this.developer = developerName;
    }

    public String getDisplayIcon() {
        return icon;
    }

    public void setDisplayIcon(String displayIcon) {
        this.icon = displayIcon;
    }

    public String getFullPortrait() {
        return portrait;
    }

    public void setFullPortrait(String fullPortrait) {
        this.portrait = fullPortrait;
    }
}
