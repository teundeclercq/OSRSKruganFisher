package com.krugan.fisher.v2.fishing_states;

import com.krugan.fisher.Main;
import com.krugan.fisher.v2.Node;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.dialogues.Dialogues;

import static org.dreambot.api.methods.MethodProvider.sleep;

public class FishingNode extends Node {
    public FishingNode(Main main) {
        super(main);
    }

    @Override
    public boolean isValid() {
        return !main.getInventory().isFull() && main.isFishing && main.getLocalPlayer().isAnimating();
    }

    @Override
    public int execute() {
        state = "Fishing";
        if (!main.getLocalPlayer().isAnimating()) {
            main.isFishing = false;
        } else {
            sleep(Calculations.random(2000, 4000));
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
