package com.github.m4plewe.collegetboicleaner;

public class TreasureCard extends Card {
    public boolean isActive;
    public boolean Used;

    public TreasureCard(String name, boolean isActive, boolean Used) {
        super(name, "Treasure");
        this.isActive = isActive;

    }

    public static void applyPredefinedPassiveEffect(Player currentPlayer, String name) {

        if (name.equals("Synthoil: +1 Damage")) {
            currentPlayer.damage += 1;
        } else if (name.equals("Meat!: +1 Health")) {
            currentPlayer.health += 1;
        } else if (name.equals("Greed's Gullet: +3 coins each turn")) {
            currentPlayer.coins += 3;
        } else if (name.equals("Empty Vessel: +2 and +2 if less than 5 Cards on Hand else +1 Damage and +1 Coins per turn") && currentPlayer.hand.size() >= 3) {
            currentPlayer.damage += 1;
        } else if (name.equals("Brimstone: +1 Damage")) {
            currentPlayer.damage += 1;
        } else if (name.equals("Sausage: +1 Health +1 Damage")) {
            currentPlayer.health += 1;
            currentPlayer.damage += 1;
        } else if (name.equals("Sacred Heart: +2 Health and +1 Damage")) {
            currentPlayer.health += 2;
            currentPlayer.damage += 1;
        } else if (name.equals("Dinner: +1 Health")) {
            currentPlayer.health += 1;
        } else if (name.equals("Lard: +2 Health")) {
            currentPlayer.health += 2;
        }

    }

}
