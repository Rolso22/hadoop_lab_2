package ru.bmstu.hadoop.labs;

import org.apache.hadoop.io.WritableComparator;

public class AirportComparator extends WritableComparator {
    protected AirportComparator() {
        super(AirportComparable.class);
    }

    @Override
    public int compare(AirportComparable a, AirportComparable b) {
        return Integer.compare(a.getAirportId(), b.getAirportId());
    }
}
