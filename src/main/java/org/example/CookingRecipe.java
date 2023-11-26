package org.example;

import java.util.ArrayList;

public class CookingRecipe {

    private String name;
    private ArrayList<RecipeIngredient> ingredients;

    public CookingRecipe(String name) {
        this.name = name;
        ingredients = new ArrayList<>();
    }

    public CookingRecipe(String name, RecipeIngredient[] ingredients) {
        this.name = name;
        this.ingredients = new ArrayList<>();
        for (RecipeIngredient i : ingredients) {
            this.ingredients.add(i);
        }
    }

    public String getName() {
        return name;
    }

    public void addOrUpdateRecipeIngredient(Ingredient ingredient, float quantity) {
        RecipeIngredient newIngredient = getRecipeIngredient(ingredient);
        if (newIngredient == null) {
            ingredients.add(new RecipeIngredient(ingredient.getName(), ingredient.getMeasuringUnit(), ingredient.getCaloriesPerUnit(), quantity));
        } else {
            newIngredient.setQuantity(quantity);
        }
    }

    public RecipeIngredient getRecipeIngredient(Ingredient ingredient) {
        return getRecipeIngredient(ingredient.getName());
    }

    public RecipeIngredient getRecipeIngredient(String ingredientName) {
        for(RecipeIngredient ing : ingredients) {
            if (ing.getName().equals(ingredientName)) {
                return ing;
            }
        }
        return null;
    }

    public RecipeIngredient removeRecipeIngredient(Ingredient ingredient) {
        return removeRecipeIngredient(ingredient.getName());
    }

    public RecipeIngredient removeRecipeIngredient(String ingredientName) {
        RecipeIngredient remove = getRecipeIngredient(ingredientName);
        if (remove == null) {
            return null;
        }
        ingredients.remove(remove);
        return remove;
    }

    public float calculateCalories() {
        float calories = 0;
        for (RecipeIngredient i : ingredients) {
            calories += i.getCaloriesPerUnit() * i.getQuantity();
        }
        return calories;
    }

    public int getNumberOfIngredients() {
        return ingredients.size();
    }

    public String toString() {
        return name + ingredients;
    }

}
