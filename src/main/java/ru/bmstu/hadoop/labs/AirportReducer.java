package ru.bmstu.hadoop.labs;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.util.Iterator;

import static ru.bmstu.hadoop.labs.Constants.*;

public class AirportReducer extends Reducer<AirportComparable, Text, Text, Text> {
    @Override
    protected void reduce(AirportComparable key, Iterator<Text> values, Context context) {
        Iterator<AirportComparable>
    }
}
