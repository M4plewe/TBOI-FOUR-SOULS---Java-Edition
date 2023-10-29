package com.github.m4plewe.collegetboicleaner;

public class TreasureCard extends Card {
    public boolean isActive;
    public boolean Used;

    public TreasureCard(String name, boolean isActive, boolean Used) {
        super(name, "Treasure");
        this.isActive = isActive;

    }

    public static void applyPredefinedPassiveEffect(Player currentPlayer, String name) {

        if (name.equals("Synthoil")) {
            currentPlayer.damage += 1;
        } else if (name.equals("Meat!")) {
            currentPlayer.health += 1;
        } else if (name.equals("Greed's Gullet")) {
            currentPlayer.coins += 3;
        } else if (name.equals("Empty Vessel") && currentPlayer.hand.size() >= 3) {
            currentPlayer.damage += 1;
        } else if (name.equals("Brimstone")) {
            currentPlayer.damage += 1;
        } else if (name.equals("Sausage")) {
            currentPlayer.health += 1;
            currentPlayer.damage += 1;
        } else if (name.equals("Sacred Heart")) {
            currentPlayer.health += 2;
            currentPlayer.damage += 1;
        } else if (name.equals("Dinner")) {
            currentPlayer.health += 1;
        } else if (name.equals("Lard")) {
            currentPlayer.health += 2;
        }

    }

}
