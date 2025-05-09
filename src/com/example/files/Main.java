package com.example.files;

public class Main {

    public static void main(String[] args) {
        String fileName = "example.txt";
        String content = """
                Este es un ejemplo de contenido
                que se escribirá en el archivo.
                Puedes agregar más líneas de texto
                o cualquier otro contenido que desees.
                Recuerda que este es un ejemplo
                y puedes modificarlo según tus necesidades.
                """;
        FileManager.writeFile(fileName, content);
        FileManager.readFile("ejemplo.txt");
    }
}
