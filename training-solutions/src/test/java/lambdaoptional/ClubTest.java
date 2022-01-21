package lambdaoptional;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ClubTest {

    @Test
    void testCreateMember() {
        Member member = new Member("John Doe", Arrays.asList("Java", "OOP"), Gender.MALE);

        assertEquals("John Doe", member.getName());
        assertEquals(Arrays.asList("Java", "OOP"), member.getSkills());
        assertEquals(Gender.MALE, member.getGender());
    }

    @Test
    void testFindFirst() {
        Club club = new Club(Arrays.asList(
                new Member("John Doe", Arrays.asList("Java", "OOP"), Gender.MALE),
                new Member("Jane Doe", Arrays.asList(".NET", "OOP"), Gender.FEMALE),
                new Member("James Doe", Arrays.asList("Python", "Java", "OOP"), Gender.MALE),
                new Member("Janet Doe", Arrays.asList("JavaScript", "scripting"), Gender.MALE)
        ));

        Optional<Member> result = club.findFirst(m -> m.getName().equals("John Doe"));

        assertTrue(result.isPresent());
        assertEquals("John Doe", result.get().getName());
        assertFalse(club.findFirst(m -> m.getName().equals("Joe")).isPresent());
    }

    @Test
    void testAverage() {
        assertFalse(new Club(Collections.emptyList()).averageNumberOfSkills().isPresent());

        Club club = new Club(Arrays.asList(
                new Member("John Doe", Arrays.asList("Java", "OOP"), Gender.MALE),
                new Member("Jane Doe", Arrays.asList(".NET", "OOP"), Gender.FEMALE),
                new Member("James Doe", Arrays.asList("Python", "Java", "OOP"), Gender.MALE),
                new Member("Janet Doe", Arrays.asList("JavaScript", "scripting"), Gender.MALE)
        ));

        Optional<Double> result = club.averageNumberOfSkills();

        assertTrue(result.isPresent());
        assertEquals(2.25, result.get());
    }

}