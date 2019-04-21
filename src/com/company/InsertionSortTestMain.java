package com.company;

import com.company.Quick.Extend.PartitionImpl1;
import com.company.Quick.Extend.PartitionImpl2;
import com.company.Quick.Extend.PartitionImpl3;
import com.company.Quick.IPartition;

import java.util.Arrays;

public class InsertionSortTestMain {

    public static void main(String[] args) {
        int array[] = Util.createRandomArray(50000);
//        int array[] = new int[]{3,1,9,6,5,2,8,4};
        int []sort1 = array.clone();
        int []sort2 = array.clone();
        int []sort4 = array.clone();
//        System.out.println("排序前:"+ Arrays.toString(sort1));
//        testSelectionSort(sort1);
//        System.out.println("排序后:"+ Arrays.toString(sort1));
//        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");

//        System.out.println("排序前:"+ Arrays.toString(sort2));
//        testInsertionSort2(sort2);
//        System.out.println("排序后:"+ Arrays.toString(sort2));
//        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");

//        System.out.println("排序前:"+ Arrays.toString(sort4));
//        //测试归并排序第一种实现方式
//        testMergeSort(sort4);
//        System.out.println("排序后:"+ Arrays.toString(sort4));
//        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");


//        System.out.println("排序前:"+ Arrays.toString(sort2));
//        //测试归并排序第二种实现方式
//        testMergeSort2(sort2);
//        System.out.println("排序后:"+ Arrays.toString(sort2));
//        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
        IPartition partitionStragety1 = new PartitionImpl1();
        IPartition partitionStragety2 = new PartitionImpl2();
        IPartition partitionStragety3 = new PartitionImpl3();
        System.out.println("排序前:"+ Arrays.toString(sort2));
        testQuickSort(sort2,partitionStragety1);
        System.out.println("排序后:"+ Arrays.toString(sort2));
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("排序前:"+ Arrays.toString(sort1));
        testQuickSort(sort1,partitionStragety2);
        System.out.println("排序后:"+ Arrays.toString(sort1));
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("排序前:"+ Arrays.toString(sort4));
        testQuickSort(sort4,partitionStragety3);
        System.out.println("排序后:"+ Arrays.toString(sort4));
    }

    /**
     * 测试选择排序
     * @param array
     */
    private static void testSelectionSort(int array[]){
//		System.out.println("排序前:"+ Arrays.toString(array));
        long startTime = System.currentTimeMillis();   //获取开始时间
        selectionSort(array);
        long endTime = System.currentTimeMillis(); //获取结束时间
        long time = endTime - startTime;
//		System.out.println("排序后:"+ Arrays.toString(array));
        System.out.println("选择排序执行耗时:"+ time+"ms");
    }

    /**
     * 测试未改良版的插入排序
     * @param array
     */
    private static void testInsertionSort1(int array[]){
//		System.out.println("排序前:"+ Arrays.toString(array));
        long startTime = System.currentTimeMillis();   //获取开始时间
        insertionSort1(array);
        long endTime = System.currentTimeMillis(); //获取结束时间
        long time = endTime - startTime;
//		System.out.println("排序后:"+ Arrays.toString(array));
        System.out.println("插入排序执行耗时:"+ time+"ms");
    }

    private static void testInsertionSort2(int array[]){
//		System.out.println("排序前:"+ Arrays.toString(array));
        long startTime = System.currentTimeMillis();   //获取开始时间
        insertionSort2(array);
        long endTime = System.currentTimeMillis(); //获取结束时间
        long time = endTime - startTime;
//		System.out.println("排序后:"+ Arrays.toString(array));
        System.out.println("插入排序执行耗时:"+ time+"ms");
    }

    /**
     * 测试归并排序第一种实现方式
     * @param array
     */
    private static void testMergeSort(int array[]){
        long startTime = System.currentTimeMillis();   //获取开始时间
        mergeSort(array);
        long endTime = System.currentTimeMillis(); //获取结束时间
        long time = endTime - startTime;
        System.out.println("归并排序执行耗时:"+ time+"ms");
    }

    /**
     * 测试归并排序第二种实现方式
     * @param array
     */
    private static void testMergeSort2(int array[]){
        long startTime = System.currentTimeMillis();   //获取开始时间
        //这里将临时空间提前声明，避免每次递归时不断创建临时空间，从而导致垃圾回收影响算法效率
        //经测试发现，这种方式实现，比原先的方式，在效率上快了几ms。测试数据量为20万
        int temp[] = new int[array.length];
        mergeSort2(array,temp,0,array.length - 1);
        long endTime = System.currentTimeMillis(); //获取结束时间
        long time = endTime - startTime;
        System.out.println("归并排序新版执行耗时:"+ time+"ms");
    }

    private static void testQuickSort(int array[], IPartition partitionStragety) {
        long startTime = System.currentTimeMillis();   //获取开始时间
        quickSort(array,array.length,partitionStragety);
        long endTime = System.currentTimeMillis(); //获取结束时间
        long time = endTime - startTime;
        System.out.println("快速排序执行耗时:"+ time+"ms");
    }

