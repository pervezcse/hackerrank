package com.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//PROBLEM URL: https://www.hackerrank.com/challenges/two-strings/problem
public class TwoStrings {
  // Complete the twoStrings function below.
  static String twoStrings(String s1, String s2) {
    char[] s1Array = s1.toCharArray();
    char[] s2Array = s2.toCharArray();
    Set<String> s1Set = new HashSet<>();
    for (char c : s1Array) {
      s1Set.add(c + "");
    }
    for (char c : s2Array) {
      if (s1Set.contains(c + "")) {
        return "YES";
      }
    }
    return "NO";
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
      String s1 = scanner.nextLine();
      String s2 = scanner.nextLine();
      String result = twoStrings(s1, s2);
      bufferedWriter.write(result);
      bufferedWriter.newLine();
    }

    bufferedWriter.close();

    scanner.close();
  }
}
