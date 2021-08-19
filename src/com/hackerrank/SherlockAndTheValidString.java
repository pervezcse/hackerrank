package com.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//PROBLEM URL: https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
public class SherlockAndTheValidString {

  // Complete the isValid function below.
  static String isValid(String s) {
    int[] freq = new int[26];
    char[] strArr = s.toCharArray();
    for (char c : strArr) {
      freq[c - 'a']++;
    }
    Map<Integer, Integer> freqCount = new HashMap<>();
    for (int i = 0; i < freq.length; i++) {
      if (freq[i] > 0) {
        freqCount.compute(freq[i], (k, v) -> v == null ? 1 : v + 1);
      }
    }
    if (freqCount.size() > 2) {
      return "NO";
    } else if (freqCount.size() == 2) {
      Set<Integer> freqSet = freqCount.keySet();
      for (int f : freqSet) {
        if (f > 1 && freqCount.get(f) == 1 && freqCount.containsKey(f - 1)
            || (f == 1 && freqCount.get(f) == 1)) {
          return "YES";
        }
      }
      return "NO";
    }
    return "YES";
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
    String s = scanner.nextLine();
    String result = isValid(s);
    bufferedWriter.write(result);
    bufferedWriter.newLine();
    bufferedWriter.close();
    scanner.close();
  }
}
