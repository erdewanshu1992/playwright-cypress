package com.flipkart.utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {

    // Read content from a file
    public static String readFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    // Write content to a file
    public static void writeFile(String filePath, String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write(content);
        writer.close();
    }

    // Append content to a file
    public static void appendToFile(String filePath, String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
        writer.append(content);
        writer.close();
    }
}
