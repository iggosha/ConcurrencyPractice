import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("¬ведите размерность матрицы: ");
        int num = read.nextInt();read.nextLine();
        System.out.println("¬ведите название файла (путь): ");
        String filePath = read.nextLine();

        DataCommon dC = new DataCommon(filePath, num);
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
        System.out.println("ќбработка завершена");
    }
}