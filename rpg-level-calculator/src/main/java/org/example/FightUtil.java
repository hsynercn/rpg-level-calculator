package org.example;

public class FightUtil {

    public Unit iterativeFight(Unit player, Unit enemy, int enemyCount) {

        float totalDuration = 0;
        int totalCycleCount = 0;


        FightResult fightResult = fight(player, enemy);

        Unit winner = fightResult.winner;

        if (winner == player) {
            awardPlayer(player, enemy);
        }

        totalDuration += fightResult.duration;
        totalCycleCount += fightResult.cycleCount;

        int iteration = 1;
        while (iteration < enemyCount && winner == player) {
            FightResult iterationResult = fight(player, enemy);
            winner = iterationResult.winner;
            if (winner == player) {
                awardPlayer(player, enemy);
            }
            totalDuration += fightResult.duration;
            totalCycleCount += fightResult.cycleCount;
            iteration++;
        }

        System.out.println("Total fight duration: " + totalDuration);
        System.out.println("Total fight cycle count: " + totalCycleCount);
        return player;
    }
    public FightResult fight(Unit player, Unit enemy) {

        prepareForFight(player);
        prepareForFight(enemy);

        float cycleDuration = 1.0f;
        int cycleCount = 0;
        System.out.println("Fight!*********************************");
        while (player.currentHP > 0 && enemy.currentHP > 0) {
            float playerDamage = getPlayerDamage(player);
            float enemyDamage = getEnemyDamage(enemy);
            player.currentHP -= enemyDamage;
            enemy.currentHP -= playerDamage;
            cycleCount++;
            System.out.println("Cycle: " + cycleCount);
            System.out.println("Player HP: " + player.maxHP +
                    " player damage: " + playerDamage +
                    " player remaining HP: " + player.currentHP);
            System.out.println("Enemy HP: " + enemy.maxHP +
                    " enemy damage: " + enemyDamage +
                    " enemy remaining HP: " + enemy.currentHP);
        }

        FightResult fightResult = new FightResult();
        fightResult.winner = player.maxHP > 0 ? player : enemy;
        fightResult.duration = cycleCount * cycleDuration;
        fightResult.cycleCount = cycleCount;
        return fightResult;
    }

    public void prepareForFight(Unit unit) {
        unit.currentHP = unit.maxHP;
    }

    public float getPlayerDamage(Unit unit) {
        float strengthDmgModifier = 1f;
        float damage =  unit.BaseDamage + (unit.Strength * strengthDmgModifier);
        damage += getDiceRoll(unit);
        return damage * getPlayerAttackSpeed(unit);
    }

    public float getPlayerAttackSpeed(Unit unit) {
        float agilityAtkSpdModifier = 0.02f;
        return 1 + unit.Agility * agilityAtkSpdModifier;
    }

    public float getDiceRoll(Unit unit) {
        float totalDamage = 0;
        for (Dice dice : unit.dices) {
            totalDamage += (int) (Math.random() * dice.faceCount) + 1;
        }
        return totalDamage;
    }

    public float getEnemyDamage(Unit enemy) {
        return enemy.BaseDamage + getDiceRoll(enemy);
    }

    public void awardPlayer(Unit player, Unit enemy) {
        player.XP += enemy.XP;
        player.Gold += enemy.Gold;
    }
}
