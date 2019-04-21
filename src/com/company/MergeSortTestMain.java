package com.company;

import java.util.Arrays;

public class MergeSortTestMain {

    public static void main(String[] args) {
        int array[] = new int[]{12,2,6,55,100,56};
        System.out.println("排序前:"+ Arrays.toString(array));
        long startTime = System.nanoTime();   //获取开始时间
        mergeSort(array);
        long endTime = System.nanoTime(); //获取结束时间
        double time = endTime - startTime;
        System.out.println("排序后:"+ Arrays.toString(array) + "执行耗时:"+ time+"ns");
    }

    private static void mergeSort(int array[]){
        _mergeSort(array,0,array.length - 1);
    }

    private static void _mergeSort(int array[],int left,int right){
        if (left >= right) {
            return;
        }
        int center = (left + right) / 2;//得到数组二分后的mid位置
        _mergeSort(array, left, center);//对二分后的起始点至mid点进行排序
        _mergeSort(array,center + 1,right);//对二分后mid点至右侧终点进行排序
        if (array[center] > array[center + 1]) {
            _merge(array, left, center, right);
        }
    }

    private static void _merge(int array[],int left,int mid,int right){
        //临时空间
        int [] aux = new int[right - left + 1];
        //从左侧l点开始,至右侧r点
        for (int i = left; i <= right; i++) {
            aux[i - left] = array[i];
        }
        int i = left;
        int j = mid + 1;
        //从开始点至结束点
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                array[k] = aux[j - left];
                j++;
            }
            else if (j > right) {
                array[k] = aux[i - left];
                i++;
            }
            else if (aux[i - left] < aux[j - left]) {
                array[k] = aux[i - left];
                i++;
            }
            else{
                array[k] = aux[j - left];
                j++;
            }
        }

    }
}
