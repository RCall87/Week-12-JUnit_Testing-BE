package com.promineotech;

import java.util.Random;

public class TestDemo {
    
    public int addPositive(int a, int b) {
        if (a > 0 && b > 0) {
            return a + b;
        } else {
            throw new IllegalArgumentException("Both parameters must be positive!");
        }
    }
    
    public int randomNumberSquared() {
        int randomValue = getRandomInt();
        return randomValue * randomValue;
    }

    int getRandomInt() {
        Random random = new Random();
        return random.nextInt(10) + 1;
    }

    // Step 3: Custom method added below
    public int multiply(int a, int b) {
        return a * b;
    }
}
