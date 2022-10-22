package simplefactory.farm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FarmComponentTest {

    @Test
    public void testNewAnimalArrivedWithEmpty() throws IllegalArgumentException {
        Farm farm = new Farm(new FarmAnimalFactory());

        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> farm.newAnimalArrived(""));
        assertEquals("Animal type must not be empty!", ex.getMessage());
    }

    @Test
    public void testGetAnimalVoicesWithOneFrog() {
        Farm farm = new Farm(new FarmAnimalFactory());
        farm.newAnimalArrived("frog");

        assertEquals(1, farm.getAnimalVoices().size());
        assertEquals("brekeke", farm.getAnimalVoices().get(0));
    }

    @Test
    public void testGetAnimalVoicesWithTwoFrog() {
        Farm farm = new Farm(new FarmAnimalFactory());
        farm.newAnimalArrived("frog");
        farm.newAnimalArrived("frog");

        assertEquals(1, farm.getAnimalVoices().size());
        assertEquals("brekeke", farm.getAnimalVoices().get(0));
    }

    @Test
    public void testGetAnimalVoicesWithOneFrogOneHorse() {
        Farm farm = new Farm(new FarmAnimalFactory());
        farm.newAnimalArrived("frog");
        farm.newAnimalArrived("horse");

        assertEquals(2, farm.getAnimalVoices().size());
        assertEquals("brekeke", farm.getAnimalVoices().get(0));
        assertEquals("nyihaha", farm.getAnimalVoices().get(1));
    }

    @Test
    public void testGetAnimalVoicesComplexTest() {
        Farm farm = new Farm(new FarmAnimalFactory());
        farm.newAnimalArrived("frog");
        farm.newAnimalArrived("cock");
        farm.newAnimalArrived("horse");
        farm.newAnimalArrived("horse");
        farm.newAnimalArrived("horse");

        assertEquals(3, farm.getAnimalVoices().size());
        assertEquals("brekeke", farm.getAnimalVoices().get(0));
        assertEquals("kukuriku", farm.getAnimalVoices().get(1));
        assertEquals("nyihaha", farm.getAnimalVoices().get(2));
    }

}