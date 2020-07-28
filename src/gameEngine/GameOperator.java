package gameEngine;

import utils.FileHandling;

public class GameOperator {
    public static void game(String fileName) {
        String jsonString = FileHandling.importFromFile(fileName);

        Generation pattern1 = new Generation();
        Generation pattern2 = new Generation();
        Generation pattern3 = new Generation();
        Generation pattern4 = new Generation();

        pattern1.newGen(jsonString, "pattern1");
        pattern2.newGen(jsonString, "pattern2");
        pattern3.newGen(jsonString, "pattern3");
        pattern4.newGen(jsonString, "pattern4");

        while (true) {
            GameCycle.cycle(pattern1);
            pattern1.resetGen();
            GameCycle.cycle(pattern2);
            pattern2.resetGen();
            GameCycle.cycle(pattern3);
            pattern3.resetGen();
            GameCycle.cycle(pattern4);
            pattern4.resetGen();
        }

    }
}
