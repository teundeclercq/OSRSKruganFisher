package com.krugan.fisher.v2.fish;

import com.krugan.fisher.v2.util.FishingSpot;
import com.krugan.fisher.v2.util.AbstractFish;
import com.krugan.fisher.v2.util.Bait;
import com.krugan.fisher.v2.util.FishingEquipment;
import com.krugan.fisher.v2.util.FishingStyle;

public class TroutSalmon extends AbstractFish {

    @Override
    public Integer[] counters() {
        return new Integer[] {0,0};
    }

    @Override
    public String[] names() {
        return new String[] {"Raw trout", "Raw salmon"};
    }

    @Override
    public Bait bait() {
        return Bait.FEATHER;
    }

    @Override
    public FishingSpot fishingSpot() {
        return new FishingSpot("Rod Fishing spot", "You attempt to catch a fish.", new String[]{"You catch a trout.", "You catch a salmon."}, "Lure");
    }

    @Override
    public FishingEquipment fishingEquipment() {
        return FishingEquipment.FLY_FISHING_ROD;
    }

    @Override
    public FishingStyle fishingStyle() {
        return FishingStyle.LURE_BAIT;
    }

    @Override
    public String toString() {
        return "Trout & Salmon";
    }
}
