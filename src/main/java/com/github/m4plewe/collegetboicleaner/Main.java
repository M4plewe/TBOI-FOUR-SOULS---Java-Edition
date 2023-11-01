package com.github.m4plewe.collegetboicleaner;

import java.util.*;

class FourSoulsGame {
    public List<Player> players;
    public Deck treasureDeck;
    public Deck monsterDeck;
    public Deck lootDeck;
    public List<MonsterCard> monstersInPlay;
    int montersInPlaySize = 2;
    public List<TreasureCard> shopItems;
    int shopSize = 2;

    public FourSoulsGame(int numPlayers) {

        Scanner sc = new Scanner(System.in);

        players = new ArrayList<>();

        for (int i = 1; i <= numPlayers; i++) {

            System.out.println("Type player #" + i + " name.");

            String playerName = sc.nextLine();

            players.add(new Player(playerName));

        }

        treasureDeck = initializeTreasureDeck();
        monsterDeck = initializeMonsterDeck();
        lootDeck = initializeLootDeck(numPlayers);

        shopItems = new ArrayList<>();
        monstersInPlay = new ArrayList<>();

    }

    private Deck initializeMonsterDeck() {
        Deck deck = new Deck();

        deck.addCard(new MonsterCard("Black Bony", 3, 4, 1, "BlackBonyDefeat"));
        deck.addCard(new MonsterCard("Boom Fly", 1, 4, 1, "BoomFlyDefeat"));
        deck.addCard(new MonsterCard("Clotty", 2, 3, 1, "ClottyDefeat"));
        deck.addCard(new MonsterCard("Big Spider", 3, 4, 1, "BigSpiderDefeat"));
        deck.addCard(new MonsterCard("Cod Worm", 1, 5, 0, "CodWormDefeat"));
        deck.addCard(new MonsterCard("Conjoined Fatty", 4, 3, 2, "ConjoinedFattyDefeat"));
        deck.addCard(new MonsterCard("Dank Globin", 2, 4, 2, "DankGlobinDefeat"));
        deck.addCard(new MonsterCard("Dinga", 3, 3, 1, "DingaDefeat"));
        deck.addCard(new MonsterCard("Dip", 1, 4, 1, "DipDefeat"));
        deck.addCard(new MonsterCard("Dople", 2, 4, 2, "DopleDefeat"));
        deck.addCard(new MonsterCard("Evil Twin", 3, 5, 2, "EvilTwinDefeat"));
        deck.addCard(new MonsterCard("Fat Bat", 3, 5, 1, "FatBatDefeat"));
        deck.addCard(new MonsterCard("Fatty", 4, 2, 1, "FattyDefeat"));
        deck.addCard(new MonsterCard("Fly", 1, 2, 1, "FlyDefeat"));
        deck.addCard(new MonsterCard("Greedling", 2, 5, 1, "GreedlingDefeat"));
        deck.addCard(new MonsterCard("Hanger", 2, 4, 2, "HangerDefeat"));
        deck.addCard(new MonsterCard("Hopper", 2, 3, 1, "HopperDefeat"));
        deck.addCard(new MonsterCard("Horf", 1, 4, 1, "HorfDefeat"));
        deck.addCard(new MonsterCard("Keeper Head", 2, 4, 1, "KeeperHeadDefeat"));
        deck.addCard(new MonsterCard("Leaper", 2, 4, 1, "LeaperDefeat"));

        Collections.shuffle(deck.cards);
        return deck;

    }

