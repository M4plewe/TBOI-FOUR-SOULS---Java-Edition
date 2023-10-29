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

                if (selectedCard instanceof LootCard lootCard) {

                    switch (lootCard.id) {
                        case "aPenny" -> player.coins += 1;
                        case "twoCents" -> player.coins += 2;
                        case "threeCents" -> player.coins += 3;
                        case "fourCents" -> player.coins += 4;
                        case "bomb" -> player.damage += 1;
                        case "chargedPenny" -> {
                            player.coins += 1;
                            player.boughtItemThisTurn = false;
                            player.hadFoughtAnEnemie = false;
                        }
                        case "creditCard" -> player.coins += 10;
                        case "jera" -> {
                            player.coins += (int) (1 + Math.random() * 5);
                            player.damage += (int) (Math.random() * 3);
                            player.health += (int) (Math.random() * 3);
                        }
                        case "soulHeart" -> player.health += 2;
                        default -> System.out.println("Unknown loot card ID: " + lootCard.id);
                    }


                    if (!lootCard.id.equals("chargedPenny")) {
                        player.hand.remove(cardIndex);
                        player.usedLootCardThisTurn = true;
                    }else{
                        player.hand.remove(cardIndex);
                    }

                }

            }

        } else {

            System.out.println("You can only use one Loot Card per turn.");

        }
    }

}
