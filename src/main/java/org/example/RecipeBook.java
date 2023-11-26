package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RecipeBook {

    private String bookName;
    private ArrayList<CookingRecipe> recipes;

    public RecipeBook(String bookName) {
        this.bookName = bookName;
        recipes = new ArrayList<>();
    }

    public CookingRecipe addRecipe(String name, RecipeIngredient[] ingredients) {
        if (findRecipeByName(name) == null) {
            CookingRecipe recipe = new CookingRecipe(name, ingredients);
            recipes.add(recipe);
            return recipe;
        }
        return null;
    }

    public CookingRecipe removeRecipe(String name) {
        CookingRecipe r = findRecipeByName(name);
        if (r == null) {
            return null;
        }
        recipes.remove(r);
        return r;
    }

    public CookingRecipe findRecipeByName(String name) {
        for (CookingRecipe r : recipes) {
            if (r.getName().equals(name)) {
                return r;
            }
        }
        return null;
    }

    public CookingRecipe[] findRecipes(RecipeIngredient[] ingredients) {
        ArrayList<CookingRecipe> foundRecipes = new ArrayList<>();
        for (CookingRecipe r : recipes) {
            boolean allFound = true;
            for (Ingredient i : ingredients) {
                if (r.getRecipeIngredient(i) == null) {
                    allFound = false;
                    break;
                }
            }
            if (allFound) {
                foundRecipes.add(r);
            }
        }
        if (foundRecipes.size() == 0) {
            return null;
        }
        CookingRecipe[] foundRecipesArray = new CookingRecipe[foundRecipes.size()];
        for (int i = 0; i < foundRecipes.size(); i++) {
            foundRecipesArray[i] = foundRecipes.get(i);
        }
        return foundRecipesArray;
    }

    public CookingRecipe[] findRecipesWithFewIngredients(int numberOfIngredients) {
        ArrayList<CookingRecipe> foundRecipes = new ArrayList<>();
        for (CookingRecipe r : recipes) {
            if (r.getNumberOfIngredients() <= numberOfIngredients) {
                foundRecipes.add(r);
            }
        }
        if (foundRecipes.size() == 0) {
            return null;
        }
        CookingRecipe[] foundRecipesArray = new CookingRecipe[foundRecipes.size()];
        for (int i = 0; i < foundRecipes.size(); i++) {
            foundRecipesArray[i] = foundRecipes.get(i);
        }
        return foundRecipesArray;
    }

}
