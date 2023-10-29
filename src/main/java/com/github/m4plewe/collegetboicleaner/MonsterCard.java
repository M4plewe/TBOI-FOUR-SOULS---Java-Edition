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

}
