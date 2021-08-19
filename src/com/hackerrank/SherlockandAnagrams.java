package com.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//PROBLEM URL: https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
public class SherlockandAnagrams {

  // Complete the sherlockAndAnagrams function below.
  static int sherlockAndAnagrams(String s) {
    int total = 0;
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      for (int j = i + 1; j <= s.length(); j++) {
        String subStr = s.substring(i, j);
        char[] subCharArray = subStr.toCharArray();
        Arrays.sort(subCharArray);
        String sortedSubStr = String.valueOf(subCharArray);
        int freq = map.getOrDefault(sortedSubStr, 0);
        total = total + freq;
        map.put(sortedSubStr, freq + 1);
      }
    }
    return total;
  }

  private static final Scanner scanner = new Scanner(System.in);  

  /**
   * 
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    BufferedWriter bufferedWriter = new BufferedWriter(
        new FileWriter(System.getenv("OUTPUT_PATH")));
    for (int index = 0; index < q; index++) {
      String s = scanner.nextLine();
      int result = sherlockAndAnagrams(s);
      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();
    }
    bufferedWriter.close();
    scanner.close();
  }
}
