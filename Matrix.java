import java.util.*;
public class Matrix {
  protected ArrayList<byte[]>m;

  Matrix() {
    m = new ArrayList<byte[]>();
  }//constructor

  public void addColumn(byte a, byte b, byte c, byte d) {
    byte[] col = {a, b, c, d};
    m.add(col);
  }//addColumn

  public void ident() {
    m = new ArrayList<byte[]>();
    for (int i=0; i<4; i++) {
      byte[] point = new byte[4];
      point[i] = 1;
      m.add(point);
    }
  }//ident

  public void mult(Matrix a) {
    byte[] tmp = new byte[4];
    for (int c=0; c<m.size(); c++) {
      byte[] point = m.get(c);
      //copy values from m over
      for (int r=0; r < point.length; r++)
        tmp[r] = point[r];

      for (int r=0; r < point.length; r++) {
        m.get(c)[r] = (byte)(((a.m.get(0)[r] * tmp[0]) ^
          (a.m.get(1)[r] * tmp[1]) ^
          (a.m.get(2)[r] * tmp[2]) ^
          (a.m.get(3)[r] * tmp[3])) & 0xff);
      }
    }
  }//mult

  public void clear() {
    m = new ArrayList<byte[]>();
  }//clear

  public byte[] get(int i) {
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
      for (byte[] p : m) {
        String s1 = String.format("%8s", Integer.toBinaryString(p[i] & 0xff)).replace(' ', '0');
        s+= s1 + " ";
      }
      s+= "\n";
    }
    return s;
  }

  public String toIntString() {
    String s = "";
    if (m.size() == 0) {
      return s;
    }

    for (int i=0; i<4; i++) {
      for (byte[] p : m) {
        s+= (int)p[i] + " ";
      }
      s+= "\n";
    }
    return s;
  }

  public String toSuperString() {
    String s = "";
    if (m.size() == 0) {
      return s;
    }

    for (int i=0; i<4; i++) {
      for (byte[] p : m) {
        s += (char)(p[i]);
      }
    }
    return s;
  }
}//Matrix
