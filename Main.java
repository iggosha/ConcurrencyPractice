import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("Введите размерность матрицы: ");
        int num = read.nextInt();

        DataCommon dC = new DataCommon("matrix.txt", num);
        ThreadRowOperation[] trpArr = new ThreadRowOperation[dC.n];
        try {
            for (int i = 0; i < dC.n; i++) {
                if (i > 0) trpArr[i - 1].thread1.join();
                trpArr[i] = new ThreadRowOperation(dC, i);
            }
            trpArr[dC.n - 1].thread1.join();
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        System.out.println("Обработка завершена");
    }
}