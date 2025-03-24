package org.example.generics.genwildcard;

import java.util.Locale;

public class MobileStudent extends Student implements QueryItem {
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

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        String fName = fieldName.toUpperCase(Locale.ROOT);
        if (fName.equals("PERCENT")) {
            return Double.parseDouble(value) <= percentComplete || Double.parseDouble(value) == percentComplete;
        }
        return false;
    }
}
