package com.krugan.fisher.v2.fishing_states;

import com.krugan.fisher.Main;
import com.krugan.fisher.v2.Node;
import com.krugan.fisher.v2.util.AbstractFish;
import com.krugan.fisher.v2.util.KFishingLocation;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.methods.interactive.GameObjects;
import org.dreambot.api.wrappers.interactive.GameObject;

import java.awt.*;
import java.beans.PropertyChangeEvent;

import static org.dreambot.api.methods.MethodProvider.sleep;
import static org.dreambot.api.methods.MethodProvider.sleepUntil;

public class BankingNode extends Node {
    public BankingNode(Main main, KFishingLocation fishingLocation, AbstractFish fishes) {
        super(main, fishingLocation, fishes);
    }

    @Override
    public boolean isValid() {
        return Inventory.isFull() && fishingLocation.bankArea().contains(main.getLocalPlayer());
    }

    @Override
    public int execute() {
        state = "Banking";
        GameObject booth = GameObjects.closest(bb -> bb != null && bb.getName().equals("Bank booth"));
        booth.interact("Bank");
        sleep(1000, 2000);
        sleepUntil(Bank::isOpen, 3000);
        if (Bank.isOpen()) {
            if (Inventory.contains(fishes.names())) {
                for(String fish: fishes.names()) {
                    Bank.depositAll(fish);
                }
                sleepUntil(() -> !Inventory.contains(fishes.names()), Calculations.random(3000, 6000));
            }
            Bank.close();
        }

        return Calculations.random(2000, 3500);
    }
}
