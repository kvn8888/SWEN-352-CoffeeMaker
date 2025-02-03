package coffeemaker;

import static org.junit.jupiter.api.Assertions.*;

import coffeemaker.domain.Recipe;
import coffeemaker.exceptions.RecipeException;
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
    @DisplayName("Recipe Constructor Test")
    public void recipeConstructorTest() {
        assertNotNull(CuT, "Recipe should not be null");
    }

    @Test
    @DisplayName("Test Default Name")
    public void testDefaultName() {
        assertNotNull(CuT.getName(), "Testing Recipe Name");
    }

    @Test
    @DisplayName("Test Set Name")
    public void testSetName() {
        CuT.setName("Test Name");
        assertEquals("Test Name", CuT.getName(), "Test Set Recipe Name");
        CuT.setName(null);
        assertNotNull(CuT.getName(), "Test that null case is handled correctly");
    }

    @Test
    @DisplayName("Test Default Price")
    public void checkDefaultPrice() {
        assertTrue(CuT.getPrice() > -1, "Testing Recipe Price");
    }

    @Test
    @DisplayName("Test Default Coffee Amount")
    public void testDefaultCoffeeAmount() {
        assertTrue(CuT.getAmtCoffee() > -1, "Testing Default Recipe Coffee Amount");
    }

    @Test
    @DisplayName("Test Default Milk Amount")
    public void testDefaultMilkAmount() {
        assertTrue(CuT.getAmtMilk() > -1, "Testing Default Recipe Milk Amount");
    }

    @Test
    @DisplayName("Test Default Sugar Amount")
    public void testDefaultSugarAmount() {
        assertTrue(CuT.getAmtSugar() > -1, "Testing Default Recipe Sugar Amount");
    }

    @Test
    @DisplayName("Test Chocolate Amount")
    public void ChocolateAmount() {
        assertTrue(CuT.getAmtChocolate() > -1, "Testing Default Recipe Chocolate Amount");
    }

    @Test
    @DisplayName("Test Set Price")
    public void testSetPrice() {
        CuT.setPrice("1");
        assertEquals(1, CuT.getPrice(), "Test Set Price to 1");
        assertThrows(RecipeException.class, () -> CuT.setPrice("-1"));
        assertThrows(RecipeException.class, () -> CuT.setPrice("test"));
    }

    @Test
    @DisplayName("Test Set Coffee Amount")
    public void testSetCoffeeAmount() {
        CuT.setAmtCoffee("100");
        assertEquals(100, CuT.getAmtCoffee(), "Test Set Coffee Amount to 100");
        assertThrows(RecipeException.class, () -> CuT.setAmtCoffee("-20"));
        assertThrows(RecipeException.class, () -> CuT.setAmtCoffee("test"));
    }

    @Test
    @DisplayName("Test Set Milk Amount")
    public void testSetMilkAmount() {
        CuT.setAmtMilk("100");
        assertEquals(100, CuT.getAmtMilk(), "Test Set Milk Amount to 100");
        assertThrows(RecipeException.class, () -> CuT.setAmtMilk("-20"));
        assertThrows(RecipeException.class, () -> CuT.setAmtMilk("test"));
    }

    @Test
    @DisplayName("Test Set Sugar Amount")
    public void testSetSugarAmount() {
        CuT.setAmtSugar("100");
        assertEquals(100, CuT.getAmtSugar(), "Test Set Sugar Amount to 100");
        assertThrows(RecipeException.class, () -> CuT.setAmtSugar("-20"));
        assertThrows(RecipeException.class, () -> CuT.setAmtSugar("test"));
    }

    @Test
    @DisplayName("Test Set Chocolate Amount")
    public void testSetChocolateAmount() {
        CuT.setAmtChocolate("100");
        assertEquals(100, CuT.getAmtChocolate(), "Test Set Chocolate Amount to 100");
        assertThrows(RecipeException.class, () -> CuT.setAmtChocolate("-20"));
        assertThrows(RecipeException.class, () -> CuT.setAmtChocolate("test"));
    }

    @Test
    @DisplayName("Test toString")
    public void testToString() {
        assertNotNull(CuT.toString(), "Testing Recipe toString");
    }

    @Test
    @DisplayName("Test Hash Code")
    public void testHashCode() {
        String testName = "This is a test name";
        int expected =  testName.hashCode();
        CuT.setName(testName);
        assertEquals(expected, CuT.hashCode(), "Test Hash Code");
    }

    @Test
    @DisplayName("Test Recipe Equals Self")
    public void testEqualsSelf(){
        assertTrue(CuT.equals(CuT), "Test Recipe Equals Self");
    }

    @Test
    @DisplayName("Test Null Returns False")
    public void testNullReturnFalse(){
        assertFalse(CuT.equals(null), "Test Null Returns False");
    }

    @Test
    @DisplayName("Test Equal Class Type")
    public void testEqualClassType(){
        String testString = "foo";
        assertFalse(CuT.equals(testString), "Test two objects of different types return false equality");
    }

    @Test
    @DisplayName("Test Equality with Recipe name")
    public void testEqualityWithRecipeName(){
        CuT.setName("Recipe1");
        Recipe CuT2 = new Recipe();
        CuT2.setName(CuT.getName());

        assertTrue(CuT.equals(CuT2));
    }

}
