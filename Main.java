package ru.hh;

import java.util.*;


public class Main {

    private static int maxSalarySum = 0;
    private static ArrayList<Integer> firstStack = new ArrayList<>();
    private static ArrayList<Integer> secondStack = new ArrayList<>();
    private static int firstStackSalariesSum = 0;
    private static int secondStackSalariesSum = 0;


    public static void main(String[] args) {



//
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

//        firstStackSalariesSum = 9;
//        secondStackSalariesSum = 13;





        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();
        String[] inputData = input.split(" ");
        int firstStackSize = Integer.parseInt(inputData[0]);
        int secondStackSize = Integer.parseInt(inputData[1]);
        maxSalarySum = Integer.parseInt(inputData[2]);

//        System.out.println("firstStackSize: " + firstStackSize + ", secondStackSize: " + secondStackSize + ", maxSalarySum: " + maxSalarySum);

        int maxSize = Math.max(firstStackSize, secondStackSize);
        for (int i = 0; i < maxSize; i++) {
            String lineInput = sc.nextLine().trim();
            String[] data = lineInput.split(" ");
            if (data[0].equals("-")) {
            } else {
                int inputOne = Integer.parseInt(data[0]);
                firstStack.add(inputOne);
                firstStackSalariesSum += inputOne;
//                System.out.println("entered: " + firstStack.get(i));
            }

            if (data[1].equals("-")) {
            } else {
                int inputTwo = Integer.parseInt(data[1]);
                secondStack.add(inputTwo);
                secondStackSalariesSum += inputTwo;
//                System.out.println("entered: "  + secondStack.get(i));
            }
        }


//        System.out.println("firstStackSize: " + firstStackSize + ", secondStackSize: " + secondStackSize + ", maxSalarySum: " + maxSalarySum);
//        System.out.println("firstStack: " + firstStack);
//        System.out.println("secondStack: " + secondStack);
//        System.out.println("firstStackSalariesSum: " + firstStackSalariesSum + ", secondStackSalariesSum: " + secondStackSalariesSum);
//        System.out.println("");


        int firstStackResult = 0;
        int secondStackResult = 0;
        int bothStacksResult = 0;

        bothStacksResult = getMaxTurns(0, 0);

        if (firstStackSalariesSum < maxSalarySum){
            firstStack.clear();
            firstStackResult = getMaxTurns(firstStackSalariesSum, firstStackSize);
        }

        if (secondStackSalariesSum < maxSalarySum) {
            secondStackResult = getMaxTurns(secondStackSalariesSum, secondStackSize);
            int salarySum = secondStackSalariesSum;
            secondStack.clear();
        }

        System.out.println(Math.max(firstStackResult, Math.max(secondStackResult, bothStacksResult)) );

    }

    private static int getMaxTurns(int initialSalarySum, int initialTurn) {
        int result = initialTurn + 1;
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
                if (firstStack.get(0) < secondStack.get(0)) {
                    salarySum += firstStack.get(0);
                    firstStack.remove(0);
                } else {
                    salarySum += secondStack.get(0);
                    secondStack.remove(0);
                }
            }
            if(salarySum > maxSalarySum){
                break;
            }
            result++;
        }
        return result;
    }
}



