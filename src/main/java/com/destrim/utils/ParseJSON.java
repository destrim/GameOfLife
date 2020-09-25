package com.destrim.utils;

import org.json.JSONArray;
import org.json.JSONObject;
import com.destrim.representation.Cell;
import com.destrim.representation.Position;

import java.util.HashMap;

public class ParseJSON {
    public static void parseJSONFromString(String jsonString, String patternName, HashMap<Position, Cell> aliveCells) {
        JSONObject obj = new JSONObject(jsonString);

        JSONArray arr = obj.getJSONArray(patternName);

        for (int i = 0; i < arr.length(); i++) {
            int posX = Integer.parseInt(arr.getJSONObject(i).getString("x"));
            int posY = Integer.parseInt(arr.getJSONObject(i).getString("y"));

            Position pos = new Position(posX, posY);
            Cell cell = new Cell(true, pos);

            aliveCells.put(pos, cell);
        }
    }
}
