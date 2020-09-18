package com.krugan.fisher.v2.fish;

import com.krugan.fisher.v2.util.FishingSpot;
import com.krugan.fisher.v2.util.Bait;
import com.krugan.fisher.v2.util.AbstractFish;
import com.krugan.fisher.v2.util.FishingEquipment;
import com.krugan.fisher.v2.util.FishingStyle;

public class Monkfish extends AbstractFish {


    @Override
    public Integer[] counters() {
        return new Integer[] {0};
    }

    @Override
    public String[] names() {
        return new String[] {"Raw monkfish"};
    }

    @Override
    public Bait bait() {
        return null;
    }

    @Override
    public FishingSpot fishingSpot() {
        /// todo get the fishing spot name of monkfish
        /// todo get the fishing start message of monkfish
        return new FishingSpot("", "", new String[] {"You catch a monkfish."}, "Net");
    }

    @Override
    public FishingEquipment fishingEquipment() {
        return FishingEquipment.SMALL_NET;
    }

    @Override
    public FishingStyle fishingStyle() {
        return FishingStyle.HARPOON_NET;
    }

    @Override
    public String toString() {
        return "Monkfish";
    }
}
