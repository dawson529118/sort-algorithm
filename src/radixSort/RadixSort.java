package radixSort;

import java.util.ArrayList;
import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        System.out.println("-------基数排序实现--------");
        int[] array={3, 44, 38, 5, 47};
        System.out.println("原始数组：" + Arrays.toString(array));
        int[] arrays = radixSort(array);
        System.out.println("排序后的数组：" + Arrays.toString(arrays));
    }

    /**
     *  基数排序算法
     * @param array
     * @return
     */
    public static int[] radixSort(int[] array) {
        if(array == null || array.length < 2) {
            return array;
        }
        // 先算出最大位数的位数
        int max = array[0];
        for(int i=0; i< array.length; i++) {
            max = Math.max(max, array[i]);
        }
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        int mod = 10, div = 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i< 10; i++) {
            bucketList.add(new ArrayList<Integer>());
        }
        for(int i=0; i< maxDigit; i++, mod*=10, div *=10) {
            for(int j=0; j< array.length; j++) {
                int num = (array[j] % mod) /div;
                bucketList.get(num).add(array[j]);
            }
            int index = 0;
            for(int j=0; j< bucketList.size(); j++) {
                for(int k=0; k < bucketList.get(j).size(); k++) {
                    array[index++] = bucketList.get(j).get(k);
                }
                bucketList.get(j).clear();
            }
        }
        return array;
    }
}
