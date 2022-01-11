package collectionsiterator;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OnlineLessonTest {

    @Test
    void testCreate() {
        OnlineLesson onlineLesson = new OnlineLesson("Kiss József", "matematika", LocalDateTime.of(2021, 12, 14, 8, 0));

        assertEquals("Kiss József", onlineLesson.getTutorName());
        assertEquals("matematika", onlineLesson.getSubject());
        assertEquals(LocalDateTime.of(2021, 12, 14, 8, 0), onlineLesson.getStart());
    }

}