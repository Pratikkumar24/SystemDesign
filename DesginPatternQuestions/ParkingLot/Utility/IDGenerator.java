package Utility;

import java.util.Random;

public interface IDGenerator {
    Random random = new Random();
    int generateId();
}
