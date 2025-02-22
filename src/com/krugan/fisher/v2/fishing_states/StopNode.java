package com.krugan.fisher.v2.fishing_states;

import com.krugan.fisher.Main;
import com.krugan.fisher.v2.Node;
import org.dreambot.api.Client;

import static org.dreambot.api.methods.MethodProvider.log;

public class StopNode extends Node {
    public StopNode(Main main) {
        super(main);
    }

    @Override
    public boolean isValid() {
        return !Client.isLoggedIn();
    }

    @Override
    public int execute() {
        state = "Stopping";
        log("Stopping the script");
        main.stop();
        return 0;
    }
}
