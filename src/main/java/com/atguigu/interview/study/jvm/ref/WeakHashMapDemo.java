package com.atguigu.interview.study.jvm.ref;/**
 * @Author huzhpm
 * @Date 2021/3/22 22:36
 * @Version 1.0
 * @Content
 */

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * @program: thread
 * @description:
 * @author: huzhpm
 * @created: 2021/03/22 22:36
 */
public class WeakHashMapDemo {

    public static void main(String[] args) {
        myHashMap();
        System.out.println("***************");
        myWeakHashMap();
    }

    private static void myHashMap() {
        HashMap<Integer, String> map = new HashMap<>();
        Integer key = new Integer(1);
        String value = "HashMap";
        map.put(key, value);
        System.out.println(map);
        key = null;
        System.out.println(map);
        System.gc();
        System.out.println(map+"\t"+map.size());
    }

    private static void myWeakHashMap() {
        WeakHashMap<Integer, String> map = new WeakHashMap<>();
        Integer key = new Integer(1);
        String value = "WeakHashMap";
        map.put(key, value);
        System.out.println(map);
        key = null;
        System.out.println(map);
        System.gc();
        System.out.println(map+"\t"+map.size());
    }
}
