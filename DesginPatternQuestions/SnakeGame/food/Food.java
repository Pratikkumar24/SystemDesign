package SnakeGame.food;

import SnakeGame.foodtype.FoodType;
import SnakeGame.foodvalue.FoodStrategy;

public class Food {
    int foodId;
    FoodStrategy foodStrategy;
    FoodType foodType;
    int row, col;
    public Food(int row, int col, FoodStrategy foodStrategy, FoodType foodType) {
        this.row = row;
        this.col = col;
        this.foodStrategy = foodStrategy;
        this.foodType = foodType;
    }

    public void setFoodStrategy(FoodStrategy foodStrategy) {
        this.foodStrategy = foodStrategy;
    }

    public FoodType getFoodType() {
        return this.foodType;
    }
}
