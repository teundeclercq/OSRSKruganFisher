package com.krugan.fisher.v2.util;

public enum FishingEquipment {
    SMALL_NET("Small net"),
    BIG_NET("Big net"),
    FLY_FISHING_ROD("Fly fishing rod"),
    FISHING_ROD("Fishing rod"),
    POT ("Lobster pot"),
    HARPOON ("Harpoon"),
    KARAMBWAN_VESSEL ("Karambwan vessel")
    ;

    private String fishingEquipmentName;

    FishingEquipment(String fishingEquipmentName) {
        this.fishingEquipmentName = fishingEquipmentName;
    }

    /**
     * Getter for property 'fishingEquipmentName'.
     *
     * @return Value for property 'fishingEquipmentName'.
     */
    public String getFishingEquipmentName() {
        return fishingEquipmentName;
    }
}
