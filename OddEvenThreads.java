class OddThread extends Thread {
    int n;
    OddThread(int n) {
        this.n = n;
    }
    public void run() {
        System.out.println("Odd Numbers:");
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }
}

class EvenThread extends Thread {
    int n;
    EvenThread(int n) {
        this.n = n;
    }
    public void run() {
        System.out.println("Even Numbers:");
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}

public class OddEvenThreads {
    public static void main(String[] args) {
        int n = 20; // You can change this range

        OddThread t1 = new OddThread(n);
        EvenThread t2 = new EvenThread(n);

        t1.start();
        t2.start();
    }
}

