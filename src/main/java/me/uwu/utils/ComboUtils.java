package me.uwu.utils;

import java.util.*;

public class ComboUtils {

    public static String toUserPass(String data){
        StringBuilder sb = new StringBuilder();
        String[] lines = data.split("\n");

        for (String line: lines){
            String[] mailpass = line.split(":");
            String mail = mailpass[0];
            String pass = mailpass[1];
            String user = mail.split("@")[0];
            sb.append(user).append(":").append(pass).append("\n");
        }

        return sb.toString();
    }

    public static String removeDuplicates(String data){
        String[] lines = data.split("\n");
        StringBuilder sb = new StringBuilder();

        List<String> al = Arrays.asList(lines);
        ArrayList<String> cleanAl = new ArrayList<>();

        for (String line : al) {
            if (!cleanAl.contains(line)) {
                cleanAl.add(line);
                sb.append(line).append("\n");
            }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

}
