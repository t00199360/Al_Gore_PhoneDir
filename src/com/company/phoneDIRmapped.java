package com.company;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class phoneDIRmapped
{
    public static void main(String[] args)
    {
        Map<String, String> phoneDirectory = new HashMap<>();
        phoneDirectory.put("Jeffrey", "0877010443");
        phoneDirectory.put("Jimbo", "0872635114");
        phoneDirectory.put("Steven", "0878457663");
        phoneDirectory.put("Diana", "0873685996");
        phoneDirectory.put("Rex", "0870134003");
        phoneDirectory.put("Claire", "0879487661");
        phoneDirectory.put("Marshall", "0876130569");

        String JeffreysNumber = phoneDirectory.get("Jeffrey");
        System.out.println(JeffreysNumber);             //expected 877010443
        // Print all keys and values in the map

        Set<String> keySet = phoneDirectory.keySet();
        for (String key : keySet)
        {
            String value = phoneDirectory.get(key);
            System.out.println(key + " : " + value);
        }
    }
}
