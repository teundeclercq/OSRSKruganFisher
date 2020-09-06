package com.krugan.fisher.model;

public enum FishType {
    SHRIMP_ANCHOVIES    (new Integer[] {0, 0}, new String[] {"Raw anchovies", "Raw shrimps"}, new String[] {"Small net"}, new String[] {}, new String[] {"Net", "Bait"}, "Net", "Fishing spot", "", new String[] {""}),
    SARDINE_HERRING     (new Integer[] {0, 0}, new String[] {"Raw sardine", "Raw herring"}, new String[] {"Fishing rod"}, new String[] {"Fishing bait"}, new String[] {"Net", "Bait"}, "Bait", "Rod Fishing Spot", "",new String[] {""}),
    TROUT_SALMON        (new Integer[] {0, 0},new String[] {"Raw trout", "Raw salmon"}, new String[] {"Fly fishing rod"}, new String[] {"feather"}, new String[] {"Lure", "Bait"}, "Lure", "Rod Fishing spot", "You attempt to catch a fish.", new String[] {"You catch a trout.", "You catch a salmon."}),
    TUNA_SWORDFISH      (new Integer[] {0, 0},new String[] {"Raw tuna", "Raw swordfish"}, new String[] {"Harpoon"}, new String[] {}, new String[] {"Cage", "Harpoon"}, "Harpoon", "Harpoon Fishing Spot", "", new String[] {""}),
    LOBSTER             (new Integer[] {0},new String[] {"Raw lobster"}, new String[] {"Lobster pot"}, new String[] {}, new String[] {"Cage", "Harpoon"}, "Cage", "Cage Fishing Spot", "", new String[] {""}),
    MACKEREL_COD_BASS   (new Integer[] {0, 0, 0, 0},new String[] {"Raw mackerel", "Raw cod", "Raw bass", "Casket"}, new String[] {"Big fishing net"}, new String[] {}, new String[] {"Net", "Harpoon"}, "Net", "Net Fishing spot", "", new String[] {""}),
    MONKFISH            (new Integer[] {0},new String[] {"Raw monkfish"}, new String[] {"Big fishing net"}, new String[] {}, new String[] {"Harpoon", "Net"}, "Net", "Net Fishing spot", "", new String[] {""}),
    SHARKS              (new Integer[] {0},new String[] {"Raw shark"}, new String[] {"Harpoon"}, new String[] {}, new String[] {"Net", "Harpoon"}, "Harpoon", "Harpoon Fishing spot", "", new String[] {""}),
    KARAMBWANJI         (new Integer[] {0},new String[] {"Raw karambwanji"}, new String[] {"Small net"}, new String[] {}, new String[] {"Net"}, "Net", "Net Fishing spot", "" ,new String[] {""}),
    KARAMBWAN           (new Integer[] {0},new String[] {"Raw karambwan"}, new String[] {"Karambwan vessel"}, new String[] {"Raw karambwanji"}, new String[] {"Fish"}, "Fish", "Fishing spot","", new String[] {""}),
    LEAPING_FISH        (new Integer[] {0},new String[] {"Leaping trout", "Leaping salmon", "Leaping sturgeon"}, new String[] {"Barbarian rod"}, new String[] {"Feather", "Fishing bait"}, new String[]{"Use-rod"}, "Use-rod", "Rod Fishing spot","",new String[] {""});


    private Integer[] counters;
    private String[] fish;
    private String[] fishingEquipment;
    private String[] fishingBait;
    private String[] spotContains;
    private String fishingMethod;
    private String fishingSpotName;
    private String fishingMessageStart;
    private String[] fishingMessageCatch;

    FishType(Integer[] counters, String[] fishName, String[]fishingEquipment, String[]fishingBait, String[] spotContains, String fishingMethod, String fishingSpotName, String fishingMessageStart, String[] fishingMessageCatch) {
        this.counters = counters;
        this.fish = fishName;
        this.fishingEquipment = fishingEquipment;
        this.fishingBait = fishingBait;
        this.spotContains = spotContains;
        this.fishingMethod = fishingMethod;
        this.fishingSpotName = fishingSpotName;
        this.fishingMessageStart = fishingMessageStart;
        this.fishingMessageCatch = fishingMessageCatch;
    }

    public String[] getFish() {
        return fish;
    }

    public Integer[] getCounters() {
        return counters;
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

    public String getFishingSpotName() {
        return fishingSpotName;
    }

    public String[] getFishingMessageCatch() {
        return fishingMessageCatch;
    }

    public String getFishingMessageStart() {
        return fishingMessageStart;
    }
}
