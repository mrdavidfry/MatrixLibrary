public class Main {

  public static void main(String[] args) {
    double[][] a = {{2, 2}, {1, 2}, {2, 0}};
    double[][] b = {{0}, {5}, {-1}};

    LinearRegression linearRegression = new LinearRegression(a, b);
    MatrixUtils.print2DMatrix(linearRegression.getApproxSolution());
  }

}
