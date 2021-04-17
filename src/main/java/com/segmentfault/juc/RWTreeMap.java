package com.segmentfault.juc;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: thread
 * @description: LockSupport Demo
 * @author: huzhpm
 * @created: 2021/04/17 15:32
 */
public class RWTreeMap {

    private final Map<String, String> m = new TreeMap<>();
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();

    public String get(String key){
        r.lock();
        try{
            return m.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            r.unlock();
        }
        return null;
    }

    public String[] allKeys(){
        r.lock();
        try {
            return (String[]) m.keySet().toArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            r.unlock();
        }
        return null;
    }

    public String put(String key, String value){
        w.lock();
        try {
            return m.put(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            w.unlock();
        }
        return null;
    }

    public void clear(){
        w.lock();
        try {
            m.clear();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            w.unlock();
        }
    }

}
