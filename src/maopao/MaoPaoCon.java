package maopao;

import java.util.Arrays;

public class MaoPaoCon {

    public static void main(String[] args) {
        System.out.println("-------------冒泡排序实现-----------");
        int array[] = {1, 4, 5, 3};
        System.out.println("排序前的数组：" + Arrays.toString(array));
        int[] arrays = bubbleSort(array);
        System.out.println("排序后的数组：" + Arrays.toString(arrays));
    }

    /**
     *   冒泡排序实现算法
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array) {
        if(array.length < 0) {
            return array;
        }
        for(int i=0; i < array.length; i++) {
            for(int j=0; j < array.length - 1 - i; j++) {
                if(array[j+1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

}
