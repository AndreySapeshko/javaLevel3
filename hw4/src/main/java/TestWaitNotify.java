public class TestWaitNotify {
    private static boolean isPresentA = true;
    private static boolean isPresentB = false;
    private static boolean isPresentC = false;

    public static void main(String[] args) {
        TestWaitNotify twn = new TestWaitNotify();
        Thread threadA = new Thread("threadA") {
            @Override
            public void run() {
                int count = 0;
                while (count < 5) {
                    twn.printChar('A');
                    count++;
                }
            }
        };
        Thread threadB = new Thread("threadB") {
            @Override
            public void run() {
                int count = 0;
                while (count < 5) {
                    twn.printChar('B');
                    count++;
                }
            }
        };
        Thread threadC = new Thread("threadC") {
            @Override
            public void run() {
                int count = 0;
                while (count < 5) {
                    twn.printChar('C');
                    count++;
                }
            }
        };
        threadA.start();
        threadB.start();
        threadC.start();
    }

    public synchronized void printChar(char c) {

        if (c == 'A') {
            while (!isPresentA) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            isPresentA = false;
            isPresentB = true;
        } else if (c == 'B') {
            while (!isPresentB) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            isPresentB = false;
            isPresentC = true;
        } else if (c == 'C') {
            while (!isPresentC) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            isPresentC = false;
            isPresentA = true;
        }
        System.out.print(c);

        notifyAll();
    }

}