    /**
     * 选择排序
     * @param array
     */
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

    /**
     * 插入排序
     * @param array
     */
    private static void insertionSort1(int array[]){
        //插入排序从数组中的第二个元素开始，所以循环初始时，i从第二个元素开始，也就是1
        for (int i = 1; i < array.length; i++) {
            //寻找i位置的元素，合适的插入位置
            //在插入排序时，需要与数组中当前元素，前面的进行比较，所以这里是j--
            //与选择排序相比，插入排序在满足条件的情况下，可以提前结束内层循环
            //而选择排序，为了找到数组中最小的元素，则需要扫描整个数组
            for (int j = i; j > 0; j--) {
                //对比当前元素和前面的元素，如果小于前面的元素，就进行位置交换
                //在内层循环中，当前元素[j]会依次与前面元素[j-1]进行比较，如果不符合小于前面的元素，就会退出内层循环。
                if (array[j] < array[j - 1]) {
                    //进行元素交换操作
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j -1] = temp;
                    System.out.println("元素插入后:"+ Arrays.toString(array));
                }else{
                    break;
                }
            }
        }
    }

    /**
     * 插入排序改良，减少swap交换操作，避免内层循环每执行一次就交换一次，找到最终位置后再进行交换
     * @param array
     */
    private static void insertionSort2(int array[]){
        //插入排序从数组中的第二个元素开始，所以循环初始时，i从第二个元素开始，也就是1
        for (int i = 1; i < array.length; i++) {
            //得到当前访问的元素
            int element = array[i];
            int j;
            for (j = i; j > 0 && array[j - 1] > element; j--) {
                array[j] = array[j - 1];
            }
            //当退出内层循环时，表示当前位置[j]元素小于element，这时将element放置到[j]位置上
            array[j] = element;
        }
    }

    private static void mergeSort(int array[]){
        _mergeSort(array,0,array.length - 1);
    }

    private static void _mergeSort(int array[],int l,int r){
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;//得到数组二分后的mid位置
        _mergeSort(array, l, mid);//对二分后的起始点至mid点进行排序
        _mergeSort(array,mid+1,r);//对二分后mid点至右侧终点进行排序
        if (array[mid] > array[mid + 1]) {
            _merge(array, l, mid, r);
        }

    }

    private static void _mergeSort2(int s1[],int s2[],int []aux){
        int i = 1;
        int j = 1;
        int n = s1.length + s2.length;
        while ( i <= n && j <= n){
            if (s1[i] <= s2[j]){
                aux[i + j - 1] = s1[i];
                i = i + 1;
            }else{
                aux[i + j - 1] = s2[i];
                j = j + 1;
            }
        }
        while (i <= n){
            aux[i + j - 1] = s1[i];
            i = i + 1;
        }
        while (j <= n){
            aux[i + j - 1] = s2[i];
            j = j + 1;
        }
    }

    private static void _merge(int array[],int l,int mid,int r){
        //临时空间
        int [] aux = new int[r-l+1];
        //从左侧l点开始,至右侧r点
        for (int i = l; i <= r; i++) {
            aux[i - l] = array[i];
        }
        int i = l;
        int j = mid + 1;
        //从开始点至结束点
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                array[k] = aux[j - l];
                j++;
            }
            else if (j > r) {
                array[k] = aux[i - l];
                i++;
            }
            else if (aux[i - l] < aux[j - l]) {
                array[k] = aux[i - l];
                i++;
            }
            else{
                array[k] = aux[j - l];
                j++;
            }
        }
    }


    private static void mergeSort2(int array[],int temp[],int left,int right){
        if (left < right){
            int center = (left + right) / 2;
            //拆分A1数组,A1数组的起点为left，终点为center
            mergeSort2(array,temp,left,center);
            //拆分A2数组，因为A2在A1右侧，且A1终点为center。
            //所以，A2数组的起点应为center + 1，而终点为right
            mergeSort2(array,temp,center + 1,right);
            //递归进行元素排序与合并
            merge2(array,temp,left,center + 1,right);
        }
    }

    private static void merge2(int array[],int temp[],int leftPos,int rightPos,int rightEnd){
        //得到左侧数组的结束点
        int leftEnd = rightPos - 1;
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

    private static void quickSort(int array[],int n,IPartition partitionStragety){
        quickSort(array,0,array.length - 1,partitionStragety);
    }

    private static void quickSort(int array[],int left,int right,IPartition partitionStragety) {
        //处理到达边界right
        if (left >= right){
            return;
        }
        int partition = partition(array,left,right,partitionStragety);
        quickSort(array,left,partition - 1,partitionStragety);
        quickSort(array,partition + 1,right,partitionStragety);
    }

    /**
     * 对array数组[left......right]部分进行partition操作
     * 返回partition，使array[left......partition - 1] < array[partition];array[partition + left......right] > array[partition]
     * @param array
     * @param left
     * @param right
     * @return
     */
    private static int partition(int array[],int left,int right,IPartition partitionStragety){
        return partitionStragety.partition(array,left,right);
    }
}
