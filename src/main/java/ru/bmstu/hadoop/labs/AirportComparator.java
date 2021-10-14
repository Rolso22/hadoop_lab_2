package ru.bmstu.hadoop.labs;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class AirportComparator extends WritableComparator {
    @Override
    public WritableComparable newKey() {
        return super.newKey();
    }
}
