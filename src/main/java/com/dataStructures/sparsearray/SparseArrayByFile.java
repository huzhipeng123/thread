package com.dataStructures.sparsearray;

import com.dataStructures.utils.ArrayUtils;

import java.io.*;

/**
 * @program: thread
 * @description: 稀疏数组通过文件存取
 * 将稀疏数组保存到磁盘中，比如map.data
 * 恢复原来的数组时，读取map.data进行恢复
 * @author: huzhpm
 * @created: 2021/04/18 19:35
 */
public class SparseArrayByFile {

    public static void main(String[] args) throws IOException {
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

        // 将稀疏数组保存到磁盘中，比如map.data
        File writeName = new File("src\\resources\\files\\map.data");
        if(!writeName.exists()){
            writeName.getParentFile().mkdirs();
            writeName.createNewFile();
        }
        BufferedWriter out = new BufferedWriter(new FileWriter(writeName));
        StringBuilder str = null;
        for(int[] row : sparseArr){
            str = new StringBuilder();
            for(int data : row){
                str.append(data).append(" ");
            }
            str.append("\r\n");
            out.write(str.toString());
        }
        out.flush();
        out.close();


//        恢复原来的数组时，读取map.data进行恢复
        InputStreamReader reader = new InputStreamReader(new FileInputStream(writeName));
        BufferedReader br = new BufferedReader(reader);
        String line = "";
        line = br.readLine();
        String[] split = line.split(" ");
        int row = Integer.valueOf(split[0]);
        int col = Integer.valueOf(split[1]);
        int sum_len = Integer.valueOf(split[2]);
        // 通过文件恢复的原始数组
        int[][] chessArr3 = new int[row][col];
        int split_len = 1;
        while ((line = br.readLine()) != null){
            split = line.split(" ");
            int i = Integer.valueOf(split[0]);
            int j = Integer.valueOf(split[1]);
            int value = Integer.valueOf(split[2]);
            chessArr3[i][j] = value;
        }
        System.out.println("恢复后的二维数组");
        ArrayUtils.printArray(chessArr3);

    }

}
