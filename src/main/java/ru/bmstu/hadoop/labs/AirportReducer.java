package ru.bmstu.hadoop.labs;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.util.Iterator;

import static ru.bmstu.hadoop.labs.Constants.*;

public class AirportReducer extends Reducer<AirportComparable, Text, Text, Text> {
    @Override
    protected void reduce(AirportComparable key, Iterator<Text> values, Context context) {
        String airportName = values.next().toString();
        float max = Float.MIN_VALUE;
        float min = Float.MAX_VALUE;
        int count = 0;
        float sum = 0;
        while (values.hasNext()) {
            float val = Float.parseFloat(values.next().toString());
            if (max < val) max = val;
            if (min > val) min = val;
            sum += val;
            count++;
        }
        
    }
}
