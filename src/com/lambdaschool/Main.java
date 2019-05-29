package com.lambdaschool;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main
{

    // Read in text
    public static String readFileAsString(String filename)throws Exception
    {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(filename)));
        return data;
    }

    public static void main(String[] args) throws Exception
    {
        // Read in the string
        String data = readFileAsString("./HumanRights.txt");
        // Make lower case
        data = data.toLowerCase();
        // Remove punctuation
        data = data.replaceAll("[[\\.\\?\\!\\,\\;\\:\\{\\}\\(\\)\\']]", "");
        // Split on space
        String[] words = data.split(" +");
        // Instantiate Hash Map
        HashMap<String, Integer> wordsHashMap = new HashMap<String, Integer>();
        // Iterate over string making hash map
        for (int i = 0; i < words.length; i++)
        {
            if (wordsHashMap.keySet().contains(words[i]))
            {
                int count = wordsHashMap.get(words[i]);
                wordsHashMap.put(words[i], count + 1);
            }
            else
            {
                wordsHashMap.put(words[i], 1);
            }
        }
        // Iterate over hash map finding most common word
        ArrayList<String> topFifty = new ArrayList<String>();
        for (int i = 0; i < 50; i++)
        {
            for (Map.Entry<String, Integer> entry : wordsHashMap.entrySet())
            {
                int largestCount = 0;
                String largestWord = "";
                String currentWord = entry.getKey();
                int currentCount = entry.getValue();
                if ((currentCount > largestCount) && (!topFifty.contains(currentWord)))
                {
                    largestCount = currentCount;
                    largestWord = currentWord;
                }
                // --> Add the word to top 50
                topFifty.add(currentWord);
                // --> Remove word from hash map
            }
        }
        for (int i = 0; i < 50; i++)
        {
            System.out.println(topFifty.get(i));
        }
    }
}
