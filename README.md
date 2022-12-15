# SPOLab4
Лаба с многопотоком



На всякий случай метод записи матрицы в файл (вставить и запустить с ним 1 раз, чтобы не заполнять матрицу. Аргумент - размерность матрицы):
```
//WriteToFileMatrix
    public static void createMatrix(int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (int) (Math.random() * 100);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        try (FileWriter writer = new FileWriter(fileMatrix, false)) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    writer.write(matrix[i][j] + " ");
                }
                writer.append('\n');
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }```
      
