package test1.java;
class EvenNumberThread extends Thread {
    public void run() {
        for (int i = 2; i <= 20; i += 2) {
            System.out.println("Even: " + i);
            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class OddNumberThread extends Thread {
    public void run() {
        for (int i = 1; i <= 20; i += 2) {
            System.out.println("Odd: " + i);
            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class EvenOddThreads {
    public static void main(String[] args) {
        EvenNumberThread evenThread = new EvenNumberThread();
        OddNumberThread oddThread = new OddNumberThread();

        evenThread.start(); 
        oddThread.start(); 
    }
}

