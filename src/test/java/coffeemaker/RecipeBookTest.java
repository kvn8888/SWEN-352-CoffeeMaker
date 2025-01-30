package coffeemaker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import coffeemaker.domain.Recipe;
import coffeemaker.domain.RecipeBook;

public class RecipeBookTest {

    /**
     * Component under Test
     */

     private RecipeBook CuT;

     @BeforeEach
     public void setUp() {
        CuT = new RecipeBook();
     }

     @AfterEach
     public void tearDown() {
        CuT = null;
     }

    @Test
    public void getRecipesTest() {
        Recipe recipe = new Recipe();
        recipe.setName("Recipe");
        assertTrue(CuT.addRecipe(recipe));
        CuT.getRecipes();
    }

    @Test
    public void addRecipeTest() {

        /**
         * Test if adding duplicate gets rejected. And if adding is successful
         */
        Recipe recipe1 = new Recipe();

        assertTrue(CuT.addRecipe(recipe1));
    }
    @Test
    public void addRecipeTestTwoAndDuplicate() {

        /**
         * Test if adding duplicate gets rejected. And if adding is successful
         */
        Recipe recipe1 = new Recipe();
        Recipe recipe2 = new Recipe();

        assertTrue(CuT.addRecipe(recipe1));
        assertTrue(CuT.addRecipe(recipe2));
        // assertTrue(CuT.addRecipe(recipe2));
    }
    @Test
    public void addRecipeTestTwoAndDuplicateAndFull() {

        /**
         * Test if adding duplicate gets rejected. And if adding is successful
         */
        Recipe recipe1 = new Recipe();
        Recipe recipe2 = new Recipe();
        Recipe recipe3 = new Recipe();
        Recipe recipe4 = new Recipe();
        Recipe recipe5 = new Recipe();

        assertTrue(CuT.addRecipe(recipe1));
        assertTrue(CuT.addRecipe(recipe2));
        assertTrue(CuT.addRecipe(recipe3));
        assertTrue(CuT.addRecipe(recipe4));
        assertFalse(CuT.addRecipe(recipe5));
    }
    @Test
    public void addRecipeTestDuplicate() {

        /**
         * Test if adding duplicate gets rejected. And if adding is successful
         */
        Recipe recipe1 = new Recipe();

        assertTrue(CuT.addRecipe(recipe1));
        assertFalse(CuT.addRecipe(recipe1));
    }
    @Test
    public void deleteRecipeTest() {
        Recipe recipe1 = new Recipe();
        recipe1.setName("Recipe1");
        assertTrue(CuT.addRecipe(recipe1));
        assertEquals(CuT.deleteRecipe(0), "Recipe1");

        assertTrue(CuT.addRecipe(recipe1));
        assertNotEquals(CuT.deleteRecipe(0), "recipe1");
        assertTrue(CuT.addRecipe(recipe1));
        assertEquals(CuT.deleteRecipe(0), "Recipe1");

        assertNotEquals(CuT.deleteRecipe(1), "Recipe1");
        assertNotEquals(CuT.deleteRecipe(2), "Recipe1");
        assertNotEquals(CuT.deleteRecipe(3), "Recipe1");
    }
    @Test
    public void deleteRecipeTestNull() {
        Recipe recipe1 = new Recipe();
        recipe1.setName("Recipe1");
        assertTrue(CuT.addRecipe(recipe1));
        assertEquals(CuT.deleteRecipe(2), null);
    }

    @Test
    public void replaceRecipeTest() {
        Recipe recipe = new Recipe();
        Recipe new_recipe = new Recipe();
        recipe.setName("Recipe");
        new_recipe.setName("New recipe");

        CuT.addRecipe(recipe);
        assertEquals(CuT.replaceRecipe(0, new_recipe), "");
    }
    @Test
    public void replaceRecipeTestNull() {
        Recipe recipe = new Recipe();
        Recipe new_recipe = new Recipe();
        recipe.setName("Recipe");
        new_recipe.setName("New recipe");

        CuT.addRecipe(recipe);
        assertEquals(CuT.replaceRecipe(2, new_recipe), null);
    }
    
}
