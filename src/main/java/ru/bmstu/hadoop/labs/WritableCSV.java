package ru.bmstu.hadoop.labs;

import com.google.gson.JsonObject;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class WritableCSV implements Writable {
    @Override
    public void write(DataOutput dataOutput) throws IOException {

    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {

    }

    public static WritableCSV read(DataInput input) throws IOException {
        WritableCSV w = new WritableCSV();
        w.readFields(input);
        return w;
    }
}
