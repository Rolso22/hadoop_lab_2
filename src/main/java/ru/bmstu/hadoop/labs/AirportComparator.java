package ru.bmstu.hadoop.labs;

import org.apache.hadoop.io.WritableComparator;

public class AirportComparator extends WritableComparator {
    public AirportComparator() {
        super(AirportComparable.class);
    }

    @Override
    public int compare(AirportComparable a, AirportComparable b) {
        return Integer.compare(a, b);
    }
}
