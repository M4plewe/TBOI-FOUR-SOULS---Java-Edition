package com.github.m4plewe.collegetboicleaner;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    public List<Card> cards;
    public Deck() {
        this.cards = new ArrayList<>();
    }
    public void addCard(Card card) {
        cards.add(card);
    }

    public Card draw() {
        if (!cards.isEmpty()) {
            return cards.remove(cards.size() - 1);
        }
        return null;
    }

    public TreasureCard drawTreasure() {
        if (!cards.isEmpty()) {
            for (int i = cards.size() - 1; i >= 0; i--) {
                if (cards.get(i) instanceof TreasureCard) {
                    return (TreasureCard) cards.remove(i);
                }
            }
        }
        return null; // Return null if no treasure cards are available.
    }

    public MonsterCard drawMonster() {
        if (!cards.isEmpty()) {
            for (int i = cards.size() - 1; i >= 0; i--) {
                if (cards.get(i) instanceof MonsterCard) {
                    return (MonsterCard) cards.remove(i);
                }
            }
        }
        return null; // Return null if no monster cards are available.
    }

}
