package com.jiehoom.sort;

public class SelectSort {

    public static void main(String[] args) {
        Integer[] arr=new Integer[]{9,5,4,16,8,48};
        sort(arr);
        for (Integer integer : arr) {
            System.out.print(integer+"\t");
        }
    }


    public static void sort(Comparable[] comparables){
        for (int i = 0; i < comparables.length; i++) {
            //记录每次遍历中最小的值的索引位置
            int index=i;
            for (int j = i+1; j < comparables.length; j++) {
                if (SortUtils.greater(comparables[index],comparables[j])){
                    index=j;
                }
            }
            //再和当前循环的位置元素交换
            SortUtils.exch(comparables,i,index);
        }
    }

}
