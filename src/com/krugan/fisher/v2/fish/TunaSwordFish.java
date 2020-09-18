package com.krugan.fisher.v2.fish;

import com.krugan.fisher.v2.util.FishingSpot;
import com.krugan.fisher.v2.util.Bait;
import com.krugan.fisher.v2.util.AbstractFish;
import com.krugan.fisher.v2.util.FishingEquipment;
import com.krugan.fisher.v2.util.FishingStyle;

public class TunaSwordFish extends AbstractFish {

    @Override
    public Integer[] counters() {
        return new Integer[] {0,0};
    }

    @Override
    public String[] names() {
        return new String[]{"Raw tuna", "Raw swordfish"};
    }

    @Override
    public Bait bait() {
        return null;
    }

    @Override
    public FishingSpot fishingSpot() {
        /// todo get the fishingspotname of tuna and swordfish.
        /// todo get the fishing start message of tuna and swordfish
        return new FishingSpot("", "", new String[] {"You catch a tuna.", "You catch a swordfish."}, "");
    }

    @Override
    public FishingEquipment fishingEquipment() {
        return FishingEquipment.HARPOON;
    }

    @Override
    public FishingStyle fishingStyle() {
        return FishingStyle.CAGE_HARPOON;
    }

    @Override
    public String toString() {
        return "Tuna & Swordfish";
    }
}
