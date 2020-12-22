package bucketSort;

import java.util.ArrayList;
import java.util.Arrays;

public class BucketSort {
    public static void main(String[] args) {
        System.out.println("---------桶排序实现----------");
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(78);
        array.add(19);
        array.add(39);
        array.add(26);
        array.add(72);
        System.out.println("原始数据：" + Arrays.toString(array.toArray()));
        ArrayList<Integer> list = bucketSort(array, 1);
        System.out.println("排序后的数据：" + Arrays.toString(list.toArray()));
    }

    /**
     *  桶排序
     * @param array
     * @param bucketSize
     * @return
     */
    public static ArrayList<Integer> bucketSort(ArrayList<Integer> array, int bucketSize) {
        if(array == null || array.size() < 2) {
            return array;
        }
        int max = array.get(0), min = array.get(0);
        //  找到最大值最小值
        for(int i=0;i<array.size();i++) {
            if(array.get(i) > max) {
                max = array.get(i);
            }
            if(array.get(i) < min) {
                min = array.get(i);
            }
        }
        int bucketCount = (max - min) / bucketSize + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        ArrayList<Integer> resultArr = new ArrayList<>();
        for(int i=0; i<bucketCount; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        for(int i=0; i<array.size();i++) {
            bucketArr.get((array.get(i) - min) / bucketSize).add(array.get(i));
        }
        for(int i=0;i<bucketCount; i++) {
            if(bucketSize == 1) {
                for(int j=0; j < bucketArr.get(i).size(); j++) {
                    resultArr.add(bucketArr.get(i).get(j));
                }
            }else {
                if(bucketCount == 1) {
                    bucketSize--;
                }
                ArrayList<Integer> temp = bucketSort(bucketArr.get(i), bucketSize);
                for(int j=0; j<temp.size();j++) {
                    resultArr.add(temp.get(j));
                }
            }
        }
        return resultArr;
    }
}
