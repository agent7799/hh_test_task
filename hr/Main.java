package ru.hh.hr;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    public static int maxSalarySum = 0;
    public static ArrayList<Integer> firstStack = new ArrayList<>();
    public static ArrayList<Integer> secondStack = new ArrayList<>();
    public static int firstStackSalariesSum = 0;
    public static int secondStackSalariesSum = 0;
    public static int firstStackSize = 0;
    public static int secondStackSize = 0;
    public static int expectedResult;

    public static void main(String[] args) {

//        ---------------------------------------------------------------------------------------------------------
//        firstStackSize = 5;
//        secondStackSize = 5;
//        maxSalarySum = 10;
//
//        firstStack.add(5);
//        firstStack.add(1);
//        firstStack.add(1);
//        firstStack.add(1);
//        firstStack.add(1);
//
//        secondStack.add(1);
//        secondStack.add(3);
//        secondStack.add(3);
//        secondStack.add(3);
//        secondStack.add(3);
//        ---------------------------------------------------------------------------------------------------------

//
//        int firstStackSize = 6;
//        int secondStackSize = 4;
//        maxSalarySum = 10;
//        firstStack = new ArrayList<>(Arrays.asList(4, 2, 4, 6, 1, 7));
//        secondStack = new ArrayList<>(Arrays.asList(2, 1, 8, 5));
//        expectedResult = 4;
//        ---------------------------------------------------------------------------------------------------------
//        firstStackSize = 4;
//        secondStackSize = 3;
//        maxSalarySum = 11;
//        firstStack = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
//        secondStack = new ArrayList<>(Arrays.asList(1, 2, 3));
//        expectedResult = 5;
//        ---------------------------------------------------------------------------------------------------------
//        firstStackSize = 5;
//        secondStackSize = 5;
//        maxSalarySum = 10;
//        firstStack = new ArrayList<>(Arrays.asList(1,3, 3, 3, 3));
//        secondStack = new ArrayList<>(Arrays.asList(5, 1, 1, 1, 1));
//        expectedResult = 6;
//        ---------------------------------------------------------------------------------------------------------
//        ---------------------------------------------------------------------------------------------------------
//        firstStackSize = 5;
//        secondStackSize = 5;
//        maxSalarySum = 10;
//        firstStack = new ArrayList<>(Arrays.asList(9, 1, 1, 1, 1));
//        secondStack = new ArrayList<>(Arrays.asList(11, 3, 3, 3, 3));
//        expectedResult = 2;
//        ---------------------------------------------------------------------------------------------------------
//        ---------------------------------------------------------------------------------------------------------
//        firstStackSize = 1;
//        secondStackSize = 5;
//        maxSalarySum = 5;
//        firstStack = new ArrayList<>(Arrays.asList(4));
//        secondStack = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 2));
//        expectedResult = 5;
//        ---------------------------------------------------------------------------------------------------------

        inputInitialData();
        firstStackSalariesSum = getStackSalariesSum(firstStack);
        secondStackSalariesSum = getStackSalariesSum(secondStack);

        int result;
        int initialSTurn = 0;
        int initialSalarySum = 0;
        if (firstStackSalariesSum <= maxSalarySum & firstStack.size() > secondStack.size()) {
            initialSTurn = firstStack.size();
            initialSalarySum = firstStackSalariesSum;
        } else if (secondStackSalariesSum <= maxSalarySum & secondStack.size() > firstStack.size()) {
            initialSTurn = secondStack.size();
            initialSalarySum = secondStackSalariesSum;
        }
        result = getMaxTurns(initialSalarySum, initialSTurn, new ArrayList<>(firstStack), new ArrayList<>(secondStack));
        System.out.println(result);
    }

    public static int getMaxTurns(int initialSalarySum, int initialTurn, ArrayList<Integer> firstStack, ArrayList<Integer> secondStack) {
        int turn = initialTurn;
        int salarySum = initialSalarySum;
        while (true) {
            if (firstStack.isEmpty() && secondStack.isEmpty()) {
                break;
            } else if (firstStack.isEmpty()) {
                salarySum += secondStack.get(0);
                secondStack.remove(0);
            } else if (secondStack.isEmpty()) {
                salarySum += firstStack.get(0);
                firstStack.remove(0);
            } else {
                if (firstStack.get(0) <= secondStack.get(0)) {
                    salarySum += firstStack.get(0);
                    firstStack.remove(0);
                    salarySum += secondStack.get(0);
                    secondStack.remove(0);
                }
            }
            if (salarySum <= maxSalarySum) {
                turn++;
            } else {
                break;
            }
        }
        return turn;
    }

    public static int getStackSalariesSum(ArrayList<Integer> stack) {
        int stackSalariesSum = 0;
        for (Integer integer : stack) {
            stackSalariesSum += integer;
        }
        return stackSalariesSum;
    }

    public static void inputInitialData() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] inputData = br.readLine().split(" ");
            firstStackSize = Integer.parseInt(inputData[0]);
            secondStackSize = Integer.parseInt(inputData[1]);
            maxSalarySum = Integer.parseInt(inputData[2]);
            for (int i = 0; i < Math.max(firstStackSize, secondStackSize); i++) {
                String[] data = br.readLine().split(" ");
                if (!data[0].equals("-")) {
                    int inputOne = Integer.parseInt(data[0]);
                    firstStack.add(inputOne);
                }
                if (!data[1].equals("-")) {
                    int inputTwo = Integer.parseInt(data[1]);
                    secondStack.add(inputTwo);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



