package ru.bmstu.hadoop.labs;

import org.apache.hadoop.io.WritableComparator;

public class AirportComparator extends WritableComparator {
    public AirportComparator() {
        super();
    }

//    @Override
//    public int compare(Object a, Object b) {
//        return Integer.compare(a, b);
//    }
}
