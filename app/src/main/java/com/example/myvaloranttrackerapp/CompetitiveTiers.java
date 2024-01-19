package com.example.myvaloranttrackerapp;

import java.util.List;

public class CompetitiveTiers {

    DataClass data;
    DataClass.Tiers tiers;

    public DataClass getData() {
        return data;
    }

    public void setData(DataClass data) {
        this.data = data;
    }

    public class DataClass {
        String uuid, assetObjectName, tiers;

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getAssetObjectName() {
            return assetObjectName;
        }

        public void setAssetObjectName(String assetObjectName) {
            this.assetObjectName = assetObjectName;
        }

        public String getTiers() {
            return tiers;
        }

        public void setTiers(String tiers) {
            this.tiers = tiers;
        }

        public class Tiers{
            String tier, tierName, divison, divisionName, color, backgroundColor, smallIcon, largeIcon, rankTriangleDownIcon, rankTriangleUpIcon;

            public String getTier() {
                return tier;
            }

            public void setTier(String tier) {
                this.tier = tier;
            }

            public String getTierName() {
                return tierName;
            }

            public void setTierName(String tierName) {
                this.tierName = tierName;
            }

            public String getDivison() {
                return divison;
            }

            public void setDivison(String divison) {
                this.divison = divison;
            }

            public String getDivisionName() {
                return divisionName;
            }

            public void setDivisionName(String divisionName) {
                this.divisionName = divisionName;
            }

            public String getColor() {
                return color;
            }

            public void setColor(String color) {
                this.color = color;
            }

            public String getBackgroundColor() {
                return backgroundColor;
            }

            public void setBackgroundColor(String backgroundColor) {
                this.backgroundColor = backgroundColor;
            }

            public String getSmallIcon() {
                return smallIcon;
            }

            public void setSmallIcon(String smallIcon) {
                this.smallIcon = smallIcon;
            }

            public String getLargeIcon() {
                return largeIcon;
            }

            public void setLargeIcon(String largeIcon) {
                this.largeIcon = largeIcon;
            }

            public String getRankTriangleDownIcon() {
                return rankTriangleDownIcon;
            }

            public void setRankTriangleDownIcon(String rankTriangleDownIcon) {
                this.rankTriangleDownIcon = rankTriangleDownIcon;
            }

            public String getRankTriangleUpIcon() {
                return rankTriangleUpIcon;
            }

            public void setRankTriangleUpIcon(String rankTriangleUpIcon) {
                this.rankTriangleUpIcon = rankTriangleUpIcon;
            }
        }
    }
}
