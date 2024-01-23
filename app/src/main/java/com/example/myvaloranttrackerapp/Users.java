package com.example.myvaloranttrackerapp;

import android.provider.ContactsContract;

import org.json.JSONArray;

import java.util.List;

public class Users {
    DataClass data;
    class DataClass{
        String uuid, displayName, description, developerName;
        String displayIcon, displayIconSmall, bustPortrait, fullPortrait, fullPortraitV2, killfeedPortrait, background;

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

        public String getDisplayIconSmall() {
            return displayIconSmall;
        }

        public void setDisplayIconSmall(String displayIconSmall) {
            this.displayIconSmall = displayIconSmall;
        }

        public String getBustPortrait() {
            return bustPortrait;
        }

        public void setBustPortrait(String bustPortrait) {
            this.bustPortrait = bustPortrait;
        }

        public String getFullPortrait() {
            return fullPortrait;
        }

        public void setFullPortrait(String fullPortrait) {
            this.fullPortrait = fullPortrait;
        }

        public String getFullPortraitV2() {
            return fullPortraitV2;
        }

        public void setFullPortraitV2(String fullPortraitV2) {
            this.fullPortraitV2 = fullPortraitV2;
        }

        public String getKillfeedPortrait() {
            return killfeedPortrait;
        }

        public void setKillfeedPortrait(String killfeedPortrait) {
            this.killfeedPortrait = killfeedPortrait;
        }

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }

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
    }
}
