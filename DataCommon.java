import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataCommon {
    final int n;
    int[][] matrix;

    public DataCommon(String filePath, int n) {
        this.n = n;
        matrix = new int[n][n];
        try {
            Scanner read = new Scanner(new File(filePath));
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = read.nextInt();
                }
            }
            if (10 % n != 0) read.nextLine();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public double rowSrAr(int numRow) {
        double max = matrix[numRow][0], min = matrix[numRow][0];
        for (int j = 0; j < n; j++) {
            if (matrix[numRow][j] > max) max = matrix[numRow][j];
            if (matrix[numRow][j] < min) min = matrix[numRow][j];
        }
        return (max + min) / 2;
    }

    public void rowPrint(int numRow) {
        for (int j = 0; j < n; j++) {
            System.out.print(matrix[numRow][j] + " ");
        }
    }
}
