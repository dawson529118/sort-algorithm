package shellSort;

import java.util.Arrays;

public class ShellSortCon {

    public static void main(String[] args) {
        System.out.println("---------希尔排序实现-------");
        int array[] = {5,3,8,6,2};
        System.out.println("原始数组：" + Arrays.toString(array));
        int[] arrays = shellSort(array);
        System.out.println("排序后的数组：" + Arrays.toString(arrays));
    }

    /**
     *  希尔排序算法实现
     * @param array
     * @return
     */
    public static int[] shellSort(int[] array) {
        if(array.length < 0) {
            return array;
        }
        int length = array.length;
        int temp, gap = length/2;
        System.out.println("temp：" + length /2);
        while(gap > 0){
            for(int i=gap; i<length; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while(preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }

}
