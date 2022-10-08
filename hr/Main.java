package ru.hh.hr;

import java.util.*;


public class Main {

    private static int maxSalarySum = 0;
    private static ArrayList<Integer> firstStack = new ArrayList<>();
    private static ArrayList<Integer> secondStack = new ArrayList<>();


    public static void main(String[] args) {
        int firstStackSize = 0;
        int secondStackSize = 0;
        int firstStackSalariesSum = 0;
        int secondStackSalariesSum = 0;

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
        maxSalarySum = 13;
        firstStack = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        secondStack = new ArrayList<>(Arrays.asList(1, 2, 3, 3, 1));
//        ---------------------------------------------------------------------------------------------------------

//        Scanner sc = new Scanner(System.in);
//        String input = sc.nextLine().trim();
//        String[] inputData = input.split(" ");
//        firstStackSize = Integer.parseInt(inputData[0]);
//        secondStackSize = Integer.parseInt(inputData[1]);
//        maxSalarySum = Integer.parseInt(inputData[2]);
//
//
//        int maxSize = Math.max(firstStackSize, secondStackSize);
//        for (int i = 0; i < maxSize; i++) {
//            String lineInput = sc.nextLine().trim();
//            String[] data = lineInput.split(" ");
//            if (!data[0].equals("-")) {
//                int inputOne = Integer.parseInt(data[0]);
//                firstStack.add(inputOne);
////               firstStackSalariesSum += inputOne;
//            }
//            if (!data[1].equals("-")) {
//                int inputTwo = Integer.parseInt(data[1]);
//                secondStack.add(inputTwo);
////                secondStackSalariesSum += inputTwo;
//            }
//        }
//        sc.close();

        firstStackSalariesSum = getStackSalariesSum(firstStack);
        secondStackSalariesSum = getStackSalariesSum(secondStack);

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
                salarySum += secondStack.get(0);
                secondStack.remove(0);
            } else if (secondStack.isEmpty()) {
                salarySum += firstStack.get(0);
                firstStack.remove(0);
            } else {
                if (firstStack.get(0) < secondStack.get(0)) {

                } if (firstStack.get(0) > secondStack.get(0)) {
                    salarySum += secondStack.get(0);
                    secondStack.remove(0);
                }else if(getStackSalariesSum(firstStack) > getStackSalariesSum(secondStack)){
                    salarySum += secondStack.get(0);
                    secondStack.remove(0);
                }else {
                    salarySum += firstStack.get(0);
                    firstStack.remove(0);
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
        for (int i = 0; i < stack.size(); i++) {
            stackSalariesSum += stack.get(i);
        }
        return stackSalariesSum;
    }
}



