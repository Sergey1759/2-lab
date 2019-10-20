package com.company;

public class Matrix {
    int[][] arr = new int[1][1];
    int M,N;
    int lengthCol;
    int lengthRow;

    public Matrix(int[][] arr) {
        this.arr = arr;
        this.lengthCol = arr[0].length;
        this.lengthRow = arr.length;
    }
    public Matrix(int M,int N,int ... arr) {
        int[][] buf = new int[M][N];
        int k = 0;
        if(M*N == arr.length){
            for (int i = 0; i < M; i++){
                for (int j = 0; j < N; j++){
                    buf[i][j] = arr[k++];
                }
            }
            this.lengthCol = buf[0].length;
            this.lengthRow = buf.length;
            this.arr = buf;
        } else {
            System.out.println("error");
        }
    }
    public void show(){
        for (int i = 0; i < this.arr.length; i++){
            for (int j = 0; j < this.arr[0].length; j++){
                System.out.print(this.arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] addition(Matrix M1,Matrix M2){
        int[][] buf = new int[M1.lengthRow][M1.lengthCol];
        if(M1.lengthRow == M2.lengthRow && M1.lengthCol == M2.lengthCol){
            for (int i = 0; i < M1.lengthRow; i++){
                for (int j = 0; j < M1.lengthCol; j++){
                    buf[i][j] = M1.arr[i][j] + M2.arr[i][j];
                }
            }
            return buf;
        } else {
            System.out.println("error");
            return null;
        }
    }
    public static int[][] multiplication(Matrix M1,Matrix M2) {
        int[][] buf = new int[M1.lengthRow][M2.lengthCol];
        for (int i = 0; i < M1.lengthRow; i++){
            for(int j = 0; j < M2.lengthCol; j++){
               buf[i][j] = multiplicationHelper(M1,M2,i,j);
            }
        }
        return buf;
    }
    public static int multiplicationHelper(Matrix M1, Matrix M2, int M, int N){
        int[] buf1 = new int[10];
        int[] buf2 = new int[10];
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < M1.lengthRow; i++){
            for (int j = 0; j < M1.lengthCol; j++){
                if(i == M){
                    buf1[count1++] = M1.arr[i][j];
                }
            }
        }
        for (int i = 0; i < M2.lengthRow; i++){
            for (int j = 0; j < M2.lengthCol; j++){
                if(j == N){
                    buf2[count2++] = M2.arr[i][j];
                }
            }
        }
        int buffer = 0;
        for(int i = 0; i < buf1.length;i++){
            buffer += buf1[i]*buf2[i];
        }
        return buffer;
    }
    public void transpose(){
        int[][] buf = new int[this.lengthCol][this.lengthRow];
        for(int i = 0; i < this.arr.length; i++){
            for(int j = 0; j < this.arr[0].length; j++){
                buf[j][i] = this.arr[i][j];
            }
        }
        this.arr = buf;
    }

}
