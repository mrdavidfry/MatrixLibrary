public class MatrixUtils {

  /** Returns the transpose of a matrix. **/
  public static double[][] transposeMatrix(double[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;

    double[][] transpose = new double[cols][rows];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        transpose[j][i] = matrix[i][j];
      }
    }
    return transpose;
  }

  /** Adds two matricies.
   *  PRE: a and b must have the same dimensions. **/
  public static double[][] addVectors(double[][] a, double[][] b) {
    int aRows = a.length;
    int aCols = a[0].length;
    int bRows = b.length;
    int bCols = b[0].length;

    assert(aRows == bRows);
    assert(aCols == bCols);

    double[][] c = new double[aRows][aCols];

    for (int i = 0; i < aRows; i++) {
      for (int j = 0; j < aCols; j++) {
        c[i][j] = a[i][j] + b[i][j];
      }
    }
    return c;
  }

  /** Returns the result of matrix a multiplied by matrix b.
   *  PRE: a[0].length == b.length. **/
  public static double[][] multiply(double[][] a, double[][] b) {
    int aRows = a.length;
    int aCols = a[0].length;
    int bRows = b.length;
    int bCols = b[0].length;

    assert(aCols == bRows);

    double[][] c = new double[aRows][bCols];
    for (int i = 0; i < aRows; i++) {
      for (int j = 0; j < bCols; j++) {
        for (int k = 0; k < aCols; k++) {
          c[i][j] += a[i][k] * b[k][j];
        }
      }
    }
    return c;
  }

  public static void print2DMatrix(double[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

}