    private Deck initializeTreasureDeck() {
        Deck deck = new Deck();

        // Treasure Cards
        deck.addCard(new TreasureCard("Sausage: +1 Health +1 Damage", false));
        deck.addCard(new TreasureCard("Brimstone: +1 Damage", false));
        deck.addCard(new TreasureCard("Sacred Heart: +2 Health and +1 Damage", false));
        deck.addCard(new TreasureCard("Dinner: +1 Health", false));
        deck.addCard(new TreasureCard("Lard: +2 Health", false));
        deck.addCard(new TreasureCard("Dry Baby: Blocks enemy attacks 25% chance", false));
        deck.addCard(new TreasureCard("Empty Vessel: +2 and +2 if less than 5 Cards on Hand else +1 Damage and +1 Coins per turn", false));
        deck.addCard(new TreasureCard("Greed's Gullet: +3 coins each turn", false));
        deck.addCard(new TreasureCard("Meat!: +1 Health", false));
        deck.addCard(new TreasureCard("Synthoil: +1 Damage", false));

// Active Treasure Cards

        deck.addCard(new TreasureCard("The Chest: Gain a Soul (Destroys on use)", true));
        deck.addCard(new TreasureCard("Pandora's Box: Random effect (+1$, +6$, +999 damage, +3 Loot, +9$, +1 Souls (Destroys on use))", true));
        deck.addCard(new TreasureCard("The Battery: Reset turn effects (can use loot, shop and fight again)", true));
        deck.addCard(new TreasureCard("Host Hat: +2 Health", true));
        deck.addCard(new TreasureCard("Mystery Sack: Random effect (+1 Loot, +4$)", true));
        deck.addCard(new TreasureCard("Book of Sin: Random effect (+1 $, +1 Loot, +1 Heart)", true));
        deck.addCard(new TreasureCard("Chaos Card: Change monster stats", true));
        deck.addCard(new TreasureCard("Battery Bum: Reactivate a used active card per 4$", true));
        deck.addCard(new TreasureCard("Dark Bum: Random effect (+3$, +1 Loot, -1 Health)", true));
        deck.addCard(new TreasureCard("Plan C: Defeat all monsters and u die with them (Destroys on use)", true));


        Collections.shuffle(deck.cards);

        return deck;
    }

