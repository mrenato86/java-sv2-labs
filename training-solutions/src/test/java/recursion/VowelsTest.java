package recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VowelsTest {

    @Test
    void testIsPalindrome() {
        Vowels vowels = new Vowels();

        assertEquals(7, vowels.getNumberOfVowels("csillagközi űrhajó"));
        assertEquals(1, vowels.getNumberOfVowels("a"));
        assertEquals(0, vowels.getNumberOfVowels("c"));
        assertEquals(0, vowels.getNumberOfVowels(""));
        assertEquals(0, vowels.getNumberOfVowels(null));
    }

}