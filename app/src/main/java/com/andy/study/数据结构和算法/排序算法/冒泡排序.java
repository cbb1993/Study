package com.andy.study.数据结构和算法.排序算法;

/**
 *  8个数以下排序优先选择冒泡算法
 * Created by 坎坎 on 2018/1/29.
 */

public class 冒泡排序 {
    public  static int[] array={5,3,7,9,1,8,4,6,2};
    public static void main(String[] a){

        sort();
        for (int i :array){
            System.out.print( i+"  " );
        }
    }

    /**
     * 思想：相连两位互相比较，满足条件，交换位置
    * */
    public static void sort(){
        /*
        * step1: 一轮移动  ，将最大值移动到末尾
        * */
       /* for (int j = 0 ;j< array.length-1;j++){
            if(array[j]> array [j+1]){
                int temp =array[j];
                array[j] =array[j+1];
                array[j+1]=temp;
            }
        }*/

        /*
        * step2: 外面套上循环 ，将整个数组排序
        * */

       /* for(int i = array.length -1 ;i>0 ;i--){
            for (int j = 0 ;j< array.length-1;j++){
                if(array[j]> array [j+1]){
                    int temp =array[j];
                    array[j] =array[j+1];
                    array[j+1]=temp;
                }
            }
        }*/

        /*
        * step3: 优化  1. 每轮排序后 ，后面的值都确定了  无需再次排序  --》 j < i
        *              2. 有可能某一轮排序时 没有发生一次交换 ，代表已经排序好了，跳出循环
        * */

        for(int i = array.length -1 ;i>0 ;i--){
            boolean exchanged=false;
            for (int j = 0 ;j< i;j++){
                if(array[j]> array [j+1]){
                    int temp =array[j];
                    array[j] =array[j+1];
                    array[j+1]=temp;
                    exchanged=true;
                }
            }
            if(!exchanged){
                break;
            }
        }
    }
}
