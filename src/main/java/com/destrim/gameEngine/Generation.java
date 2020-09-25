package com.destrim.gameEngine;

import com.destrim.representation.Cell;
import com.destrim.representation.Position;
import com.destrim.utils.ParseJSON;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Generation {
    public HashMap<Position, Cell> aliveCells = new HashMap<>();
    public HashMap<Position, Cell> initAliveCells = new HashMap<>();

    public int length = 10;
    public int width = 10;

    public void newGen(String jsonString, String patternName) {
        ParseJSON.parseJSONFromString(jsonString, patternName, aliveCells);
        initAliveCells = (HashMap<Position, Cell>) aliveCells.clone();
    }

    public void nextGen() {
        HashMap<Position, Integer> numberOfNeighbours = new HashMap<>();

        Set<Position> setOfAlivePos = aliveCells.keySet();
        Iterator<Position> listOfAlivePosIterator = setOfAlivePos.iterator();

        while (listOfAlivePosIterator.hasNext()) {
            Position positionForGettingXY = listOfAlivePosIterator.next();

            int x = positionForGettingXY.getX();
            int y = positionForGettingXY.getY();

            for (int i = x-1; i <= x+1; i++) {
                for (int j = y-1; j <= y+1; j++) {
                    Position pos = new Position(i%length, j%width);

                    if (pos.getX() == x && pos.getY() == y)
                        ;
                    else if (numberOfNeighbours.containsKey(pos)) {
                        int val = numberOfNeighbours.get(pos);
                        val++;
                        numberOfNeighbours.put(pos, val);
                    } else
                        numberOfNeighbours.put(pos, 1);
                }
            }
        }

        Set<Position> setOfNumberOfNeighbours = numberOfNeighbours.keySet();
        Iterator<Position> setOfNumberOfNeighboursIterator = setOfNumberOfNeighbours.iterator();

        while (setOfNumberOfNeighboursIterator.hasNext()) {
            Position pos = setOfNumberOfNeighboursIterator.next();

            int neighbours = numberOfNeighbours.get(pos);

            if (neighbours < 2 || neighbours > 3) {
                aliveCells.remove(pos);
            } else if (neighbours == 3) {
                if (!aliveCells.containsKey(pos)) {
                    Cell cell = new Cell(true, pos);
                    aliveCells.put(pos, cell);
                }
            }
        }
    }

    public void resetGen() {
        aliveCells = (HashMap<Position, Cell>) initAliveCells.clone();
    }

    public void showGen() {
        System.out.println("");
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                Position pos = new Position(i, j);

                if (aliveCells.containsKey(pos))
                    System.out.print("X");
                else
                    System.out.print("o");

                System.out.print(" ");
            }

            System.out.print("\n");
        }
    }
}
