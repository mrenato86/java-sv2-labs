package introexceptionreadfiletestjunit5;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RecipeTest {

    Recipe recipe = new Recipe();

    @Test
    void testAddIngredients() {
        Path file = Paths.get("src/test/resources/introexceptionreadfiletestjunit5/recipe.txt");
        recipe.addIngredients(file);
        List<String> expected = List.of("liszt", "margarin", "kristálycukor", "tojás", "citrom",
                "sütőpor", "vanillincukor", "tejföl", "alma", "fahéj");

        assertEquals(expected, recipe.getIngredients());
    }

    @Test
    void testAddIngredientsNoFile() {
        Path noFile = Paths.get("src/test/resources/introexceptionreadfiletestjunit5/NoRecipe.txt");
        IllegalStateException ise = assertThrows(IllegalStateException.class, () -> recipe.addIngredients(noFile));
        assertEquals("File reading error!", ise.getMessage());
    }

}