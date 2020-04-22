import java.util.Arrays;

public class MethodsForArrays {

    public static void main(String[] args) {
        int[] num = {4, 1, 3, 5, 6};
        System.out.println(Arrays.toString(elementsAfter4(num)));
    }

    public static int[] elementsAfter4(int[] n) {
        int[] result = null;
        if (isPercentFour(n)) {
            for (int i = n.length - 1; i >= 0; i--) {
                if (n[i] == 4) {
                    result = new int[n.length - i -1];
                    for (int j = i + 1; j < n.length; j++) {
                        result[j - i - 1] = n[j];
                    }
                   return result;
                }
            }
        } else {
            throw new RuntimeException("В переданном массиве нет цыфры 4");
        }
        return result;
    }

    public static boolean isPercentFour(int[] n) {
        for (int i = 0; i < n.length; i++) {
            if (n[i] == 4) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPercentOneOrFour(int[] n) {
        for (int i = 0; i < n.length; i++) {
            if (n[i] == 1 || n[i] == 4) {
                return true;
            }
        }
        return false;
    }
}
