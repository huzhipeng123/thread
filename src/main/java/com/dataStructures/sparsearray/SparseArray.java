package com.dataStructures.sparsearray;

import com.dataStructures.utils.ArrayUtils;

/**
 * @program: thread
 * @description: 稀疏数组
 * @author: huzhpm
 * @created: 2021/04/18 19:35
 */
public class SparseArray {

    public static void main(String[] args) {
        // 创建一个原始的二维数组 11 * 11
        // 0：表示没有棋子，1表示黑子，2表示蓝子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][4] = 2;
        // 输出原始二维数组
        System.out.println("原始的二维数组：");
        ArrayUtils.printArray(chessArr1);

        // 将二维数组转稀疏数组的思想
        // 1、先遍历二维数组，得到非0的数组的个数
        int sum = 0;
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                if(chessArr1[i][j] != 0){
                    sum++;
                }
            }
        }

        // 创建对应的稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        // 给稀疏数组赋值
        sparseArr[0][0] = chessArr1.length;
        sparseArr[0][1] = chessArr1[0].length;
        sparseArr[0][2] = sum;

        // 遍历二维数组，将非0的值存放到sparseArr中
        // count 用于记录是第几个非0数据
        int count = 1;
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                if(chessArr1[i][j] != 0){
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                    count++;
                }
            }
        }

        // 输出稀疏数组的形式
        System.out.println();
        System.out.println("等到的稀疏数组为~~~~~~");
        for(int[] sparse : sparseArr){
            System.out.printf("%d\t%d\t%d\t", sparse[0], sparse[1], sparse[2]);
            System.out.println();
        }


        // 将稀疏数组 --> 恢复成原始的二维数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for(int i = 1; i < sparseArr.length; i++){
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("恢复后的二维数组");
        ArrayUtils.printArray(chessArr2);
    }

}
