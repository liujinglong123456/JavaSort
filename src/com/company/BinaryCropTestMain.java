package com.company;

public class BinaryCropTestMain {

    public static void main(String[] args) {
        int array[] = new int[]{1,2,3,4,5,6,7,8,9,11,22,33,44,55,66,77,88,89};
        System.out.println("当前值在数组中的位置是" + binaryChop(array, 2));
    }

    /**
     * 二分查找法
     * @param array 有序数组
     * @param search 被查找的值
     * @return
     */
    public static int binaryChop(int array[],int search){
        int middle = 0;
        int low = 0;
        //得到被查询数组的总长度
        int pow = array.length;
        while (true) {
            //获取每次迭代查找的中央位置
            middle = (pow + low)/2;
            //检查当前中间的值，是否为被查询的这个值，如果是就直接返回
            if (search == array[middle]) {
                return middle;
            }
            else if (low > pow) {
                return -1;
            }
            else{
                //每次得到中央位置后，将中央位置的值与被查询位置的值进行对比
                //如果中央位置的值，大于被查询的值，这时就需要向左移动，这样再次循环时，就会根据左移后的位置，进行再次二分。
                if (array[middle] > search) {
                    pow = middle -1;
                }else{
                    //向右移动后同理，再次循环会根据右侧位置，进行二分。
                    low = middle + 1;
                }
            }
        }
    }
}
