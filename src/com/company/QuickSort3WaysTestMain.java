package com.company;

import java.util.Arrays;

/**
 * 三路快速排序
 */
public class QuickSort3WaysTestMain {

    public static void main(String[] args) {
        int array[] = new int[]{3,1,9,6,5,6,2,8,3,3,18,10,4,6,18,72,70,55,34,34,10,1};
        System.out.println("排序前:"+ Arrays.toString(array));
        quickSort3Ways(array);
        System.out.println("排序后:"+ Arrays.toString(array));
    }

    private static void quickSort3Ways(int array[]){
        quickSort3Ways(array,0,array.length - 1);
    }

    private static void quickSort3Ways(int array[],int left,int right){
        //获取基准值
        int value = array[left];
        int lt = left;//array[l + 1...lt] < value
        int gt = right + 1;//array[gt...r] > value
        int i = left + 1;//array[lt + 1...i] == value
        while (i < gt){
            //i从left + 1开始
            //lt从left开始
            if (array[i] < value){
                //一旦当前元素i小于基准值，将当前元素放入到array[l + 1...lt]序列的lt + 1位置
                int temp = array[i];
                array[i] = array[lt + 1];
                array[lt + 1] = temp;
                lt++;
                i++;
            }else if (array[i] > value){
                //需要将当前元素放入到array[gt...r]序列中，放入到该序列的第一个位置，故gt - 1位置
                int temp = array[i];
                array[i] = array[gt - 1];
                array[gt - 1] = temp;
                gt--;
            }else{
                //array[i] == V
                i++;
            }
        }
        int temp = array[left];
        array[left] = array[lt];
        array[lt] = temp;
        quickSort3Ways(array,left,lt - 1);
        quickSort3Ways(array,gt,right);
    }
}
