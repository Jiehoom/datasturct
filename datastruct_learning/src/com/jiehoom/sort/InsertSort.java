package com.jiehoom.sort;

public class InsertSort {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{9, 5, 4, 16, 8, 48, 98, 1, 2};
        sort(arr);
        for (Integer integer : arr) {
            System.out.print(integer+"\t");
        }
    }

    public static void sort(Comparable[] comparables){
        for (int i = 1; i < comparables.length; i++) {
            for (int j=i;j>0&&SortUtils.greater(comparables[j-1],comparables[j]);j--){
                //用临时移动的索引和已经排序好的"有序"数组中分别比较和交换
                SortUtils.exch(comparables,j-1,j);
            }
        }
    }
}
