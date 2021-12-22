package interfacestaticmethods.schoolchild;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PrimarySchoolChildTest {

    @Test
    void testOfWithLowerClassChild() {
        PrimarySchoolChild primarySchoolChild = PrimarySchoolChild.of(8);

        assertEquals(LowerClassSchoolChild.class, primarySchoolChild.getClass());
    }

    @Test
    void testOfWithUpperClassChild() {
        PrimarySchoolChild primarySchoolChild = PrimarySchoolChild.of(13);

        assertEquals(UpperClassSchoolChild.class, primarySchoolChild.getClass());
    }

    @Test
    void testOfWithWrongAge() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> PrimarySchoolChild.of(2));
        assertEquals("It's not a schoolchild with this age!", iae.getMessage());
    }
}