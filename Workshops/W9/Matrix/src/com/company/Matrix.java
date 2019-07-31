package com.company;

public class Matrix {
    double[][] a;

    public Matrix(int n) {
        this.a = new double[n][n];
    }

    public void fillMatrix() {
        for (int i = 0; i < this.a.length; i++) {
            for (int j = 0; j < this.a[i].length; j++) {
                this.a[i][j] = 1;
            }
        }
    }

    public double[][] getA() {
        return a;
    }
}
