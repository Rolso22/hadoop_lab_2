package ru.bmstu.hadoop.labs;

import org.apache.hadoop.io.WritableComparable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import static ru.bmstu.hadoop.labs.Constants.*;

public class AirportComparable implements WritableComparable {

    private final int airportId;
    private final int flag;

    public AirportComparable(int airportId, int flag) {
        this.airportId = airportId;
        this.flag = flag;
    }

    public int getAirportId() {
        return airportId;
    }

    public int getFlag() {
        return flag;
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.airportId, ((AirportComparable) o).airportId);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(airportId);
        dataOutput.writeInt(flag);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {

    }
}
