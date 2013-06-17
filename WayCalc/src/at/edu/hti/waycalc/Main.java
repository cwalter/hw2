
package at.edu.hti.waycalc;

import at.edu.hti.waycalc.graph.Matrix;

public class Main {

  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    Matrix matrix = new Matrix();
    try {
      if (args.length <= 0) {
        throw new NullPointerException("Provide an absolute file path to the matrix resource file, e.g. /testfiles/matrix.txt");
      }
      matrix.load(args[0]);

      matrix.traverse(matrix.getStartnode(), 0);

      int shortestWay = -1;
      for (int i = 0; i < matrix.getWayWeights().size(); i++) {
        if (shortestWay < 0 || matrix.getWayWeights().get(i) < shortestWay) {
          shortestWay = matrix.getWayWeights().get(i);
        }
      }

      long stop = System.currentTimeMillis();
      System.out.println("Solution: " + shortestWay + " in: " + (stop - start) + " millis");
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
