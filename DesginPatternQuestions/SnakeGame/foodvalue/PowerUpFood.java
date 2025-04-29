package SnakeGame.foodvalue;
import SnakeGame.snakeboard.Board;

public class PowerUpFood implements FoodStrategy{
    @Override
    public int generateFoodValue(Board board) {
        return 3;
    }
}
