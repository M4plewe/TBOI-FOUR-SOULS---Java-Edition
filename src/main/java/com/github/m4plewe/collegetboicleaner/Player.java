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
        this.coins = 3000; // Starting coins
        this.health = 2;
        this.damage = 1;
        this.hand = new ArrayList<>();
        this.souls = 0;
        this.boughtItemThisTurn = false;
        this.usedLootCardThisTurn = false;
        this.hadFoughtAnEnemie = false;
    }

}
