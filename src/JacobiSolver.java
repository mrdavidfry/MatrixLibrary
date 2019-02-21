public class JacobiSolver {

  private final double[][] coefficients;
  private final double[][] c;
  private double[][] solution;

  /** Coefficients is a matrix [A | b]. **/
  public JacobiSolver(double[][] coefficients) {
    int rows = coefficients.length;
    int cols = coefficients[0].length;

    assert (rows > 0);
    assert (cols > 0);
    assert(rows >= cols - 1);

    int rowsMinusOne = rows - 1;
    int colsMinusOne = cols - 1;

    // populate coefficients array:
    this.coefficients = new double [rows][colsMinusOne];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < colsMinusOne; j++) {
        this.coefficients[i][j] = coefficients[i][j];
      }
    }

    double leadCoefficient;
    for (int i = 0; i < rows; i++) {
      leadCoefficient = coefficients[i][i];
      for (int j = 0; j < colsMinusOne; j++) {
        this.coefficients[i][j] /= -leadCoefficient;
      }
      this.coefficients[i][i] = 0;
    }

    // populate array of constants c:
    c = new double [rows][1];
    for (int i = 0; i < rows; i++) {
      leadCoefficient = coefficients[i][i];
      this.c[i][0] = coefficients[i][colsMinusOne] / leadCoefficient;
    }
    this.solution = new double[rows][1];
  }

  /** Returns the current approximation to the solution. **/
  public double[][] getCurrentSolution() {
    return this.solution;
  }

  public void printCurrentSolution() {
    MatrixUtils.print2DMatrix(this.solution);
  }

  /** Completes one jacobi Iteration. **/
  public double[][] jacobiIterate() {
    this.solution = MatrixUtils.addVectors(MatrixUtils.multiply(this.coefficients, this.solution), this.c);
    return this.solution;
  }

}
