package coffeemaker;

import static org.junit.jupiter.api.Assertions.*;

import coffeemaker.domain.Inventory;
import coffeemaker.domain.Recipe;
import coffeemaker.exceptions.InventoryException;
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
                () -> assertEquals(15, inventory.getCoffee(), "Default coffee should be 15"),
                () -> assertEquals(15, inventory.getMilk(), "Default milk should be 15"),
                () -> assertEquals(15, inventory.getSugar(), "Default sugar should be 15"),
                () -> assertEquals(15, inventory.getChocolate(), "Default chocolate should be 15")
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


    @Test
    @DisplayName("Adding invalid coffee amount throws InventoryException")
    public void testAddCoffeeInvalidFormat() {
        InventoryException exception = assertThrows(InventoryException.class, () -> inventory.addCoffee("abc"),
                "Adding invalid coffee amount should throw InventoryException");
        assertEquals("Units of coffee must be a positive integer", exception.getMessage());
    }

    @Test
    @DisplayName("Adding negative coffee amount throws InventoryException")
    public void testAddCoffeeNegativeValue() {
        InventoryException exception = assertThrows(InventoryException.class, () -> inventory.addCoffee("-5"),
                "Adding negative coffee amount should throw InventoryException");
        assertEquals("Units of coffee must be a positive integer", exception.getMessage());
    }

    @Test
    @DisplayName("Setting a positive milk value updates correctly")
    public void testSetMilkPositiveValue() {
        inventory.setMilk(10);
        assertEquals(10, inventory.getMilk(), "Milk value should be updated to 10");
    }

    @Test
    @DisplayName("Setting a negative milk value does not update")
    public void testSetMilkNegativeValue() {
        inventory.setMilk(-10);
        assertEquals(15, inventory.getMilk(), "Milk value should remain 15 when set to a negative number");
    }

    @Test
    @DisplayName("Adding valid milk amount updates inventory correctly")
    public void testAddMilkValidValue() throws InventoryException {
        inventory.addMilk("10");
        assertEquals(25, inventory.getMilk(), "Milk value should be updated to 25 after adding 10");
    }

    @Test
    @DisplayName("Adding invalid milk amount throws InventoryException")
    public void testAddMilkInvalidFormat() {
        InventoryException exception = assertThrows(InventoryException.class, () -> inventory.addMilk("abc"),
                "Adding invalid milk amount should throw InventoryException");
        assertEquals("Units of milk must be a positive integer", exception.getMessage());
    }

    @Test
    @DisplayName("Adding negative milk amount throws InventoryException")
    public void testAddMilkNegativeValue() {
        InventoryException exception = assertThrows(InventoryException.class, () -> inventory.addMilk("-10"),
                "Adding negative milk amount should throw InventoryException");
        assertEquals("Units of milk must be a positive integer", exception.getMessage());
    }

    @Test
    @DisplayName("String representation of inventory is correct")
    public void testToString() {
        String expectedOutput = "Coffee: 15\nMilk: 15\nSugar: 15\nChocolate: 15\n";
        assertEquals(expectedOutput, inventory.toString(), "Inventory string representation should match expected output");
    }

    @Test
    @DisplayName("Setting sugar to a positive value should update it")
    public void testSetSugarPositiveValue() {
        inventory.setSugar(10);
        assertEquals(10, inventory.getSugar());
    }

    @Test
    @DisplayName("Adding valid sugar amount updates inventory correctly")
    public void testAddSugarValidValue() throws InventoryException {
        inventory.addSugar("10");
        assertEquals(25, inventory.getSugar(), "Sugar value should be updated to 25 after adding 10");
    }

    @Test
    @DisplayName("Setting sugar to a negative value should not change it")
    public void testSetSugarNegativeValue() {
        inventory.setSugar(-5);
        assertEquals(15, inventory.getSugar());
    }

    @Test
    @DisplayName("Adding invalid sugar amount throws InventoryException")
    public void testAddSugarInvalidFormat() {
        InventoryException exception = assertThrows(InventoryException.class, () -> inventory.addSugar("abc"),
                "Adding invalid sugar amount should throw InventoryException");
        assertEquals("Units of sugar must be a positive integer", exception.getMessage());
    }

    @Test
    @DisplayName("Adding negative sugar amount throws InventoryException")
    public void testAddSugarNegativeValue() {
        InventoryException exception = assertThrows(InventoryException.class, () -> inventory.addSugar("-5"),
                "Adding negative sugar amount should throw InventoryException");
        assertEquals("Units of sugar must be a positive integer", exception.getMessage());
    }

    @Test
    @DisplayName("Adding valid chocolate amount updates inventory correctly")
    public void testAddChocolateValidValue() throws InventoryException {
        inventory.addChocolate("5");
        assertEquals(20, inventory.getChocolate(), "Chocolate value should be updated to 20 after adding 5");
    }

    @Test
    @DisplayName("Setting chocolate to a positive value should update it")
    public void testSetChocolatePositiveValue() {
        inventory.setChocolate(10);
        assertEquals(10, inventory.getChocolate());
    }

    @Test
    @DisplayName("Setting chocolate to a negative value should not change it")
    public void testSetChocolateNegativeValue() {
        inventory.setChocolate(-5);
        assertEquals(15, inventory.getChocolate());
    }

    @Test
    @DisplayName("Adding invalid chocolate amount throws InventoryException")
    public void testAddChocolateInvalidFormat() {
        InventoryException exception = assertThrows(InventoryException.class, () -> inventory.addChocolate("3.5"),
                "Adding invalid chocolate amount should throw InventoryException");
        assertEquals("Units of chocolate must be a positive integer", exception.getMessage());
    }

    @Test
    @DisplayName("Adding negative chocolate amount throws InventoryException")
    public void testAddChocolateNegativeValue() {
        InventoryException exception = assertThrows(InventoryException.class, () -> inventory.addChocolate("-2"),
                "Adding negative chocolate amount should throw InventoryException");
        assertEquals("Units of chocolate must be a positive integer", exception.getMessage());
    }

    @Test
    @DisplayName("useIngredients updates inventory correctly")
    public void testUseIngredients() {
        Recipe recipe = new Recipe();
        recipe.setAmtCoffee("5");
        recipe.setAmtMilk("5");
        recipe.setAmtSugar("5");
        recipe.setAmtChocolate("5");

        assertTrue(inventory.useIngredients(recipe), "useIngredients should return true when ingredients are sufficient");

        assertEquals(10, inventory.getCoffee(), "Coffee should be reduced by 5");
        assertEquals(10, inventory.getMilk(), "Milk should be reduced by 5");
        assertEquals(10, inventory.getSugar(), "Sugar should be reduced by 5");
        assertEquals(10, inventory.getChocolate(), "Chocolate should be reduced by 5");

        recipe.setAmtCoffee("20");
        assertFalse(inventory.useIngredients(recipe), "Should return false if ingredients are insufficient");
    }



}