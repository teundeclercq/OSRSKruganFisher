package com.krugan.fisher.v2.fish;

import com.krugan.fisher.v2.util.FishingSpot;
import com.krugan.fisher.v2.util.AbstractFish;
import com.krugan.fisher.v2.util.Bait;
import com.krugan.fisher.v2.util.FishingEquipment;
import com.krugan.fisher.v2.util.FishingStyle;

public class Shark extends AbstractFish {

    @Override
    public Integer[] counters() {
        return new Integer[] {0};
    }

    @Override
    public String[] names() {
        return new String[]{"Raw shark"};
    }

    @Override
    public Bait bait() {
        return null;
    }

    @Override
    public FishingSpot fishingSpot() {
        /// todo get the fishingSpotName, FishingStartMessage for Shark.
        return new FishingSpot("","",new String[]{"You catch a shark."}, "");
    }

    @Override
    public FishingEquipment fishingEquipment() {
        return FishingEquipment.HARPOON;
    }

    @Override
    public FishingStyle fishingStyle() {
        return FishingStyle.NET_HARPOON;
    }

    @Override
    public String toString() {
        return "Shark";
    }
}
