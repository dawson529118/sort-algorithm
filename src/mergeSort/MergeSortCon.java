package mergeSort;

import java.util.Arrays;

public class MergeSortCon {

    public static void main(String[] args) {
        System.out.println("---------归并排序实现-----------");
        int array[]={3,2,7,4,6};
        System.out.println("原始数组：" + Arrays.toString(array));
        int[] arrays = mergeSort(array);
        System.out.println("排序后的数组：" + Arrays.toString(arrays));
    }

    /**
     *  归并排序算法实现
     * @param array
     * @return
     */
    public static int[] mergeSort(int[] array) {
        if(array.length < 2) {
            return array;
        }
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    /**
     * 归并排序——将两段排序好的数组结合成一个排序数组
     * @param left
     * @param right
     * @return
     */
    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }
}
