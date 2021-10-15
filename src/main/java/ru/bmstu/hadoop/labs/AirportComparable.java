package ru.bmstu.hadoop.labs;

import org.apache.hadoop.io.WritableComparable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

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
        flag = dataInput.readInt();
        airportId = dataInput.readInt();
    }
}
