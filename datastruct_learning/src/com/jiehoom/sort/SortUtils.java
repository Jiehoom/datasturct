package com.jiehoom.sort;

public class SortUtils {
    private  SortUtils(){

    }

    //判断a是否大于b
    public static boolean greater(Comparable a,Comparable b){
        return a.compareTo(b)>0;
    }

    //交换数据
    public static void exch(Comparable[] comparables ,int i,int j){
        Comparable temp=comparables[i];
        comparables[i]=comparables[j];
        comparables[j]=temp;
    }
}
