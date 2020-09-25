package com.destrim.gameEngine;

public class GameCycle {
    public static void cycle(Generation pattern) {
        pattern.showGen();
        for (int i = 0; i < 50; i++) {
            pattern.nextGen();
            pattern.showGen();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
