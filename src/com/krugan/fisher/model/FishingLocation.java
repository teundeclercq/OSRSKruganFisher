package com.krugan.fisher.model;

import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Tile;

public enum FishingLocation {
    ALKHARID                ("Alkharid", new Area(3265, 3173, 3272, 3161), new Area(3261, 3150, 3279, 3136, 0), new FishType[] {FishType.SARDINE_HERRING, FishType.SHRIMP_ANCHOVIES}),
    BARBARIANASSAULT        ("Barbarian assault", new Area(2533, 3576, 2538, 3570, 0), new Area(2519, 3578, 2507, 3557), new FishType[] {FishType.SARDINE_HERRING, FishType.SHRIMP_ANCHOVIES}),
    BARBARIANVILLAGE        ("Barbarian village", new Area(3091, 3497, 3098, 3488), new Area(3099, 3436, 3110, 3422), new FishType[] {FishType.TROUT_SALMON}),
    BAXTORIANFALLS          ("Baxtorian falls", new Area(2612, 3334, 2621, 3330), new Area(2539, 3403, 2521, 3415), new FishType[] {FishType.TROUT_SALMON}),
    CATHERBY                ("Catherby", new Area(2806, 3445, 2812, 3438), new Area(2834, 3433, 2861, 3421), new FishType[] {FishType.SHARKS, FishType.TUNA_SWORDFISH, FishType.MACKEREL_COD_BASS, FishType.SARDINE_HERRING, FishType.LOBSTER}),
    DRAYNOR                 ("Draynor", new Area(3090, 3246, 3097, 3240), new Area(3080, 3237, 3090, 3220), new FishType[] {FishType.SARDINE_HERRING, FishType.SHRIMP_ANCHOVIES}),
    KARAMAJA_MUSA_POINT     ("Karamja Musa point", new Area(3090, 3246, 3097, 3240), new Area(2920, 3184, 2929, 3173), new FishType[] {FishType.LOBSTER}),
    LUMBRIDE_SWAMP          ("Lumbridge swamp", new Area(3207, 3222, 3210, 3215, 2), new Area(3241, 3160, 3247, 3149, 0), new FishType[] {FishType.SHRIMP_ANCHOVIES}),
    LUMBRIDGE_TOWN          ("Lumbridge town", new Area(3207, 3222, 3210, 3215, 2), new Area(3236, 3255, 3242, 3239, 0), new FishType[] {FishType.SARDINE_HERRING, FishType.TROUT_SALMON}),
    NORTH_ARDOUGNE          ("North Ardougne", new Area(2612, 3334, 2621, 3330), new Area(2568, 3366, 2557, 3375), new FishType[] {FishType.TROUT_SALMON}),
    NORTH_FISHING_GUILD     ("North fishing guild", new Area(2589, 3418, 2583, 3421), new Area(2596, 3428, 2606, 3418), new FishType[] {FishType.SHARKS, FishType.LOBSTER, FishType.TUNA_SWORDFISH}),
    OTTO_GROTTO             ("Otto grotto", new Area(2498, 3515, 2507, 3492), new Area(), new FishType[] {FishType.LEAPING_FISH}),
    SOUT_FISHING_GUILD      ("South fishing guild", new Area(2589, 3418, 2583, 3421), new Area(2600, 3418, 2614, 3409), new FishType[] {FishType.SHARKS, FishType.LOBSTER, FishType.TUNA_SWORDFISH});

    private String name;
    private Area bankArea;
    private Area fishingArea;
    private FishType[] fishTypes;

    FishingLocation(String name, Area bankArea, Area fishingArea, FishType[] fishTypes) {
        this.name = name;
        this.bankArea = bankArea;
        this.fishingArea = fishingArea;
        this.fishTypes = fishTypes;
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
