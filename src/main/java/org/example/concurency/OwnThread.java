package org.example.concurency;

public class OwnThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5 ; i++) {
            System.out.println("1");

            try {
                //delay 1 second
                Thread.sleep(500);
            }catch (InterruptedException e ){
                e.printStackTrace();
            }
        }
    }
}
