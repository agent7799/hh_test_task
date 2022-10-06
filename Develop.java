package ru.hh;

import java.util.*;


public class Develop {

    private static int maxSalarySum = 0;
    private static ArrayList<Integer> firstStack = new ArrayList<>();
    private static ArrayList<Integer> secondStack = new ArrayList<>();
    private static int firstStackSalariesSum = 0;
    private static int secondStackSalariesSum = 0;
    private static int firstStackSize = 0;
    private static int secondStackSize = 0;

    public static void main(String[] args) {

//        ---------------------------------------------------------------------------------------------------------
        firstStackSize = 5;
        secondStackSize = 5;
        maxSalarySum = 10;

        firstStack.add(5);
        firstStack.add(1);
        firstStack.add(1);
        firstStack.add(1);
        firstStack.add(1);

        secondStack.add(1);
        secondStack.add(3);
        secondStack.add(3);
        secondStack.add(3);
        secondStack.add(3);
//        ---------------------------------------------------------------------------------------------------------

//
//        int firstStackSize = 6;
//        int secondStackSize = 4;
//        maxSalarySum = 10;
//
//        firstStack.add(4);
//        firstStack.add(2);
//        firstStack.add(4);
//        firstStack.add(6);
//        firstStack.add(1);
//        firstStack.add(7);
//
//        secondStack.add(2);
//        secondStack.add(1);
//        secondStack.add(8);
//        secondStack.add(5);
//        ---------------------------------------------------------------------------------------------------------

//        int firstStackSize = 3;
//        int secondStackSize = 4;
//        maxSalarySum = 11;
//
//        firstStack.add(1);
//        firstStack.add(2);
//        firstStack.add(3);
//
//        secondStack.add(1);
//        secondStack.add(2);
//        secondStack.add(3);
//        secondStack.add(4);
//        ---------------------------------------------------------------------------------------------------------
//
//        ---------------------------------------------------------------------------------------------------------

//        Scanner sc = new Scanner(System.in);
//        String input = sc.nextLine().trim();
//        String[] inputData = input.split(" ");
//        firstStackSize = Integer.parseInt(inputData[0]);
//        secondStackSize = Integer.parseInt(inputData[1]);
//        maxSalarySum = Integer.parseInt(inputData[2]);

//        int maxSize = Math.max(firstStackSize, secondStackSize);
//        for (int i = 0; i < maxSize; i++) {
//            String lineInput = sc.nextLine().trim();
//            String[] data = lineInput.split(" ");
//            if (data[0].equals("-")) {
//            } else {
//                int inputOne = Integer.parseInt(data[0]);
//                firstStack.add(inputOne);
//                firstStackSalariesSum += inputOne;
//                System.out.println("entered: " + firstStack.get(i));
//            }
//            if (data[1].equals("-")) {
//            } else {
//                int inputTwo = Integer.parseInt(data[1]);
//                secondStack.add(inputTwo);
//                secondStackSalariesSum += inputTwo;
//                System.out.println("entered: "  + secondStack.get(i));
//            }
//        }

        for (int i = 0; i < firstStack.size(); i++) {
            firstStackSalariesSum += firstStack.get(i);
        }

        for (int i = 0; i < secondStack.size(); i++) {
            secondStackSalariesSum += secondStack.get(i);
        }

        System.out.println("firstStackSize: " + firstStackSize + ", secondStackSize: " + secondStackSize + ", maxSalarySum: " + maxSalarySum);
        System.out.println("firstStack: " + firstStack);
        System.out.println("secondStack: " + secondStack);
        System.out.println("firstStackSalariesSum: " + firstStackSalariesSum + ", secondStackSalariesSum: " + secondStackSalariesSum);
        System.out.println("");


        int firstStackResult = 0;
        int secondStackResult = 0;
        int bothStacksResult = 0;

        bothStacksResult = getMaxTurns(0, 0);
        System.out.println("one by one stacks bothStacksResult: " + bothStacksResult);

        if (firstStackSalariesSum < maxSalarySum) {
            firstStack.clear();
            System.out.println("firstStackSize " + firstStackSize );
            firstStackResult = getMaxTurns(firstStackSalariesSum, firstStackSize);
            System.out.println("one by one 1st stack , firstStackResult: " + firstStackResult);
        } else {
            System.out.println("firstStackSalariesSum > maxSalarySum");
        }

        if (secondStackSalariesSum < maxSalarySum) {
            secondStack.clear();
            System.out.println("secondStackSize" + secondStackSize );
            secondStackResult = getMaxTurns(secondStackSalariesSum, secondStackSize);
            System.out.println("one by one 2nd stack, secondStackResult: " + secondStackResult);
        } else {
            System.out.println("secondStackSalariesSum > maxSalarySum");
        }
        System.out.println("---------------------------------------------------------------------");
        System.out.println("BEST RESULT IS: " + Math.max(firstStackResult, Math.max(secondStackResult, bothStacksResult)) + " TURNS");
        System.out.println("---------------------------------------------------------------------");
    }

    private static int getMaxTurns(int initialSalarySum, int initialTurn) {
        int result = initialTurn;
        int salarySum = initialSalarySum;
        ArrayList<Integer> firstStackCopy = new ArrayList<>(firstStack);
        ArrayList<Integer> secondStackCopy = new ArrayList<>(secondStack);
        while (true) {
            System.out.println("turn " + result + ": " + " salarySum: " + salarySum);
            if (firstStackCopy.isEmpty() && secondStackCopy.isEmpty()) {
                break;
            } else if (firstStackCopy.isEmpty()) {
                System.out.println(secondStackCopy.get(0) + " from " + secondStackCopy + " added");
                salarySum += secondStackCopy.get(0);
                secondStackCopy.remove(0);
            } else if (secondStackCopy.isEmpty()) {
                System.out.println(firstStackCopy.get(0) + " from " + firstStackCopy + " added");
                salarySum += firstStackCopy.get(0);
                firstStackCopy.remove(0);
            } else {
                if (firstStackCopy.get(0) < secondStackCopy.get(0)) {
                    System.out.println(firstStackCopy.get(0) + " from " + firstStackCopy + " added");
                    salarySum += firstStack.get(0);
                    firstStackCopy.remove(0);
                } else {
                    System.out.println(secondStackCopy.get(0) + " from " + secondStackCopy + " added");
                    salarySum += secondStackCopy.get(0);
                    secondStackCopy.remove(0);
                }
            }

            if (salarySum > maxSalarySum) {
                break;
            }
            result++;
        }
        System.out.println("finished at turn " + result);
        System.out.println("");
        return result;
    }
}



