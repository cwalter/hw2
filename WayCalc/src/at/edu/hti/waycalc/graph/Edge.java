package at.edu.hti.waycalc.graph;

public class Edge {
	
	private int weight = -1;
	
	private Node target = null;
	
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public Node getTarget() {
		return target;
	}
	
	public void setTarget(Node target) {
		this.target = target;
	}

}
