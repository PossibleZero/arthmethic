package basic.chapter1;

public class arithmetic15 {

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 4, 5, 4, 4, 6, 8};
        int b[] = histogram(a, 10);
        for (int i = 0; i < b.length; i++) {
            System.out.println(i + " 的数值是：" + b[i]);

        }

        int i = 0;
        //++i;
        System.out.println(""+i+++""+i);

    }

    public static int[] histogram(int[] array, int index) {
        int[] newArray = new int[index];
        for (int i = 0; i < newArray.length; i++) {
            int data = countSize(i, array);
            newArray[i] = data;

        }
        return newArray;


    }

    private static int countSize(int index, int[] array) {
        int number = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == index) {
                number++;
            }
        }
        return number;
    }
}
