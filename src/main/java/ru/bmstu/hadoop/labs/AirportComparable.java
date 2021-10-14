package ru.bmstu.hadoop.labs;

import org.apache.hadoop.io.WritableComparable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import static ru.bmstu.hadoop.labs.Constants.*;

public class AirportComparable implements WritableComparable {

    private int airportId;
    private int flag;

    public AirportComparable(int airportId, int flag) {
        this.airportId = airportId;
        this.flag = flag;
    }

    public int getAirportId() {
        return airportId;
    }

    public void setAirportId(int airportId) {
        this.airportId = airportId;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {

    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {

    }
}
