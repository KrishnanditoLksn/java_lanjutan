package org.example.generics;

public class MobileStudent extends Student {
    private double percentComplete;

    public double getPercentComplete() {
        return percentComplete;
    }

    @Override
    public String toString() {
        return "%s %8.1f%%".formatted(super.toString(), percentComplete);
    }

    public MobileStudent() {
        percentComplete = random.nextDouble(0, 100.111);

    }
}
