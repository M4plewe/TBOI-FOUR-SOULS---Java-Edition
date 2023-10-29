package com.github.m4plewe.collegetboicleaner;

public class LootCard extends Card {

    public String effect;
    public String id;
    public boolean trinket;

    public LootCard(String name, String effect, String id, boolean trinket) {
        super(name, "Loot");
        this.effect = effect;
        this.id = id;
        this.trinket = trinket;
    }

    // Add functions specific to Loot cards
    public void play(Player player, int cardIndex) {
        // Implement the play logic for Loot cards
        if (!player.usedLootCardThisTurn) {

            if (cardIndex >= 0 && cardIndex < player.hand.size()) {
                Card selectedCard = player.hand.get(cardIndex);

                if (selectedCard instanceof LootCard) {
                    LootCard lootCard = (LootCard) selectedCard;

                    if (lootCard.id.equals("aPenny")) {
                        player.coins += 1;
                    } else if (lootCard.id.equals("twoCents")) {
                        player.coins += 2;
                    } else if (lootCard.id.equals("threeCents")) {
                        player.coins += 3;
                    } else if (lootCard.id.equals("fourCents")) {
                        player.coins += 4;
                    } else if (lootCard.id.equals("bomb")) {
                        player.damage += 1;
                    } else if (lootCard.id.equals("chargedPenny")) {
                        player.coins += 1;
                        player.usedLootCardThisTurn = false;
                        player.boughtItemThisTurn = false;
                        player.hadFoughtAnEnemie = false;
                    } else if (lootCard.id.equals("creditCard")) {
                        player.coins += 10;
                    } else if (lootCard.id.equals("jera")) {
                        player.coins += 1 + Math.random() * 5;
                        player.damage += Math.random() * 3;
                        player.health += Math.random() * 3;
                    } else if (lootCard.id.equals("soulHeart")) {
                        player.health += 2;
                    } else {
                        System.out.println("Unknown loot card ID: " + lootCard.id);
                    }

                    player.hand.remove(cardIndex);

                    // Set the flag to indicate that the player has used a Loot Card this turn
                    player.usedLootCardThisTurn = true;

                }

            }

        } else {

            System.out.println("You can only use one Loot Card per turn.");

        }
    }

}
