package controlselection.consonant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToConsonantTest {

    @Test
    void convertToConsonant() {
        ToConsonant toConsonant = new ToConsonant();

        assertEquals('b', toConsonant.convertToConsonant('a'));
        assertEquals('f', toConsonant.convertToConsonant('e'));
        assertEquals('j', toConsonant.convertToConsonant('i'));

        assertEquals('b', toConsonant.convertToConsonant('b'));
        assertEquals('h', toConsonant.convertToConsonant('h'));
        assertEquals('z', toConsonant.convertToConsonant('z'));
    }

}