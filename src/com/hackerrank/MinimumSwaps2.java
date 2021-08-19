package com.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//PROBLEM URL: https://www.hackerrank.com/challenges/minimum-swaps-2/problem
public class MinimumSwaps2 {

  // Complete the minimumSwaps function below.
  static int minimumSwaps(int[] arr) {
    int swapCount = 0;
    for (int i = 0; i < arr.length; i++) {
      while (arr[i] != i + 1 && arr[i] <= arr.length) {
        int temp = arr[i];
        arr[i] = arr[temp - 1];
        arr[temp - 1] = temp;
        swapCount++;
      }
    }
    return swapCount;
  }

  private static final Scanner scanner = new Scanner(System.in);

  /**
   * 
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    int[] arr = new int[n];
    String[] arrItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int arrItem = Integer.parseInt(arrItems[i]);
      arr[i] = arrItem;
    }
    int res = minimumSwaps(arr);
    BufferedWriter bufferedWriter = new BufferedWriter(
        new FileWriter(System.getenv("OUTPUT_PATH")));
    bufferedWriter.write(String.valueOf(res));
    bufferedWriter.newLine();
    bufferedWriter.close();
    scanner.close();
  }
}
