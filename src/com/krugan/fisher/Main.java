package com.krugan.fisher;

import com.krugan.fisher.v2.Node;
import com.krugan.fisher.view.FishingGUI;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.script.listener.AdvancedMessageListener;
import org.dreambot.api.utilities.Timer;
import org.dreambot.api.wrappers.widgets.message.Message;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@ScriptManifest(category = Category.FISHING, name = "OSKruganFisher", author = "Krugan", version = 1.123)
public class Main extends AbstractScript implements AdvancedMessageListener {

    //GUI variables
    private boolean isRunning = false;

    //Drawing variables
    private final Timer timer = new Timer(1000);
    private Integer[] counters;
    private List<Node> nodes = new LinkedList<>();
    private String[] fishes;
    private String[] fishingCatchMessages;
    private String state;
    public boolean isFishing;
    private String fishingStartMessage;

    @Override
    public void onStart() {
        FishingGUI gui = new FishingGUI(this);
    }

    public void setRunning(boolean running) {
        this.isRunning = running;
    }
    public void setFishes(String[] fishes) {this.fishes = fishes;}
    public void setFishingCatchMessages(String[] fishingCatchMessages) {this.fishingCatchMessages = fishingCatchMessages;}

    public void setFishingStartMessage(String fishingStartMessage) {
        this.fishingStartMessage = fishingStartMessage;
    }
    public void addNodes(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }
    public void setCounters(Integer[] counters) { this.counters = counters; }
    @Override
    public int onLoop() {

        if (isRunning) {
            if (this.nodes.isEmpty()) {
                log("No more available nodes, script has ended.");
                this.stop();
                return Calculations.random(1000, 5000);
            } else {
                for (Node node : nodes) {
                    if (node.isValid()) {
                        this.state = node.state;
                        log(String.valueOf(isFishing));
                        return node.execute();
                    }
                }
            }
        }
        return 300;

    }
    @Override
    public void onPaint(Graphics g) {
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("KruganFisher", 44, 205);
        g.drawString("State: " + state, 44, 235);
        int yAsState = 235;
        for (String fish: fishes) {
            int indexOfFishCounter = Arrays.asList(fishes).indexOf(fish);
            g.drawString( fish + " Caught: " + counters[indexOfFishCounter], 44, yAsState += 25);
        }
        g.drawString("Timer: "  + timer.formatTime(), 44, yAsState += 25);
    }

    @Override
    public void onAutoMessage(Message message) {
    }

    @Override
    public void onPrivateInfoMessage(Message message) {

    }

    @Override
    public void onClanMessage(Message message) {

    }

    @Override
    public void onGameMessage(Message message) {
        if (message.getMessage().equals(fishingStartMessage)) {
            this.isFishing = true;
        }

        for (int i = 0; i < fishingCatchMessages.length; i++) {
            if (message.getMessage().equals(fishingCatchMessages[i])) {
                counters[i] ++;
            }
        }
    }

    @Override
    public void onPlayerMessage(Message message) {

    }

    @Override
    public void onTradeMessage(Message message) {

    }

    @Override
    public void onPrivateInMessage(Message message) {

    }

    @Override
    public void onPrivateOutMessage(Message message) {

    }
}
