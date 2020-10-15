package com.jiehoom.sort;

public class ShellSort {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{9, 5, 4, 16, 8, 48, 98, 1, 2};
        sort(arr);
        SortUtils.print(arr);
    }

    public static void sort(Comparable[] comparables) {
        //h值的确定还待考究
        //首先确定好h的值
        int h = 1;
        while (h < comparables.length) {
            h = 2 * h + 1;
        }
        while (h >= 1) {
            //排序
            //决定h每次变化后执行的次数
            for (int i = h; i < comparables.length; i++) {
                for (int j=i;j>=h&&SortUtils.greater(comparables[j-h],comparables[j]);j-=h){
                    SortUtils.exch(comparables,j-h,j);
                }
            }
            h = h / 2;
        }

    }
}
