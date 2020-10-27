package com.krugan.fisher.v2.fishing_states;

import com.krugan.fisher.Main;
import com.krugan.fisher.v2.Node;
import com.krugan.fisher.v2.util.KFishingLocation;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.walking.impl.Walking;

import static org.dreambot.api.methods.MethodProvider.log;
import static org.dreambot.api.methods.MethodProvider.sleepUntil;

public class WalkToBankNode extends Node {
    public WalkToBankNode(Main main, KFishingLocation fishingLocation) {
        super(main, fishingLocation);
    }

    @Override
    public boolean isValid() {
        return Inventory.isFull() && !fishingLocation.bankArea().contains(main.getLocalPlayer());
    }

    @Override
    public int execute() {
        state = "Walking to the bank";
        if (main.isFishing) {
            main.isFishing = false;
        }
        if (!fishingLocation.bankArea().contains(main.getLocalPlayer())) {
            if (!main.getLocalPlayer().isMoving()) {
                Walking.walk(fishingLocation.bankArea().getRandomTile());
                sleepUntil(() -> !main.getLocalPlayer().isMoving(), Calculations.random(400, 4000));
            }
        }
        return Calculations.random(400, 4000);
    }
}
