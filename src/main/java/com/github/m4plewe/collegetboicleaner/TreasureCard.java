package com.github.m4plewe.collegetboicleaner;

import java.util.List;
import java.util.Scanner;

public class TreasureCard extends Card {
    public boolean isActive;
    public boolean Used;
    public String id;
    public TreasureCard(String name, boolean isActive, String id) {
        super(name, "Treasure");
        this.isActive = isActive;

    }

    public static void applyPredefinedPassiveEffect(Player currentPlayer, String name) {


        switch (name) {
            case "Synthoil":
                currentPlayer.damage += 1;
                break;

            case "Meat":
                currentPlayer.health += 1;
                break;

            case "GreedsGullet":
                currentPlayer.coins += 3;
                break;

            case "EmptyVessel":
                if (currentPlayer.hand.size() >= 5) {
                    currentPlayer.damage += 1;
                    currentPlayer.coins += 1;
                } else {
                    currentPlayer.damage += 2;
                    currentPlayer.coins += 2;
                }
                break;

            case "Sausage":
                currentPlayer.health += 1;
                currentPlayer.damage += 1;
                break;

            case "Sacred Heart":
                currentPlayer.health += 2;
                currentPlayer.damage += 1;
                break;

            case "Dinner":
                currentPlayer.health += 1;
                break;

            case "Lard":
                currentPlayer.health += 2;
                break;
        }
    }

    public void playTreasure(Player currentPlayer, int cardIndex, Deck lootDeck, Deck treasureDeck, MonsterCard selectedMonster) {
        // Implement the play logic for Loot cards

        if (cardIndex >= 0 && cardIndex < currentPlayer.hand.size()) {
            Card selectedTreasureCard = currentPlayer.hand.get(cardIndex);

            if (selectedTreasureCard instanceof TreasureCard treasureCard && !treasureCard.Used) {
                switch (treasureCard.name) {
                    case "TheChest":
                        currentPlayer.souls += 1;
                        break;

                    case "PandorasBox":
                        int RandomPandora = (int) (1 + Math.random() * 6);
                        switch (RandomPandora) {
                            case 1:
                                currentPlayer.coins += 1;
                                System.out.println("Player got +1 coin");
                                break;
                            case 2:
                                currentPlayer.coins += 6;
                                System.out.println("Player got +6 coins");
                                break;
                            case 3:
                                currentPlayer.damage = 999;
                                System.out.println("Player got +999 damage");
                                break;
                            case 5:
                                currentPlayer.coins += 9;
                                System.out.println("Player got +9 coins");
                                break;
                            case 6:
                                currentPlayer.souls += 1;
                                System.out.println("Player got +1 souls, item destroyed");
                                currentPlayer.hand.remove(selectedTreasureCard);
                                break;
                        }
                        treasureCard.Used = true;
                        break;

                    case "TheBattery":
                        currentPlayer.boughtItemThisTurn = false;
                        currentPlayer.hadFoughtAnEnemie = false;
                        currentPlayer.usedLootCardThisTurn = false;
                        treasureCard.Used = true;
                        break;

                    case "HostHat":
                        currentPlayer.health += 2;
                        treasureCard.Used = true;
                        break;

                    case "MysterySack":
                        int RandomMysterySack = (int) (1 + Math.random() * 6);
                        if (RandomMysterySack <= 2) {
                            Card card = lootDeck.draw();
                            currentPlayer.hand.add(card);
                            System.out.println("Player got +1 Loot");
                        } else {
                            currentPlayer.coins += 4;
                            System.out.println("Player got +4 coins");
                        }
                        treasureCard.Used = true;
                        break;

                    case "BookOfSin":
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
                        treasureCard.Used = true;
                        break;

                    case "ChaosCard":
                        selectedMonster.health = (int) (1 + Math.random() * 10);
                        selectedMonster.damage = (int) (1 + Math.random() * 10);
                        selectedMonster.evasion = (int) (1 + Math.random() * 6);
                        break;

                    case "BatteryBum":
                        if (currentPlayer.coins >= 4) {

                            for (int i = 0; i < currentPlayer.hand.size(); i++) {
                                Card card = currentPlayer.hand.get(i);
                                if (card instanceof TreasureCard && ((TreasureCard) card).isActive
                                        && ((TreasureCard) card).Used) {
                                    System.out.println((i + 1) + ". " + card.name);
                                }
                            }
                            System.out.println("Enter the number of the card to reactivate (or 0 to cancel):");
                            Scanner sc = new Scanner(System.in);
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
                        break;

                    case "DarkBum":
                        int RandomDarkBum = (int) (1 + Math.random() * 6);
                        if (RandomDarkBum <= 2) {
                            currentPlayer.coins += 3;
                            System.out.println("Player got +3 coins");
                        } else if (RandomDarkBum == 3 || RandomDarkBum == 4) {
                            Card card = lootDeck.draw();
                            currentPlayer.hand.add(card);
                            System.out.println("Player got +1 loot");
                        } else {
                            System.out.println("Player got nothing");
                        }
                        treasureCard.Used = true;
                        break;

                    case "PlanC":
                        selectedMonster.monsterDefeated(currentPlayer, selectedMonster.defeat, lootDeck, treasureDeck);
                        System.out.println("Plan C defeated: " + selectedMonster.name);
                        currentPlayer.hand.remove(treasureCard);
                        break;
                }
            }
        }
    }

}