    private Deck initializeLootDeck(int numCartas) {

        Deck deck = new Deck();

        deck.addCard(new LootCard("A Penny! (Self explanatory)", "", "aPenny", false));
        deck.addCard(new LootCard("2 Cents! (Self explanatory)", "", "twoCents", false));
        deck.addCard(new LootCard("3 Cents! (Self explanatory)", "", "threeCents", false));
        deck.addCard(new LootCard("4 Cents! (Self explanatory)", "", "fourCents", false));
        deck.addCard(new LootCard("Bomb (+1 Damage this turn)", "", "bomb", false));
        deck.addCard(new LootCard("Charged Penny (+1 Coin and Reset turn effects (can use loot, shop and fight again)", "", "chargedPenny", false));
        deck.addCard(new LootCard("Credit Card (+10 coins)", "", "creditCard", false));
        deck.addCard(new LootCard("Jera ( +1-3 Damage, +1-3 Health, +1-5 Coins)", "", "jera", false));
        deck.addCard(new LootCard("Soul Heart (+2 Health)", "", "soulHeart", false));

        // Repitiendo para luego el shuffle

        deck.addCard(new LootCard("A Penny! (Self explanatory)", "", "aPenny", false));
        deck.addCard(new LootCard("2 Cents! (Self explanatory)", "", "twoCents", false));
        deck.addCard(new LootCard("3 Cents! (Self explanatory)", "", "threeCents", false));
        deck.addCard(new LootCard("4 Cents! (Self explanatory)", "", "fourCents", false));
        deck.addCard(new LootCard("Bomb (+1 Damage this turn)", "", "bomb", false));
        deck.addCard(new LootCard("Charged Penny (+1 Coin and Reset turn effects (can use loot, shop and fight again)", "", "chargedPenny", false));
        deck.addCard(new LootCard("Credit Card (+10 coins)", "", "creditCard", false));
        deck.addCard(new LootCard("Jera ( +1-3 Damage, +1-3 Health, +1-5 Coins)", "", "jera", false));
        deck.addCard(new LootCard("Soul Heart (+2 Health)", "", "soulHeart", false));
        deck.addCard(new LootCard("A Penny! (Self explanatory)", "", "aPenny", false));
        deck.addCard(new LootCard("2 Cents! (Self explanatory)", "", "twoCents", false));
        deck.addCard(new LootCard("3 Cents! (Self explanatory)", "", "threeCents", false));
        deck.addCard(new LootCard("4 Cents! (Self explanatory)", "", "fourCents", false));
        deck.addCard(new LootCard("Bomb (+1 Damage this turn)", "", "bomb", false));
        deck.addCard(new LootCard("Charged Penny (+1 Coin and Reset turn effects (can use loot, shop and fight again)", "", "chargedPenny", false));
        deck.addCard(new LootCard("Credit Card (+10 coins)", "", "creditCard", false));
        deck.addCard(new LootCard("Jera ( +1-3 Damage, +1-3 Health, +1-5 Coins)", "", "jera", false));
        deck.addCard(new LootCard("Soul Heart (+2 Health)", "", "soulHeart", false));
        deck.addCard(new LootCard("A Penny! (Self explanatory)", "", "aPenny", false));
        deck.addCard(new LootCard("2 Cents! (Self explanatory)", "", "twoCents", false));
        deck.addCard(new LootCard("3 Cents! (Self explanatory)", "", "threeCents", false));
        deck.addCard(new LootCard("4 Cents! (Self explanatory)", "", "fourCents", false));
        deck.addCard(new LootCard("Bomb (+1 Damage this turn)", "", "bomb", false));
        deck.addCard(new LootCard("Charged Penny (+1 Coin and Reset turn effects (can use loot, shop and fight again)", "", "chargedPenny", false));
        deck.addCard(new LootCard("Credit Card (+10 coins)", "", "creditCard", false));
        deck.addCard(new LootCard("Jera ( +1-3 Damage, +1-3 Health, +1-5 Coins)", "", "jera", false));
        deck.addCard(new LootCard("Soul Heart (+2 Health)", "", "soulHeart", false));
        deck.addCard(new LootCard("A Penny! (Self explanatory)", "", "aPenny", false));
        deck.addCard(new LootCard("2 Cents! (Self explanatory)", "", "twoCents", false));
        deck.addCard(new LootCard("3 Cents! (Self explanatory)", "", "threeCents", false));
        deck.addCard(new LootCard("4 Cents! (Self explanatory)", "", "fourCents", false));
        deck.addCard(new LootCard("Bomb (+1 Damage this turn)", "", "bomb", false));
        deck.addCard(new LootCard("Charged Penny (+1 Coin and Reset turn effects (can use loot, shop and fight again)", "", "chargedPenny", false));
        deck.addCard(new LootCard("Credit Card (+10 coins)", "", "creditCard", false));
        deck.addCard(new LootCard("Jera ( +1-3 Damage, +1-3 Health, +1-5 Coins)", "", "jera", false));
        deck.addCard(new LootCard("Soul Heart (+2 Health)", "", "soulHeart", false));
        deck.addCard(new LootCard("A Penny! (Self explanatory)", "", "aPenny", false));
        deck.addCard(new LootCard("2 Cents! (Self explanatory)", "", "twoCents", false));
        deck.addCard(new LootCard("3 Cents! (Self explanatory)", "", "threeCents", false));
        deck.addCard(new LootCard("4 Cents! (Self explanatory)", "", "fourCents", false));
        deck.addCard(new LootCard("Bomb (+1 Damage this turn)", "", "bomb", false));
        deck.addCard(new LootCard("Charged Penny (+1 Coin and Reset turn effects (can use loot, shop and fight again)", "", "chargedPenny", false));
        deck.addCard(new LootCard("Credit Card (+10 coins)", "", "creditCard", false));
        deck.addCard(new LootCard("Jera ( +1-3 Damage, +1-3 Health, +1-5 Coins)", "", "jera", false));
        deck.addCard(new LootCard("Soul Heart (+2 Health)", "", "soulHeart", false));
        deck.addCard(new LootCard("A Penny! (Self explanatory)", "", "aPenny", false));
        deck.addCard(new LootCard("2 Cents! (Self explanatory)", "", "twoCents", false));
        deck.addCard(new LootCard("3 Cents! (Self explanatory)", "", "threeCents", false));
        deck.addCard(new LootCard("4 Cents! (Self explanatory)", "", "fourCents", false));
        deck.addCard(new LootCard("Bomb (+1 Damage this turn)", "", "bomb", false));
        deck.addCard(new LootCard("Charged Penny (+1 Coin and Reset turn effects (can use loot, shop and fight again)", "", "chargedPenny", false));
        deck.addCard(new LootCard("Credit Card (+10 coins)", "", "creditCard", false));
        deck.addCard(new LootCard("Jera ( +1-3 Damage, +1-3 Health, +1-5 Coins)", "", "jera", false));
        deck.addCard(new LootCard("Soul Heart (+2 Health)", "", "soulHeart", false));
        deck.addCard(new LootCard("A Penny! (Self explanatory)", "", "aPenny", false));
        deck.addCard(new LootCard("2 Cents! (Self explanatory)", "", "twoCents", false));
        deck.addCard(new LootCard("3 Cents! (Self explanatory)", "", "threeCents", false));
        deck.addCard(new LootCard("4 Cents! (Self explanatory)", "", "fourCents", false));
        deck.addCard(new LootCard("Bomb (+1 Damage this turn)", "", "bomb", false));
        deck.addCard(new LootCard("Charged Penny (+1 Coin and Reset turn effects (can use loot, shop and fight again)", "", "chargedPenny", false));
        deck.addCard(new LootCard("Credit Card (+10 coins)", "", "creditCard", false));
        deck.addCard(new LootCard("Jera ( +1-3 Damage, +1-3 Health, +1-5 Coins)", "", "jera", false));
        deck.addCard(new LootCard("Soul Heart (+2 Health)", "", "soulHeart", false));


        Collections.shuffle(deck.cards);

        while (deck.cards.size() > (10*numCartas + 3*numCartas)) {
            deck.cards.remove(deck.cards.size() - 1);
        }

        return deck;

    }

