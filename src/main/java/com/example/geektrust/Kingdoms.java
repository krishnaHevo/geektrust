package com.example.geektrust;

import java.util.HashMap;
import java.util.Map;

public class Kingdoms {
    static Map<String, String> kingdomEmblem = new HashMap<>();

    Kingdoms() {
        kingdomEmblem.put("SPACE", "gorilla");
        kingdomEmblem.put("LAND", "panda");
        kingdomEmblem.put("WATER", "octopus");
        kingdomEmblem.put("ICE", "mammoth");
        kingdomEmblem.put("AIR", "owl");
        kingdomEmblem.put("FIRE", "dragon");
    }

}
