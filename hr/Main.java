package ru.hh.hr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {





    public static void main(String[] args) {
        ArrayList<Integer> firstStack = new ArrayList<>();
        ArrayList<Integer> secondStack = new ArrayList<>();
        int firstStackLength = 0;
        int secondStackLength = 0;
        int maxSalarySum = 0;
//        ---------------------------------------------------------------------------------------------------------
////
//         firstStackLength = 6;
//         secondStackLength = 4;
//        maxSalarySum = 10;
//        firstStack = new ArrayList<>(Arrays.asList(4, 2, 4, 6, 1, 7));
//        secondStack = new ArrayList<>(Arrays.asList(2, 1, 8, 5));
//        ---------------------------------------------------------------------------------------------------------
//        int firstStackLength = 3;
//        int secondStackLength = 4;
//        maxSalarySum = 11;
//        firstStack = new ArrayList<>(Arrays.asList(1, 2, 3));
//        secondStack = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
//        ---------------------------------------------------------------------------------------------------------
//        firstStackLength = 5;
//        secondStackLength = 5;
//        maxSalarySum = 10;
//        firstStack = new ArrayList<>(Arrays.asList(5, 1, 1, 1, 1));
//        secondStack = new ArrayList<>(Arrays.asList(1, 3, 3, 3, 3));

//        ---------------------------------------------------------------------------------------------------------
//        firstStackLength = 4;
//        secondStackLength = 5;
//        maxSalarySum = 13;
//        firstStack = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
//        secondStack = new ArrayList<>(Arrays.asList(1, 2, 3, 3, 1));
//        ---------------------------------------------------------------------------------------------------------
//
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();
        String[] inputData = input.split(" ");
        firstStackLength = Integer.parseInt(inputData[0]);
        secondStackLength = Integer.parseInt(inputData[1]);
        maxSalarySum = Integer.parseInt(inputData[2]);


        int maxSize = Math.max(firstStackLength, secondStackLength);
        for (int i = 0; i < maxSize; i++) {
            String lineInput = sc.nextLine().trim();
            String[] data = lineInput.split(" ");
            if (!data[0].equals("-")) {
                int inputOne = Integer.parseInt(data[0]);
                firstStack.add(inputOne);
//               firstStackSalariesSum += inputOne;
            }
            if (!data[1].equals("-")) {
                int inputTwo = Integer.parseInt(data[1]);
                secondStack.add(inputTwo);
//                secondStackSalariesSum += inputTwo;
            }
        }
        sc.close();

        int result = Math.max(findMaxTurns(firstStack, secondStack, maxSalarySum), findMaxTurns(secondStack, firstStack, maxSalarySum));
        System.out.println(result);


    }

    public static int findMaxTurns (ArrayList<Integer> firstStack, ArrayList < Integer > secondStack,int maxSalarySum){
        int firstStackLength = firstStack.size();
        int maxTurns;
        int firstStackMaxTurns = 0;
        int sum = 0;
        //перебираем только 1-й стек
        //находим макс кол-во ходов первого стека и макс получившуюся сумму, не превышающую заданную
        while (firstStackMaxTurns < firstStackLength && sum + firstStack.get(firstStackMaxTurns) < maxSalarySum) {
            sum += firstStack.get(firstStackMaxTurns);
            firstStackMaxTurns++;
        }

        maxTurns = firstStackMaxTurns;
        //перебираем второй стек,
        //добавляем по одному элементу из второго стека к сумме
        for (int secondStackMaxTurns = 1; secondStackMaxTurns <= secondStack.size(); secondStackMaxTurns++) {
            sum += secondStack.get(secondStackMaxTurns - 1);

            //пока сумма больше и ходы по первому стеку есть:
            while (sum > maxSalarySum && firstStackMaxTurns > 0) {
                //  уменьшаем ходы первого стека
                firstStackMaxTurns--;
                //уменьшаем сумму на последний элемент из первого стека, на котором сумма не превышает макс
                sum -= firstStack.get(firstStackMaxTurns);
            }

            //если ходы первого стека кончились, а сумма все равно больше - выходим из цикла
            if (sum > maxSalarySum) {
                break;
            }
            maxTurns = Math.max(maxTurns, firstStackMaxTurns + secondStackMaxTurns);
        }
        return maxTurns;
    }
}



