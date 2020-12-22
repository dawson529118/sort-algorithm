package countingSort;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        System.out.println("---------计数排序实现---------");
        int[] array = {1,2,3,2,4};
        System.out.println("原始数组：" + Arrays.toString(array));
        int[] arrays = countingSort(array);
        System.out.println("排序后的数组："+ Arrays.toString(arrays));
    }

    /**
     *  计数排序算法
     * @param array
     * @return
     */
    public static int[] countingSort(int[] array) {
        if(array.length < 0) {
            return array;
        }
        int bias, min = array[0], max = array[0];
        for(int i=1;i<array.length;i++) {
            if(array[i] >max) {
                max = array[i];
            }
            if(array[i] < min) {
                min = array[i];
            }
        }
        bias = 0 -min;
        int[] bucket = new int[max -min + 1];
        Arrays.fill(bucket, 0);
        for(int i=0;i<array.length;i++) {
            bucket[array[i] + bias]++;
        }
        int index = 0, i=0;
        while (index < array.length) {
            if(bucket[i] != 0) {
                array[index] = i - bias;
                bucket[i]--;
                index++;
            }else {
                i++;
            }
        }
        return array;
    }
}
