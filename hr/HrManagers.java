package ru.hh.hr;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


@Slf4j
public class HrManagers {

    public static int maxSalarySum = 0;
    public static ArrayList<Integer> firstStack = new ArrayList<>();
    public static ArrayList<Integer> secondStack = new ArrayList<>();
    public static int firstStackSalariesSum = 0;
    public static int secondStackSalariesSum = 0;
    public static int firstStackSize = 0;
    public static int secondStackSize = 0;


    public static void main(String[] args) {
//        ---------------------------------------------------------------------------------------------------------
////
//         firstStackSize = 6;
//         secondStackSize = 4;
//        maxSalarySum = 10;
//        firstStack = new ArrayList<>(Arrays.asList(4, 2, 4, 6, 1, 7));
//        secondStack = new ArrayList<>(Arrays.asList(2, 1, 8, 5));
//        ---------------------------------------------------------------------------------------------------------
//        int firstStackSize = 3;
//        int secondStackSize = 4;
//        maxSalarySum = 11;
//        firstStack = new ArrayList<>(Arrays.asList(1, 2, 3));
//        secondStack = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
//        ---------------------------------------------------------------------------------------------------------
//        firstStackSize = 5;
//        secondStackSize = 5;
//        maxSalarySum = 10;
//        firstStack = new ArrayList<>(Arrays.asList(5, 1, 1, 1, 1));
//        secondStack = new ArrayList<>(Arrays.asList(1, 3, 3, 3, 3));

//        ---------------------------------------------------------------------------------------------------------
        firstStackSize = 4;
        secondStackSize = 5;
        maxSalarySum = 14;
        firstStack = new ArrayList<>(Arrays.asList(1, 2, 3, 3, 1, 3, 1, 2));
        secondStack = new ArrayList<>(Arrays.asList(1, 2, 3, 3, 2, 3, 2, 3));
//        ---------------------------------------------------------------------------------------------------------

        //inputInitialData();
        firstStackSalariesSum = getStackSalariesSum(firstStack);
        secondStackSalariesSum = getStackSalariesSum(secondStack);

        log.info("maxSalarySum: " + maxSalarySum);
        log.info("firstStack: " + firstStack + ", firstStackSize: " + firstStack.size() + ", firstStackSalariesSum: " + firstStackSalariesSum);
        log.info("secondStack: " + secondStack + ", secondStackSize: " + secondStack.size() + ", secondStackSalariesSum: " + secondStackSalariesSum);

        boolean isFirstStackOkBySum = firstStackSalariesSum <= maxSalarySum;
        boolean isSecondStackOkBySum = secondStackSalariesSum <= maxSalarySum;
        int result;

        if ((isFirstStackOkBySum & !isSecondStackOkBySum)
                || (isFirstStackOkBySum & isSecondStackOkBySum & (firstStackSize > secondStackSize))
        ) {
            result = getMaxTurns(firstStackSalariesSum, firstStackSize, new ArrayList<>(), new ArrayList<>(secondStack));
        } else if ((isSecondStackOkBySum & !isFirstStackOkBySum)
                || ((isFirstStackOkBySum & isSecondStackOkBySum) & firstStackSize < secondStackSize))
        {
            result = getMaxTurns(secondStackSalariesSum, secondStackSize, new ArrayList<>(firstStack), new ArrayList<>());
        } else {
            result = getMaxTurns(0, 0, new ArrayList<>(firstStack), new ArrayList<>(secondStack));
        }

        System.out.println(result);
    }

    public static int getMaxTurns(int salarySum, int turn, ArrayList<Integer> firstStack, ArrayList<Integer> secondStack) {
        while (true) {
            if (firstStack.isEmpty() && secondStack.isEmpty()) {
                break;
            } else if (firstStack.isEmpty()) {
                salarySum =incrementSumAndRemove(secondStack, salarySum);
//                salarySum += secondStack.get(0);
//                secondStack.remove(0);
            } else if (secondStack.isEmpty()) {
                salarySum =incrementSumAndRemove(firstStack, salarySum);
//                salarySum += firstStack.get(0);
//                firstStack.remove(0);
            } else {
                if (firstStack.get(0) < secondStack.get(0)) {
                    salarySum =incrementSumAndRemove(firstStack, salarySum);
//                    salarySum += firstStack.get(0);
//                    firstStack.remove(0);
                } else if (firstStack.get(0) > secondStack.get(0)) {
                    salarySum =incrementSumAndRemove(secondStack, salarySum);
//                    salarySum += secondStack.get(0);
//                    secondStack.remove(0);
                }else if(getStackSalariesSum(firstStack) > getStackSalariesSum(secondStack)){
                    salarySum = incrementSumAndRemove(secondStack, salarySum);
//                    salarySum += secondStack.get(0);
//                    secondStack.remove(0);
                }else {
                    salarySum = incrementSumAndRemove(firstStack, salarySum);
//                    salarySum += firstStack.get(0);
//                    firstStack.remove(0);
                }
            }
            log.info("firstStack: " + firstStack);
            log.info("secondStack: " + secondStack);
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
//               firstStackSalariesSum += inputOne;
                    log.info("entered to firstStack: " + firstStack.get(i));
                }
                if (!data[1].equals("-")) {
                    int inputTwo = Integer.parseInt(data[1]);
                    secondStack.add(inputTwo);
//                secondStackSalariesSum += inputTwo;
                    log.info("entered to secondStack: " + secondStack.get(i));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int incrementSumAndRemove(ArrayList<Integer> stack, int salarySum){
        salarySum += stack.get(0);
        stack.remove(0);
        return salarySum;
    }
}



