package com.krugan.fisher.view;

import com.krugan.fisher.Main;
import com.krugan.fisher.v2.fishing_locations.Catherby;
import com.krugan.fisher.v2.fishing_locations.LumbridgeTown;
import com.krugan.fisher.v2.util.AbstractFish;
import com.krugan.fisher.v2.util.FishFactory;
import com.krugan.fisher.v2.util.KFishingLocation;

import javax.swing.*;

public class FishingGUI {

    private JComboBox<AbstractFish> fishingStyleCMB;
    private JButton startButton;
    private JCheckBox bankingCheckbox;
    private JComboBox<KFishingLocation> fishingLocationCMB;
    private JPanel mainPanel;

    private KFishingLocation fishingLocation;
    private AbstractFish fish;

    public FishingGUI(Main main) {
        JFrame jFrame = new JFrame("FishingGUI");
        jFrame.setContentPane(mainPanel);
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        KFishingLocation[] locationList = {new LumbridgeTown(), new Catherby()};
        fishingLocationCMB.setModel(new DefaultComboBoxModel<>(locationList));
        fishingLocationCMB.addActionListener(l -> {
              fishingLocation = (KFishingLocation) fishingLocationCMB.getSelectedItem();
              fishingStyleCMB.setModel(new DefaultComboBoxModel<>(fishingLocation.getFishTypes()));

        });

        fishingStyleCMB.addActionListener(l -> {
            fish = (AbstractFish) fishingStyleCMB.getSelectedItem();
        });
        jFrame.pack();
        jFrame.setVisible(true);

        startButton.addActionListener(l -> {
            main.addNodes(FishFactory.CreateNodes(main, fish, fishingLocation));
            main.setCounters(fish.counters());
            main.setFishes(fish.names());
            main.setFishingStartMessage(fish.fishingSpot().getFishingStartMessage());
            main.setFishingCatchMessages(fish.fishingSpot().getFishingCatchMessage());
            main.isFishing = false;
            main.setRunning(true);
            jFrame.dispose();
            main.log("Closing gui");

        });
    }
}
