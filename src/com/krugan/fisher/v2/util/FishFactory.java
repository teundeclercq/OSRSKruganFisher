package com.krugan.fisher.v2.util;

import com.krugan.fisher.Main;
import com.krugan.fisher.v2.Node;
import com.krugan.fisher.v2.fishing_states.*;

import java.util.ArrayList;

public class FishFactory {
    public static ArrayList<Node> CreateNodes(Main main, AbstractFish fish, KFishingLocation fishingLocation) {
        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(new BankingNode(main, fishingLocation, fish));
        nodes.add(new FishingNode(main, fishingLocation, fish));
        nodes.add(new LfFishingSpotNode(main, fishingLocation, fish));
        nodes.add(new LogoutNode(main));
        nodes.add(new StopNode(main));
        nodes.add(new WalkToBankNode(main, fishingLocation));
        nodes.add(new WalkToFishingSpotNode(main, fishingLocation, fish));
        return nodes;
    }
}
