package controlselection.accents;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WithoutAccentsTest {

    @Test
    void stripAccent() {
        WithoutAccents withoutAccents = new WithoutAccents();
        assertEquals('a', withoutAccents.stripAccent('á'));
        assertEquals('e', withoutAccents.stripAccent('é'));
        assertEquals('i', withoutAccents.stripAccent('í'));
        assertEquals('U', withoutAccents.stripAccent('Ű'));

        assertEquals('a', withoutAccents.stripAccent('a'));
        assertEquals('h', withoutAccents.stripAccent('h'));
        assertEquals('z', withoutAccents.stripAccent('z'));
    }
}