package ru.hh.hr;

import java.util.*;


public class HrManagers {

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

//        //        ---------------------------------------------------------------------------------------------------------
//        firstStackSize = 5;
//        secondStackSize = 5;
//        maxSalarySum = 10;
//        firstStack = new ArrayList<>(Arrays.asList(9, 1, 1, 1, 1));
//        secondStack = new ArrayList<>(Arrays.asList(11, 3, 3, 3, 3));
//        expectedResult = 2;
//        ---------------------------------------------------------------------------------------------------------
//        ---------------------------------------------------------------------------------------------------------
        firstStackSize = 1;
        secondStackSize = 5;
        maxSalarySum = 5;
        firstStack = new ArrayList<>(Arrays.asList(4));
        secondStack = new ArrayList<>(Arrays.asList(1, 1, 1 , 1, 2));
        expectedResult = 5;
//        ---------------------------------------------------------------------------------------------------------


//        Scanner sc = new Scanner(System.in);
//        String input = sc.nextLine().trim();
//        String[] inputData = input.split(" ");
//        firstStackSize = Integer.parseInt(inputData[0]);
//        secondStackSize = Integer.parseInt(inputData[1]);
//        maxSalarySum = Integer.parseInt(inputData[2]);

//
//        int maxSize = Math.max(firstStackSize, secondStackSize);
//        for (int i = 0; i < maxSize; i++) {
//            String lineInput = sc.nextLine().trim();
//            String[] data = lineInput.split(" ");
//            if (!data[0].equals("-")) {
//                int inputOne = Integer.parseInt(data[0]);
//                firstStack.add(inputOne);
////               firstStackSalariesSum += inputOne;
//                System.out.println("entered: " + firstStack.get(i));
//            }
//            if (!data[1].equals("-")) {
//                int inputTwo = Integer.parseInt(data[1]);
//                secondStack.add(inputTwo);
////                secondStackSalariesSum += inputTwo;
//                System.out.println("entered: "  + secondStack.get(i));
//            }
//        }
//        sc.close();

//        ------------------------------------------------------------------------------------------------------
//      FOR TEST ONLY!!!!!
//        ------------------------------------------------------------------------------------------------------


//        ------------------------------------------------------------------------------------------------------
        firstStackSalariesSum = getStackSalariesSum(firstStack);
        secondStackSalariesSum = getStackSalariesSum(secondStack);

//        System.out.println( "maxSalarySum: " + maxSalarySum);
//        System.out.print(" firstStack: " + firstStack);
//        System.out.print(", firstStackSize: " + firstStack.size());
//        System.out.println(", firstStackSalariesSum: " + firstStackSalariesSum);
//
//        System.out.print(" secondStack: " + secondStack);
//        System.out.print(", secondStackSize: " + secondStack.size());
//        System.out.println(", secondStackSalariesSum: " + secondStackSalariesSum);
//        System.out.println("");




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
//        System.out.println("initialSTurn " + initialSTurn + " initialSalarySum " + initialSalarySum);
        result = getMaxTurns(initialSalarySum, initialSTurn, new ArrayList<>(firstStack), new ArrayList<>(secondStack));
//        System.out.println("running bothStacksResult: " + result);

//        System.out.println("---------------------------------------------------------------------");
//        System.out.println("BEST RESULT IS: " + Math.max(firstStackResult, Math.max(secondStackResult, bothStacksResult)));
//        System.out.println("EXPECTED: " + expectedResult);
//        System.out.println("---------------------------------------------------------------------");
        System.out.println(result);
    }

    public static int getMaxTurns(int initialSalarySum, int initialTurn,  ArrayList<Integer> firstStack, ArrayList<Integer> secondStack) {
        int turn = initialTurn;
        int salarySum = initialSalarySum;
        while (true) {
            if (firstStack.isEmpty() && secondStack.isEmpty()) {
                break;
            } else if (firstStack.isEmpty()) {
//                System.out.println(secondStack.get(0) + " from secondStack " + secondStack + " added on turn " + turn );
                salarySum += secondStack.get(0);
                secondStack.remove(0);
            } else if (secondStack.isEmpty()) {
//                System.out.println(firstStack.get(0) + " from firstStack " + firstStack + "  added on turn " + turn );
                salarySum += firstStack.get(0);
                firstStack.remove(0);
            } else {
                if (firstStack.get(0) <= secondStack.get(0)) {
//                    System.out.println(firstStack.get(0) + " from firstStack " + firstStack + "  added on turn " + turn );
                    salarySum += firstStack.get(0);
                    firstStack.remove(0);
                } else {
//                    System.out.println(secondStack.get(0) + " from secondStack" + secondStack + "  added on turn " + turn );
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



