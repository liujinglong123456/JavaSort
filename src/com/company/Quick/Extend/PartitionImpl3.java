package com.company.Quick.Extend;

import com.company.Quick.IPartition;

public class PartitionImpl3 implements IPartition{

    @Override
    public int partition(int[] array, int left, int right) {
        //得到基准值
        int value = array[right];
        //左侧开始位置
        int l = left;
        //右侧开始位置
        int r = right - 1;
        while (l <= r){
            //从左侧向右扫描，每次扫描后递增l
            while (l <= r && array[l] <= value){
                l = l + 1;
            }
            while (r >= l && array[r] >= value){
                r = r - 1;
            }
            if (l < r){
                //交换元素l和r
                int temp = array[r];
                array[r] = array[l];
                array[l] = temp;
            }
        }
        //交换元素right和l
        int temp = array[right];
        array[right] = array[l];
        array[l] = temp;
        return l;
    }
}
