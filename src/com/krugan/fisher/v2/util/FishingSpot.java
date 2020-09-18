package com.krugan.fisher.v2.util;

public class FishingSpot {
    protected String fishingSpotName;

    protected String fishingStartMessage;

    protected String[] fishingCatchMessage;

    protected String fishingInteractionAction;

    public FishingSpot(String fishingSpotName, String fishingStartMessage, String[] fishingCatchMessage, String fishingInteractionAction) {
        this.fishingSpotName = fishingSpotName;
        this.fishingStartMessage = fishingStartMessage;
        this.fishingCatchMessage = fishingCatchMessage;
        this.fishingInteractionAction = fishingInteractionAction;
    }

    /**
     * Getter for property 'fishingCatchMessage'.
     *
     * @return Value for property 'fishingCatchMessage'.
     */
    public String[] getFishingCatchMessage() {
        return fishingCatchMessage;
    }
    /**
     * Getter for property 'fishingSpotName'.
     *
     * @return Value for property 'fishingSpotName'.
     */
    public String getFishingSpotName() {
        return fishingSpotName;
    }

    /**
     * Getter for property 'fishingStartMessage'.
     *
     * @return Value for property 'fishingStartMessage'.
     */
    public String getFishingStartMessage() {
        return fishingStartMessage;
    }

    /**
     * Getter for property 'fishingInteractionAction'.
     *
     * @return Value for property 'fishingInteractionAction'.
     */
    public String getFishingInteractionAction() {
        return fishingInteractionAction;
    }
}
