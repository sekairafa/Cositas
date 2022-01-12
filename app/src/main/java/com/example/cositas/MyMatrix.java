 package com.example.cositas;

public class MyMatrix {
    private int rows;
    private int columns;

    private double[][] matrix;

    public MyMatrix(int rows, int columns) {
        this.initialize(rows, columns);
    }

    public MyMatrix(int size) {
        initialize(size, size);
    }

    public MyMatrix(MyMatrix myMatrix) {
        this.initialize(myMatrix.rows, myMatrix.columns);
        for(int j = 0; j < this.rows; j++) {
            System.arraycopy(myMatrix.matrix[j], 0, this.matrix[j], 0, this.columns);
        }
    }

    private void initialize(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        this.matrix = new double[this.rows][this.columns];
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

    public double get(int row, int column) {
        return this.matrix[row][column];
    }

    public void set(int row, int column, double val) {
        this.matrix[row][column] = val;
    }

    public boolean isSquare() {
        return (this.rows == this.columns);
    }

    public MyMatrix sum(double val) {
        for(int j = 0; j < this.rows; j++) {
            for(int i = 0; i < this.columns; i++) {
                this.matrix[j][i] += val;
            }
        }

        return this;
    }

    public MyMatrix sum(MyMatrix myMatrix) {
        if (this.rows == myMatrix.rows || this.columns == myMatrix.columns) {
            for(int j = 0; j < this.rows; j++) {
                for(int i = 0; i < this.columns; i++) {
                    this.matrix[j][i] += myMatrix.matrix[j][i];
                }
            }
        }

        return this;
    }

    public MyMatrix sub(double val) {
        return this.sum(-val);
    }


    public MyMatrix sub(MyMatrix myMatrix) {
        if (this.rows == myMatrix.rows || this.columns == myMatrix.columns) {
            for(int j = 0; j < this.rows; j++) {
                for(int i = 0; i < this.columns; i++) {
                    this.matrix[j][i] -= myMatrix.matrix[j][i];
                }
            }
        }

        return this;
    }

    public MyMatrix multiply(double val) {
        for(int j = 0; j < this.rows; j++) {
            for(int i = 0; i < this.columns; i++) {
                this.matrix[j][i] *= val;
            }
        }

        return this;
    }

    public static MyMatrix sum(MyMatrix matrixA, MyMatrix matrixB) {
        MyMatrix matrixC = new MyMatrix(matrixA);

        return matrixC.sum(matrixB);
    }

    public static MyMatrix sub(MyMatrix matrixA, MyMatrix matrixB) {
        MyMatrix matrixC = new MyMatrix(matrixA);

        return matrixC.sub(matrixB);
    }

    public static MyMatrix multiply(MyMatrix matrixA, MyMatrix matrixB) {
        if (matrixA.columns != matrixB.rows) {
            return null;
        }

        MyMatrix matrixC = new MyMatrix(matrixA.rows, matrixB.columns);

        for(int j = 0; j < matrixC.rows; j++) {
            for(int i = 0; i < matrixC.columns; i++) {
                matrixC.matrix[j][i] = 0.0;

                for(int k = 0; k < matrixA.columns; k++) {
                    matrixC.matrix[j][i] += matrixA.matrix[j][k] * matrixB.matrix[k][i];
                }
            }
        }

        return matrixC;
    }

    public MyMatrix transpose() {
        MyMatrix matrix = new MyMatrix(this.columns, this.rows);

        for(int j = 0; j < this.columns; j++) {
            for(int i = 0; i < this.rows; i++) {
                matrix.matrix[j][i] = this.matrix[i][j];
            }
        }

        return matrix;
    }

    public double determinant() {
        if (!this.isSquare()) {
            return 0.0;
        }

        int n = this.rows;
        if (n == 1) {
            return this.matrix[0][0];
        }

        double temp = 0.0;

        for (int i = 0; i < n; i++) {
            temp += subAdjunct(0, i) * this.matrix[0][i];
        }

        return temp;
    }

    private double subAdjunct(int row, int col) {
        return Math.pow(-1.0, row + col) * this.minimum(row, col).determinant();
    }

    private MyMatrix minimum(int row, int col) {
        int n = this.rows - 1;

        if (n == 0) {
            return null;
        }

        MyMatrix matrix = new MyMatrix(n);

        int i, j;

        for (j = 0; j < row; j++) {
            for (i = 0; i < col; i++) {
                matrix.matrix[j][i] = this.matrix[j][i];
            }

            for (i = col; i < n; i++) {
                matrix.matrix[j][i] = this.matrix[j][i + 1];
            }
        }

        for (j = row; j < n; j++) {
            int j_ = j + 1;

            for (i = 0; i < col; i++) {
                matrix.matrix[j][i] = this.matrix[j_][i];
            }

            for (i = col; i < n; i++) {
                matrix.matrix[j][i] = this.matrix[j_][i + 1];
            }

        }

        return matrix;
    }

    public MyMatrix adjunct() {
        if (!this.isSquare()) {
            return null;
        }

        int n = this.rows;
        if (n == 1) {
            MyMatrix temp = new MyMatrix(1);
            temp.set(0, 0, 1.0);
            return temp;
        }

        MyMatrix matrix = new MyMatrix(n);

        for(int j = 0; j < n; j++) {
            for(int i = 0; i < n; i++) {
                matrix.matrix[j][i] = subAdjunct(j, i);
            }
        }

        return matrix;
    }

    public MyMatrix inverse() {
        if (!this.isSquare()) {
            return null;
        }

        double determinant = this.determinant();
        if (determinant == 0.0) {
            return null;
        }

        return this.adjunct().transpose().multiply(1 / determinant);
    }

    public static double[] getSolutions(MyMatrix fields_left, double[] fields_right) throws Exception {
        if (!fields_left.isSquare()) {
            throw new Exception("Sistema debe ser matriz cudrada");
        }

        int order = fields_left.getRows();
        if (order != fields_right.length) {
            throw new Exception("Sistema incongruente");
        }

        double determinant = fields_left.determinant();
        if (determinant == 0.0) {
            throw new Exception("Sistema linealmente dependiente");
        }

        double[] solutions = new double[order];

        for (int i = 0; i < order; i++) {
            solutions[i] = fields_left.replaceCol(fields_right, i).determinant() / determinant;
        }

        return solutions;
    }

    private MyMatrix replaceCol(double[] col, int index) {
        MyMatrix matrix = new MyMatrix(this);

        for (int i = 0; i < this.columns; i++) {
            matrix.matrix[i][index] = col[i];
        }

        return matrix;
    }
}
