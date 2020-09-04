package com.krugan.fisher;

import com.krugan.fisher.view.FishingGUI;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.methods.dialogues.Dialogues;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.script.listener.AdvancedMessageListener;
import org.dreambot.api.wrappers.interactive.GameObject;
import org.dreambot.api.wrappers.interactive.NPC;
import org.dreambot.api.wrappers.widgets.message.Message;

import java.util.Arrays;

@ScriptManifest(category = Category.FISHING, name = "OSKruganLummyFisher", author = "Krugan", version = 1.111)
public class Main extends AbstractScript implements AdvancedMessageListener {

    //Botting variables
    State state;
    int spot;
    private boolean isFishing = false;

    //GUI variables
    private boolean isRunning;

    //Drawing variables
    String s;
    int shrimpsCaught = 0;
    int anchoviesCaught = 0;

    private Area bankArea;
    private Area fishArea;
    private Tile bankTile;
    private Tile fishingTile;
    private String[] fishToCatch;
    private String fishMethod;
    private String[] fishingSpotContainsActions;

    @Override
    public void onStart() {
        FishingGUI gui = new FishingGUI(this);
    }

    public void setBankArea(Area bankArea) {
        this.bankArea = bankArea;
    }

    public void setFishArea(Area fishArea) {
        this.fishArea = fishArea;
    }

    public void setFishMethod(String fishMethod) {
        this.fishMethod = fishMethod;
    }
    public void setFishToCatch(String[] fishToCatch) {
        this.fishToCatch = fishToCatch;
    }

    public void setFishingSpotContainsActions(String[] fishingSpotContainsActions) {
        this.fishingSpotContainsActions = fishingSpotContainsActions;
    }
    public void setBankTile(Tile bankTile) {
        this.bankTile = bankTile;
    }
    public void setFishingTile(Tile fishingTile) {
        this.fishingTile = fishingTile;
    }

    public void setRunning(boolean running) {
        this.isRunning = running;
    }

    @Override
    public int onLoop() {
            if (isRunning) {
                switch (getState()) {
                    case WALKING_TO_BANK:
                        s = "Going to bank";
                        if (isFishing) {
                            isFishing = false;
                        }
                        if (!bankArea.contains(getLocalPlayer())) {
                            if (!getLocalPlayer().isMoving()) {
                                getWalking().walk(bankTile);
                                sleepUntil(() -> !getLocalPlayer().isMoving(), 4432);
                            }
                        }
                        break;
                    case BANKING:
                        s = "Banking";
                        GameObject booth = getGameObjects().closest(bb -> bb != null && bb.getName().equals("Bank booth"));
                        booth.interact("Bank");
                        sleep(1000, 2000);
                        Bank bank = getBank();
                        sleepUntil(bank::isOpen, 3000);
                        if (bank.isOpen()) {
                            if (getInventory().contains(fishToCatch)) {
                                for(String fish: fishToCatch) {
                                    bank.depositAll(fish);
                                }
                                sleepUntil(() -> !getInventory().contains(fishToCatch), Calculations.random(3000, 6000));
                            }
                            bank.close();
                        }
                        break;
                    case FISHING:
                        s = "Fishing";
                        if (!getLocalPlayer().isAnimating()) {
                            isFishing = false;
                        } else {
                            sleep(Calculations.random(2000, 4000));
                        }

                        Dialogues d = getDialogues();
                        while (d.inDialogue()) {
                            if (d.canContinue()) {
                                d.spaceToContinue();
                            }
                        }
                        break;
                    case LF_FISHING_SPOT:
                        s = "Looking for Fishing spot";
                        NPC fishingSpot = getNpcs().closest(fs -> fs.getName().contentEquals("Fishing spot") && fishArea.contains(fs) && Arrays.equals(fs.getActions(), fishingSpotContainsActions));
                        fishingSpot.interact(fishMethod);
                        sleepUntil(() -> isFishing, Calculations.random(3000, 10000));
                        break;
                    case WALKING_TO_FISHING_SPOT:
                        s = "Going to Fishing area";
                        if (!fishArea.contains(getLocalPlayer())) {
                            if (!getLocalPlayer().isMoving()) {
                                getWalking().walk(fishingTile);
                                sleepUntil(() -> !getLocalPlayer().isMoving(), 4432);
                            }
                        }
                        break;
                    case LOGOUT:
                        log("logging out");
                        getTabs().logout();
                        break;
                    case STOP:
                        log("Stopping the script");
                        stop();
                        break;
                }
            }
        return 300;

    }


    public enum State {
        STOP, LOGOUT, BANKING, WALKING_TO_BANK, FISHING, LF_FISHING_SPOT, WALKING_TO_FISHING_SPOT
    }

    public State getState() {
        if (!getClient().isLoggedIn()) {
            state = State.STOP;
        } else if (getSkills().getRealLevel(Skill.FISHING) >= 40) {
            state = State.LOGOUT;
        } else if (getInventory().isFull() && bankArea.contains(getLocalPlayer())) {
            state = State.BANKING;
        } else if (getInventory().isFull() && !bankArea.contains(getLocalPlayer())) {
            state = State.WALKING_TO_BANK;
        } else if (!getInventory().isFull() && !fishArea.contains(getLocalPlayer())) {
            state = State.WALKING_TO_FISHING_SPOT;
        } else if (!getInventory().isFull() && !isFishing && fishArea.contains(getLocalPlayer())) {
            state = State.LF_FISHING_SPOT;
        } else if (!getInventory().isFull() && isFishing && getLocalPlayer().isAnimating()) {
            state = State.FISHING;
        }
        return state;
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
