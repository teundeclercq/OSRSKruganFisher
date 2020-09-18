package com.krugan.fisher.v2.fishing_states;

import com.krugan.fisher.Main;
import com.krugan.fisher.v2.Node;
import com.krugan.fisher.v2.util.AbstractFish;
import com.krugan.fisher.v2.util.KFishingLocation;
import org.dreambot.api.methods.Calculations;

import static org.dreambot.api.methods.MethodProvider.log;
import static org.dreambot.api.methods.MethodProvider.sleepUntil;

public class WalkToFishingSpotNode  extends Node {
    public WalkToFishingSpotNode(Main main, KFishingLocation fishingLocation, AbstractFish fishes) {
        super(main, fishingLocation, fishes);
    }

    @Override
    public boolean isValid() {
        return !main.getInventory().isFull() && !fishingLocation.fishingArea().contains(main.getLocalPlayer());
    }

    @Override
    public int execute() {
        state = "Walking to the fishing spot.";
        if (!fishingLocation.fishingArea().contains(main.getLocalPlayer())) {
            if (!main.getLocalPlayer().isMoving()) {
                log("Going");
                main.getWalking().walk(fishingLocation.fishingArea().getRandomTile());
                sleepUntil(() -> !main.getLocalPlayer().isMoving(), Calculations.random(1000, 2000));
            }
        }

        return 0;
    }
}
