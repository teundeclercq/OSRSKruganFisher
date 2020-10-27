package com.krugan.fisher.v2.fish;

import com.krugan.fisher.v2.util.FishingSpot;
import com.krugan.fisher.v2.util.Bait;
import com.krugan.fisher.v2.util.AbstractFish;
import com.krugan.fisher.v2.util.FishingEquipment;
import com.krugan.fisher.v2.util.FishingStyle;

public class ShrimpAnchovies extends AbstractFish {


    @Override
    public Integer[] counters() {
        return new Integer[] {0,0};
    }

    @Override
    public String[] names() {
        return new String[] {"Raw shrimps", "Raw anchovies"};
    }

    @Override
    public Bait bait() {
        return null;
    }

    @Override
    public FishingSpot fishingSpot() {
        return new FishingSpot("Fishing spot", "You start catching fish...", new String[]{"You catch some shrimps.", "You catch some anchovies."}, "Net");
    }

    @Override
    public FishingEquipment fishingEquipment() {
        return FishingEquipment.SMALL_NET;
    }

    @Override
    public FishingStyle fishingStyle() {
        return FishingStyle.NET_BAIT;
    }

    @Override
    public String toString() {
        return "Shrimp & Anchovies";
    }
}
