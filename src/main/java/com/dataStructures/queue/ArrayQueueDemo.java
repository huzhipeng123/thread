package com.dataStructures.queue;

/**
 * @program: thread
 * @description: 数组模拟队列
 * @author: huzhpm
 * @created: 2021/04/18 21:11
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {

    }

}

/**
 * 使用数组模拟队列
 * 编写一个ArrayQueue类
 */
class ArrayQueue{
    /**
     * 表示数组的最大容量
     */
    private int maxSize;

    /**
     * 队列头
     */
    private int front;

    /**
     * 队列尾
     */
    private int rear;

    /**
     * 该数据用于存放数据，模拟队列
     */
    private int[] arr;

    /**
     * 创建队列的构造器
     * @param arrMaxSize
     */
    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        // 指向队列头部，分析出front是指向队列头的前一个位置
        front = -1;
        // 指向队列尾部，指向队列尾的数据（即就是队列的最后一个数据）
        rear = -1;
    }

    /**
     * 判断队列是否满
     * @return
     */
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return front == rear;
    }

    /**
     * 添加数据到队列
     */
    public void addQueue(int n){
        // 判断队列是否满
        if(isFull()){
            throw new RuntimeException("队列满，不能加入数据~");
        }
        // 让rear 后移
        rear++;
        arr[rear] = n;
    }

    /**
     * 获取队列的数据，出队列
     * @return
     */
    public int getQueue(){
        // 判断队列是否空
        if(isEmpty()){
            // 通过抛出异常
            throw new RuntimeException("队列空， 不能取数据");
        }
        // front 后移
        front++;
        return arr[front];
    }

    /**
     * 显示队列的所有数据
     */
    public void showQueue(){
        // 遍历
        if(isEmpty()){
            System.out.println("队列为空，没有数据~~");
        }
        for(int i = 0; i < arr.length; i++){
            System.out.printf("arr[%d]=[%d]\n", i, arr[i]);
            System.out.println();
        }
    }

    /**
     * 显示队列的头数据，注意不是取出数据
     */
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return arr[front + 1];
    }

}