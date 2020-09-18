package com.krugan.fisher.v2.fish;

import com.krugan.fisher.v2.util.FishingSpot;
import com.krugan.fisher.v2.util.Bait;
import com.krugan.fisher.v2.util.AbstractFish;
import com.krugan.fisher.v2.util.FishingEquipment;
import com.krugan.fisher.v2.util.FishingStyle;

public class Bass extends AbstractFish {


    @Override
    public Integer[] counters() {
        return new Integer[] {0,0,0,0,0,0};
    }

    @Override
    public String[] names() {
        return new String[] {"Raw mackerel", "Raw cod", "Raw Bass", "Casket", "Seaweed", "Oyster"};
    }

    @Override
    public Bait bait() {
        return null;
    }

    @Override
    public FishingSpot fishingSpot() {
        // todo get the fishing spot name, fishing start message.
        return new FishingSpot("",
                "",
                new String[] {
                        "You catch a bass.",
                        "You catch a mackerel.",
                        "You catch a cod.",
                        "You catch a casket.",
                }, "Net");
    }

    @Override
    public FishingEquipment fishingEquipment() {
        return FishingEquipment.BIG_NET;
    }

    @Override
    public FishingStyle fishingStyle() {
        return FishingStyle.NET_HARPOON;
    }

    @Override
    public String toString() {
        return "Bass";
    }
}
