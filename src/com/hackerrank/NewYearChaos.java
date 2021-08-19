package com.hackerrank;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/new-year-chaos/problem
public class NewYearChaos {

  // Complete the minimumBribes function below.
  static void minimumBribes(int[] q) {
    int bribeCount = 0;
    for (int i = 0; i < q.length; i++) {
      if (q[i] - (i + 1) > 2) {
        System.out.println("Too chaotic");
        return;
      }
      int fromPosOfBriber = Math.max(0, q[i] - 2);
      int toPosOfBriber = i - 1;
      if (fromPosOfBriber <= toPosOfBriber) {
        for (int j = fromPosOfBriber; j <= toPosOfBriber; j++) {
          if (q[j] > q[i]) {
            bribeCount++;
          }
        }
      }
    }
    System.out.println(bribeCount);
  }

  private static final Scanner scanner = new Scanner(System.in);
  
  /**
   * 
   * @param args
   */
  public static void main(String[] args) {
    int t = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int index = 0; index < t; index++) {
      int n = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int[] q = new int[n];
      String[] items = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < n; i++) {
        int item = Integer.parseInt(items[i]);
        q[i] = item;
      }
      minimumBribes(q);
    }
    scanner.close();
  }
}
