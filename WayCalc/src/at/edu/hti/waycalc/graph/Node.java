
package at.edu.hti.waycalc.graph;

import java.util.LinkedList;
import java.util.List;

public class Node {

  private int weight = 0;
  private int id = 0;

  private List<Node> nextNodes = new LinkedList<>();

  public Node(int id, int edgeWeight) {
    this.weight = edgeWeight;
    this.id = id;
    //		System.err.println("Created> " + id + "/" + weight);
  }

  public void addNode(Node n) {
    nextNodes.add(n);
  }

  public int getWeight() {
    return weight;
  }

  public List<Node> getNextNodes() {
    return nextNodes;
  }

  public int getId() {
    return id;
  }
  // private int weight = -1;
  //
  // private List<Edge> edges = new LinkedList<>();
  //
  // private Node parent = null;
  //
  // public void add(Edge edge) {
  // edges.add(edge);
  // }

}
