package com.krugan.fisher.v2.util;

import java.util.Arrays;

public enum FishingStyle {
    NET_BAIT ("Net", "Bait"),
    LURE_BAIT ("Lure", "Bait"),
    BAIT ("Bait"),
    CAGE_HARPOON ("Cage", "Harpoon"),
    NET_HARPOON ("Net", "Harpoon"),
    HARPOON_NET ("Harpoon", "Net"),
    NET ("Net"),
    FISH ("Fish");

    private String[] styles;
    FishingStyle(String ...styles) {
        this.styles = styles;
    }

    /**
     * Getter for property 'styles'.
     *
     * @return Value for property 'styles'.
     */
    public String[] getStyles() {
        return styles;
    }
}
