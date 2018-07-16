package hackerrank.solutions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//PROBLEM URL: https://www.hackerrank.com/challenges/cut-the-tree/problem
public class CutTheTree {

  private static final Scanner scanner = new Scanner(System.in);
  static int[] data;
  static int[] treeWeight;
  static boolean[] visited;
  static Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
  static int totalWeight = 0;

  static int cutTheGraph() {
    return diffDFS(1);
  }

  static Integer diffDFS(Integer node) {
    visited[node - 1] = true;
    int diff = Integer.MAX_VALUE;
    Set<Integer> children = graph.get(node);
    for (Integer child : children) {
      if (!visited[child - 1]) {
        int childDiff = diffDFS(child);
        if (diff > childDiff)
          diff = childDiff;
        data[node - 1] = data[node - 1] + data[child - 1];
      }
    }
    int newDiff = Math.abs(totalWeight - 2 * data[node - 1]);
    if (diff > newDiff)
      return newDiff;
    else
      return diff;
  }

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(
        new FileWriter(System.getenv("OUTPUT_PATH")));
    int n = scanner.nextInt();
    data = new int[n];
    visited = new boolean[n];
    for (int i = 0; i < n; i++) {
      int dataItem = scanner.nextInt();
      data[i] = dataItem;
      visited[i] = false;
      totalWeight = totalWeight + dataItem;
    }
    for (int i = 0; i < n - 1; i++) {
      int u = scanner.nextInt();
      int v = scanner.nextInt();

      if (!graph.containsKey(u))
        graph.put(u, new HashSet<Integer>());
      graph.get(u).add(v);
      if (!graph.containsKey(v))
        graph.put(v, new HashSet<Integer>());
      graph.get(v).add(u);
    }
    int result = cutTheGraph();

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();
    bufferedWriter.close();
    scanner.close();
  }
}
