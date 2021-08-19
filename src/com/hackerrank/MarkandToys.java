package com.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

//PROBLEM URL: https://www.hackerrank.com/challenges/mark-and-toys/problem
public class MarkandToys {
  static int maximumToys(int[] prices, int k) {
    Arrays.sort(prices);
    int count = 0;
    for (int i = 0; i < prices.length; i++) {
      if (prices[i] > k) {
        count = i;
        break;
      }
      k = k - prices[i];
    }
    return count;
  }

  private static final Scanner scanner = new Scanner(System.in);

  /**
   * 
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    String[] nk = scanner.nextLine().split(" ");
    int n = Integer.parseInt(nk[0]);
    int k = Integer.parseInt(nk[1]);
    int[] prices = new int[n];
    String[] pricesItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    for (int i = 0; i < n; i++) {
      int pricesItem = Integer.parseInt(pricesItems[i]);
      prices[i] = pricesItem;
    }
    int result = maximumToys(prices, k);
    BufferedWriter bufferedWriter = new BufferedWriter(
        new FileWriter(System.getenv("OUTPUT_PATH")));
    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();
    bufferedWriter.close();
    scanner.close();
  }
}
