public class LinearRegression {

  private double[][] a;
  private double[][] aTranspose;
  private double[][] aTa; // (A^T)A
  private double [][] x;
  private double [][] b;
  private double [][] aTb; // (A^T)b

  public LinearRegression(double[][] a, double[][] b) {

    assert(x[0].length == 1);
    assert(b[0].length == 1);
    assert(a.length == b.length);

    this.a = a;
    this.b = b;
    this.aTranspose = MatrixUtils.transposeMatrix(a);
    this.aTa = MatrixUtils.multiply(this.aTranspose, a);
    this.aTb = MatrixUtils.multiply(this.aTranspose, b);

    // create coefficient matrix for jacobiSolver:
    int aTaRows = this.aTa.length;
    int aTaCols = this.aTa[0].length;
    double[][] coefficients = new double[aTaRows][aTaCols + 1];
    for (int i = 0; i < aTaRows; i++) {
      coefficients[i][aTaCols] = this.aTb[i][0];
    }

    for (int i = 0; i < aTaRows; i++) {
      for (int j = 0; j < aTaCols; j++) {
        coefficients[i][j] = this.aTa[i][j];
      }
    }

    JacobiSolver jacobiSolver = new JacobiSolver(coefficients);
    for (int i = 0; i < 20; i++) {
      jacobiSolver.jacobiIterate();
    }
    this.x = jacobiSolver.getCurrentSolution();
  }

  public double[][] getApproxSolution() {
    return this.x;
  }

}
