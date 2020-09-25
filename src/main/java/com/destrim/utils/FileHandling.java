package com.destrim.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandling {
    public static String importFromFile(String fileName) {
        Path path = Path.of(fileName + ".json");
        try {
            return Files.readString(path);
        } catch (IOException e) {
            return "";
        }
    }
}
