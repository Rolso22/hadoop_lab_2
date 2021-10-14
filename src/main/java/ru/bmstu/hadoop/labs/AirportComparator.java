package ru.bmstu.hadoop.labs;

import org.apache.hadoop.io.WritableComparator;

import static ru.bmstu.hadoop.labs.Constants.*;

public class AirportComparator extends WritableComparator {
    public AirportComparator() {
        super(AirportWritable.class);
    }

    @Override
    public int compare(AirportWritable a, AirportWritable b) {
        return Integer.compare(a, b);
    }
}
