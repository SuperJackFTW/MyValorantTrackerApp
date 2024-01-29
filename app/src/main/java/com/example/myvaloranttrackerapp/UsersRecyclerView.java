package com.example.myvaloranttrackerapp;

public class UsersRecyclerView {

    DataClass data;
    static class DataClass{
        String displayName;
        String displayIcon;

        public DataClass(String displayName, String displayIcon) {
            this.displayName = displayName;
            this.displayIcon = displayIcon;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayIcon() {
            return displayIcon;
        }

        public void setDisplayIcon(String displayIcon) {
            this.displayIcon = displayIcon;
        }
    }
}
