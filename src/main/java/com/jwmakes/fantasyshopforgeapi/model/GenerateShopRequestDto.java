package com.jwmakes.fantasyshopforgeapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GenerateShopRequestDto {

    @JsonProperty("shopType")
    private String shopType;

    @JsonProperty("rarity")
    private String rarity;

    @JsonProperty("alignment")
    private String alignment;

    @JsonProperty("tone")
    private String tone;

    public String getShopType() {
        return shopType;
    }

    public String getRarity() {
        return rarity;
    }

    public String getAlignment() {
        return alignment;
    }

    public String getTone() {
        return tone;
    }
}
