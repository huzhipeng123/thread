package com.dataStructures.utils;

/**
 * @program: thread
 * @description: 数组工具类
 * @author: huzhpm
 * @created: 2021/04/18 20:00
 */
public class ArrayUtils {

    /**
     * 打印二维数组
     * @param chessArr1
     */
    public static void printArray(int[][] chessArr1) {
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

}
