package coffeemaker;

import static org.junit.jupiter.api.Assertions.*;

import coffeemaker.domain.Inventory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class InventoryTest {
    private Inventory inventory;

    @BeforeEach
    public void setUp() {
        inventory = new Inventory();
    }

    @AfterEach
    public void tearDown() {
        inventory = null;
    }

    @Test
    @DisplayName("Default inventory values")
    public void testDefaultInventoryValues() {
        assertAll(
                () -> assertEquals(15, inventory.getCoffee(), "Default coffee value should be 15"),
                () -> assertEquals(15, inventory.getCoffee(), "Default milk value should be 15"),
                () -> assertEquals(15, inventory.getCoffee(), "Default sugar value should be 15"),
                () -> assertEquals(15, inventory.getCoffee(), "Default chocolate value should be 15")
        );
    }

    @Test
    @DisplayName("Setting a positive coffee value should update")
    public void testSetCoffeePositiveValue() {
        inventory.setCoffee(10);
        assertEquals(10, inventory.getCoffee(), "Coffee value should be updated to 10");
    }

    @Test
    @DisplayName("Setting a negative coffee value does not update")
    public void testSetCoffeeNegativeValue(){
        inventory.setCoffee(-5);
        assertEquals(15, inventory.getCoffee(), "Coffee value should be updated to 10");
    }

    @Test
    @DisplayName("Adding valid coffee amount updates inventory correctly")
    public void testAddCoffeeValidValue() {
        inventory.addCoffee("5");
        assertEquals(20, inventory.getCoffee(), "Coffee value should be updated to 20 after adding 5");
    }














}