package com.krugan.fisher.v2.fish;

import com.krugan.fisher.v2.util.FishingSpot;
import com.krugan.fisher.v2.util.AbstractFish;
import com.krugan.fisher.v2.util.Bait;
import com.krugan.fisher.v2.util.FishingEquipment;
import com.krugan.fisher.v2.util.FishingStyle;

public class SardineHerring extends AbstractFish {

    @Override
    public Integer[] counters() {
        return new Integer[] {0,0};
    }

    @Override
    public String[] names() {
        return new String[]{"Raw herring", "Raw sardine"};
    }

    @Override
    public Bait bait() {
        return Bait.BAIT;
    }

    @Override
    public FishingSpot fishingSpot() {
        /// todo get the fishing spot name and the fishing start message of sardine and herring.
        return new FishingSpot("", "", new String[]{"You catch a sardine.","You catch a herring."}, "Bait");
    }

    @Override
    public FishingEquipment fishingEquipment() {
        return FishingEquipment.FISHING_ROD;
    }

    @Override
    public FishingStyle fishingStyle() {
        return FishingStyle.NET_BAIT;
    }

    @Override
    public String toString() {
        return "Sardine & Herring";
    }
}
