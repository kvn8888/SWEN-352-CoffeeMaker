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

        /*
         * NOTE: test fails if we don't assign names!
         */

        recipe1.setName("recipe1");
        recipe2.setName("recipe2");

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

        recipe1.setName("recipe1");
        recipe2.setName("recipe2");
        recipe3.setName("recipe3");
        recipe4.setName("recipe4");
        recipe5.setName("recipe5");

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
        assertEquals(CuT.deleteRecipe(1), "Recipe1");
        assertTrue(CuT.addRecipe(recipe1));
        assertNotEquals(CuT.deleteRecipe(0), "Recipe1");
    }
    @Test
    public void deleteRecipeTestIndex0() {
        Recipe recipe1 = new Recipe();
        recipe1.setName("Recipe1");
        assertTrue(CuT.addRecipe(recipe1));
        assertEquals(CuT.deleteRecipe(0), "Recipe1");

        assertTrue(CuT.addRecipe(recipe1));
        assertEquals(CuT.deleteRecipe(1), "Recipe1");
        assertTrue(CuT.addRecipe(recipe1));
        assertNotEquals(CuT.deleteRecipe(0), "Recipe1");

    }
    @Test
    public void deleteRecipeTestLowercase() {
        Recipe recipe1 = new Recipe();
        recipe1.setName("Recipe1");
        assertTrue(CuT.addRecipe(recipe1));
        assertEquals(CuT.deleteRecipe(0), "Recipe1");

        assertTrue(CuT.addRecipe(recipe1));
        assertNotEquals(CuT.deleteRecipe(1), "recipe1");

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
        assertEquals(CuT.replaceRecipe(0, new_recipe), "Recipe");
    }
    @Test
    public void replaceRecipeTestNewRecipeGetName() {
        Recipe recipe = new Recipe();
        Recipe new_recipe = new Recipe();
        recipe.setName("Recipe");
        new_recipe.setName("Recipe");

        CuT.addRecipe(recipe);
        assertEquals(CuT.replaceRecipe(0, new_recipe), "Recipe");
        assertEquals(new_recipe.getName(), "Recipe");
    }
    @Test
    public void replaceRecipeTestNewRecipeThreeTimes() {
        Recipe recipe = new Recipe();
        Recipe recipe1 = new Recipe();
        Recipe recipe2 = new Recipe();
        recipe.setName("Recipe");
        recipe1.setName("Recipe");
        recipe2.setName("Recipe");

        CuT.addRecipe(recipe);
        assertEquals(CuT.replaceRecipe(0, recipe1), "Recipe");
        assertEquals(CuT.replaceRecipe(0, recipe2), "Recipe");
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
