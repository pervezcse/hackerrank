package com.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//PROBLEM URL: https://www.hackerrank.com/challenges/ctci-merge-sort/problem
public class MergeSortCountingInversions {

  // Complete the countInversions function below.
  static long countInversions(int[] arr) {
    return mergeAndCount(arr, 0, arr.length - 1);
  }

  static long mergeAndCount(int[] arr, int startIndex, int endIndex) {
    if (startIndex >= endIndex) {
      return 0;
    }
    long totalCount = 0;
    int middleIndex = (startIndex + endIndex) / 2;
    long leftCount = mergeAndCount(arr, startIndex, middleIndex);
    long rightCount = mergeAndCount(arr, middleIndex + 1, endIndex);

    int[] mergedArr = new int[endIndex - startIndex + 1];
    int i = startIndex;
    int j = middleIndex + 1;
    for (int k = 0; k < mergedArr.length; k++) {
      if (i > middleIndex) {
        mergedArr[k] = arr[j];
        j++;
      } else if (j > endIndex || arr[i] <= arr[j]) {
        mergedArr[k] = arr[i];
        i++;
      } else {
        mergedArr[k] = arr[j];
        totalCount = totalCount + (middleIndex - i + 1);
        j++;
      }
    }
    System.arraycopy(mergedArr, 0, arr, startIndex, mergedArr.length);
    totalCount = totalCount + leftCount + rightCount;
    return totalCount;
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
    int t = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    for (int index = 0; index < t; index++) {
      int n = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
      int[] arr = new int[n];
      String[] arrItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
      for (int i = 0; i < n; i++) {
        int arrItem = Integer.parseInt(arrItems[i]);
        arr[i] = arrItem;
      }
      long result = countInversions(arr);
      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();
    }
    bufferedWriter.close();
    scanner.close();
  }
}
