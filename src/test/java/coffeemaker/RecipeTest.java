package coffeemaker;

import static org.junit.jupiter.api.Assertions.*;

import coffeemaker.domain.Recipe;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RecipeTest {
    private Recipe CuT;

    @BeforeEach
    public void setUp() {
        CuT = new Recipe();
    }

    @AfterEach
    public void tearDown() {
        CuT = null;
    }

    @Test
    @DisplayName("Sanity Check")
    public void sanityCheck() {
        assertTrue(true, "This should always pass");
    }

    @Test
    @DisplayName("Check Name")
    public void checkName() {
        assertNotNull(CuT.getName(), "Testing Recipe Name");
    }

    @Test
    @DisplayName("Check Price")
    public void checkPrice() {
        assertTrue(CuT.getPrice() > -1, "Testing Recipe Price");
    }

    @Test
    @DisplayName("Check Coffee Amount")
    public void checkCoffeeAmount() {
        assertTrue(CuT.getAmtCoffee() > -1, "Testing Recipe Coffee Amount");
    }

    @Test
    @DisplayName("Check Milk Amount")
    public void checkMilkAmount() {
        assertTrue(CuT.getAmtMilk() > -1, "Testing Recipe Milk Amount");
    }

    @Test
    @DisplayName("Check Sugar Amount")
    public void checkSugarAmount() {
        assertTrue(CuT.getAmtSugar() > -1, "Testing Recipe Sugar Amount");
    }

    @Test
    @DisplayName("Check Chocolate Amount")
    public void checkChocolateAmount() {
        assertTrue(CuT.getAmtChocolate() > -1, "Testing Recipe Chocolate Amount");
    }
}
