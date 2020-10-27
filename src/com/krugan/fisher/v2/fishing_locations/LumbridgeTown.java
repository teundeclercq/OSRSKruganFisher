package com.krugan.fisher.v2.fishing_locations;

import com.krugan.fisher.v2.fish.SardineHerring;
import com.krugan.fisher.v2.fish.TroutSalmon;
import com.krugan.fisher.v2.util.AbstractFish;
import com.krugan.fisher.v2.util.KFishingLocation;
import org.dreambot.api.methods.map.Area;

import java.util.Arrays;

public class LumbridgeTown extends KFishingLocation {
    protected  AbstractFish[] abstractFish;
    private AbstractFish fishToCatch;

    public LumbridgeTown() {
        this.abstractFish = new AbstractFish[] {
                new SardineHerring(),
                new TroutSalmon(),
        };
    }

    @Override
    public Area fishingArea() {
        return new Area(3236, 3255, 3242, 3239, 0);
    }

    @Override
    public Area bankArea() {
        return new Area(3207, 3222, 3210, 3215, 2);
    }


    @Override
    public AbstractFish[] getFishTypes() {
        return this.abstractFish;
    }

    @Override
    public String toString() {
        return "Lumbridge Town";
    }
}
