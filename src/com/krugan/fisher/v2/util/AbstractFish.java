package com.krugan.fisher.v2.util;

public abstract class AbstractFish {
    public abstract Integer[] counters();
    public abstract String[] names();
    public abstract Bait bait();
    public abstract FishingSpot fishingSpot();
    public abstract FishingEquipment fishingEquipment();
    public abstract FishingStyle fishingStyle();
    public abstract String toString();
}
