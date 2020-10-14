package me.uwu.utils;

import java.io.*;

public class FileUtils {

    public static String fileToString(String absolutePath) throws IOException {
        File file = new File(absolutePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();

        String st;
        while ((st = br.readLine()) != null)
            sb.append(st).append("\n");

        return sb.toString();
    }

    public static void stringToFile(String absolutePath, String data) throws IOException {
        createFile(absolutePath);

        try {
            FileWriter myWriter = new FileWriter(absolutePath);
            myWriter.write(data);
            myWriter.close();
            System.out.println("Successfully saved file.");
        } catch (IOException e) {
            System.out.println("Unable to save file :/");
            e.printStackTrace();
        }
    }

    public static void createFile(String absolutePath){
            try {
                File myObj = new File(absolutePath);
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("Unable to create file :/");
                e.printStackTrace();
            }
    }

}
