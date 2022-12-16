public class ThreadRowOperation implements Runnable {
    int numRow;
    DataCommon dC;
    Thread thread1;

    public ThreadRowOperation(DataCommon dC, int numRow) {
        this.dC = dC;
        this.numRow = numRow;
        thread1 = new Thread(this);
        thread1.start();
    }

    @Override
    public void run() {
        synchronized (this.dC) {
            dC.rowPrint(numRow);
            System.out.print(" Среднее арифметическое ряда: " + dC.rowSrAr(numRow) + '\n');

        }
    }
}
