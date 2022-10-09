package ru.hh.hr;

import java.util.Scanner;


/**
 * 1. Сначала выберите любой из двух
 *
 * 2. Добавить все элементы из первого стека a, пока не достигнете предела x
 *
 * 3. Затем начните удалять элементы, которые добавляются первыми, и добавлять элементы из стека b вместо них так, чтобы summ<=x
 *
 * 4. Следите за количеством элементов, которые были в списке после каждой итерации, и сохраняйте максимум.
 *
 * # number of test cases
 * tests = int(input())
 * for i in range(tests):
 *     na, nb, x = map(int, input().split(' '))
 *     a = list(map(int, input().split(' ')))
 *     b = list(map(int, input().split(' ')))
 *     temp = []
 *     stk_a = Stack(a)
 *     stk_b = Stack(b)
 *     score = 0
 *     count = 0
 * # first taking elements from stack A , till score becomes just less than desired total
 *     for j in range(len(a)):
 *         if score + stk_a.peek() <= x:
 *             score += stk_a.peek()
 *
 *             count += 1
 *             temp.append(stk_a.peek())
 *             # storing the popped elements in temporary stack such that we can again remove them from score
 *             # when we find better element in stack B
 *             stk_a.pop()
 * # this is maximum number of moves using only stack A
 *     max_now = count
 * # now iterating through stack B for element lets say k which on adding to total score should be less than desired
 *     # or else we will remove each element of stack A from score till it becomes just less than desired total.
 *     for k in range(len(b)):
 *         score += stk_b.peek()
 *         stk_b.pop()
 *         count += 1
 *         while score > x and count > 0 and len(temp) > 0:
 *             count = count - 1
 *             score = score - temp[-1]
 *             temp.pop()
 *         # if the score after adding element from stack B is greater than max_now then we have new set of moves which will also lead
 *         # to just less than desired so we should pick maximum of both
 *         if score <= x and count > max_now:
 *             max_now = count
 *     print(max_now)
 */

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int g = sc.nextInt();
        for (int tc = 0; tc < g; tc++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int x = sc.nextInt();
            int[] a = readArray(sc, n);
            int[] b = readArray(sc, m);

            System.out.println(solve(a, b, x));
        }

        sc.close();
    }

    static int[] readArray(Scanner sc, int size) {
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = sc.nextInt();
        }
        return result;
    }

    //stack 1
    static int solve(int[] a, int[] b, int x) {
        int lengthB = 0;
        int sum = 0;
        while (lengthB < b.length && sum + b[lengthB] <= x) {
            sum += b[lengthB];
            lengthB++;
        }

        //stack 2
        int maxScore = lengthB;
        for (int lengthA = 1; lengthA <= a.length; lengthA++) {
            sum += a[lengthA - 1];

            while (sum > x && lengthB > 0) {
                lengthB--;
                sum -= b[lengthB];
            }

            if (sum > x) {
                break;
            }

            maxScore = Math.max(maxScore, lengthA + lengthB);
        }
        return maxScore;
    }
}