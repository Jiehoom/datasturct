package com.jiehoom.sort;

/**
 * 实现冒泡排序 时间复杂度为O(n^2)
 */
public class BubbleSorting{
    public static void main(String[] args) {
        Integer[] arr=new Integer[]{9,5,4,16,8,48};
        sort(arr);
        for (Integer integer : arr) {
            System.out.print(integer+"\t");
        }
    }


    public static void sort(Comparable[] comparables) {
        for (int i = 0; i < comparables.length; i++) {
            for (int j = i; j < comparables.length; j++) {
                if (SortUtils.greater(comparables[i],comparables[j])){
                    SortUtils.exch(comparables,i,j);
                }
            }
        }
    }
}
