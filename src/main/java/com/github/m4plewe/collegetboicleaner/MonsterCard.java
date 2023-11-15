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
            case "DipDefeat" -> {
                player.coins += 1;
                //  Agregar recompensas específicas para Dip
            }
            case "SquirtDefeat" -> {
                //  Agregar recompensas específicas para Squirt
                Card card = lootDeck.draw();
                   if (card != null) {
                       player.hand.add(card);
                   }
            }
            case "FlyDefeat" -> {
                player.coins += 1;
                //  Agregar recompensas específicas para Fly
            }
            case "RingOfFliesDefeat" -> {
                //  Agregar recompensas específicas para Ring of Flies
                player.coins += 3;
            }
            case "SwarmOfFliesDefeat" -> {
                //  Agregar recompensas específicas para Swarm of Flies
                player.coins += 5;
            }
            case "PooterDefeat" -> {
                //  Agregar recompensas específicas para Pooter
                Card card = lootDeck.draw();
                    if (card != null) {
                        player.hand.add(card);
                    }
            }
            case "SpiderDefeat" -> {
                //  Agregar recompensas específicas para Spider
                Card card = lootDeck.draw();
                if (card != null) {
                    player.hand.add(card);
                }
            }
            case "BigSpiderDefeat" -> {
                //  Agregar recompensas específicas para Big Spider
                Card card = lootDeck.draw();
                if (card != null) {
                    player.hand.add(card);
                }
                player.hadFoughtAnEnemie = false;
                System.out.println("The current player can attack again");
            }
            case "TriteDefeat" -> {
                //  Agregar recompensas específicas para Trite
                for (int i = 0; i < 2; i++) {
                    Card card = lootDeck.draw();
                    if (card != null) {
                        player.hand.add(card);
                    }
                }
            }
            case "ClottyDefeat" -> {
                //  Agregar recompensas específicas para Clotty
                player.coins += 4;
            }
            case "MulliganDefeat" -> {
                //  Agregar recompensas específicas para Mulligan
                player.coins += 3;
            }
            case "MulliboomDefeat" -> {
                //  Agregar recompensas específicas para Mulliboom
                player.coins += 6;
            }
            case "HopperDefeat" -> {
                player.coins += 3;
                //  Agregar recompensas específicas para Hopper
            }
            case "HorfDefeat" -> {
                player.coins += 3;
                //  Agregar recompensas específicas para Horf
            }
            case "PsyHorfDefeat" -> {
                //  Agregar recompensas específicas para Psy Horf
                Card card = lootDeck.draw();
                if (card != null) {
                    player.hand.add(card);
                }
            }
            case "FattyDefeat" -> {
                //  Agregar recompensas específicas para Fatty
                Card card = lootDeck.draw();
                if (card != null) {
                    player.hand.add(card);
                }
            }
            case "ConjoinedFattyDefeat" -> {
                //  Agregar recompensas específicas para Conjoined Fatty
                for (int i = 0; i < 2; i++){
                Card card = lootDeck.draw();
                if (card != null) {
                    player.hand.add(card);
                }
            }
            }
            case "PaleFattyDefeat" -> {
                //  Agregar recompensas específicas para Pale Fatty
                player.coins += 6;
            }
            case "RedHostDefeat" -> {
                //  Agregar recompensas específicas para Red Host
                player.coins += 5;
            }
            case "FatBatDefeat" -> {
                //  Agregar recompensas específicas para Fat Bat
                if (!treasureDeck.cards.isEmpty()) {
                    TreasureCard item = treasureDeck.drawTreasure();
                    player.hand.add(item);
                    // Handle the treasure card as needed
                }
            }
            case "HangerDefeat" -> {
                //  Agregar recompensas específicas para Hanger
                player.coins += 7;
            }
            case "KeeperHeadDefeat" -> {
                //  Agregar recompensas específicas para Keeper Head
                int CoinsRandom =(int) (1+Math.random()*6);
                player.coins += CoinsRandom;
            }
            case "BoomFlyDefeat" -> {
                player.coins += 4;
                //  Agregar recompensas específicas para Boom Fly
            }
            case "LeaperDefeat" -> {
                //  Agregar recompensas específicas para Leaper
                player.coins += 5;
            }
            case "PortalDefeat" -> {
                //  Agregar recompensas específicas para Portal
                player.coins += 3;
            }
            case "GreedlingDefeat" -> {
                player.coins += 7;
                //  Agregar recompensas específicas para Greedling
            }
            case "StoneyDefeat" -> {
                //  Agregar recompensas específicas para Stoney
                Card card = lootDeck.draw();
                if (card != null) {
                    player.hand.add(card);
                }
            }
            case "BlackBonyDefeat" -> {
                //  Agregar recompensas específicas para Black Bony

                int lootRandom = (int) (1+ Math.random()*6);

                    for (int i = 0; i < lootRandom; i++) {

                        Card card = lootDeck.draw();
                        if (card != null) {
                            player.hand.add(card);
                        }
                        // Handle the treasure card as needed
                    }
            }
            case "DingaDefeat" -> {
                int coinsRandom = (int) (1 + Math.random() * 6);
                player.coins += coinsRandom;
                //  Agregar recompensas específicas para Dinga
            }
            case "WizoobDefeat" -> {
                //  Agregar recompensas específicas para Wizoob
                for (int i = 0; i < 3; i++) {

                    Card card = lootDeck.draw();
                    if (card != null) {
                        player.hand.add(card);
                    }
                    // Handle the treasure card as needed
                }
            }
            case "DankGlobinDefeat" -> {
                //  Agregar recompensas específicas para Dank Globin
                for (int i = 0; i < 2; i++) {

                    Card card = lootDeck.draw();
                    if (card != null) {
                        player.hand.add(card);
                    }
                    // Handle the treasure card as needed
                }
            }
            case "RageCreepDefeat" -> {
                //  Agregar recompensas específicas para Rage Creep
                for (int i = 0; i < 2; i++) {

                    Card card = lootDeck.draw();
                    if (card != null) {
                        player.hand.add(card);
                    }
                    // Handle the treasure card as needed
                }
            }
            case "MomsHandDefeat" -> {
                //  Agregar recompensas específicas para Mom's Hand
                player.coins += 4;
            }
            case "MomsDeadHandDefeat" -> {
                //  Agregar recompensas específicas para Mom's Dead Hand
                player.coins += 4;
            }
            case "MomsEyeDefeat" -> {
                //  Agregar recompensas específicas para Mom's
                Card card = lootDeck.draw();
                if (card != null) {
                    player.hand.add(card);
                }
            }
            case "LeechDefeat" -> {
                //  Agregar recompensas específicas para Leech
                Card card = lootDeck.draw();
                if (card != null) {
                    player.hand.add(card);
                }
            }
            case "CodWormDefeat" -> {
                player.coins += 3;
                //  Agregar recompensas específicas para Cod Worm
            }
            case "DopleDefeat" -> {
                player.coins += 7;
                //  Agregar recompensas específicas para Dople
            }
            case "EvilTwinDefeat" -> {
                //  Agregar recompensas específicas para Evil Twin
                if (!treasureDeck.cards.isEmpty()) {
                    TreasureCard item = treasureDeck.drawTreasure();
                    player.hand.add(item);
                    // Handle the treasure card as needed
                }

            }
            case "HolyDipDefeat" -> {
                player.coins += 1;
                //  Agregar recompensas específicas para Holy Dip
            }
                case "HolySquirtDefeat" -> {
                    //  Agregar recompensas específicas para Holy Squirt
                    for (int i = 0; i < 2; i++) {
                        Card card = lootDeck.draw();
                        if (card != null) {
                            player.hand.add(card);
                        }
                    }
                }

            case "HolyDingaDefeat" -> {
                //  Agregar recompensas específicas para Holy Dinga
                int CoinsRandom =(int) (1+Math.random()*6);
                player.coins += CoinsRandom;
            }
            case "HolyMomsEyeDefeat" -> {
                //  Agregar recompensas específicas para Holy Mom's Eye
                Card card = lootDeck.draw();
                if (card != null) {
                    player.hand.add(card);
                }
            }
            case "HolyKeeperHeadDefeat" -> {
                //  Agregar recompensas específicas para Holy Keeper Head
                int CoinsRandom =(int) (1+Math.random()*6);
                player.coins += CoinsRandom;
            }
            case "CursedKeeperHeadDefeat" -> {
                //  Agregar recompensas específicas para Cursed Keeper Head
                int CoinsRandom =(int) (1+Math.random()*6);
                player.coins += CoinsRandom;
            }
            case "CursedHorfDefeat" ->
                //  Agregar recompensas específicas para Cursed Horf
                    player.coins += 3;
            case "CursedPsyHorfDefeat"-> {
                //  Agregar recompensas específicas para Cursed Psy Horf
                for (int i = 0; i < 2; i++) {
                    Card card = lootDeck.draw();
                    if (card != null) {
                        player.hand.add(card);
                    }
                }
            }
            case "CursedFattyDefeat"-> {
                //  Agregar recompensas específicas para Cursed Fatty
                for (int i = 0; i < 2; i++) {
                    Card card = lootDeck.draw();
                    if (card != null) {
                        player.hand.add(card);
                    }
                }
            }
            case "CursedMomsHandDefeat"->
                //  Agregar recompensas específicas para Cursed Mom's Hand
                player.coins += 4;

            case "CursedGaperDefeat"->
                //  Agregar recompensas específicas para Cursed Gaper
                player.coins += 3;

            case "MonstroDefeat" -> {
                // Implementa las recompensas y acciones específicas para Monstro aquí
                player.coins += 6;
                player.souls += 1;

            }
            case "LittleHornDefeat"-> {
                // Implementa las recompensas y acciones específicas para Little Horn aquí
                for (int i = 0; i < 2; i++) {
                    Card card = lootDeck.draw();
                    if (card != null) {
                        player.hand.add(card);
                    }
                }
                player.souls += 1;

            }
            case "LarryJrDefeat"-> {
                // Implementa las recompensas y acciones específicas para Larry Jr. aquí
                player.coins += 6;
                player.souls += 1;

            }
            case "DukeOfFliesDefeat"-> {
                // Implementa las recompensas y acciones específicas para The Duke of Flies aquí
                for (int i = 0; i < 2; i++) {
                    Card card = lootDeck.draw();
                    if (card != null) {
                        player.hand.add(card);
                    }
                }
                player.souls += 1;

            }
            case "PinDefeat"-> {
                // Implementa las recompensas y acciones específicas para Pin aquí
                player.coins += 5;
                player.souls += 1;

            }
            case "GeminiDefeat"-> {
                // Implementa las recompensas y acciones específicas para Gemini aquí
                player.coins += 5;
                player.souls += 1;

            }
            case "RagManDefeat"-> {
                // Implementa las recompensas y acciones específicas para Rag Man aquí
                for (int i = 0; i < 3; i++) {
                    Card card = lootDeck.draw();
                    if (card != null) {
                        player.hand.add(card);
                    }
                }
                player.souls += 1;

            }
            case "TheHauntDefeat"-> {
                // Implementa las recompensas y acciones específicas para The Haunt aquí
                if (!treasureDeck.cards.isEmpty()) {
                    TreasureCard item = treasureDeck.drawTreasure();
                    player.hand.add(item);
                    // Handle the treasure card as needed
                }
                player.souls += 1;

            }
            case "GurdyJrDefeat"-> {
                // Implementa las recompensas y acciones específicas para Gurdy Jr. aquí
                if (!treasureDeck.cards.isEmpty()) {
                    TreasureCard item = treasureDeck.drawTreasure();
                    player.hand.add(item);
                    // Handle the treasure card as needed
                }
                player.souls += 1;

            }
            case "GurdyDefeat"-> {
                // Implementa las recompensas y acciones específicas para Gurdy aquí
                player.coins += 7;
                player.souls += 1;

            }
            case "MegaFattyDefeat"-> {
                // Implementa las recompensas y acciones específicas para Mega Fatty aquí
                for (int i = 0; i < 2; i++) {
                    Card card = lootDeck.draw();
                    if (card != null) {
                        player.hand.add(card);
                    }
                }
                player.souls += 1;

            }
            case "ChubDefeat"-> {
                // Implementa las recompensas y acciones específicas para Chub aquí
                player.coins += 7;
                player.souls += 1;

            }
            case "CarrionQueenDefeat"-> {
                // Implementa las recompensas y acciones específicas para Carrion Queen aquí
                if (!treasureDeck.cards.isEmpty()) {
                    TreasureCard item = treasureDeck.drawTreasure();
                    player.hand.add(item);
                    // Handle the treasure card as needed
                }
                player.souls += 1;

            }
            case "PeepDefeat"-> {
                // Implementa las recompensas y acciones específicas para Peep aquí
                if (!treasureDeck.cards.isEmpty()) {
                    TreasureCard item = treasureDeck.drawTreasure();
                    player.hand.add(item);
                    // Handle the treasure card as needed
                }
                player.souls += 1;

            }
            case "TheBloatDefeat"-> {
                // Implementa las recompensas y acciones específicas para The Bloat aquí
                if (!treasureDeck.cards.isEmpty()) {
                    TreasureCard item = treasureDeck.drawTreasure();
                    player.hand.add(item);
                    // Handle the treasure card as needed
                }
                player.souls += 1;

            }
            case "DarkOneDefeat"-> {
                // Implementa las recompensas y acciones específicas para Dark One aquí
                if (!treasureDeck.cards.isEmpty()) {
                    TreasureCard item = treasureDeck.drawTreasure();
                    player.hand.add(item);
                    // Handle the treasure card as needed
                }
                player.souls += 1;

            }
            case "MaskOfInfamyDefeat"-> {
                // Implementa las recompensas y acciones específicas para Mask of Infamy aquí
                if (!treasureDeck.cards.isEmpty()) {
                    TreasureCard item = treasureDeck.drawTreasure();
                    player.hand.add(item);
                    // Handle the treasure card as needed
                }
                player.souls += 1;

            }
            case "DaddyLongLegsDefeat"-> {
                // Implementa las recompensas y acciones específicas para Daddy Long Legs aquí
                player.coins += 7;
                player.souls += 1;

            }
            case "ScolexDefeat"-> {
                // Implementa las recompensas y acciones específicas para Scolex aquí
                if (!treasureDeck.cards.isEmpty()) {
                    TreasureCard item = treasureDeck.drawTreasure();
                    player.hand.add(item);
                    // Handle the treasure card as needed
                }
                player.souls += 1;

            }
            case "FamineDefeat"-> {
                // Implementa las recompensas y acciones específicas para Famine aquí
                for (int i = 0; i < 3; i++) {
                    Card card = lootDeck.draw();
                    if (card != null) {
                        player.hand.add(card);
                    }
                }
                player.souls += 1;

            }
            case "PestilenceDefeat"-> {
                // Implementa las recompensas y acciones específicas para Pestilence aquí

                for (int i = 0; i < 2; i++) {
                    Card card = lootDeck.draw();
                    if (card != null) {
                        player.hand.add(card);
                    }
                }
                player.souls += 1;

            }
            case "WarDefeat"-> {
                // Implementa las recompensas y acciones específicas para War aquí
                player.coins += 8;
                player.souls += 1;

            }
            case "DeathDefeat"-> {
                // Implementa las recompensas y acciones específicas para Death aquí

                if (!treasureDeck.cards.isEmpty()) {
                    TreasureCard item = treasureDeck.drawTreasure();
                    player.hand.add(item);
                    // Handle the treasure card as needed
                }
                player.souls += 1;


            }
            case "ConquestDefeat"-> {
                // Implementa las recompensas y acciones específicas para Conquest aquí
                player.coins += 6;
                player.souls += 1;
            }

            case "EnvyDefeat"-> {
                // Implementa las recompensas y acciones específicas para Envy aquí
                player.coins += 1;
                player.souls += 1;
            }
            case "GreedDefeat"-> {
                // Implementa las recompensas y acciones específicas para Greed aquí
                player.coins += 9;
                player.souls += 1;

            }
            case "WrathDefeat"-> {
                // Implementa las recompensas y acciones específicas para Wrath aquí
                player.coins += 6;
                player.souls += 1;

            }
            case "SlothDefeat"-> {
                // Implementa las recompensas y acciones específicas para Sloth aquí
                player.coins += 1;
                player.souls += 1;

            }
            case "PrideDefeat"-> {
                // Implementa las recompensas y acciones específicas para Pride aquí
                player.coins += 5;
                player.souls += 1;

            }
            case "GluttonyDefeat"-> {
                // Implementa las recompensas y acciones específicas para Gluttony aquí
                Card card = lootDeck.draw();
                if (card != null) {
                    player.hand.add(card);
                }
                player.souls += 1;

            }
            case "LustDefeat"-> {
                // Implementa las recompensas y acciones específicas para Lust aquí
                for (int i = 0; i < 2; i++) {
                    Card card = lootDeck.draw();
                    if (card != null) {
                        player.hand.add(card);
                    }
                }
                player.souls += 1;

            }
            case "MomDefeat"-> {
                // Implementa las recompensas y acciones específicas para Mom aquí
                if (!treasureDeck.cards.isEmpty()) {
                    TreasureCard item = treasureDeck.drawTreasure();
                    player.hand.add(item);
                    // Handle the treasure card as needed
                }
                player.souls += 2;

            }
            case "SatanDefeat"-> {
                // Implementa las recompensas y acciones específicas para Satan aquí
                if (!treasureDeck.cards.isEmpty()) {
                    for (int i = 0; i < 2; i++) {
                        TreasureCard item = treasureDeck.drawTreasure();
                        player.hand.add(item);
                        // Handle the treasure card as needed
                    }
                }
                player.souls += 2;

            }
            case "TheLambDefeat"-> {
                // Implementa las recompensas y acciones específicas para The Lamb aquí
                player.coins += 3;
                player.souls += 2;


            }
            case "DeliriumDefeat"-> {

                for (int i = 0; i < 3; i++) {
                    Card card = lootDeck.draw();
                    if (card != null) {
                        player.hand.add(card);
                    }
                }
                player.souls += 2;
            }
        }

    }
}
