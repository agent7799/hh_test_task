package ru.hh.hr;

import java.util.*;


public class Main {

    private static int maxSalarySum = 0;
    private static ArrayList<Integer> firstStack = new ArrayList<>();
    private static ArrayList<Integer> secondStack = new ArrayList<>();
    private static int firstStackSalariesSum = 0;
    private static int secondStackSalariesSum = 0;
    private static int firstStackSize = 0;
    private static int secondStackSize = 0;


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
//        firstStack = new ArrayList<>(Arrays.asList(1, 2, 3));
//        secondStack = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
//        String expectedResult = "Test 3: 5";
//        ---------------------------------------------------------------------------------------------------------
//        firstStackSize = 5;
//        secondStackSize = 5;
//        maxSalarySum = 10;
//        firstStack = new ArrayList<>(Arrays.asList(1, 3, 3, 3, 3));
//        secondStack = new ArrayList<>(Arrays.asList(5, 1, 1, 1, 1));
//        ---------------------------------------------------------------------------------------------------------

//        //        ---------------------------------------------------------------------------------------------------------
//        firstStackSize = 4;
//        secondStackSize = 5;
//        maxSalarySum = 18;
//        firstStack = new ArrayList<>(Arrays.asList(1,3, 5, 7));
//        secondStack = new ArrayList<>(Arrays.asList(1, 2, 6, 8, 1));
//        ---------------------------------------------------------------------------------------------------------


        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();
        String[] inputData = input.split(" ");
        firstStackSize = Integer.parseInt(inputData[0]);
        secondStackSize = Integer.parseInt(inputData[1]);
        maxSalarySum = Integer.parseInt(inputData[2]);


        int maxSize = Math.max(firstStackSize, secondStackSize);
        for (int i = 0; i < maxSize; i++) {
            String lineInput = sc.nextLine().trim();
            String[] data = lineInput.split(" ");
            if (!data[0].equals("-")) {
                int inputOne = Integer.parseInt(data[0]);
                firstStack.add(inputOne);
//               firstStackSalariesSum += inputOne;
//                System.out.println("entered: " + firstStack.get(i));
            }
            if (!data[1].equals("-")) {
                int inputTwo = Integer.parseInt(data[1]);
                secondStack.add(inputTwo);
//                secondStackSalariesSum += inputTwo;
//                System.out.println("entered: "  + secondStack.get(i));
            }
        }
        sc.close();

//        ------------------------------------------------------------------------------------------------------
//      FOR TEST ONLY!!!!!
//        ------------------------------------------------------------------------------------------------------
//        ------------------------------------------------------------------------------------------------------

//        System.out.println( "maxSalarySum: " + maxSalarySum);
//        System.out.print(" firstStack: " + firstStack);
//        System.out.print(", firstStackSize: " + firstStackSize);
//        System.out.println(", firstStackSalariesSum: " + firstStackSalariesSum);
//
//        System.out.print(" secondStack: " + secondStack);
//        System.out.print(", secondStackSize: " + secondStackSize);
//        System.out.println(", secondStackSalariesSum: " + secondStackSalariesSum);
//        System.out.println("");

        firstStackSalariesSum = getStackSalariesSum(firstStack);
        secondStackSalariesSum = getStackSalariesSum(secondStack);

        int firstStackResult = 0;
        int secondStackResult = 0;
        int bothStacksResult;

        bothStacksResult = getMaxTurns(0, 0, new ArrayList<>(firstStack), new ArrayList<>(secondStack));
//        System.out.println("running bothStacksResult: " + bothStacksResult);

        if (firstStackSalariesSum <= maxSalarySum) {
            firstStackResult = getMaxTurns(firstStackSalariesSum, firstStackSize, new ArrayList<>(), new ArrayList<>(secondStack));
//            System.out.println("running firstStackResult: " + firstStackResult);
        }
//        else {
//            System.out.println("firstStackSalariesSum > maxSalarySum");
//        }

        if (secondStackSalariesSum <= maxSalarySum) {
            secondStackResult = getMaxTurns(secondStackSalariesSum, secondStackSize, new ArrayList<>(firstStack), new ArrayList<>());
//            System.out.println("running secondStackResult: " + secondStackResult);
        }
//        else {
//            System.out.println("secondStackSalariesSum > maxSalarySum");
//        }
//        System.out.println("---------------------------------------------------------------------");
//        System.out.println("BEST RESULT IS: " + Math.max(firstStackResult, Math.max(secondStackResult, bothStacksResult)) + " TURNS");
        System.out.println(Math.max(firstStackResult, Math.max(secondStackResult, bothStacksResult)));
//        System.out.println("---------------------------------------------------------------------");
    }

    public static int getMaxTurns(int initialSalarySum, int initialTurn,  ArrayList<Integer> firstStack, ArrayList<Integer> secondStack) {
        int turn = initialTurn;
        int salarySum = initialSalarySum;
        while (true) {
//            System.out.println("turn " + turn + ": " + " salarySum: " + salarySum);
            if (firstStack.isEmpty() && secondStack.isEmpty()) {
                break;
            } else if (firstStack.isEmpty()) {
//                System.out.println(secondStack.get(0) + " from secondStack" + secondStack + " added");
                salarySum += secondStack.get(0);
                secondStack.remove(0);
            } else if (secondStack.isEmpty()) {
//                System.out.println(firstStack.get(0) + " from firstStack" + firstStack + " added");
                salarySum += firstStack.get(0);
                firstStack.remove(0);
            } else {
                if (firstStack.get(0) <= secondStack.get(0)) {
//                    System.out.println(firstStack.get(0) + " from firstStack" + firstStack + " added");
                    salarySum += firstStack.get(0);
                    firstStack.remove(0);
                } else {
//                    System.out.println(secondStack.get(0) + " from secondStack" + secondStack + " added");
                    salarySum += secondStack.get(0);
                    secondStack.remove(0);
                }
            }
            if (salarySum <= maxSalarySum){
                turn++;
            }else {
                break;
            }

        }
//        System.out.println("finished at turn " + turn);
//        System.out.println("");
        return turn;
    }

    public static int getStackSalariesSum(ArrayList<Integer> stack){
        int stackSalariesSum = 0;
        for (int i = 0; i < stack.size(); i++) {
            stackSalariesSum += stack.get(i);
        }
        return stackSalariesSum;
    }
}



