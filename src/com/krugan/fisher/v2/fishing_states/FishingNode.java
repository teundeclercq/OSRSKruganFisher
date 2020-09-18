package com.krugan.fisher.v2.fishing_states;

import com.krugan.fisher.Main;
import com.krugan.fisher.v2.Node;
import com.krugan.fisher.v2.util.AbstractFish;
import com.krugan.fisher.v2.util.KFishingLocation;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.dialogues.Dialogues;
import org.dreambot.api.wrappers.interactive.NPC;

import static org.dreambot.api.methods.MethodProvider.log;

public class FishingNode extends Node {
    public FishingNode(Main main, KFishingLocation fishingLocation, AbstractFish fishes) {
        super(main, fishingLocation, fishes);
    }

    @Override
    public boolean isValid() {
        return !main.getInventory().isFull() && main.isFishing && main.getLocalPlayer().isAnimating();
    }

    @Override
    public int execute() {
        state = "Fishing";
        log("Fishing");
        NPC npc = main.getNpcs().closest(fishes.fishingSpot().getFishingSpotName());
        if (!main.getLocalPlayer().isInteracting(npc)) {
            main.isFishing = false;
        } else {
            return Calculations.random(2000, 4000);
        }

        Dialogues d = main.getDialogues();
        while (d.inDialogue()) {
            if (d.canContinue()) {
                d.spaceToContinue();
            }
        }

        return Calculations.random(1500, 3200);
    }

}
