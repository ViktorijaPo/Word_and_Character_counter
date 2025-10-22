package com.example.wordandcharactercounter;


public class CharacterCounter {
    public static long countCharacters(String text) {
        if (text == null) return 0;
        return text.length();
    }
}
