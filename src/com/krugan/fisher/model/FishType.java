package com.krugan.fisher.model;

public enum FishType {
    SHRIMP_ANCHOVIES    (new String[] {"Raw anchovies", "Raw shrimps"}, new String[] {"Small net"}, new String[] {}, new String[] {"Net", "Bait"}, "Net"),
    SARDINE_HERRING     (new String[] {"Raw sardine", "Raw herring"}, new String[] {"Fishing rod"}, new String[] {"Fishing bait"}, new String[] {"Net", "Bait"}, "Bait"),
    TROUT_SALMON        (new String[] {"Raw trout", "Raw salmon"}, new String[] {"Fly fishing rod"}, new String[] {"feather"}, new String[] {"Lure", "Bait"}, "Lure"),
    TUNA_SWORDFISH      (new String[] {"Raw tuna", "Raw swordfish"}, new String[] {"Harpoon"}, new String[] {}, new String[] {"Cage", "Harpoon"}, "Harpoon"),
    LOBSTER             (new String[] {"Raw lobster"}, new String[] {"Lobster pot"}, new String[] {}, new String[] {"Cage", "Harpoon"}, "Cage"),
    MACKEREL_COD_BASS   (new String[] {"Raw mackerel", "Raw cod", "Raw bass", "Casket"}, new String[] {"Big fishing net"}, new String[] {}, new String[] {"Net", "Harpoon"}, "Net"),
    MONKFISH            (new String[] {"Raw monkfish"}, new String[] {"Big fishing net"}, new String[] {}, new String[] {"Harpoon", "Net"}, "Net"),
    SHARKS              (new String[] {"Raw shark"}, new String[] {"Harpoon"}, new String[] {}, new String[] {"Net", "Harpoon"}, "Harpoon"),
    KARAMBWANJI         (new String[] {"Raw karambwanji"}, new String[] {"Small net"}, new String[] {}, new String[] {"Net"}, "Net"),
    KARAMBWAN           (new String[] {"Raw karambwan"}, new String[] {"Karambwan vessel"}, new String[] {"Raw karambwanji"}, new String[] {"Fish"}, "Fish"),
    LEAPING_FISH        (new String[] {"Leaping trout", "Leaping salmon", "Leaping sturgeon"}, new String[] {"Barbarian rod"}, new String[] {"Feather", "Fishing bait"}, new String[]{"Use-rod"}, "Use-rod");

    private String[] fish;
    private String[] fishingEquipment;
    private String[] fishingBait;
    private String[] spotContains;
    private String fishingMethod;

    FishType(String[] fishName, String[]fishingEquipment, String[]fishingBait, String[] spotContains, String fishingMethod) {
        this.fish = fishName;
        this.fishingEquipment = fishingEquipment;
        this.fishingBait = fishingBait;
        this.spotContains = spotContains;
        this.fishingMethod = fishingMethod;
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
}
