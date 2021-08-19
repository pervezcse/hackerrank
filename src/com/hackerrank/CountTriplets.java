package com.hackerrank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//PROBLEM URL: https://www.hackerrank.com/challenges/count-triplets-1/problem
public class CountTriplets {
  // Complete the countTriplets function below.
  static long countTriplets(List<Long> arr, long r) {
    Map<Long, Long> pairCount = new HashMap<>();
    Map<Long, Long> tripletCount = new HashMap<>();
    long totalCount = 0L;
    for (long i : arr) {
      if (tripletCount.containsKey(i)) {
        totalCount = totalCount + tripletCount.get(i);
      }
      if (pairCount.containsKey(i)) {
        tripletCount.put(i * r, tripletCount.getOrDefault(i * r, 0L) + pairCount.get(i));
      }
      pairCount.put(i * r, pairCount.getOrDefault(i * r, 0L) + 1);
    }
    return totalCount;
  }

  /**
   * 
   * @param args
   * @throws IOException
   */
  // public static void main(String[] args) throws IOException {
  // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
  // BufferedWriter bufferedWriter = new BufferedWriter(
  // new FileWriter(System.getenv("OUTPUT_PATH")));
  // String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
  // long r = Long.parseLong(nr[1]);
  // List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
  // .map(Long::parseLong).collect(toList());
  // long ans = countTriplets(arr, r);
  // bufferedWriter.write(String.valueOf(ans));
  // bufferedWriter.newLine();
  // bufferedReader.close();
  // bufferedWriter.close();
  // }
}
