package com.krugan.fisher.v2.fish;

import com.krugan.fisher.v2.util.FishingSpot;
import com.krugan.fisher.v2.util.AbstractFish;
import com.krugan.fisher.v2.util.Bait;
import com.krugan.fisher.v2.util.FishingEquipment;
import com.krugan.fisher.v2.util.FishingStyle;

public class Lobster extends AbstractFish {

    @Override
    public Integer[] counters() {
        return new Integer[] {0};
    }

    @Override
    public String[] names() {
        return new String[] {"Raw lobster"};
    }

    @Override
    public Bait bait() {
        return null;
    }

    @Override
    public FishingSpot fishingSpot() {
        /// todo get the fishingspot name and the fishing start message of lobster.
        return new FishingSpot("Lobster spot", "You start to catch some fish...", new String[]{"You catch a lobster."}, "Cage");
    }

    @Override
    public FishingEquipment fishingEquipment() {
        return FishingEquipment.POT;
    }

    @Override
    public FishingStyle fishingStyle() {
        return FishingStyle.CAGE_HARPOON;
    }

    @Override
    public String toString() {
        return "Lobster";
    }
}
