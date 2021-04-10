package com.destrim.utils;

import java.io.IOException;

public class VariousUtils {
    public static void clearScreen() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
