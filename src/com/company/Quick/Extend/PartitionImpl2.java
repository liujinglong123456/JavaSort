package com.company.Quick.Extend;

import com.company.Quick.IPartition;

/**
 *
 */
public class PartitionImpl2 implements IPartition {

    /**
     * 对array数组[left......right]部分进行partition操作
     * 返回partition，使array[left......partition - 1] < array[partition];array[partition + left......right] > array[partition]
     * @param array
     * @param left
     * @param right
     * @return
     */
    @Override
    public int partition(int[] array, int left, int right) {

        int i = left;
        int j = right;
        //以数组左侧元素，作为基准
        int value = array[left];
        while (i < j){
            //每次向左扫描后，j位置递减，一直扫描到首部i位置
            while (i < j && array[j] > value){
                j --;
            }
            if (i < j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
            while (i < j && array[i] <= value){
                i ++;
            }
            if (i < j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                j--;
            }
        }
        return i;
    }
}
