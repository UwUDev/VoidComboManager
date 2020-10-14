package me.uwu.utils;

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

}
