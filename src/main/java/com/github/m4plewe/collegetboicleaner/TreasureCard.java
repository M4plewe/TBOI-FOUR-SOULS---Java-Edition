package com.github.m4plewe.collegetboicleaner;

public class TreasureCard extends Card {
    public boolean isActive;
    public boolean Used;

    public TreasureCard(String name, boolean isActive, boolean Used) {
        super(name, "Treasure");
        this.isActive = isActive;

    }

}
