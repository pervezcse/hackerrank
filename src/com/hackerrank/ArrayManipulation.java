package com.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

//PROBLEM URL: https://www.hackerrank.com/challenges/crush/problem
public class ArrayManipulation {

  // Complete the arrayManipulation function below.
  static long arrayManipulation(int n, int[][] queries) {
    long[] result = new long[n];
    Arrays.setAll(result, i -> 0);
    for (int i = 0; i < queries.length; i++) {
      result[queries[i][0] - 1] = result[queries[i][0] - 1] + queries[i][2];
      if (queries[i][1] < n) {
        result[queries[i][1]] = result[queries[i][1]] - queries[i][2];
      }
    }
    long sum = 0L;
    long max = 0L;
    for (int i = 0; i < n; i++) {
      sum = sum + result[i];
      if (max < sum) {
        max = sum;
      }
    }
    return max;
  }

  private static final Scanner scanner = new Scanner(System.in);

  /**
   * 
   * @param args
   * @throws IOException
   */

  public static void main(String[] args) throws IOException {
    String[] nm = scanner.nextLine().split(" ");
    int n = Integer.parseInt(nm[0]);
    int m = Integer.parseInt(nm[1]);
    int[][] queries = new int[m][3];
    for (int i = 0; i < m; i++) {
      String[] queriesRowItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
      for (int j = 0; j < 3; j++) {
        int queriesItem = Integer.parseInt(queriesRowItems[j]);
        queries[i][j] = queriesItem;
      }
    }
    long result = arrayManipulation(n, queries);
    BufferedWriter bufferedWriter = new BufferedWriter(
        new FileWriter(System.getenv("OUTPUT_PATH")));
    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();
    bufferedWriter.close();
    scanner.close();
  }
}
