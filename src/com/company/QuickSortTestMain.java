package com.company;

import com.company.Quick.Extend.PartitionImpl1;
import com.company.Quick.IPartition;

import java.util.Arrays;

public class QuickSortTestMain {

    public static void main(String[] args) {
        IPartition partition1 = new PartitionImpl1();
        int array[] = new int[]{3,1,9,6,5,2,8,4};
        System.out.println("排序前:"+ Arrays.toString(array));
        quickSort(array,partition1);
        System.out.println("排序后:"+ Arrays.toString(array));
    }

    private static void quickSort(int array[],IPartition partition){
        quickSort(array,0,array.length - 1,partition);
    }

    private static void quickSort(int array[],int left,int right,IPartition partitionImpl) {
        //处理到达边界right
        if (left >= right){
            return;
        }
        int partition = partition(array,left,right,partitionImpl);
        //对left至partition - 1的位置进行快速排序
        quickSort(array,left,partition - 1,partitionImpl);
        //对partition + 1至right的位置进行快速排序
        quickSort(array,partition + 1,right,partitionImpl);
    }

    /**
     * 对array数组[left......right]部分进行partition操作
     * 返回partition，使array[left......partition - 1] < array[partition];array[partition + left......right] > array[partition]
     * @param array
     * @param left
     * @param right
     * @return
     */
    private static int partition(int array[],int left,int right,IPartition partition){
        return partition.partition(array,left,right);
    }
}
