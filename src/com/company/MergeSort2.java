package com.company;

import java.util.Arrays;

public class MergeSort2 {

    public static void main(String[] args) {
        int array[] = new int[]{3,1,9,6,5,2,8,4,300,10,18,3,5,200,124};
        System.out.println("排序前:"+ Arrays.toString(array));
        mergeSort(array,0,array.length - 1);
        System.out.println("排序后:"+ Arrays.toString(array));
    }

    private static void mergeSort(int array[],int temp[],int left,int right){
        if (left < right){
            int center = (left + right) / 2;
            //拆分A1数组,A1数组的起点为left，终点为center
            mergeSort(array,temp,left,center);
            //拆分A2数组，因为A2在A1右侧，且A1终点为center。
            //所以，A2数组的起点应为center + 1，而终点为right
            mergeSort(array,temp,center + 1,right);
            //递归进行元素排序与合并
            merge(array,temp,left,center,center + 1,right);
        }
    }

    private static void mergeSort(int []array,int left,int right) {
        if (left < right){
            int center = (left + right) / 2;
            //拆分A1数组,A1数组的起点为left，终点为center
            mergeSort(array,left,center);
            //拆分A2数组，因为A2在A1右侧，且A1终点为center。
            //所以，A2数组的起点应为center + 1，而终点为right
            mergeSort(array,center + 1,right);
            //递归进行元素排序与合并
            merge(array,left,center,right);
        }
    }

    private static void merge(int []array,int left,int mid,int right) {
        int []temp = new int[right - left + 1];//创建临时数组
        int i = left;//A1数组开始位置
        int j = mid + 1;//A2数组开始位置，由于A1结束位置为mid，所以，A2开始位置为mid+1
        int k = 0;//临时数组放置元素的位置
        while ( i <= mid && j <= right){//扫描A1和A2，将A1当前元素与A2元素对比，i和j分别代表A1和A2这两个数组的访问位置
            //对比元素，如果A1当前元素大于A2,则继续将A1当前元素与A2中的下一个进行对比
            if (array[i] < array[j]) {
                //如果这时A1中的当前元素小于A2中当前阶段的元素
                //就将A1当前元素，拷贝到临时数组中，并更新临时数组的k位置
                //这时也会更新A1数组的位置，使其下次访问下一个元素
                temp[k++] = array[i];
                i++;
            }
            else {
                //如果这时A2中的当前元素大于A2中当前阶段的元素
                //则将A2当前阶段的元素，放入到临时数组中
                //接下来就需要对A2数组中下一个位置的元素进行检查，故更新j
                temp[k++] = array[j];
                j++;
            }
        }
        while (i <= mid){
            temp[k++] = array[i++];//处理A1和A2的剩余元素
        }
        while (j <= right){
            temp[k++] = array[j++];
        }
        for (i = left,k = 0;i <= right;i++){
            array[i] = temp[k++]; //将合并后的元素，拷贝到原数组中
        }
    }

    /**
     *
     * @param array
     * @param temp
     * @param leftPos
     * @param leftEnd
     * @param rightPos
     * @param rightEnd
     */
    private static void merge(int array[],int temp[],int leftPos,int leftEnd,int rightPos,int rightEnd){
        //临时数组的起点tempPos，由于临时数组长度就是原数组长度，并且leftPos为左侧数组的起点。
        //所以，临时起点与其相同。
        int tempPos = leftPos;
        int numberElements = rightEnd - leftPos + 1;
        while (leftPos <= leftEnd && rightPos <= rightEnd){
            if (array[leftPos] < array[rightPos]){
                temp[tempPos++] = array[leftPos++];
            }else{
                temp[tempPos++] = array[rightPos++];
            }
        }
        while (leftPos <= leftEnd){
            temp[tempPos++] = array[leftPos++];
        }
        while (rightPos <= rightEnd){
            temp[tempPos++] = array[rightPos++];
        }
        for (int i = 0;i < numberElements; i++, rightEnd--){
            array[rightEnd] = temp[rightEnd];
        }
    }
}
