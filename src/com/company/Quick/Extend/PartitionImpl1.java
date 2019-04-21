package com.company.Quick.Extend;

import com.company.Quick.IPartition;
import java.util.Arrays;
/**
 * 获取partition策略，返回partition索引，满足array[left......partition - 1] < array[partition];array[partition + left......right] > array[partition]。
 *  //TODO 这个基准值获取是需要一定规则的，随意取会使快速排序算法效率发生退化。
 *  //TODO 这里为了先实现此操作，暂且先使用数组中的第一个元素
 */
public class PartitionImpl1 implements IPartition {

    /**
     * 对array数组[left......right]部分进行partition操作
     * @param array
     * @param left
     * @param right
     * @return 返回partition索引，满足array[left......partition - 1] < array[partition];array[partition + left......right] > array[partition]
     */
    @Override
    public int partition(int[] array, int left, int right) {
        //以某个值为基准，使数组[left......partition - 1]这一段内部的元素值，全都小于这个位置的值，位置就是partition。
        //同样，使数组[partition + left......right]这一段内部的元素值，全都大于这个位置的值，位置就是partition。
        //返回的partition，将会满足上述两种条件。
        //首先得到基准值，将数组第一个元素作为基准值
        int value = array[left];
        //返回的partition，这里定义为j。
        int j = left;
        //因为是将数组中的第一个元素作为了基准值，所以，下面的循环，应该从当前位置后面的这个元素开始
        //因此，循环i元素的初始值为left + 1。
        //循环满足array[left + 1...j] < array[v]，array[j + 1...i] > array[v]
        for (int i = left + 1;i <= right;i++){
            //当前考察的元素，小于基准值时，基准值为数组的第一个元素。
            if (array[i] < value){
                //考察点是从基准值的下一个元素开始，left为基准元素下标，故考察点i = left + 1。
                //j初始时为基准点位置
                //因此，当考察点元素小于基准值时，需要将当前元素放入到当前j位置的下一个位置，并使j进行递增
                //这样做的目的就是满足array[left + 1...j] < array[v]条件，达到对左侧数组的扩容，并将小于基准值的元素，都放到这个数组中。
                //因为j初始值为基准点位置，所以，一旦当前元素i小于基准值，就需要将当前元素i放入到基准点后面的位置，故j + 1位置。
                //最后通过j++更新位置，这样再继续迭代发现小于基准值的元素时，再次与j进行位置交换。
                //这样一来，就可以根据基准值，将小于基准值的元素，都放入到array[left + 1...j]中，而剩下的元素，都是大于基准值的，即满足array[j + 1...i]
                int temp = array[i];
                array[i] = array[j + 1];
                array[j + 1] = temp;
                //更新j++，使下次扫描时，若i小于基准值，能使其放入到上次迭代的下一个位置。
                j++;
            }
        }
        //上述循环会满足array[left......partition - 1] < array[partition]和array[partition + left......right] > array[partition]这两种条件。
        //由于left位置元素为基准值，而在上面的循环中，j位置就是partition
        //所以，下面将这两者进行位置交换，返回j位置
        int temp = array[left];
        array[left] = array[j];
        array[j] = temp;
        return j;
    }
}
