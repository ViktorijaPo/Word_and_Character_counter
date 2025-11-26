package com.example.wordandcharactercounter;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    // WordCounter Tests
    @Test
    public void countWords_emptyString_returnsZero() {
        assertEquals(0, WordCounter.countWords(""));
    }

    @Test
    public void countWords_stringWithSpaces_returnsZero() {
        assertEquals(0, WordCounter.countWords("    "));
    }

    @Test
    public void countWords_stringWithTabs_returnsZero() {
        assertEquals(0, WordCounter.countWords("\t\t\t"));
    }

    @Test
    public void countWords_singleWord_returnsOne() {
        assertEquals(1, WordCounter.countWords("hello"));
    }

    @Test
    public void countWords_multipleWords_returnsCorrectCount() {
        assertEquals(5, WordCounter.countWords("this is a sample sentence"));
    }

    @Test
    public void countWords_wordsWithExtraSpaces_returnsCorrectCount() {
        assertEquals(4, WordCounter.countWords("  this  has   extra spaces  "));
    }

    @Test
    public void countWords_nullInput_returnsZero() {
        assertEquals(0, WordCounter.countWords(null));
    }

    // CharacterCounter Tests
    @Test
    public void countCharacters_emptyString_returnsZero() {
        assertEquals(0, CharacterCounter.countCharacters(""));
    }

    @Test
    public void countCharacters_stringWithSpaces_returnsCorrectCount() {
        assertEquals(4, CharacterCounter.countCharacters("    "));
    }

    @Test
    public void countCharacters_stringWithTabs_returnsCorrectCount() {
        assertEquals(3, CharacterCounter.countCharacters("\t\t\t"));
    }

    @Test
    public void countCharacters_simpleString_returnsCorrectCount() {
        assertEquals(5, CharacterCounter.countCharacters("hello"));
    }

    @Test
    public void countCharacters_stringWithSpacesAndText_returnsCorrectCount() {
        assertEquals(11, CharacterCounter.countCharacters("hello world"));
    }

    @Test
    public void countCharacters_nullInput_returnsZero() {
        assertEquals(0, CharacterCounter.countCharacters(null)) ;
    }
}
