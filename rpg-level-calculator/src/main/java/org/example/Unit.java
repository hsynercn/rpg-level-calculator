package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Create the Unit class with these properties
 * Unit:
 *
 * - HP
 * - HP regeneration
 * - Strength
 * - Agility
 * - Intelligence
 * - Armor
 * - Mana
 * - Mana regeneration
 * - Base damage
 * - XP
 * - Level
 * - Gold
 * - Inventory
 *   - Equipment
 * - Skills
 *   - Skill
 */
public class Unit {
    public int maxHP;
    public int currentHP;
    public int HPRegeneration;
    public int Strength;
    public int Agility;
    public int Intelligence;
    public int Armor;
    public int Mana;
    public int ManaRegeneration;
    public int BaseDamage;
    public int XP;
    public int Level;
    public int Gold;

    public List<Dice> dices;

    public Unit(
            int maxHP,
            int HPRegeneration,
            int Strength,
            int Agility,
            int Intelligence,
            int Armor,
            int Mana,
            int ManaRegeneration,
            int BaseDamage,
            int XP,
            int Level,
            int Gold,
            List<Dice> dices
    ) {
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.HPRegeneration = HPRegeneration;
        this.Strength = Strength;
        this.Agility = Agility;
        this.Intelligence = Intelligence;
        this.Armor = Armor;
        this.Mana = Mana;
        this.ManaRegeneration = ManaRegeneration;
        this.BaseDamage = BaseDamage;
        this.XP = XP;
        this.Level = Level;
        this.Gold = Gold;
        this.dices = dices;
    }


}
