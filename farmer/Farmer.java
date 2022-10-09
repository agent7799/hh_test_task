package ru.hh.farmer;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * ���������� ������� �������:
 * ���� �� ������� {
 * ���� �� �������� {
 * ������� ������� �������, ������ ������� {
 * �����++ }
 * ��������� �� ������� ��������� ������ �� ���������� ���� ������� ��� �������� ��������� �� ������� ��������� ���� �� ���������� ���� ������� ��� �������� ���� �� ������� � �������� ��� ��������� ���� ��������� ��������� ��������������
 * }
 * }
 */

public class Farmer {

    public static void main(String[] args) {



        byte[][] field;

        //field = inputData();

        {
            field = new byte[][]{
                    {1, 0, 0, 1},           // m = 0
                    {0, 0, 0, 0},           // m = 1
                    {0, 0, 0, 0},           // m = 2
                    {1, 0, 0, 1}            // m = 3

                    // n = 0, 1, 2, 3
            };
        }

        printArray(field);

    }

    private static byte[][] inputData() {
        Scanner sc = new Scanner(System.in);
        String[] inputData = sc.nextLine().split(" ");
        int n = Integer.parseInt(inputData[0]); //columns
        int m = Integer.parseInt(inputData[1]); //rows
        byte[][] array = new byte[n][m];
        for (int i = 0; i < m; i++) {
            String[] row = sc.nextLine().split(" ");
            byte[] st = new byte[n];
            for (int j = 0; j < n; j++) {
                st[j] = Byte.parseByte(row[j]);
            }
            array[i] = st;
        }
        sc.close();
        return array;
    }

    public static void printArray(byte[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
    }


}



