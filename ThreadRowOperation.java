public class ThreadRowOperation implements Runnable {
    int numRow;
    DataCommon dC;
    Thread thread1, thread2;

    public ThreadRowOperation(DataCommon dC, int numRow) {
        this.dC = dC;
        this.numRow = numRow;
        thread1 = new Thread(this);
        thread1.start();
    }

    @Override
    public void run() {
        Runnable r = () -> {
            dC.rowPrint(numRow);
        };
        synchronized (this.dC) {
            try {
                thread2 = new Thread(r, "Поток вывода");
                thread2.start();
                thread2.join();
                System.out.print(" Среднее арифметическое ряда: " + dC.rowSrAr(numRow) + '\n');
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
