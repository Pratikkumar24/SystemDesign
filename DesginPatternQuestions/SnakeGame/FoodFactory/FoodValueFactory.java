package SnakeGame.FoodFactory;

import SnakeGame.foodtype.FoodType;
import SnakeGame.foodvalue.FoodStrategy;
import SnakeGame.foodvalue.PoisnousFood;
import SnakeGame.foodvalue.PowerUpFood;

public class FoodValueFactory {
    public FoodStrategy getFoodStrategy(FoodType type) {
        switch (type) {
            case POISNOUS_FOOD:
                return new PoisnousFood();
            case POWER_UP_FOOD:
                return new PowerUpFood();
            default:
                return null;
        }
    }
}
