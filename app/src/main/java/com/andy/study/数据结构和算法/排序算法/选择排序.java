package com.andy.study.数据结构和算法.排序算法;

/**
 * Created by 坎坎 on 2018/1/29.
 */

public class 选择排序 {

    public  static int[] array={5,3,7,9,1,8,4,6,2};
    public static void main(String[] a){
        sort();
        for (int i :array){
            System.out.print( i+"  " );
        }
    }
    /** 升序案例
    *  思想 ：第一位不动，在后面的元素中找到最小的一位， 再与第一位比较 ，
    * */
    private static void sort() {
        /*
        * step1: 找到除第一位最小的一位 与第一位比较 满足条件则交换位置
        * */
       /* int index=0;
        for (int j = 1; j < array.length; j++) {
            if (array[j] < array[index]) {
                index = j;
            }
        }
        if(index!=0){
            if(array[0]> array[index]){
                int temp =array[0];
                array[0] =array[index];
                array[index]=temp;
            }
        }*/

       /*
       * step2: 起始位置往后递增
       * */
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            if (index != i) {//表示打到过最小值
                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
        }
    }
}
