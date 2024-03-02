package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        UnitGenerationUtil unitGenerationUtil = new UnitGenerationUtil();


        Unit player = unitGenerationUtil.createPlayer();
        Unit enemy = unitGenerationUtil.createEnemy();

        FightUtil fightUtil = new FightUtil();

        //iterative fight with 3 enemies
        Unit winner = fightUtil.iterativeFight(player, enemy, 3);
    }
}