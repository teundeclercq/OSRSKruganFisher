package com.krugan.fisher;

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

@ScriptManifest(category = Category.FISHING, name = "OSKruganLummyFisher", author = "Krugan", version = 1.116)
public class Main extends AbstractScript implements AdvancedMessageListener {

    //Botting variables
    State state;
    int spot;
    private boolean isFishing = false;

    //GUI variables
    private boolean isRunning;
    private String fish;


    final Area BANK_AREA = new Area(new Tile(3207, 3222, 2), new Tile(3210, 3215,2));
    final Tile BANK_TILE = new Tile(3208,3219 ,2);

    final Tile FISHING_TILE = new Tile(3244, 3155, 0 );
    final Area FISHING_AREA = new Area(new Tile(3241, 3162,0 ), new Tile(3248, 3148, 0));

    //Drawing variables
    String s;
    int shrimpsCaught = 0;
    int anchoviesCaught = 0;

    @Override
    public int onLoop() {
        if (isRunning) {
            switch (getState()) {
                case WALKING_TO_BANK:
                    s = "Going to bank";
                    if (isFishing) {
                        isFishing = false;
                    }
                    if (!BANK_AREA.contains(getLocalPlayer())) {
                        if (!getLocalPlayer().isMoving()) {
                            getWalking().walk(BANK_TILE);
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
                    sleepUntil(() -> bank.isOpen(), 3000);
                    if (bank.isOpen()) {
                        if (getInventory().contains("Raw shrimps") && getInventory().contains("Raw anchovies")) {
                            bank.depositAll(item -> item.getName().equals("Raw shrimps"));
                            bank.depositAll(item -> item.getName().equals("Raw anchovies"));
                            sleepUntil(() -> !getInventory().contains(item -> item.getName().equals("Raw anchovies") || item.getName().equals("Raw shrimp")), 3000);
                        } else {
                            bank.depositAll(item -> item.getName().equals("Raw shrimps"));
                            sleepUntil(() -> !getInventory().contains(item -> item.getName().equals("Raw shrimps")), 3000);
                        }
                        bank.close();
                    }
                    break;
                case FISHING:
                    s = "Fishing";
                    if (!getLocalPlayer().isAnimating()) {
                        isFishing = false;

                    } else {
                        sleep(1000, 2000);
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
                    NPC fishingSpot = getNpcs().closest(fs -> fs.getName().contentEquals("Fishing spot") && FISHING_AREA.contains(fs));
                    fishingSpot.interact("Net");
                    sleepUntil(() -> isFishing, randomNum(5000, 7000));
                    break;
                case WALKING_TO_FISHING_SPOT:
                    s = "Going to Fishing area";
                    if (!FISHING_AREA.contains(getLocalPlayer())) {
                        if (!getLocalPlayer().isMoving()) {
                            getWalking().walk(FISHING_TILE);
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
        } else if (getInventory().isFull() && BANK_AREA.contains(getLocalPlayer())) {
            state = State.BANKING;
        } else if (getInventory().isFull() && !BANK_AREA.contains(getLocalPlayer())) {
            state = State.WALKING_TO_BANK;
        } else if (!getInventory().isFull() && !FISHING_AREA.contains(getLocalPlayer())) {
            state = State.WALKING_TO_FISHING_SPOT;
        } else if (!getInventory().isFull() && !isFishing && FISHING_AREA.contains(getLocalPlayer()) ) {
            state = State.LF_FISHING_SPOT;
        } else if (!getInventory().isFull() && isFishing && getLocalPlayer().isAnimating()) {
            state = State.FISHING;
        }
        return state;
    }

    public int randomNum(int i, int k) {
        return (int)(Math.random() * (k - i + 1)) + i;
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
