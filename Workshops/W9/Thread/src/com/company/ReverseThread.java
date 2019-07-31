package com.company;

public class ReverseThread extends Thread {
    int sequence;

    ReverseThread(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public void run() {
        if (sequence < 50) {
            newThread(sequence + 1);
        }
        System.out.println("Hello from thread ! " + sequence);
    }

    public void newThread(int sequence) {
        ReverseThread r = new ReverseThread(sequence);
        r.start();
        try {
            r.join();
        } catch(InterruptedException i) {
            System.out.println("Thread " +  r + " interrupted.");
        }
    }

}
