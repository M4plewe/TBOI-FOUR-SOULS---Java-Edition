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
        this.id = id;

    }

    public static void applyPredefinedPassiveEffect(Player currentPlayer, String id) {


        switch (id) {
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
            case "Euthanasia":
                int rng = (int) (1+Math.random()*20);

                if(rng == 1){
                    currentPlayer.damage = 999;
                }
                break;

            case "Polyphemus":
                currentPlayer.damage += 2;
                break;
            case "Abaddon":

                currentPlayer.damage += 3;
                break;

            case "ThreeDollarBill":

                rng = (int) (1+Math.random()*2);

                switch (rng) {
                    case 4, 5:
                        currentPlayer.health += 1;
                    case 6:
                        currentPlayer.damage += 2;
                }
                break;
            case "Brimstone":
                currentPlayer.damage += 1;

                break;

        }
    }

    public void playTreasure(Player currentPlayer, TreasureCard treasureCard, Deck lootDeck, Deck treasureDeck, MonsterCard selectedMonster) {
        // Implement the play logic for Loot cards


                switch (treasureCard.id) {
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
                                currentPlayer.hand.remove(treasureCard);
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
                    case "ForgetMeNow":
                        System.out.println(currentPlayer+" just fucked up everyone game");
                        System.out.println("eitherway, how many ppl will continue playing?");
                        currentPlayer.hand.remove(treasureCard);
                        Scanner sc = new Scanner(System.in);
                        int players = sc.nextInt();
                        FourSoulsGame newgame = new FourSoulsGame(players);
                        newgame.startGame();
                        break;

                    case "RKey" :

                        currentPlayer.hand.remove(treasureCard);
                        for (int i = 0; i < i+2 ; i++) {

                            System.out.println("FUCK YOU ALL");
                        }
                        break;

                    case "AQuarter":
                        currentPlayer.coins += 25;
                        currentPlayer.hand.remove(treasureCard);
                    break;

                }
            }
        }