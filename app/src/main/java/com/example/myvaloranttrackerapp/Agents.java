package com.example.myvaloranttrackerapp;

public class Agents {

    DataClass data;

    public DataClass getData() {
        return data;
    }

    public void setData(DataClass data) {
        this.data = data;
    }

    class DataClass{
        String uuid, displayName, description, developerName, characterTags, displayIcon, displayIconSmall, bustPortrait, fullPortrait,
                fullPortraitV2, killfeedPortrait, background, backgroundGradientColors, assetPath, role, recruitmentData, abilities, voiceLine;

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

        public String getCharacterTags() {
            return characterTags;
        }

        public void setCharacterTags(String characterTags) {
            this.characterTags = characterTags;
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

        public String getBackgroundGradientColors() {
            return backgroundGradientColors;
        }

        public void setBackgroundGradientColors(String backgroundGradientColors) {
            this.backgroundGradientColors = backgroundGradientColors;
        }

        public String getAssetPath() {
            return assetPath;
        }

        public void setAssetPath(String assetPath) {
            this.assetPath = assetPath;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getRecruitmentData() {
            return recruitmentData;
        }

        public void setRecruitmentData(String recruitmentData) {
            this.recruitmentData = recruitmentData;
        }

        public String getAbilities() {
            return abilities;
        }

        public void setAbilities(String abilities) {
            this.abilities = abilities;
        }

        public String getVoiceLine() {
            return voiceLine;
        }

        public void setVoiceLine(String voiceLine) {
            this.voiceLine = voiceLine;
        }
    }
}
