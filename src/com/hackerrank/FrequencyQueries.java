package com.hackerrank;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.joining;

//PROBLEM URL: https://www.hackerrank.com/challenges/frequency-queries/problem
public class FrequencyQueries {

  // Complete the freqQuery function below.
  static List<Integer> freqQuery(List<int[]> queries) {
    List<Integer> results = new ArrayList<>();
    Map<Integer, Integer> numberCountMap = new HashMap<>();
    Map<Integer, Integer> countCountMap = new HashMap<>();
    for (int[] row : queries) {
      if (row[0] == 1) {
        countCountMap.computeIfPresent(numberCountMap.getOrDefault(row[1], 0),
            (k, v) -> (v > 1) ? v - 1 : 0);
        numberCountMap.compute(row[1], (k, v) -> (v == null) ? 1 : v + 1);
        countCountMap.compute(numberCountMap.get(row[1]), (k, v) -> (v == null) ? 1 : v + 1);
      } else if (row[0] == 2) {
        if (numberCountMap.containsKey(row[1])) {
          countCountMap.computeIfPresent(numberCountMap.getOrDefault(row[1], 0),
              (k, v) -> (v > 1) ? v - 1 : 0);
          numberCountMap.computeIfPresent(row[1], (k, v) -> (v > 1) ? v - 1 : 0);
          countCountMap.compute(numberCountMap.get(row[1]), (k, v) -> (v == null) ? 1 : v + 1);
        }
      } else if (countCountMap.getOrDefault(row[1], 0) > 0) {
        results.add(1);
      } else {
        results.add(0);
      }
    }
    return results;
  }

  /**
   * 
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
      int q = Integer.parseInt(bufferedReader.readLine().trim());
      List<int[]> queries = new ArrayList<>(q);
      Pattern p = Pattern.compile("^(\\d+)\\s+(\\d+)\\s*$");
      for (int i = 0; i < q; i++) {
        int[] query = new int[2];
        Matcher m = p.matcher(bufferedReader.readLine());
        if (m.matches()) {
          query[0] = Integer.parseInt(m.group(1));
          query[1] = Integer.parseInt(m.group(2));
          queries.add(query);
        }
      }
      List<Integer> ans = freqQuery(queries);
      try (BufferedWriter bufferedWriter = new BufferedWriter(
          new FileWriter(System.getenv("OUTPUT_PATH")))) {
        bufferedWriter.write(ans.stream().map(Object::toString).collect(joining("\n")) + "\n");
      }
    }
  }
}
