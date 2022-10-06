package ru.hh;

import java.util.ArrayDeque;
import java.util.Scanner;


public class MainDraft {


    public static void main(String[] args) {
        // write your code here
        int firstStackSize;
        int secondStackSize;
        int maxSalarySum = 0;
        int salarySum = 0;
        boolean isFinished = false;
        int turn = 0;


        String firstInputRegexp = "\\d+\\s\\d+\\s\\d+";
        String lineInputRegexp = "-?\\d?\\s-?\\d?";

        ArrayDeque<Integer> firstStack = new ArrayDeque<>();
        ArrayDeque<Integer> secondStack = new ArrayDeque<>();

        Scanner sc = new Scanner(System.in);
                String input = sc.nextLine().trim();
                String[] inputData = input.split(" ");
                firstStackSize = Integer.parseInt(inputData[0]);
                secondStackSize = Integer.parseInt(inputData[1]);
                maxSalarySum = Integer.parseInt(inputData[2]);
//        Scanner sc = new Scanner(System.in);
//        while (true) {
//            System.out.println("Input FIRST stack size, SECOND stack size and MAX salary (separated by spaces): ");
//            String input = sc.nextLine().trim();
//            if (input.matches(firstInputRegexp)) {
//                System.out.println("input is ok");
//                String[] inputData = input.split(" ");
//                firstStackSize = Integer.parseInt(inputData[0]);
//                secondStackSize = Integer.parseInt(inputData[1]);
//                maxSalarySum = Integer.parseInt(inputData[2]);
//                break;
//            } else {
//                System.out.println("Input data wrong, pls input again!");
//                continue;
//            }
//        }

//        int maxSize = Math.max(firstStackSize, secondStackSize);
//        for (int i = 0; i < maxSize; i++) {
//            String lineInput;
//            while (true) {
//                lineInput = sc.nextLine().trim();
//                if (lineInput.matches(lineInputRegexp)) {
//                    break;
//                } else {
//                    System.out.println("Input line is incorrect, pls input again!");
//                }
//            }
//            String[] data = lineInput.split(" ");
//            if (!data[0].equals("-")) {
//                firstStack.addLast(Integer.parseInt(data[0]));
//            }
//            if (!data[1].equals("-")) {
//                secondStack.addLast(Integer.parseInt(data[1]));
//            }
//        }


        int maxSize = Math.max(firstStackSize, secondStackSize);
        for (int i = 0; i < maxSize; i++) {
            String lineInput;
                 lineInput = sc.nextLine().trim();
                 String[] data = lineInput.split(" ");
            if (!data[0].equals("-")) {
                firstStack.addLast(Integer.parseInt(data[0]));
            }
            if (!data[1].equals("-")) {
                secondStack.addLast(Integer.parseInt(data[1]));
            }
        }

        while (!isFinished) {
            turn++;
            if (firstStack.isEmpty() && secondStack.isEmpty()) {
                isFinished = true;
            } else if (firstStack.isEmpty() && !secondStack.isEmpty()) {
                salarySum += secondStack.poll();
            } else if (!firstStack.isEmpty() && secondStack.isEmpty()) {
                salarySum += firstStack.poll();
            } else {
                if (firstStack.peek() < secondStack.peek()) {
                    salarySum += firstStack.poll();
                } else {
                    salarySum += secondStack.poll();
                }
            }

            if (salarySum > maxSalarySum) {
                isFinished = true;
                System.out.println(turn);
            }
        }
        System.out.println(turn);
    }


}



