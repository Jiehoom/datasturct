package com.jiehoom.array.sparsearray;

/**
 * 实现一个二维数组转成稀疏数组的问题,也可以实现反转
 */
public class SparseArray {
    //自定义一个二维数组(以int类型为例)
    public static void main(String[] args) {
        int[][] chessArray = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;

        int[][] sparseArray=switchToSparseArray(chessArray);
        for (int[] row : sparseArray) {
            for (int item : row) {
                System.out.print(item+"\t");
            }
            System.out.println();
        }

        int[][] array = switchToArray(sparseArray);
        for (int[] row : array) {
            for (int item : row) {
                System.out.print(item+"\t");
            }
            System.out.println();
        }


    }

    /**
     * 转换成稀疏数组
     * @param chessArray
     * @return
     */
    public static int[][] switchToSparseArray(int[][] chessArray){
        //获取到非0的个数
        int sum = 0;
        for (int[] row : chessArray) {
            for (int item : row) {
                if (item != 0) {
                    sum++;
                }
            }
        }
        //创建稀疏数组对象
        int[][] sparseArray=new int[sum+1][3];
        sparseArray[0][0]=chessArray.length;
        sparseArray[0][1]=chessArray[0].length;
        sparseArray[0][2]=sum;

        //给稀疏数组赋值
        int count=0;
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[i].length; j++) {
                if (chessArray[i][j]!=0){
                    count++;
                    sparseArray[count][0]=i;
                    sparseArray[count][1]=j;
                    sparseArray[count][2]=chessArray[i][j];
                }
            }
        }
        return sparseArray;
    }

    /**
     * 稀疏数组复原为二维数组
     * @param sparseArray
     * @return
     */
    public static int[][] switchToArray(int[][] sparseArray){
        int[][] array;
        array=new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            int row=sparseArray[i][0];
            int clo=sparseArray[i][1];
            int num=sparseArray[i][2];
            array[row][clo]=num;
        }
        return array;
    }


}
