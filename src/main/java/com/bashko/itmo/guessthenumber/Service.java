package com.bashko.itmo.guessthenumber;

import javafx.stage.Stage;

import java.util.Random;
import java.util.Stack;

public class Service {

    // контейнер объектов Stage (основного игрового поля) для доступа с целью закрытия
    private static Service instance;

    private static Stack<Stage> stageStack = new Stack<>();

    private  int desireNumber;
    private static int numberOfAttempts;

    private Service() {
    }

    public static Service getInstance() {
        if (instance == null) return new Service();
        return instance;
    }

    public Stack<Stage> getStageStack() {
        return stageStack;
    }

    public int getDesireNumber() {
        return desireNumber;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public void playRules(String level) {
        if (level.equals("Easy")) {
            desireNumber = (int) (Math.random() * 10);
            numberOfAttempts = 3;
        } else if (level.equals("Medium")) {
            desireNumber = (int) (Math.random() * 100);
            numberOfAttempts = 10;
        } else {
            Random random = new Random(1000);
            desireNumber = (int) (Math.random() * 1000);
            numberOfAttempts = 15;
        }
    }

    public int guessNumber(int parseInt) {
        if (parseInt > desireNumber) {
            numberOfAttempts--;
            return 1;
        } else if (parseInt < desireNumber) {
            numberOfAttempts--;
            return -1;
        } else return 0;
    }
}
