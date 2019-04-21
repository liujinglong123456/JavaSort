package com.company.Quick;

/**
 * 快速排序的Partition策略
 */
public interface IPartition {

    /**
     * 获取划分后基准元素所在位置
     *  对array数组[left......right]部分进行partition操作
     * @param array 数组
     * @param left
     * @param right
     * @return 返回partition，使array[left......partition - 1] < array[partition];array[partition + left......right] > array[partition]
     */
    int partition(int array[],int left,int right);
}
