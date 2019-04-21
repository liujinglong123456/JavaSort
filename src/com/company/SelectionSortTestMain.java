package com.company;

import java.util.Arrays;

public class SelectionSortTestMain {

    public static void main(String[] args) {
        int array[] = new int[]{12,9,3,7,14,11};
        System.out.println("排序前:"+ Arrays.toString(array));
        selectionSort(array);
        System.out.println("排序后:"+ Arrays.toString(array));
    }

    public static void selectionSort(int array[]){
        int n = array.length;
        //外层循环主要用于迭代访问到数组中的每一个元素
        for (int i = 0; i < n - 1; i++){
            for (int j = i + 1;j < n; j++){
                //检查当前阶段[i]元素是否小于其后面的元素[i+1]。
                //由于内层循环从i+1开始，因此，内层循环中就可以对比当前元素[i]和[j]
                //[j]就表示当前数组中[i]元素的下一个元素
                if (array[j] < array[i]){
                    //如果当前元素大于后面的，就进行位置交换
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
