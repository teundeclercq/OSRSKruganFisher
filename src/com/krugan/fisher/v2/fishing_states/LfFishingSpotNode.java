package com.krugan.fisher.v2.fishing_states;

import com.krugan.fisher.Main;
import com.krugan.fisher.v2.Node;
import com.krugan.fisher.v2.util.AbstractFish;
import com.krugan.fisher.v2.util.KFishingLocation;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.wrappers.interactive.NPC;

import static org.dreambot.api.methods.MethodProvider.sleepUntil;

public class LfFishingSpotNode extends Node {
    public LfFishingSpotNode(Main main, KFishingLocation fishingLocation, AbstractFish fishes) {
        super(main, fishingLocation, fishes);
    }

    @Override
    public boolean isValid() {
        return !main.getInventory().isFull() && !main.isFishing && fishingLocation.fishingArea().contains(main.getLocalPlayer());
    }

    @Override
    public int execute() {
        state = "Looking for fishing spot";
        NPC fishingSpot = main.getNpcs().closest(fs -> fs != null && fs.getName().contentEquals(fishes.fishingSpot().getFishingSpotName()) && fishingLocation.fishingArea().contains(fs));
        fishingSpot.interact(fishes.fishingSpot().getFishingInteractionAction());
        sleepUntil(() -> main.isFishing, Calculations.random(1000, 2500));
        return Calculations.random(1000, 2000);
    }
}
