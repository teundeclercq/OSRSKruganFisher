package com.krugan.fisher.v2;

import com.krugan.fisher.Main;
import com.krugan.fisher.v2.util.AbstractFish;
import com.krugan.fisher.v2.util.KFishingLocation;
import org.dreambot.api.methods.MethodContext;
import org.dreambot.api.methods.MethodProvider;

import java.beans.PropertyChangeListener;

public abstract class Node {
    public String state;
    protected AbstractFish fishes;
    protected KFishingLocation fishingLocation;
    protected Main main;

    public Node(Main main) {
        this.main = main;
    }
    public Node(Main main, KFishingLocation fishingLocation) {
        this.main = main;
        this.fishingLocation = fishingLocation;
    }
    public Node(Main main, KFishingLocation fishingLocation, AbstractFish fishes) {
        this.main = main;
        this.fishingLocation = fishingLocation;
        this.fishes = fishes;
    }
    public abstract boolean isValid();
    public abstract int execute();
}
