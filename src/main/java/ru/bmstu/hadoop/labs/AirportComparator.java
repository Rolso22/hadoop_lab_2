package ru.bmstu.hadoop.labs;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class AirportComparator extends WritableComparator {
    public AirportComparator() {
        super(AirportComparable.class);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        AirportComparable airportA = (AirportComparable) a;
        AirportComparable airportB = (AirportComparable) b;
        return Integer.compare(airportA.getAirportId(), airportB.getAirportId());
    }
}
