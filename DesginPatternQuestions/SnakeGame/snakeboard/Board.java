package SnakeGame.snakeboard;

import java.util.HashSet;
import java.util.List;

import SnakeGame.FoodFactory.FoodValueFactory;
import SnakeGame.coordinateGenerator.Generator;
import SnakeGame.food.Food;
import SnakeGame.foodtype.FoodType;
import SnakeGame.foodvalue.FoodStrategy;
import SnakeGame.snake.Snake;

public class Board {
    int[][] snakeBoard;
    int n, m;
    Food food;
    Snake snake;
    public static Board boardInstance;
    public FoodValueFactory factory;
    HashSet<List<Integer>> snakeSet;
    HashSet<List<Integer>> foodSet;
    
    private Board(){}

    public static Board getInstance() {
        if (boardInstance == null) {
            synchronized(Board.class) {
                boardInstance = new Board();
            }
        }
        return boardInstance;
    }

    public void setSizeOfBoard(int row, int col) {
        this.n = row;
        this.m = col;
        snakeBoard = new int[n][m];
        initializeSnakeAndFood();
    }

    public Snake getSnake() {
        return this.snake;
    }

    public void initializeSnakeAndFood() {
        snakeSet = new HashSet<>();
        foodSet = new HashSet<>();

        factory = new FoodValueFactory();
        this.snake = new Snake(n-1, 0);
        snakeSet.add(List.of(n-1, 0));

        int[] foodCoordinate = Generator.generateCoordinatePoint(this);
        FoodStrategy strategy = factory.getFoodStrategy(FoodType.POWER_UP_FOOD);
        foodSet.add(List.of(foodCoordinate[0], foodCoordinate[1]));

        if (foodCoordinate[0] == -1) {
            System.out.println("---------------------YOU ARE OUT-----------------");
            return;
        }
        this.food = new Food(foodCoordinate[0], foodCoordinate[1], strategy, FoodType.POWER_UP_FOOD);

        displayBoard();
    }

    public int[][] getSnakeBoard() {
        return this.snakeBoard;
    }

    public int[] getMatrixSize() {
        return new int[]{n, m};
    }
    public void displayBoard() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if (snakeSet.contains(List.of(i, j))) {
                    System.out.print(" * ");
                }
                else if(foodSet.contains(List.of(i, j))) {
                    System.out.print(" F ");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
    }
}
