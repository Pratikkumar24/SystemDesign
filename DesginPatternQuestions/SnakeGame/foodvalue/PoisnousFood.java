package SnakeGame.foodvalue;

import SnakeGame.snakeboard.Board;


public class PoisnousFood implements FoodStrategy {
    @Override
    public int generateFoodValue(Board board) {
        return -1;
    }
}
