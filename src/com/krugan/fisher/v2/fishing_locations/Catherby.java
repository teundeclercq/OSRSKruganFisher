package com.krugan.fisher.v2.fishing_locations;

import com.krugan.fisher.v2.fish.Lobster;
import com.krugan.fisher.v2.fish.Shark;
import com.krugan.fisher.v2.util.AbstractFish;
import com.krugan.fisher.v2.util.KFishingLocation;
import org.dreambot.api.methods.map.Area;

import java.util.Arrays;

public class Catherby extends KFishingLocation {
    protected AbstractFish[] abstractFish;

    public Catherby() {
        abstractFish = new AbstractFish[] {
                new Shark(),
                new Lobster()
        };
    }

    @Override
    public Area fishingArea() {
        return new Area();
    }

    @Override
    public Area bankArea() {
        return new Area();
    }

    @Override
    public AbstractFish[] getFishTypes() {
        return this.abstractFish;
    }

    @Override
    public String toString() {
        return "Catherby";
    }
}
