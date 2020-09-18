package com.krugan.fisher.v2.util;

public enum Bait {
    FEATHER ("Feather"),
    BAIT ("Bait"),
    KARAMBWANJI ("Raw karambwanji")
    ;

    private String bait;

    Bait(String bait) {
        this.bait = bait;
    }
    /**
     * Getter for property 'bait'.
     *
     * @return Value for property 'bait'.
     */
    public String getBait() {
        return bait;
    }
}
