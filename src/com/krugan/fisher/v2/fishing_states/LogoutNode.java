package com.krugan.fisher.v2.fishing_states;

import com.krugan.fisher.Main;
import com.krugan.fisher.v2.Node;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.tabs.Tabs;

import static org.dreambot.api.methods.MethodProvider.log;

public class LogoutNode extends Node {
    public LogoutNode(Main main) {
        super(main);
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public int execute() {
        state = "Logging out...";
        Tabs.logout();
        return Calculations.random(3000, 4600);
    }
}
