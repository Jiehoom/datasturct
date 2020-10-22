package com.jiehoom.sort;


import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 测试希尔排序和插入排序的时间
 */
public class TestSortCompare {
    public static void main(String[] args) throws Exception {


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(TestSortCompare.class.getClassLoader().getResourceAsStream("reveredArray.txt")));
        String line =null;
        ArrayList<Integer> list = new ArrayList<>();
        while ((line=bufferedReader.readLine())!=null){
            int i = Integer.parseInt(line);
            list.add(i);
        }
        bufferedReader.close();

        Integer[] a =new Integer[list.size()];
        list.toArray(a);
        //testShellSort(a);//shell 排序的时间为32ms
        testInsetSort(a);//insert 排序的时间为27529ms
    }

    public static void testShellSort(Integer[] a){
        long begin = System.currentTimeMillis();
        ShellSort.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("shell 排序的时间为"+(end-begin)+"ms");
    }

    public static void testInsetSort(Integer[] a){
        long begin = System.currentTimeMillis();
        InsertSort.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("insert 排序的时间为"+(end-begin)+"ms");
    }
}
