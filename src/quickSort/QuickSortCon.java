package quickSort;

import java.util.Arrays;

public class QuickSortCon {

    public static void main(String[] args) {
        System.out.println("--------快速排序算法实现-----------");
        int array[] = {2,4,1,6,3};
        System.out.println("原始数组：" + Arrays.toString(array));
        int[] arrays = QuickSort(array, 0, array.length - 1);
        System.out.println("排序后的数组：" + Arrays.toString(arrays));
    }

    /**
     * 快速排序方法
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int[] QuickSort(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end) return null;
        int smallIndex = partition(array, start, end);
        if (smallIndex > start)
            QuickSort(array, start, smallIndex - 1);
        if (smallIndex < end)
            QuickSort(array, smallIndex + 1, end);
        return array;
    }

    /**
     *  快速排序算法--partition
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int partition(int[] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i <= end; i++) {
            if (array[i] <= array[end]) {
                smallIndex++;
                if (i > smallIndex)
                    swap(array, i, smallIndex);
            }
        }
        return smallIndex;
    }

    /**
     *  交换数组内两个元素
     * @param array
     * @param i
     * @param j
     */
    public static void  swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
