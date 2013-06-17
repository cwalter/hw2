
package at.edu.hti.waycalc.graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

public class Matrix {

  Node startnode;

  Node targetnode;

  List<Node> matrix = new LinkedList<>();

  List<Integer> wayWeights = new LinkedList<>();

  public Matrix() {
    startnode = null;
  }

  public void load(String file) throws Exception {
    BufferedReader reader = null;
    try {
      File map = new File(file);
      if (map != null && !map.isFile()) {
        throw new NullPointerException("File not foud or valid.");
      }

      reader = new BufferedReader(new FileReader(map));

      List<String[]> allNodesAndEdges = new LinkedList<>();

      String tmp = null;
      while ((tmp = reader.readLine()) != null) {
        String[] nodes = tmp.split(",");
        allNodesAndEdges.add(nodes);
      }

      matrix = new LinkedList<>();

      int counter = 0;
      for (int i = 0; i < allNodesAndEdges.size(); i++) {
        String[] nodeConfigs = allNodesAndEdges.get(i);
        for (String cfg : nodeConfigs) {
          Node n = new Node(matrix.size(), Integer.valueOf(cfg).intValue());
          int modulo = (matrix.size() % nodeConfigs.length);
          if (matrix.size() > 0 && modulo != 0) {
            matrix.get(matrix.size() - 1).addNode(n);
          }
          matrix.add(n);
        }

        if (matrix.size() >= nodeConfigs.length * 2) {
          for (int j = nodeConfigs.length * counter; j < (matrix.size() - nodeConfigs.length); j++) {
            matrix.get(j).addNode(matrix.get(j + nodeConfigs.length));
          }
          counter++;
        }
      }

      this.startnode = matrix.get(0);
      this.targetnode = matrix.get(matrix.size() - 1);
    } catch (Exception e) {
      System.err.println("Failed to parse file> " + e.getMessage());
      throw e;
    } finally {
      try {
        reader.close();
      } catch (Throwable e2) {
        // ignore stream already closed
      }
    }
  }

  public Integer traverse(Node node, Integer sum) {
    sum += node.getWeight();
    if (node == this.targetnode) {
      wayWeights.add(sum);
      return sum;
    }

    for (Node next : node.getNextNodes()) {
      traverse(next, sum);
    }

    return sum;
  }

  public Node getStartnode() {
    return startnode;
  }

  public List<Integer> getWayWeights() {
    return wayWeights;
  }

  public List<Node> getMatrix() {
    return matrix;
  }
}