    public void restockShopAndAddMonster(int shopSize, int montersInPlaySize) {
        // Check if the shop needs restocking
        if (shopItems.size() < shopSize) {
            // Restock the shop with new items
            for (int i = shopItems.size(); i < 2; i++) {
                TreasureCard item = treasureDeck.drawTreasure();
                shopItems.add(item);
            }
        }

        // Check if new monsters need to be added
        if (monstersInPlay.size() < 2) {
            // Add new monsters
            for (int i = monstersInPlay.size(); i < 2; i++) {
                MonsterCard monster = monsterDeck.drawMonster();
                monstersInPlay.add(monster);
            }
        }
    }

    public void monsterDefeated(Player player, String monsterDefeatString) {

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

    public void startGame() {
        // Add game setup logic here, like shuffling decks, dealing cards, etc.
        // Implement game rules as described in your game's rules.

        int currentPlayerIndex = 0;

        // For example, you can deal starting hands to players.

        for (Player player : players) {
            for (int i = 0; i < 2; i++) {
                Card card = lootDeck.draw();
                if (card != null) {
                    player.hand.add(card);
                }
            }
        }

        while (!isGameOver()) {
            Player currentPlayer = players.get(currentPlayerIndex);
            boolean endTurn = false;

            restockShopAndAddMonster(shopSize, montersInPlaySize);

            // Reset boolean flags at the start of the player's turn
            currentPlayer.usedLootCardThisTurn = false;
            currentPlayer.boughtItemThisTurn = false;
            currentPlayer.hadFoughtAnEnemie = false;

            currentPlayer.health = 2;
            currentPlayer.damage = 1;

            for (int i = 0; i < currentPlayer.hand.size(); i++) {
                Card card = currentPlayer.hand.get(i);
                if (card instanceof TreasureCard && ((TreasureCard) card).isActive && ((TreasureCard) card).Used) {
                    ((TreasureCard) card).Used = false;
                }
            }

            for (Player player : players) {
                player.boughtItemThisTurn = false;
            }

            if (currentPlayer.hand.size() < 10) {
                for (int i = 0; i < 1; i++) {
                    Card card = lootDeck.draw();
                    if (card != null) {
                        currentPlayer.hand.add(card);
                    }
                }
            }

            for (Card card : currentPlayer.hand) {

                if (card instanceof TreasureCard && !((TreasureCard) card).isActive) {

                    TreasureCard.applyPredefinedPassiveEffect(currentPlayer, card.name);

                }

            }

            do {

                // Display player's stats and options
                System.out.println("Player: " + currentPlayer.name);
                System.out.println("Coins: " + currentPlayer.coins);
                System.out.println("Health: " + currentPlayer.health);
                System.out.println("Damage: " + currentPlayer.damage);

                System.out.println("Hand: ");

                for (Card card : currentPlayer.hand) {

                    System.out.println(card.name);

                }

                System.out.println("Souls: " + currentPlayer.souls);

                // Offer options to the player
                System.out.println("Options:");
                System.out.println("1. Activate an active Treasure card");
                System.out.println("2. Use a loot card");
                System.out.println("3. Buy a Treasure card");
                System.out.println("4. Attack a monster");
                System.out.println("5. End Turn");

                // Read the player's choice

                Scanner sc = new Scanner(System.in);

                int choice = sc.nextInt();/* Read the player's choice from input */

                switch (choice) {
                    case 1:

                        // Activate an active Treasure card

                        System.out.println("Select an Active Treasure Card to activate:");

                        for (int i = 0; i < currentPlayer.hand.size(); i++) {
                            Card card = currentPlayer.hand.get(i);
                            if (card instanceof TreasureCard && ((TreasureCard) card).isActive
                                    && !((TreasureCard) card).Used) {
                                String cardName = card.name;
                                System.out.println((i + 1) + ". " + cardName);
                            }
                        }

                        System.out.println("Enter the number of the card to activate (or 0 to cancel):");
                        int cardIndexToActivate = sc.nextInt();

                        if (cardIndexToActivate > 0 && cardIndexToActivate <= currentPlayer.hand.size()) {
                            TreasureCard selectedTreasureCard = (TreasureCard) currentPlayer.hand
                                    .get(cardIndexToActivate - 1);
                            String cardName = selectedTreasureCard.name;

                            if (cardName.equals("The Chest: Gain a Soul (Destroys on use)") && !selectedTreasureCard.Used) {

                                currentPlayer.souls += 1;

                                currentPlayer.hand.remove(selectedTreasureCard);

                            } else if (cardName.equals("Pandora's Box: Random effect (+1$, +6$, +999 damage, +3 Loot, +9$, +1 Souls (Destroys on use))") && !selectedTreasureCard.Used) {

                                int RandomPandora = (int) (1 + Math.random() * 6);

                                if (RandomPandora == 1) {

                                    currentPlayer.coins += 1;

                                    System.out.println("Player got +1 coin");

                                } else if (RandomPandora == 2) {

                                    currentPlayer.coins += 6;

                                    System.out.println("Player got +6 coins");

                                } else if (RandomPandora == 3) {

                                    currentPlayer.damage = 999;

                                    System.out.println("Player got +999 damage");

                                } else if (RandomPandora == 5) {

                                    currentPlayer.coins += 9;

                                    System.out.println("Player got +9 coins");

                                } else if (RandomPandora == 6) {

                                    currentPlayer.souls += 1;

                                    System.out.println("Player got +1 souls, item destroyed");

                                    currentPlayer.hand.remove(selectedTreasureCard);

                                }

                                selectedTreasureCard.Used = true;

                            } else if (cardName.equals("The Battery: Reset turn effects (can use loot, shop and fight again)") && !selectedTreasureCard.Used) {

                                currentPlayer.boughtItemThisTurn = false;
                                currentPlayer.hadFoughtAnEnemie = false;
                                currentPlayer.usedLootCardThisTurn = false;

                                selectedTreasureCard.Used = true;

                            } else if (cardName.equals("Host Hat: +2 Health") && !selectedTreasureCard.Used) {

                                currentPlayer.health += 2;

                                selectedTreasureCard.Used = true;

                            } else if (cardName.equals("Mystery Sack: Random effect (+1 Loot, +4$)") && !selectedTreasureCard.Used) {

                                int RandomMysterySack = (int) (1 + Math.random() * 6);

                                if (RandomMysterySack <= 2) {

                                    Card card = lootDeck.draw();

                                    currentPlayer.hand.add(card);

                                    System.out.println("Player got +1 Loot");

                                } else {

                                    currentPlayer.coins += 4;

                                    System.out.println("Player got +4 coins");

                                }

                                selectedTreasureCard.Used = true;

                            } else if (cardName.equals("Book of Sin: Random effect (+1 $, +1 Loot, +1 Heart)") && !selectedTreasureCard.Used) {

                                int RandomBookOfSin = (int) (1 + Math.random() * 6);

                                if (RandomBookOfSin <= 2) {

                                    currentPlayer.coins += 1;

                                    System.out.println("Player got +1 coin");

                                } else if (RandomBookOfSin == 3 || RandomBookOfSin == 4) {

                                    Card card = lootDeck.draw();

                                    currentPlayer.hand.add(card);

                                    System.out.println("Player got +1 Loot");

                                } else {

                                    currentPlayer.health += 1;

                                    System.out.println("Player got +1 Health");

                                }

                                selectedTreasureCard.Used = true;

                            } else if (cardName.equals("Chaos Card: Change monster stats") && !selectedTreasureCard.Used) {

                                for (MonsterCard selectedMonster : monstersInPlay) {

                                    selectedMonster.health = (int) (1 + Math.random()*10);
                                    selectedMonster.damage =  (int) (1 + Math.random()*10);
                                    selectedMonster.evasion = (int) (1 + Math.random()*6);

                                }


                            } else if (cardName.equals("Battery Bum: Reactivate a used active card per 4$") && !selectedTreasureCard.Used) {

                                if (currentPlayer.coins >= 4) {

                                    for (int i = 0; i < currentPlayer.hand.size(); i++) {
                                        Card card = currentPlayer.hand.get(i);
                                        if (card instanceof TreasureCard && ((TreasureCard) card).isActive
                                                && ((TreasureCard) card).Used) {
                                            System.out.println((i + 1) + ". " + card.name);
                                        }
                                    }

                                    System.out.println("Enter the number of the card to reactivate (or 0 to cancel):");
                                    int cardIndexToReactivate = sc.nextInt();

                                    if (cardIndexToReactivate > 0
                                            && cardIndexToReactivate <= currentPlayer.hand.size()) {
                                        TreasureCard cardToReactivate = (TreasureCard) currentPlayer.hand
                                                .get(cardIndexToReactivate - 1);
                                        if (cardToReactivate.isActive && cardToReactivate.Used) {
                                            cardToReactivate.Used = false;
                                            currentPlayer.coins -= 4;
                                            System.out
                                                    .println("Reactivated " + cardToReactivate.name + " for 4 cents.");
                                        } else {
                                            System.out
                                                    .println(
                                                            "Invalid card selection. Make sure it's a used active card.");
                                        }
                                    } else if (cardIndexToReactivate != 0) {
                                        System.out.println("Invalid card selection.");

                                    }

                                } else {

                                    System.out.println("You don't have enough coins for Bum.");

                                }

                            } else if (cardName.equals("Dark Bum: Random effect (+3$, +1 Loot, -1 Health)") && !selectedTreasureCard.Used) {

                                int RandomDarkBum = (int) (1 + Math.random() * 6);

                                if (RandomDarkBum <= 2) {

                                    currentPlayer.coins += 3;

                                    System.out.println("Player got +3 coins");

                                } else if (RandomDarkBum == 3 || RandomDarkBum == 4) {

                                    Card card = lootDeck.draw();

                                    currentPlayer.hand.add(card);

                                    System.out.println("Player got +1 loot");

                                } else {

                                    currentPlayer.health -= 1;

                                    System.out.println("Player got hurt -1 health");

                                    if (currentPlayer.health <= 0){

                                        endTurn = true;
                                    }

                                }

                                selectedTreasureCard.Used = true;

                            } else if (cardName.equals("Plan C: Defeat all monsters and u die with them (Destroys on use)") && !selectedTreasureCard.Used) {

                                for (MonsterCard selectedMonster : monstersInPlay) {

                                    monstersInPlay.remove(selectedMonster);

                                    monsterDefeated(currentPlayer, selectedMonster.defeat);

                                    System.out.println("Plan C defeated: " + selectedMonster.name);

                                }

                                if (currentPlayer.coins > 0) {

                                    currentPlayer.coins -= 1;
                                }

                                boolean lootCardRemoved = false; // Flag to track if a LootCard has been
                                // removed

                                for (Card card : currentPlayer.hand) {
                                    if (card instanceof LootCard) {
                                        currentPlayer.hand.remove(card);
                                        lootCardRemoved = true;
                                        break; // Remove only one LootCard
                                    }
                                }

                                if (!lootCardRemoved) {

                                    System.out.println("No LootCards to remove from the player's hand.");

                                }

                                endTurn = true;

                                currentPlayer.hand.remove(selectedTreasureCard);

                            }

                        }

                        break;

                    case 2:
                        // Use a loot card
                        if (!currentPlayer.usedLootCardThisTurn) {
                            System.out.println("Select a Loot Card to activate:");

                            for (int i = 0; i < currentPlayer.hand.size(); i++) {
                                Card card = currentPlayer.hand.get(i);
                                if (card instanceof LootCard) {
                                    System.out.println(i + 1 + ". " + card.name);
                                }
                            }

                            System.out.println("Enter the number of the card to activate (or 0 to cancel):");
                            cardIndexToActivate = sc.nextInt();

                            if (cardIndexToActivate > 0 && cardIndexToActivate <= currentPlayer.hand.size()) {
                                LootCard selectedLootCard = (LootCard) currentPlayer.hand.get(cardIndexToActivate - 1);
                                selectedLootCard.play(currentPlayer, cardIndexToActivate - 1);
                            } else if (cardIndexToActivate != 0) {
                                System.out.println("Invalid card selection.");
                            }
                        } else {
                            System.out.println("You can only use one Loot Card per turn.");
                        }
                        break;

                    case 3:

                        // Buy a Treasure card

                        if (!players.get(currentPlayerIndex).boughtItemThisTurn) {
                            if (players.get(currentPlayerIndex).coins >= 10) {
                                if (!shopItems.isEmpty()) {
                                    System.out.println("Shop Items:");
                                    for (int i = 0; i < shopItems.size(); i++) {
                                        System.out.println(i + 1 + ". " + shopItems.get(i).name);
                                    }
                                    System.out.println("Enter the number of the item you want to buy: ");

                                    int itemNumber = sc.nextInt();
                                    if (itemNumber > 0 && itemNumber <= shopItems.size()) {
                                        TreasureCard itemToBuy = shopItems.get(itemNumber - 1);
                                        players.get(currentPlayerIndex).coins -= 10;
                                        players.get(currentPlayerIndex).hand.add(itemToBuy);
                                        shopItems.remove(itemToBuy);
                                        players.get(currentPlayerIndex).boughtItemThisTurn = true;
                                        System.out.println(
                                                players.get(currentPlayerIndex).name + " has bought " + itemToBuy.name);
                                    } else {
                                        System.out.println("Invalid item number.");
                                    }
                                } else {
                                    System.out.println("Shop is empty.");
                                }
                            } else {
                                System.out.println("Not enough coins to buy an item.");
                            }
                        } else {
                            System.out.println("You can only buy one item per turn.");
                        }
                        break;

                    case 4:
                        // Attack a monster
                        if (!monstersInPlay.isEmpty()) {
                            if (currentPlayer.hadFoughtAnEnemie) {
                                System.out.println(
                                        "You've already fought an enemy this turn. You cannot attack another enemy.");
                            } else {
                                // Display available monsters for the player to choose from
                                System.out.println("Available monsters to attack:");

                                for (int i = 0; i < monstersInPlay.size(); i++) {
                                    MonsterCard monster = monstersInPlay.get(i);
                                    System.out.println(i + 1 + ". " + monster.name + " - Health: " + monster.health
                                            + " - Evasion: " + monster.evasion + " - Damage: " + monster.damage);
                                }

                                System.out.println(
                                        "Enter the number of the monster you want to attack (or 0 to cancel): ");
                                int monsterIndexToAttack = sc.nextInt();

                                if (monsterIndexToAttack > 0 && monsterIndexToAttack <= monstersInPlay.size()) {
                                    MonsterCard selectedMonster = monstersInPlay.get(monsterIndexToAttack - 1);
                                    int damage = currentPlayer.damage;

                                    while (selectedMonster.health > 0 && currentPlayer.health > 0) {
                                        // Generate a random number between 0 and 5 (inclusive)
                                        int randomNumber = (int) (Math.random() * 6); // Random number between 0 and 5
                                        // (inclusive)

                                        if (randomNumber >= selectedMonster.evasion) {
                                            // Attack successful
                                            selectedMonster.health -= damage;
                                            System.out
                                                    .println("Dealt " + damage + " damage to " + selectedMonster.name);
                                        } else {
                                            // Attack missed

                                            int dodge = (int) (1 + Math.random() * 4); // Generate a random number between 0
                                            // and 3

                                            boolean playerHasDryBaby = false; // Initialize the flag as false

                                            for (Card treasureCard : currentPlayer.hand) {
                                                if (treasureCard.name.equals("Dry Baby: Blocks enemy attacks 25% chance")) {
                                                    playerHasDryBaby = true;
                                                    break; // You can exit the loop early since you've found "Dry Baby"
                                                }
                                            }

                                            // Check if the player has "Dry Baby"

                                            if (playerHasDryBaby && dodge == 2) {
                                                System.out.println("Your attack missed but dodged enemie attack from: "
                                                        + selectedMonster.name);
                                            } else {
                                                System.out.println("Your attack missed " + selectedMonster.name);

                                                // Handle player's health for missed attack
                                                int monsterDamage = selectedMonster.damage;
                                                currentPlayer.health -= monsterDamage;
                                            }
                                        }

                                        if (selectedMonster.health <= 0) {
                                            // Monster defeated
                                            System.out.println("You defeated " + selectedMonster.name);
                                            monstersInPlay.remove(selectedMonster);

                                            // Handle loot drop using monsterDefeated method
                                            monsterDefeated(currentPlayer, selectedMonster.defeat);
                                            break; // Exit the loop after defeating the monster
                                        } else if (currentPlayer.health <= 0) {
                                            // Player is defeated
                                            System.out.println(currentPlayer.name + " has been defeated!");

                                            if (currentPlayer.coins > 0) {
                                                currentPlayer.coins -= 1;
                                            }

                                            boolean lootCardRemoved = false; // Flag to track if a LootCard has been
                                            // removed

                                            for (Card card : currentPlayer.hand) {
                                                if (card instanceof LootCard) {
                                                    currentPlayer.hand.remove(card);
                                                    lootCardRemoved = true;
                                                    break; // Remove only one LootCard
                                                }
                                            }

                                            if (!lootCardRemoved) {
                                                System.out.println("No LootCards to remove from the player's hand.");
                                            }

                                            endTurn = true;

                                            break;
                                        }
                                    }

                                    // Set the flag to indicate that the player has fought an enemy this turn
                                    currentPlayer.hadFoughtAnEnemie = true;
                                }
                            }
                        } else {
                            System.out.println("There are no monsters to attack.");
                        }
                        break;

                    case 5:
                        // End the turn
                        endTurn = true;

                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } while (!endTurn);

            // Update the game state (e.g., resolve monster attacks, check for win/loss
            // conditions)
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }

        for (Player player : players) {

            if (player.souls >= 4) {

                System.out.println("Game over. " + player.name + " has collected 4 souls!");

            }
        }

    }

    // After the loop, you can check for game-over conditions or win conditions

    public boolean isGameOver() {
        for (Player player : players) {
            if (player.souls >= 4) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        // Create a new game with a specified number of players.

        Scanner sc = new Scanner(System.in);

        System.out.println("Hi, welcome to TBOI FOUR SOULS, Simple Java Edition");
        System.out.println("Do you wanna see the rules?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        int Rules = sc.nextInt();

        if (Rules == 1) {

            System.out.println("Welcome to The Binding of Isaac: Four Souls!");
            System.out.println("Objective: Be the first player to collect four Soul Hearts.");

            System.out.println("\nSetup:");
            System.out.println("1. The game is played with 2-4 players.");
            System.out.println(
                    "2. Each player chooses a character card and starts with 1 coin, 1 loot card, and 3 loot cards in their hand.");
            System.out.println(
                    "3. Create a shop deck and a treasure deck with cards corresponding to the number of players.");
            System.out.println("4. Create a monster deck by selecting monster cards based on the players' choice.");
            System.out.println("5. The game board includes spaces for loot, shop, and monster cards.");

            System.out.println("\nGameplay:");
            System.out.println("1. Players take turns in clockwise order.");
            System.out.println("2. On your turn, you can perform various actions:");
            System.out.println("   - Activate an active Treasure card.");
            System.out.println("   - Use a loot card.");
            System.out.println("   - Buy a Treasure card from the shop.");
            System.out.println("   - Attack a monster.");
            System.out.println("   - End your turn.");

            System.out.println("\nActive Treasure Cards:");
            System.out.println("- Active Treasure cards can be used on your turn to activate their special effects.");
            System.out.println("- Some active cards have a cost, like coins or health.");

            System.out.println("\nLoot Cards:");
            System.out.println(
                    "- Loot cards provide various effects, such as gaining coins, dealing damage, or healing.");

            System.out.println("\nShop:");
            System.out.println("- You can spend coins to buy Treasure cards from the shop.");
            System.out.println("- The cost of each item in the shop is 10 coins.");

            System.out.println("\nMonsters:");
            System.out.println(
                    "- Monsters are encountered during your turn. You can choose to attack a monster if there are any in play.");
            System.out.println("- Combat involves rolling a die to determine whether your attack is successful.");
            System.out.println("- Defeating monsters may reward you with Soul Hearts.");

            System.out.println("\nEnd of Turn:");
            System.out.println("- Once you've taken your actions, you can choose to end your turn.");

            System.out.println("\nWinning:");
            System.out.println("- The first player to collect four Soul Hearts wins the game.");

            System.out.println("\nSpecial Cards:");
            System.out.println(
                    "- The game includes special cards like \"The Chest,\" \"Pandora's Box,\" and more, each with unique effects.");

            System.out.println("\nGame Over:");
            System.out.println(
                    "- The game ends when a player collects four Soul Hearts or meets another victory condition, depending on the rules you've chosen.");

            System.out.println("\nAdditional Rules:");
            System.out.println("- You can make variations by adding expansion packs or house rules.");

            System.out.println(
                    "\nRemember to refer to the game's rulebook for specific card interactions and any additional rules or clarifications. Have fun playing The Binding of Isaac: Four Souls!");

        } else {

            System.out.println(" Alright! Good Luck to everyone.");
        }

        System.out.println("How many players will be playing?");
        System.out.println("2 - 4");
        System.out.println("(We recommended for Java Simple Edition 2 players)");

        int players = sc.nextInt();

        if (players <= 1 || players >= 5) {

            System.out.println("The game doesn't supports that many players");

        }else{

            FourSoulsGame game = new FourSoulsGame(players);

            // Start the game.

            game.startGame();

        }

    }

}
