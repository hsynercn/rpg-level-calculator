package org.example;

import java.util.ArrayList;

public class UnitGenerationUtil {
    public Unit createPlayer() {
        int hp = 100;
        int hpRegeneration = 1;
        int strength = 10;
        int agility = 10;
        int intelligence = 10;
        int armor = 10;
        int mana = 100;
        int manaRegeneration = 1;
        int baseDamage = 10;
        int xp = 0;
        int level = 1;
        int gold = 0;
        ArrayList<Dice> dices = new ArrayList<>();
        dices.add(new Dice(6));

        return new Unit(
                hp,
                hpRegeneration,
                strength,
                agility,
                intelligence,
                armor,
                mana,
                manaRegeneration,
                baseDamage,
                xp,
                level,
                gold,
                dices
        );
    }

    public Unit createEnemy() {
        int hp = 55;
        int hpRegeneration = 0;
        int strength = 0;
        int agility = 0;
        int intelligence = 0;
        int armor = 1;
        int mana = 100;
        int manaRegeneration = 1;
        int baseDamage = 5;
        int xp = 6;
        int level = 1;
        int gold = 4;
        ArrayList<Dice> dices = new ArrayList<>();
        dices.add(new Dice(2));
        dices.add(new Dice(2));


        return new Unit(
                hp,
                hpRegeneration,
                strength,
                agility,
                intelligence,
                armor,
                mana,
                manaRegeneration,
                baseDamage,
                xp,
                level,
                gold,
                dices
        );
    }
}
