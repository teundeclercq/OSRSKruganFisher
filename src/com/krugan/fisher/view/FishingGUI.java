package com.krugan.fisher.view;

import com.krugan.fisher.Main;
import com.krugan.fisher.model.FishType;
import com.krugan.fisher.model.FishingLocation;
import org.dreambot.api.methods.map.Area;

import javax.swing.*;

public class FishingGUI {

    private JComboBox<FishType> fishingStyleCMB;
    private JButton startButton;
    private JCheckBox bankingCheckbox;
    private JComboBox<FishingLocation> fishingLocationCMB;
    private JPanel mainPanel;
    private FishType fishType;
    private FishingLocation fishingLocation;

    // FishType
    private String[] fish;
    private String[] fishingEquipment;
    private String[] fishingBait;
    private String[] spotContains;
    private String fishingMethod;

    // FishingLocation
    private String name;
    private Area bankArea;
    private Area fishingArea;
    private FishType[] fishTypes;

    public FishingGUI(Main main) {
        JFrame jFrame = new JFrame("FishingGUI");
        jFrame.setContentPane(mainPanel);
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        fishingLocationCMB.setModel(new DefaultComboBoxModel<>(FishingLocation.values()));
        fishingLocationCMB.addActionListener(l -> {
            fishingLocation = (FishingLocation) fishingLocationCMB.getSelectedItem();
            fishTypes = fishingLocation.getFishTypes();
            fishingStyleCMB.setModel(new DefaultComboBoxModel<>(fishTypes));

            name = fishingLocation.getName();
            bankArea = fishingLocation.getBankArea();
            fishingArea = fishingLocation.getFishingArea();
            fishTypes = fishingLocation.getFishTypes();
        });

        fishingStyleCMB.addActionListener(l -> {

        });
        jFrame.pack();
        jFrame.setVisible(true);

        startButton.addActionListener(l -> {


            fishType = (FishType) fishingStyleCMB.getSelectedItem();
            fishingLocation = (FishingLocation) fishingLocationCMB.getSelectedItem();



            main.setBankArea(fishingLocation.getBankArea());
            main.setFishArea(fishingLocation.getFishingArea());
            main.setFishMethod(fishType.getFishingMethod());
            main.setFishingStartMessage(fishType.getFishingMessageStart());
            main.setFishingCatchMessages(fishType.getFishingMessageCatch());

            main.setFishingSpotName(fishType.getFishingSpotName());
            main.setFishToCatch(fishType.getFish());
            main.setCounters(fishType.getCounters());

            main.setRunning(true);
            jFrame.dispose();
            main.log("Closing gui");


            fishingMethod = fishType.getFishingMethod();



        });
    }

    private void setFish(String[] fish) {
        this.fish = fish;
    }

    private void setFishingEquipment(String[] fishingEquipment) {
        this.fishingEquipment = fishingEquipment;
    }

    private void setFishingBait(String[] fishingBait) {
        this.fishingBait = fishingBait;
    }

    private void setSpotContains(String[] spotContains) {
        this.spotContains = spotContains;
    }

    private void setFishingMethod(String fishingMethod) {
        this.fishingMethod = fishingMethod;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setBankArea(Area bankArea) {
        this.bankArea = bankArea;
    }

    private void setFishingArea(Area fishingArea) {
        this.fishingArea = fishingArea;
    }

    private void setFishTypes(FishType[] fishTypes) {
        this.fishTypes = fishTypes;
    }


    public String[] getFish() {
        return fish;
    }

    public String[] getFishingEquipment() {
        return fishingEquipment;
    }

    public String[] getFishingBait() {
        return fishingBait;
    }

    public String[] getSpotContains() {
        return spotContains;
    }

    public String getFishingMethod() {
        return fishingMethod;
    }

    public String getName() {
        return name;
    }

    public Area getBankArea() {
        return bankArea;
    }

    public Area getFishingArea() {
        return fishingArea;
    }

    public FishType[] getFishTypes() {
        return fishTypes;
    }
}
