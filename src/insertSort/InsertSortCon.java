package insertSort;

import java.util.Arrays;

public class InsertSortCon {

    public static void main(String[] args) {
        System.out.println("----------插入排序实现------------");
        int array[] = {2,4,6,1,9};
        System.out.println("原始数组：" + Arrays.toString(array));
        int[] arrays = insertSort(array);
        System.out.println("排序后的数组：" + Arrays.toString(array));
    }

    /**
     *  插入排序算法
     * @param array
     * @return
     */
    public static int[] insertSort(int[] array) {
        if(array.length < 0) {
            return array;
        }
        int current;
        for(int i=0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while(preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }

}
