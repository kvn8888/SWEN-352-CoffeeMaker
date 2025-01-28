package coffeemaker;

import static org.junit.jupiter.api.Assertions.*;

import coffeemaker.domain.Recipe;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RecipeTest {
    private Recipe recipe;

    @BeforeEach
    public void setUp() {

    }

    @AfterEach
    public void tearDown() {

    }

    @Test
    @DisplayName("Sanity Check")
    public void testRecipe() {
        assertTrue(true, "This should always pass");
    }
}
