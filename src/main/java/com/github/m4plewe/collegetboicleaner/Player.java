package com.github.m4plewe.collegetboicleaner;

import java.util.ArrayList;
import java.util.List;

public class Player {

    public String name;
    public int coins;
    public int health;
    public int damage;
    public List<Card> hand;
    public int souls;
    public boolean boughtItemThisTurn;
    public boolean usedLootCardThisTurn;
    public boolean hadFoughtAnEnemie;

    public Player(String name) {
        this.name = name;
        this.coins = 3; // Starting coins
        this.health = 2;
        this.damage = 1;
        this.hand = new ArrayList<>();
        this.souls = 0;
        this.boughtItemThisTurn = false;
        this.usedLootCardThisTurn = false;
        this.hadFoughtAnEnemie = false;
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
