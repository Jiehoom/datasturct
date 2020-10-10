package com.jiehoom.sort;

public class InsertSort {
    public static void main(String[] args) {
        Integer[] arr=new Integer[]{9,5,4,16,8,48};
        sort(arr);
        for (Integer integer : arr) {
            System.out.print(integer+"\t");
        }
    }

    public static void sort(Comparable[] comparables){
        for (int i = 1; i < comparables.length; i++) {
            int temp=i;
            for (int j=i-1;j>=0;j--){
                //用临时移动的索引和已经排序好的"有序"数组中分别比较和交换
                if (SortUtils.greater(comparables[j],comparables[temp])){
                    SortUtils.exch(comparables,temp,j);
                    temp=j;
                }else {
                    break;
                }
            }
        }
    }
}
