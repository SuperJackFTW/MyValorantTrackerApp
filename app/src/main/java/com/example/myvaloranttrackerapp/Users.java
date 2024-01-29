package com.example.myvaloranttrackerapp;

import android.provider.ContactsContract;

import org.json.JSONArray;
import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;

import java.util.List;

public class Users extends LitePalSupport{

    DataClass data;

    class DataClass{

        @Column(unique = true, defaultValue = "unknown")
        private String uuid, displayName, description, developerName, displayIcon, fullPortrait;

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDeveloperName() {
            return developerName;
        }

        public void setDeveloperName(String developerName) {
            this.developerName = developerName;
        }

        public String getDisplayIcon() {
            return displayIcon;
        }

        public void setDisplayIcon(String displayIcon) {
            this.displayIcon = displayIcon;
        }

        public String getFullPortrait() {
            return fullPortrait;
        }

        public void setFullPortrait(String fullPortrait) {
            this.fullPortrait = fullPortrait;
        }
    }

    // OLD VERSION OF MODEL
//    String uuid;
//    DataClass data;

//    public Users(String uuid) {
//        this.uuid = uuid;
//    }
//
//    public String getUuid() {
//        return uuid;
//    }
//
//    public void setUuid(String uuid) {
//        this.uuid = uuid;
//    }
//
//    class DataClass{
//        String uuid, displayName, description, developerName;
//        String displayIcon,fullPortrait;
//
//        public DataClass(String uuid, String displayName, String description, String developerName, String displayIcon, String fullPortrait) {
//            this.uuid = uuid;
//            this.displayName = displayName;
//            this.description = description;
//            this.developerName = developerName;
//            this.displayIcon = displayIcon;
//            this.fullPortrait = fullPortrait;
//        }
//
//        public String getDescription() {
//            return description;
//        }
//
//        public void setDescription(String description) {
//            this.description = description;
//        }
//
//        public String getDeveloperName() {
//            return developerName;
//        }
//
//        public void setDeveloperName(String developerName) {
//            this.developerName = developerName;
//        }
//
//        public String getDisplayIcon() {
//            return displayIcon;
//        }
//
//        public void setDisplayIcon(String displayIcon) {
//            this.displayIcon = displayIcon;
//        }
//
//
//        public String getFullPortrait() {
//            return fullPortrait;
//        }
//
//        public void setFullPortrait(String fullPortrait) {
//            this.fullPortrait = fullPortrait;
//        }
//
//        public String getUuid() {
//            return uuid;
//        }
//
//        public void setUuid(String uuid) {
//            this.uuid = uuid;
//        }
//
//        public String getDisplayName() {
//            return displayName;
//        }
//
//        public void setDisplayName(String displayName) {
//            this.displayName = displayName;
//        }
//    }
}
