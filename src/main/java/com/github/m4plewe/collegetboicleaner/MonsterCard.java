package com.github.m4plewe.collegetboicleaner;

public class MonsterCard extends Card {

    public int health;
    public int evasion;
    public int damage;
    public String defeat;

    public MonsterCard(String name, int health, int evasion, int damage, String defeat) {
        super(name, "Monster");

        this.health = health;
        this.evasion = evasion;
        this.damage = damage;
        this.defeat = defeat;

    }

    public void monsterDefeated(Player player, String monsterDefeatString, Deck lootDeck, Deck treasureDeck) {

        switch (monsterDefeatString) {
            case "BlackBonyDefeat" -> {
                int blackBonyRandom = (int)(1 + Math.random()*6);
                for (int i= 0; i < blackBonyRandom; i ++){
                    Card card = lootDeck.draw();
                    if (card != null) {
                        player.hand.add(card);
                    }
                }
            }
            case "BoomFlyDefeat" -> {
                player.coins += 4;
            }
            case "ClottyDefeat" -> player.coins += 4;
            case "BigSpiderDefeat", "FattyDefeat" -> {
                Card card = lootDeck.draw();
                if (card != null)
                    player.hand.add(card);
            }
            case "CodWormDefeat" -> player.coins += 3;
            case "ConjoinedFattyDefeat" -> {
                for (int i = 0; i < 2 ; i++){
                    Card card = lootDeck.draw();
                    if (card != null)
                        player.hand.add(card);
                }
            }
            case "DankGlobinDefeat" -> {

                for (int i = 0; i < 2 ; i++){
                    Card card = lootDeck.draw();
                    if (card != null)
                        player.hand.add(card);
                }
                for (int i = 0; i < 2 ; i++) {
                    for (Card card : player.hand) {
                        if (card instanceof LootCard) {
                            player.hand.remove(card);
                            break; // Remove only one LootCard
                        }
                    }
                }
            }
            case "DingaDefeat", "KeeperHeadDefeat" -> {
                int CoinsRandom =(int) (1+Math.random()*6);
                player.coins += CoinsRandom;
            }
            case "DipDefeat" -> player.coins += 1;


            case "DopleDefeat" -> player.coins += 7;

            case "EvilTwinDefeat", "FatBatDefeat" -> {

                if (!treasureDeck.cards.isEmpty()) {
                    TreasureCard item = treasureDeck.drawTreasure();
                    player.hand.add(item);
                    // Handle the treasure card as needed
                }
            }
            case "FlyDefeat" ->
                    player.coins += 1;
            case "GreedlingDefeat" ->
                    player.coins += 7;
            case "HangerDefeat" -> player.coins += 7;
            case "HopperDefeat" -> {
                player.coins += 3;
            }
            case "HorfDefeat" -> player.coins += 3;
            case "LeaperDefeat" -> player.coins += 5;
        }
        // Add more cases for other monsters' defeat strings and item rewards as needed.
    }


}
