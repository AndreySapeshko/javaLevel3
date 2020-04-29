import java.util.Arrays;

public class FillInTheMatrix {

    public static void main(String[] args) {
        int[][] matrix = fillMatrixInSpiral(7);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static int[][] fillMatrixInSpiral(int sizeMatrix) {
        int[][] matrix = new int[sizeMatrix][sizeMatrix];
        int count = 1;
        boolean verticalOrHorizontal = false;
        int i = 0, j = 0;
        while (matrix[i][j] == 0) {
            while (j < sizeMatrix && matrix[i][j] == 0) {
                matrix[i][j] = count;
                count++;
                j++;
            }
            i++;
            j--;
            while (i < sizeMatrix && matrix[i][j] == 0) {
                matrix[i][j] = count;
                count++;
                i++;
            }
            i--;
            j--;
            while (j >= 0 && matrix[i][j] == 0) {
                matrix[i][j] = count;
                count++;
                j--;
            }
            i--;
            j++;
            while (i >= 0 && matrix[i][j] == 0) {
                matrix[i][j] = count;
                count++;
                i--;
            }
            i++;
            j++;
        }
        return matrix;
    }
}
