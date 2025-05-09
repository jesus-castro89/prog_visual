package com.example.files;

import javax.swing.*;
import java.io.*;

public class FileManager {
    private static final String FILE_PATH = "archivos/";

    public static void writeFile(String fileName, String content) {
        try(BufferedWriter bw = new BufferedWriter(
                new FileWriter(FILE_PATH + fileName,
                        true))) {
            bw.write(content);
            bw.close();
            JOptionPane.showMessageDialog(null,
                    "Archivo guardado con éxito",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH + fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JOptionPane.showMessageDialog(null,
                content.toString(),
                "Contenido del archivo",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
