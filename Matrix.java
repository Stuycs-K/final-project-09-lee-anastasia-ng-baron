import java.util.*;
public class Matrix {
  protected ArrayList<int[]> m;

  Matrix() {
    m = new ArrayList<int[]>();
  }//constructor

  public void addColumn(int a, int b, int c, int d) {
    int[] col = {a, b, c, d};
    m.add(col);
  }//addColumn

  public void ident() {
    m = new ArrayList<int[]>();
    for (int i=0; i<4; i++) {
      int[] point = new int[4];
      point[i] = 1;
      m.add(point);
    }
  }//ident

  public void mult(Matrix a) {
    int[] tmp = new int[4];
    for (int c=0; c<m.size(); c++) {
      int[] point = m.get(c);
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
    m = new ArrayList<int[]>();
  }//clear

  public int[] get(int i) {
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
      for (int[] p : m) {
        s+= p[i] + " ";
      }
      s+= "\n";
    }
    return s;
  }
}//Matrix
