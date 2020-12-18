package selectsort;

import java.util.Arrays;

public class SelectSortCon {

    public static void main(String[] args) {
        System.out.println("---------选择排序实习---------");
        int array[] = {1, 5, 3, 6 ,2};
        System.out.println("原始数组：" + Arrays.toString(array));
        int[] arrays = selectSort(array);
        System.out.println("选择排序后的数组：" + Arrays.toString(arrays));
    }

    /**
     * 选择排序算法实现
     * @param array
     * @return
     */
    public static int[] selectSort(int[] array) {
        if(array.length < 0) {
            return array;
        }
        for(int i = 0; i < array.length; i++) {
            int minIndex = i;
            for(int j = i; j < array.length; j++) {
                if(array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

}
