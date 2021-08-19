package com.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

//PROBLEM URL: https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem
public class FraudulentActivityNotifications {

  static int activityNotifications(int[] expenditure, int d) {
    int[] freq = new int[201];
    for (int i = 0; i < d; i++) {
      freq[expenditure[i]]++;
    }
    int totalNotification = 0;
    for (int i = d; i < expenditure.length; i++) {
      if (i > d) {
        freq[expenditure[i - d - 1]]--;
        freq[expenditure[i - 1]]++;
      }
      int median = getMedian(freq, d);
      if ((d % 2 == 1 && expenditure[i] >= 2 * median)
          || (d % 2 == 0 && expenditure[i] >= median)) {
        totalNotification++;
      }
    }
    return totalNotification;
  }

  private static int getMedian(int[] freq, int d) {
    int[] freqSum = Arrays.copyOf(freq, freq.length);
    for (int i = 1; i < freqSum.length; i++) {
      freqSum[i] = freqSum[i] + freqSum[i - 1];
    }
    int median = -1;
    if (d % 2 == 1) {
      int medianPos = (d + 1) / 2;
      for (int i = 0; i < freqSum.length; i++) {
        if (freqSum[i] >= medianPos) {
          median = i;
          break;
        }
      }
    } else {
      int first = -1;
      int second = -1;
      int firstPos = d / 2;
      int secondPos = d / 2 + 1;
      for (int i = 0; i < freqSum.length; i++) {
        if (freqSum[i] >= firstPos) {
          first = i;
          break;
        }
      }
      for (int i = 0; i < freqSum.length; i++) {
        if (freqSum[i] >= secondPos) {
          second = i;
          break;
        }
      }
      median = first + second;
    }
    return median;
  }

  private static final Scanner scanner = new Scanner(System.in);

  /**
   * 
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(
        new FileWriter(System.getenv("OUTPUT_PATH")));
    String[] nd = scanner.nextLine().split(" ");
    int n = Integer.parseInt(nd[0]);
    int d = Integer.parseInt(nd[1]);
    int[] expenditure = new int[n];
    String[] expenditureItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    for (int i = 0; i < n; i++) {
      int expenditureItem = Integer.parseInt(expenditureItems[i]);
      expenditure[i] = expenditureItem;
    }
    int result = activityNotifications(expenditure, d);
    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();
    bufferedWriter.close();
    scanner.close();
  }

}
