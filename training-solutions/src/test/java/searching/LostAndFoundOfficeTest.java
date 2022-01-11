package searching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LostAndFoundOfficeTest {

    List<LostProperty> properties = new ArrayList<>();
    LostAndFoundOffice office;

    @BeforeEach
    void init() {
        properties.add(new LostProperty("0001", "sárga plüssmackó", LocalDate.of(2021, 3, 4)));
        properties.add(new LostProperty("0002", "színes esernyő", LocalDate.of(2021, 6, 7)));
        properties.add(new LostProperty("0003", "nokia telefon", LocalDate.of(2021, 2, 9)));
        properties.add(new LostProperty("0004", "lakáskulcs kulcstartó nélkül", LocalDate.of(2021, 3, 16)));
        properties.add(new LostProperty("0005", "kék bolyhos pulóver", LocalDate.of(2021, 8, 10)));
        properties.add(new LostProperty("0006", "színes esernyő", LocalDate.of(2021, 6, 29)));
        properties.add(new LostProperty("0007", "bőr pénztárca", LocalDate.of(2021, 2, 16)));
        properties.add(new LostProperty("0008", "műanyag kulacs", LocalDate.of(2021, 9, 28)));
        Collections.sort(properties);
        office = new LostAndFoundOffice(properties);
    }

    @Test
    void testFindLostProperty() {
        LostProperty expected = office.findLostProperty(new LostProperty("színes esernyő", LocalDate.of(2021, 6, 29)));

        assertEquals("0006", expected.getId());
    }

    @Test
    void testFindLostPropertyNotFound() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> office.findLostProperty(new LostProperty("xyz", LocalDate.of(2021, 6, 29))));
        assertEquals("Property not found.", ex.getMessage());
    }

}