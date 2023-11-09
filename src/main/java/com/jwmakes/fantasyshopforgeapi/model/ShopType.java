package com.jwmakes.fantasyshopforgeapi.model;

public enum ShopType {
    POTIONS("Potions Shop"),
    MAGIC_ITEM("Magic Item Shop"),
    TAVERN("Tavern"),
    WEAPONS("Weapons Shop"),
    GENERAL("General Store");

    public final String label;

    private ShopType(String label) {
        this.label = label;
    }
}
