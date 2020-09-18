package com.krugan.fisher.v2.fishing_states;

import com.krugan.fisher.Main;
import com.krugan.fisher.v2.Node;
import com.krugan.fisher.v2.util.KFishingLocation;
import org.dreambot.api.methods.Calculations;

import static org.dreambot.api.methods.MethodProvider.log;
import static org.dreambot.api.methods.MethodProvider.sleepUntil;

public class WalkToBankNode extends Node {
    public WalkToBankNode(Main main, KFishingLocation fishingLocation) {
        super(main, fishingLocation);
    }

    @Override
    public boolean isValid() {
        return main.getInventory().isFull() && !fishingLocation.bankArea().contains(main.getLocalPlayer());
    }

    @Override
    public int execute() {
        state = "Walking to the bank";
        if (main.isFishing) {
            main.isFishing = false;
        }
        if (!fishingLocation.bankArea().contains(main.getLocalPlayer())) {
            if (!main.getLocalPlayer().isMoving()) {
                main.getWalking().walk(fishingLocation.bankArea().getRandomTile());
                sleepUntil(() -> !main.getLocalPlayer().isMoving(), Calculations.random(1000, 3500));
            }
        }
        return Calculations.random(2000, 4000);
    }
}
