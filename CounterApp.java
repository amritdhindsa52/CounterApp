public class CounterApp {

    public static void main(String[] args) {
        // Create the first thread to count up to 20
        Thread counterUp = new Thread(new CounterUp());
        counterUp.start();

        // Wait for the first thread to finish
        try {
            counterUp.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Create the second thread to count down to 0
        Thread counterDown = new Thread(new CounterDown());
        counterDown.start();
    }
}

class CounterUp implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.println("Counter Up: " + i);
            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class CounterDown implements Runnable {
    @Override
    public void run() {
        for (int i = 20; i >= 0; i--) {
            System.out.println("Counter Down: " + i);
            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
