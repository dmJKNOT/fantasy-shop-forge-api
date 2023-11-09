package com.jwmakes.fantasyshopforgeapi.model.chat;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeneratedItem {

    @JsonProperty("Name")
    private String Name;

    @JsonProperty("Cost")
    private int Cost;

    @JsonProperty("Rarity")
    private String Rarity;

    @JsonProperty("Effects")
    private String Effects;

    @JsonProperty("Requirements")
    private String Requirements;


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getCost() {
        return Cost;
    }

    public void setCost(int cost) {
        Cost = cost;
    }

    public String getRarity() {
        return Rarity;
    }

    public void setRarity(String rarity) {
        Rarity = rarity;
    }

    public String getEffects() {
        return Effects;
    }

    public void setEffects(String effects) {
        Effects = effects;
    }

    public String getRequirements() {
        return Requirements;
    }

    public void setRequirements(String requirements) {
        Requirements = requirements;
    }
}
