package com.krugan.fisher.v2.fishing_states;

import com.krugan.fisher.Main;
import com.krugan.fisher.v2.Node;
import com.krugan.fisher.v2.util.AbstractFish;
import com.krugan.fisher.v2.util.KFishingLocation;
import org.dreambot.api.Client;
import org.dreambot.api.input.Mouse;
import org.dreambot.api.input.mouse.destination.AbstractMouseDestination;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.dialogues.Dialogues;
import org.dreambot.api.methods.input.MouseKeys;
import org.dreambot.api.methods.input.mouse.MouseSettings;
import org.dreambot.api.methods.input.mouse.MouseTracker;
import org.dreambot.api.methods.interactive.NPCs;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.Skills;
import org.dreambot.api.methods.tabs.Tab;
import org.dreambot.api.methods.tabs.Tabs;
import org.dreambot.api.methods.widget.Widget;
import org.dreambot.api.methods.widget.Widgets;
import org.dreambot.api.wrappers.interactive.NPC;
import org.dreambot.api.wrappers.widgets.WidgetChild;

import java.util.Random;

import static org.dreambot.api.methods.MethodProvider.log;
import static org.dreambot.api.methods.MethodProvider.sleepUntil;

public class FishingNode extends Node {
    public FishingNode(Main main, KFishingLocation fishingLocation, AbstractFish fishes) {
        super(main, fishingLocation, fishes);
    }

    @Override
    public boolean isValid() {
        return !Inventory.isFull() && main.isFishing && main.getLocalPlayer().isAnimating();
    }

    @Override
    public int execute() {
        state = "Fishing";
        NPC npc = NPCs.closest(fishes.fishingSpot().getFishingSpotName());
        if (!main.getLocalPlayer().isInteracting(npc)) {
            main.isFishing = false;
        }

        if (Dialogues.inDialogue()) {
            if (Dialogues.canContinue()) {

                Dialogues.spaceToContinue();
            }
        }

        Mouse.moveMouseOutsideScreen();
        sleepUntil(() -> !Mouse.isMouseInScreen(), Calculations.random(700, 4000), Calculations.random(3000, 4000));



        return Calculations.random(1500, 3200);
    }

}
