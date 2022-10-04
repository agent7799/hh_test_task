package ru.hh;

import java.util.Scanner;
import java.util.regex.Matcher;

public class Main {

//    private static int firstStackSize;
//    private static int secondStackSize;
//    private static int maxSalary;

    public static void main(String[] args) {
	// write your code here

        int firstStackSize;
        int secondStackSize;
        int maxSalarySum;
        int salarySum = 0;
        int result = 0;
        String firstInputRegexp = "\\d+\\s\\d+\\s\\d+";
        String lineInputRegexp = "-?\\d?\\s-?\\d?";

        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("Input FIRST stack size, SECOND stack size and MAX salary (separated by spaces): ");
            String input = sc.nextLine().trim();

            if(input.matches(firstInputRegexp)) {
                System.out.println("input is ok");
                String[] inputData = input.split(" ");
                firstStackSize = Integer.parseInt(inputData[0]);
                secondStackSize = Integer.parseInt(inputData[1]);
                maxSalarySum = Integer.parseInt(inputData[2]);
                break;
            } else {
                System.out.println("Input data wrong, pls input again!");
                continue;
            }
        }

        int maxSize =  Math.max(firstStackSize, secondStackSize);
        for (int i = 0; i < maxSize; i++) {
            int data0;
            int data1;
            int minData;
            String lineInput;

            while (true){
                lineInput = sc.nextLine().trim();
                if(lineInput.matches(lineInputRegexp)) {
                   break;
                }else {
                    System.out.println("Input data wrong, pls input again!");
                }
            }


            String[] data = lineInput.split(" ");
            if (data[0].equals("-")) {
                minData = Integer.parseInt(data[1]);
            }else if (data[1].equals("-")){
                minData = Integer.parseInt(data[0]);
            }else {
                minData = Math.min(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
            }
            result = i+1;
            salarySum += minData;
            System.out.println(String.format("Salary sum: %d , max Salary: %d", salarySum, maxSalarySum));
            if (salarySum > maxSalarySum){
                break;
            }
        }
        result = result + 1;
        System.out.println("result " + result);
    }
}
