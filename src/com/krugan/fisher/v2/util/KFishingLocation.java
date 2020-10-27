package com.krugan.fisher.v2.util;

import com.krugan.fisher.Main;
import org.dreambot.api.methods.map.Area;

import java.util.List;

public abstract class KFishingLocation {
    public abstract Area fishingArea();
    public abstract Area bankArea();
    public abstract AbstractFish[] getFishTypes();
    public abstract String toString();
}
