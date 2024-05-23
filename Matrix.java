import java.util.*;
public class Matrix {
  protected ArrayList<double []>m;

  Matrix() {
    m = new ArrayList<double []>();
  }//constructor

  public void addColumn(double x, double y, double z) {
    double[] col = {x, y, z, 1};
    m.add(col);
  }//addColumn

  public void ident() {
    m = new ArrayList<double []>();
    for (int i=0; i<4; i++) {
      double[] point = new double[4];
      point[i] = 1;
      m.add(point);
    }
  }//ident

  public void mult(Matrix a) {
    double[] tmp = new double[4];
    for (int c=0; c<m.size(); c++) {
      double[] point = m.get(c);
      //copy values from m over
      for (int r=0; r < point.length; r++)
        tmp[r] = point[r];

      for (int r=0; r < point.length; r++) {
        m.get(c)[r] = a.m.get(0)[r] * tmp[0] +
          a.m.get(1)[r] * tmp[1] +
          a.m.get(2)[r] * tmp[2] +
          a.m.get(3)[r] * tmp[3];
      }
    }
  }//mult

  public void clear() {
    m = new ArrayList<double[] >();
  }//clear

  public double[] get(int i) {
    return m.get(i);
  }

  public Matrix copy() {
    Matrix nm = new Matrix();
    for (int c=0; c<m.size(); c++) {
      nm.m.add( Arrays.copyOf(m.get(c), 4));
    }
    return nm;
  }

  public String toString() {

    String s = "";
    if (m.size() == 0) {
      return s;
    }

    for (int i=0; i<4; i++) {
      for (double[] p : m) {
        s+= p[i] + " ";
      }
      s+= "\n";
    }
    return s;
  }
}//Matrix
