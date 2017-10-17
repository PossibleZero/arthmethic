package basic.base;

import basic.tools.SystemUtils;

import java.util.Random;

public class BaseChapter1 {

    private static int[] datas = {1, 2, 3, 4, 5, 6};

    public static void main(String[] args) {
        int max = findMax();
        SystemUtils.println("最大值:" + max);

        int averageDatas = averageDatas();
        SystemUtils.println("平均数:" + averageDatas);

        int[] ints = copyIndexs();
        SystemUtils.printIntdatas(ints);
        //SystemUtils.println("copy数组:" + ints.toString());

        int[] reverseIndex = reverseIndex();
        SystemUtils.printIntdatas(reverseIndex);

        random();

    }

    /**
     * 找最大的
     *
     * @return
     */
    private static int findMax() {

        int max = datas[0];
        for (int i = 0; i < datas.length; i++) {
            if (max < datas[i]) {
                max = datas[i];
            }
        }
        return max;
    }

    /**
     * 平均数
     *
     * @return
     */
    private static int averageDatas() {
        int sum = 0;
        for (int i = 0; i < datas.length; i++) {
            sum += datas[i];
        }

        int average = sum / datas.length;
        return average;
    }

    /**
     * 复制一份儿
     *
     * @return
     */
    private static int[] copyIndexs() {
        int[] newIndex = new int[datas.length];

        for (int i = 0; i < datas.length; i++) {
            newIndex[i] = datas[i];
        }
        return newIndex;
    }

    /**
     * 反转
     *
     * @return
     */
    private static int[] reverseIndex() {
        int temp;
        int length = datas.length;
        for (int i = 0; i < length / 2; i++) {
            temp = datas[i];
            datas[i] = datas[length - i - 1];
            datas[length - i - 1] = temp;
        }
        return datas;
    }


    /**
     * 绝对值
     *
     * @param data
     * @return
     */
    private static int abs(int data) {
        if (data < 0) {
            return -data;
        } else {
            return data;
        }
    }

    private static float abs(float data) {
        if (data < 0.0) {
            return -data;
        } else {
            return data;
        }
    }

    /**
     * 是否是素数
     *
     * @return
     */
    private static boolean isPrime(int N) {
        if (N < 2) {
            return false;
        }
        for (int i = 2; i * i < N; i++) {
            if (N % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 通过递归调用二分查找，数据需要是有序的（从小到大）
     *
     * @param index
     * @param datas
     * @return
     */
    private static int binarySearch(int index, int[] datas) {
        return binarySearch(index, datas, 0, datas.length - 1);
    }

    private static int binarySearch(int index, int[] datas, int low, int high) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (index < mid) {
            return binarySearch(index, datas, low, mid - 1);
        } else if (index > mid) {
            return binarySearch(index, datas, mid + 1, high);
        } else if (index == mid) {
            return mid;
        }
        return mid;

    }

    private static void random() {
        Random random = new Random();
        for (int i =0;i<100;i++) {
            int nextInt = random.nextInt(4);
            SystemUtils.println("随机数是："+nextInt);
        }
    }


}
