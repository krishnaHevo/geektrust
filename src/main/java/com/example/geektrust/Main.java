package com.example.geektrust;

import com.google.common.collect.Lists;

import java.io.*;
import java.util.*;

import static com.example.geektrust.Kingdoms.kingdomEmblem;

public class Main {
    public static String decrpyt(String message, Integer key) {
        String decrypted_message = "";
        for(Character ch: Lists.charactersOf(message)) {
            int ch1 = (ch - key);
            ch1 = ch1 < 97 ? ch1+26 : ch1;
            decrypted_message += (char)ch1;
        }
        return decrypted_message;
    }

    public static boolean stringContains(String message, String emblem) {
        Set<Character> a = new HashSet<>();
        Set<Character> b = new HashSet<>();
        for(Character c : Lists.charactersOf(message))
            a.add(c);
        for(Character c : Lists.charactersOf(emblem))
            b.add(c);

        return a.containsAll(b);
    }

    public static boolean isAlly(String kingdom, String message) {
        String emblem = kingdomEmblem.get(kingdom);
        Integer secret_key = emblem.length();
        String decrypted_message = decrpyt(message.toLowerCase(), secret_key);

        return stringContains(decrypted_message, emblem);
    }

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        Kingdoms kingdoms = new Kingdoms();
        int count = 0;
        List<String> allies = new ArrayList<>();
        String st;
        allies.add("SPACE");
        while ((st = in.readLine()) != null) {
            String input[] = st.split(" ");
            String kingdom = input[0];
            String message = input[1];
            if(isAlly(kingdom, message)) {
                count += 1;
                allies.add(kingdom);
            }
        }

        if(count >= 3) {
            System.out.println(String.join(" ", allies));
        }
        else {
            System.out.println("NONE");
        }
	}
}