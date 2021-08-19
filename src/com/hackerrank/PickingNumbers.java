package com.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//PROBLEM URL: https://www.hackerrank.com/challenges/picking-numbers/problem
public class PickingNumbers {

  private static final Scanner scanner = new Scanner(System.in);

  // Complete the pickingNumbers function below.
  static int pickingNumbers(int[] a) {
    int[] numFreq = new int[100];
    int maxCount = 0;
    for (int i = 0; i < numFreq.length; i++) {
      numFreq[i] = 0;
    }
    for (int i = 0; i < a.length; i++) {
      numFreq[a[i]]++;
    }
    for (int i = 1; i < numFreq.length - 1; i++) {
      int count = numFreq[i] + numFreq[i + 1];
      if (maxCount < count) {
        maxCount = count;
      }
    }
    return maxCount;
  }

  /**
   * 
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    int n = scanner.nextInt();
    int[] a = new int[n];

    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    String[] items = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    for (int i = 0; i < n; i++) {
      int item = Integer.parseInt(items[i]);
      a[i] = item;
    }
    int result = pickingNumbers(a);
    BufferedWriter bufferedWriter = new BufferedWriter(
        new FileWriter(System.getenv("OUTPUT_PATH")));
    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();
    bufferedWriter.close();
    scanner.close();
  }
}
