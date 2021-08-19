package com.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//PROBLEM URL: https://www.hackerrank.com/challenges/alternating-characters/problem
public class AlternatingCharacters {
  // Complete the alternatingCharacters function below.

  static int alternatingCharacters(String s) {
    char[] strArr = s.toCharArray();
    int count = 0;
    char lastRepeatChar = strArr[0];
    for (int i = 1; i < strArr.length; i++) {
      if (strArr[i] == lastRepeatChar) {
        count++;
      } else {
        lastRepeatChar = strArr[i];
      }
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
    BufferedWriter bufferedWriter = new BufferedWriter(
        new FileWriter(System.getenv("OUTPUT_PATH")));
    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    for (int index = 0; index < q; index++) {
      String s = scanner.nextLine();
      int result = alternatingCharacters(s);
      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();
    }
    bufferedWriter.close();
    scanner.close();
  }
}
