package com.company;

public class Main {

    public static void main(String[] args) {
        Matrix m1 = new Matrix(2,2,1,2,3,4);
        Matrix m2 = new Matrix(2,2,1,2,3,4);
        Matrix A = new Matrix(2,4,1,4,5,1,2,3,7,3);
        Matrix B = new Matrix(3,2,3,4,2,7,4,2);
//        m1.show();
        Matrix m3 = new Matrix(Matrix.addition(m1,m2));
//        m3.show();
        A.show();
        B.show();
        Matrix C = new Matrix(Matrix.multiplication(B,A));
        C.show();
        C.transpose();
        C.show();
    }
}
