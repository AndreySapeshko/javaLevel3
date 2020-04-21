public class MFU {
    private final Object printLock = new Object();
    private final Object scanLock = new Object();

    public void print(String strForPrint, int countPrint) {
        synchronized (printLock) {
            for (int i = 0; i < countPrint; i++) {
                System.out.println(strForPrint + " " + (i + 1));
            }
            System.out.println("Print finish");
        }
    }

    public void scan(String strForScan, int countScan, boolean printOrFile) {
        synchronized (scanLock) {
            for (int i = 0; i < 1; i++) {
                System.out.println(strForScan + " " + (i + 1));
            }
            if (printOrFile) {
                synchronized (printLock) {
                    for (int i = 0; i < countScan; i++) {
                        System.out.println(strForScan + " printed " + (i + 1));
                    }
                }
            }
            System.out.println("Scan finish");
        }

    }

    public synchronized void copy(String strForCopy, int countCopy) {
        scan(strForCopy + " Scan",1, false);
        print(strForCopy + " Print", countCopy);
        System.out.println("Copy finish");
    }

    public static void main(String[] args) {
        MFU mfu = new MFU();

        for (int i = 0; i < 8; i++) {
            int nThread = i;
            new Thread(()->{
                switch (nThread) {
                    case 0: case 5:
                        System.out.println("Thread " + nThread + " call print()");
                        mfu.print("thread " + nThread + " Document for print", 3);
                        break;
                    case 1: case 3:
                        System.out.println("Thread " + nThread + " call scan()");
                        mfu.scan("thread " + nThread + " Document for scan", 2, true);
                        break;
                    case 2: case 4:
                        System.out.println("Thread " + nThread + " call copy()");
                        mfu.copy("thread " + nThread + " Document for copy", 2);
                        break;
                    case 6: case 7:
                        System.out.println(("Thread " + nThread + " call scan(in file)"));
                        mfu.scan("thread " + nThread + " Document for scan in file", 2, false);
                        break;
                }
            }).start();
        }
    }
}
