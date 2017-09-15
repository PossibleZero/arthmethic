package basic.tools;

public class SystemUtils {

    public static void println(String str) {
        System.out.println(str);
    }

    public static <T> void printIntdatas(int[] datas) {
        for (int i = 0; i < datas.length; i++) {
            if (i == (datas.length - 1)) {
                SystemUtils.println(datas[i] + " ");
            } else {
                System.out.print(datas[i] + " ");
            }
        }
    }
}
