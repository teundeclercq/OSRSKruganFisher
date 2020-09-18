package com.krugan.fisher.v2.fish;

import com.krugan.fisher.v2.util.FishingSpot;
import com.krugan.fisher.v2.util.Bait;
import com.krugan.fisher.v2.util.AbstractFish;
import com.krugan.fisher.v2.util.FishingEquipment;
import com.krugan.fisher.v2.util.FishingStyle;

public class Karambwan extends AbstractFish {
    @Override
    public Integer[] counters() {
        return new Integer[]{0};
    }

    @Override
    public String[] names() {
        return new String[] {"Raw karambwan"};
    }

    @Override
    public Bait bait() {
        return Bait.KARAMBWANJI;
    }

    @Override
    public FishingSpot fishingSpot() {
        /// todo get the fishingspot name and the fishing start message.
        return new FishingSpot("", "", new String[] {"You catch a karambwan."}, "Fish");
    }

    @Override
    public FishingEquipment fishingEquipment() {
        return FishingEquipment.KARAMBWAN_VESSEL;
    }

    @Override
    public FishingStyle fishingStyle() {
        return FishingStyle.FISH;
    }

    @Override
    public String toString() {
        return "Karambwan";
    }
}
