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

        deck.addCard(new MonsterCard("Dip", 1, 4, 1, "DipDefeat"));
        deck.addCard(new MonsterCard("Squirt", 2, 3, 1, "SquirtDefeat"));
        deck.addCard(new MonsterCard("Fly", 1, 2, 1, "FlyDefeat"));
        deck.addCard(new MonsterCard("Ring of Flies", 3, 3, 1, "RingOfFliesDefeat"));
        deck.addCard(new MonsterCard("Swarm of Flies", 5, 2, 1, "SwarmOfFliesDefeat"));
        deck.addCard(new MonsterCard("Pooter", 2, 3, 1, "PooterDefeat"));
        deck.addCard(new MonsterCard("Spider", 1, 4, 1, "SpiderDefeat"));
        deck.addCard(new MonsterCard("Big Spider", 3, 4, 1, "BigSpiderDefeat"));
        deck.addCard(new MonsterCard("Trite", 1, 5, 1, "TriteDefeat"));
        deck.addCard(new MonsterCard("Clotty", 2, 3, 1, "ClottyDefeat"));
        deck.addCard(new MonsterCard("Mulligan", 1, 3, 1, "MulliganDefeat"));
        deck.addCard(new MonsterCard("Mulliboom", 1, 2, 4, "MulliboomDefeat"));
        deck.addCard(new MonsterCard("Hopper", 2, 3, 1, "HopperDefeat"));
        deck.addCard(new MonsterCard("Horf", 1, 4, 1, "HorfDefeat"));
        deck.addCard(new MonsterCard("Psy Horf", 1, 5, 1, "PsyHorfDefeat"));
        deck.addCard(new MonsterCard("Fatty", 4, 2, 1, "FattyDefeat"));
        deck.addCard(new MonsterCard("Conjoined Fatty", 4, 3, 2, "ConjoinedFattyDefeat"));
        deck.addCard(new MonsterCard("Pale Fatty", 4, 3, 1, "PaleFattyDefeat"));
        deck.addCard(new MonsterCard("Red Host", 2, 3, 2, "RedHostDefeat"));
        deck.addCard(new MonsterCard("Fat Bat", 3, 5, 1, "FatBatDefeat"));
        deck.addCard(new MonsterCard("Hanger", 2, 4, 2, "HangerDefeat"));
        deck.addCard(new MonsterCard("Keeper Head", 2, 4, 1, "KeeperHeadDefeat"));
        deck.addCard(new MonsterCard("Boom Fly", 1, 4, 1, "BoomFlyDefeat"));
        deck.addCard(new MonsterCard("Leaper", 2, 4, 1, "LeaperDefeat"));
        deck.addCard(new MonsterCard("Portal", 2, 4, 1, "PortalDefeat"));
        deck.addCard(new MonsterCard("Greedling", 2, 5, 1, "GreedlingDefeat"));
        deck.addCard(new MonsterCard("Stoney", 3, 0, 0, "StoneyDefeat"));
        deck.addCard(new MonsterCard("Black Bony", 3, 4, 1, "BlackBonyDefeat"));
        deck.addCard(new MonsterCard("Dinga", 3, 3, 1, "DingaDefeat"));
        deck.addCard(new MonsterCard("Wizoob", 3, 5, 1, "WizoobDefeat"));
        deck.addCard(new MonsterCard("Dank Globin", 2, 4, 2, "DankGlobinDefeat"));
        deck.addCard(new MonsterCard("Rage Creep", 1, 5, 1, "RageCreepDefeat"));
        deck.addCard(new MonsterCard("Mom's Hand", 2, 4, 1, "MomsHandDefeat"));
        deck.addCard(new MonsterCard("Mom's Dead Hand", 2, 5, 1, "MomsDeadHandDefeat"));
        deck.addCard(new MonsterCard("Mom's Eye", 1, 4, 2, "MomsEyeDefeat"));
        deck.addCard(new MonsterCard("Leech", 1, 4, 2, "LeechDefeat"));
        deck.addCard(new MonsterCard("Cod Worm", 2, 5, 0, "CodWormDefeat"));
        deck.addCard(new MonsterCard("Dople", 2, 4, 2, "DopleDefeat"));
        deck.addCard(new MonsterCard("Evil Twin", 3, 5, 2, "EvilTwinDefeat"));
        deck.addCard(new MonsterCard("Holy Dip", 1, 4, 1, "HolyDipDefeat"));
        deck.addCard(new MonsterCard("Holy Squirt", 2, 3, 1, "HolySquirtDefeat"));
        deck.addCard(new MonsterCard("Holy Dinga", 3, 3, 1, "HolyDingaDefeat"));
        deck.addCard(new MonsterCard("Holy Mom's Eye", 1, 4, 2, "HolyMomsEyeDefeat"));
        deck.addCard(new MonsterCard("Holy Keeper Head", 2, 4, 1, "HolyKeeperHeadDefeat"));
        deck.addCard(new MonsterCard("Cursed Keeper Head", 2, 4, 1, "CursedKeeperHeadDefeat"));
        deck.addCard(new MonsterCard("Cursed Horf", 1, 4, 1, "CursedHorfDefeat"));
        deck.addCard(new MonsterCard("Cursed Psy Horf", 1, 5, 1, "CursedPsyHorfDefeat"));
        deck.addCard(new MonsterCard("Cursed Fatty", 4, 2, 1, "CursedFattyDefeat"));
        deck.addCard(new MonsterCard("Cursed Mom's Hand", 2, 4, 1, "CursedMomsHandDefeat"));
        deck.addCard(new MonsterCard("Cursed Gaper", 2, 4, 1, "CursedGaperDefeat"));
        deck.addCard(new MonsterCard("Monstro", 4, 4, 1, "MonstroDefeat"));
        deck.addCard(new MonsterCard("Little Horn", 2, 6, 1, "LittleHornDefeat"));
        deck.addCard(new MonsterCard("Larry Jr.", 4, 3, 1, "LarryJrDefeat"));
        deck.addCard(new MonsterCard("The Duke of Flies", 4, 3, 1, "DukeOfFliesDefeat"));
        deck.addCard(new MonsterCard("Pin", 2, 4, 1, "PinDefeat"));
        deck.addCard(new MonsterCard("Gemini", 3, 4, 1, "GeminiDefeat"));
        deck.addCard(new MonsterCard("Rag Man", 2, 3, 2, "RagManDefeat"));
        deck.addCard(new MonsterCard("The Haunt", 3, 4, 1, "TheHauntDefeat"));
        deck.addCard(new MonsterCard("Gurdy Jr.", 2, 5, 1, "GurdyJrDefeat"));
        deck.addCard(new MonsterCard("Gurdy", 5, 4, 1, "GurdyDefeat"));
        deck.addCard(new MonsterCard("Mega Fatty", 3, 3, 1, "MegaFattyDefeat"));
        deck.addCard(new MonsterCard("Chub", 4, 3, 1, "ChubDefeat"));
        deck.addCard(new MonsterCard("Carrion Queen", 3, 4, 1, "CarrionQueenDefeat"));
        deck.addCard(new MonsterCard("Peep", 3, 4, 1, "PeepDefeat"));
        deck.addCard(new MonsterCard("The Bloat", 4, 4, 2, "TheBloatDefeat"));
        deck.addCard(new MonsterCard("Dark One", 3, 4, 1, "DarkOneDefeat"));
        deck.addCard(new MonsterCard("Mask of Infamy", 4, 4, 1, "MaskOfInfamyDefeat"));
        deck.addCard(new MonsterCard("Daddy Long Legs (monster)", 4, 4, 1, "DaddyLongLegsDefeat"));
        deck.addCard(new MonsterCard("Scolex", 3, 5, 1, "ScolexDefeat"));
        deck.addCard(new MonsterCard("Famine", 2, 3, 1, "FamineDefeat"));
        deck.addCard(new MonsterCard("Pestilence", 4, 4, 1, "PestilenceDefeat"));
        deck.addCard(new MonsterCard("War", 3, 3, 1, "WarDefeat"));
        deck.addCard(new MonsterCard("Death", 3, 4, 2, "DeathDefeat"));
        deck.addCard(new MonsterCard("Conquest", 2, 3, 1, "ConquestDefeat"));
        deck.addCard(new MonsterCard("Envy", 2, 5, 1, "EnvyDefeat"));
        deck.addCard(new MonsterCard("Greed", 3, 4, 1, "GreedDefeat"));
        deck.addCard(new MonsterCard("Wrath", 3, 3, 1, "WrathDefeat"));
        deck.addCard(new MonsterCard("Sloth", 3, 4, 1, "SlothDefeat"));
        deck.addCard(new MonsterCard("Pride", 2, 4, 1, "PrideDefeat"));
        deck.addCard(new MonsterCard("Gluttony", 4, 3, 1, "GluttonyDefeat"));
        deck.addCard(new MonsterCard("Lust", 2, 4, 1, "LustDefeat"));
        deck.addCard(new MonsterCard("Mom!", 5, 4, 2, "MomDefeat"));
        deck.addCard(new MonsterCard("Satan!", 6, 4, 2, "SatanDefeat"));
        deck.addCard(new MonsterCard("The Lamb", 6, 3, 6, "TheLambDefeat"));
        deck.addCard(new MonsterCard("Delirium", 5, 4, 3, "DeliriumDefeat"));

        Collections.shuffle(deck.cards);
        return deck;

    }

    private Deck initializeTreasureDeck() {
        Deck deck = new Deck();

        // Treasure Cards
        deck.addCard(new TreasureCard("Sausage: +1 Health +1 Damage", false, "Sausage"));
        deck.addCard(new TreasureCard("Brimstone: +1 Damage", false, "Brimstone"));
        deck.addCard(new TreasureCard("Sacred Heart: +2 Health and +1 Damage", false,"SacredHeart"));
        deck.addCard(new TreasureCard("Dinner: +1 Health", false, "Dinner"));
        deck.addCard(new TreasureCard("Lard: +2 Health", false, "Lard"));
        deck.addCard(new TreasureCard("Dry Baby: Blocks enemy attacks 25% chance", false, "DryBaby"));
        deck.addCard(new TreasureCard("Empty Vessel: +2 damage and +2 health if less than 3 Cards on Hand else +1 Damage and +1 Coins per turn", false, "EmptyVassel"));
        deck.addCard(new TreasureCard("Greed's Gullet: +3 coins each turn", false, "GreedsGullet"));
        deck.addCard(new TreasureCard("Meat!: +1 Health", false, "Meat"));
        deck.addCard(new TreasureCard("Synthoil: +1 Damage", false, "Synthoil"));
        deck.addCard(new TreasureCard("Euthanasia: 5% chance get 999 damage", false, "Euthanasia"));
        deck.addCard(new TreasureCard("Polyphemus: +2 Damage", false, "Polyphemus"));
        deck.addCard(new TreasureCard("Abaddon: +3 damage", false, "Abaddon"));
        deck.addCard(new TreasureCard("Three Dollar Bill: (nothing, +1 health, +2 damage)", false, ""));


// Active Treasure Cards

        deck.addCard(new TreasureCard("The Chest: Gain a Soul (Destroys on use)", true,"TheChest"));
        deck.addCard(new TreasureCard("Pandora's Box: Random effect (+1$, +6$, +999 damage, +3 Loot, +9$, +1 Souls (Destroys on use))", true, "PandorasBox"));
        deck.addCard(new TreasureCard("The Battery: Reset turn effects (can use loot, shop and fight again)", true,"TheBattery"));
        deck.addCard(new TreasureCard("Host Hat: +2 Health", true, "HostHat"));
        deck.addCard(new TreasureCard("Mystery Sack: Random effect (+1 Loot, +4$)", true, "MysterySack"));
        deck.addCard(new TreasureCard("Book of Sin: Random effect (+1 $, +1 Loot, +1 Heart)", true, "BookOfSin"));
        deck.addCard(new TreasureCard("Chaos Card: Change monster stats", true, "ChaosCard"));
        deck.addCard(new TreasureCard("Battery Bum: Reactivate a used active card per 4$", true, "BatteryBum"));
        deck.addCard(new TreasureCard("Dark Bum: Random effect (+3$, +1 Loot, -1 Health)", true, "DarkBum"));
        deck.addCard(new TreasureCard("Plan C: Defeat all monsters and u die with them (Destroys on use)", true, "PlanC"));
        deck.addCard(new TreasureCard("Forget Me Now: Restart the whole game", false, "ForgetMeNow"));
        deck.addCard(new TreasureCard("R Key: nothing better than rage quit (crash the game)", false, "RKey"));
        deck.addCard(new TreasureCard("A Quarter: we'all love inflation", false, ""));

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
        deck.addCard(new LootCard("Credit Card (+1-10 coins)", "", "creditCard", false));
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


                            for (MonsterCard selectedMonster : monstersInPlay) {

                                selectedTreasureCard.playTreasure(currentPlayer,cardIndexToActivate - 1, lootDeck, treasureDeck, selectedMonster);

                                break;
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
                                            selectedMonster.monsterDefeated(currentPlayer, selectedMonster.defeat, lootDeck, treasureDeck);
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
